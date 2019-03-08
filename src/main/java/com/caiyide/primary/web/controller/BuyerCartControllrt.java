package com.caiyide.primary.web.controller;

import com.caiyide.primary.ShopCar.AddCarParam;
import com.caiyide.primary.ShopCar.BuyerCart;
import com.caiyide.primary.ShopCar.BuyerItem;
import com.caiyide.primary.ShopCar.CartService;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BOrder;
import com.caiyide.primary.entity.BOrderDetails;
import com.caiyide.primary.entity.BProduct;
import com.caiyide.primary.mapper.BOrderDetailsMapper;
import com.caiyide.primary.mapper.BOrderMapper;
import com.caiyide.primary.mapper.BProductMapper;
import com.caiyide.primary.service.UcpaasService;
import com.caiyide.primary.util.IdParamList;
import com.caiyide.primary.util.LoginUtil;
import com.caiyide.primary.util.OrderUtil;
import com.caiyide.primary.util.SplicingCharacterUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @outhor liusiyu
 * @create 2019-02-12-16:03
 */
@RestController
@RequestMapping("/buyerCart")
@Api(description = "buyerCart API")
public class BuyerCartControllrt {
    @Autowired
    private CartService cartService;
    @Autowired
    private BProductMapper bProductMapper;
    @Autowired
    private BOrderMapper bOrderMapper;
    @Autowired
    private BOrderDetailsMapper bOrderDetailsMapper;
    @Autowired
    private  UcpaasService ucpaasService;

    //加入购物车
    @PostMapping(value = "/shopping/buyerCart")
    @ApiOperation(value = "加入购物车", notes = "加入购物车", response = ResponseResult.class)
    public <T> Object buyerCart(@RequestBody AddCarParam addCarParam) throws IOException {
        //将对象转换成json字符串/json字符串转成对象
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        BuyerCart buyerCart = null;
        //2,Cookie中没有购物车, 创建购物车对象
        if (null == buyerCart) {
            buyerCart = new BuyerCart();
        }

        //3, 将当前款商品追加到购物车
        if (null != addCarParam.getProductId() && null != addCarParam.getAmount()) {
            BProduct bProduct = new BProduct();
            bProduct.setProductId( addCarParam.getProductId() );
            BuyerItem buyerItem = new BuyerItem();
            buyerItem.setSku( bProduct );
            //设置数量
            buyerItem.setAmount( addCarParam.getAmount() );
            //添加购物项到购物车
            buyerCart.addItem( buyerItem );
        }
        //排序  倒序
        List<BuyerItem> items = buyerCart.getItems();
        Collections.sort( items, new Comparator<BuyerItem>() {
            @Override
            public int compare(BuyerItem o1, BuyerItem o2) {
                return -1;
            }
        } );
        //前三点 登录和非登录做的是一样的操作, 在第四点需要判断
        String username = LoginUtil.getLoginSysUser().getUserId();
        cartService.insertBuyerCartToRedis( buyerCart, username );
        //6, 重定向
        return ResponseResult.success( "添加成功" );
    }

    //去购物车结算, 这里有两个地方可以直达: 1,在商品详情页 中点击加入购物车按钮  2, 直接点击购物车按钮
    @PostMapping(value = "/shopping/toCart")
    @ApiOperation(value = "购物车", notes = "去购物车", response = ResponseResult.class)
    public Object toCart() {
        //将对象转换成json字符串/json字符串转成对象
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        BuyerCart buyerCart = null;

        //判断是否登录
        String username = LoginUtil.getLoginSysUser().getUserId();
        //3, 取出Redis中的购物车
        buyerCart = cartService.selectBuyerCartFromRedis( username );
        if(buyerCart!=null) {
            //5, 将购物车装满, 前面只是将skuId装进购物车, 这里还需要查出sku详情
            List<BuyerItem> items = buyerCart.getItems();
            if (items.size() > 0) {
                //只有购物车中有购物项, 才可以将sku相关信息加入到购物项中
                for (BuyerItem buyerItem : items) {
                    buyerItem.setSku( bProductMapper.getById( buyerItem.getSku().getProductId() ) );
                }
            }
            return buyerCart;
        }
       return ResponseResult.error( "暂未添加产品！" );
    }

    //去结算
    @PostMapping(value = "/buyer/trueBuy")
    @ApiOperation(value = "下单", notes = "下单", response = ResponseResult.class)
    public Object trueBuy(@RequestBody IdParamList idParamList) {
        String[] Sku = idParamList.getId().toArray( new String[0] );
        //1, 购物车必须有商品,
        //取出用户名  再取出购物车
        //判断是否登录
        String username = LoginUtil.getLoginSysUser().getUserId();
        //取出所有购物车
        BuyerCart buyerCart = cartService.selectBuyerCartFromRedisBySkuIds( Sku, username );
        List<BuyerItem> items = buyerCart.getItems();
        String oderno = OrderUtil.random();
        String ProductCreater = null;
        Date createtime = new Date(  );
        if (items.size() > 0) {
            //购物车中有商品
            //判断所勾选的商品是否都有货, 如果有一件无货, 那么就刷新页面.
            Boolean flag = true;
            //2, 购物车中商品必须有库存 且购买大于库存数量时视为无货. 提示: 购物车原页面不动. 有货改为无货, 加红提醒.
            for (BuyerItem buyerItem : items) {
                //装满购物车的购物项, 当前购物项只有skuId这一个东西, 我们还需要购物项的数量去判断是否有货
                buyerItem.setSku( bProductMapper.getById( buyerItem.getSku().getProductId() ) );
                //校验库存
//                if (buyerItem.getAmount() > buyerItem.getSku().getProductTotal()) {
//                    //无货
//                    buyerItem.setIsHave(false);
//                    flag = false;
//                }
//                if (!flag) {
//                    //无货, 原页面不动, 有货改成无货, 刷新页面.
//                    model.addAttribute("buyerCart", buyerCart);
//                    return "cart";
//                }
                //创建订单
                BOrder bOrder =new BOrder();
                bOrder.setOrderNo( oderno );
                bOrder.setUserId(buyerItem.getSku().getProductCreater());
                bOrder.setProductId(buyerItem.getSku().getProductId());
                bOrder.setProductSum( buyerItem.getAmount() );
                bOrder.setOrderTime( createtime );
                bOrder.setProductAllPrice( buyerItem.getAmount()*buyerItem.getSku().getProductPrice() );
                bOrderMapper.createOrder( bOrder );
            }
        } else {
            //购物车没有商品
            //没有商品: 1>原购物车页面刷新(购物车页面提示没有商品)
            return ResponseResult.error( "没有选择商品" );
        }
        //拼接产品名字
        List<String>  productname =  bOrderMapper.selectByProductName(oderno);
        String  pname =  SplicingCharacterUtil.SplicingCharacter(productname);
        BOrderDetails details =new BOrderDetails();
        details.setOrderNo( oderno );
        details.setProductPrice( buyerCart.getProductPrice() );
        details.setProductSum( buyerCart.getProductAmount() );
        details.setOrderType( 1 );
        details.setProductName(String.valueOf( pname )  );
        bOrderDetailsMapper.ConfirmOrder(details);
        //拼接电话号码
        List<String>  phone =  bOrderMapper.selectByPhone(oderno);
        String  mobile =  SplicingCharacterUtil.SplicingCharacter(phone);
        //发送通知
        ucpaasService.SendMessage( mobile );
        return  new ResponseResult(200,"下单成功",oderno);
    }
}
