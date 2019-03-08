package com.caiyide.primary.ShopCar;

import com.caiyide.primary.entity.BProduct;
import com.caiyide.primary.util.IdParamList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @outhor liusiyu
 * @create 2019-02-12-16:39
 */
@Service
public class CartService {
    @Autowired
    private RedisTemplate redisTemplate;

    //保存购物车到Redis中
    public void insertBuyerCartToRedis(BuyerCart buyerCart, String username) {
        List<BuyerItem> items = buyerCart.getItems();
        if (items.size() > 0) {
            for (BuyerItem item : items) {
                //判断是否有同款
                if (redisTemplate.hasKey( "buyerCart:" + username )) {
                    HashMap<String, Integer> map = (HashMap<String, Integer>) redisTemplate.opsForValue().get( "buyerCart:" + username );
                    //如果存在则修改产品数量
                    if (map.containsKey( String.valueOf( item.getSku().getProductId() ) )) {
                        BuyerItem buyerItem = new BuyerItem();
                        if (item.getAmount() + map.get( String.valueOf( item.getSku().getProductId() ) ) >= 1) {
                            buyerItem.setAmount( item.getAmount() + map.get( String.valueOf( item.getSku().getProductId() ) ) );
                            map.put( String.valueOf( item.getSku().getProductId() ), buyerItem.getAmount() );
                            redisTemplate.opsForValue().set( "buyerCart:" + username, map );
                        } else {
                            //
                            map.remove( String.valueOf( item.getSku().getProductId() ) );
                            redisTemplate.opsForValue().set( "buyerCart:" + username, map );
                        }
                    } else {
//                        //如果不存在则新增产品
                        map.put( String.valueOf( item.getSku().getProductId() ), item.getAmount() );
                        if (map.size() > 0) {
                            redisTemplate.opsForValue().set( "buyerCart:" + username, map );
                        }
                    }
                } else {
                    //没有购物车则新增
                    Map<String, Integer> hash = new HashMap<String, Integer>();
                    hash.put( String.valueOf( item.getSku().getProductId() ), item.getAmount() );
                    redisTemplate.opsForValue().set( "buyerCart:" + username, hash );
                }
            }
        }
    }

    //取出Redis中购物车
    public BuyerCart selectBuyerCartFromRedis(String username) {
        BuyerCart buyerCart = new BuyerCart();
        //获取所有商品, redis中保存的是skuId 为key , amount 为value的Map集合
        Map<String, Integer> hgetAll = (Map<String, Integer>) redisTemplate.opsForValue().get( "buyerCart:" + username );
        if (hgetAll!=null) {
            Set<Map.Entry<String, Integer>> entrySet = hgetAll.entrySet();
            for (Map.Entry<String, Integer> entry : entrySet) {
                //entry.getKey(): skuId
                BProduct bProduct = new BProduct();
                bProduct.setProductId( Integer.parseInt( entry.getKey() ) );
                BuyerItem buyerItem = new BuyerItem();
                buyerItem.setSku( bProduct );
                //entry.getValue(): amount
                buyerItem.setAmount( entry.getValue() );
                //添加到购物车中
                buyerCart.addItem( buyerItem );
            }
            return buyerCart;
        }
         return null;
    }


    //从购物车中取出指定商品
    public BuyerCart selectBuyerCartFromRedisBySkuIds(String[] Sku, String username) {
        BuyerCart buyerCart = new BuyerCart();
        //获取所有商品, redis中保存的是skuId 为key , amount 为value的Map集合
        Map<String, Integer> hgetAll = (Map<String, Integer>) redisTemplate.opsForValue().get( "buyerCart:" + username );
        if (null != hgetAll && hgetAll.size() > 0) {
            Set<Map.Entry<String, Integer>> entrySet = hgetAll.entrySet();
            for (Map.Entry<String, Integer> entry : entrySet) {
                for (String skuId : Sku) {
                    if (skuId.equals( entry.getKey() )) {
                        //entry.getKey(): skuId
                        BProduct bProduct = new BProduct();
                        bProduct.setProductId( Integer.parseInt( entry.getKey() ) );
                        BuyerItem buyerItem = new BuyerItem();
                        buyerItem.setSku( bProduct );
                        //entry.getValue(): amount
                        buyerItem.setAmount( entry.getValue() );
                        //添加到购物车中
                        buyerCart.addItem( buyerItem );
                    }
                }
            }
        }

        return buyerCart;
    }


}
