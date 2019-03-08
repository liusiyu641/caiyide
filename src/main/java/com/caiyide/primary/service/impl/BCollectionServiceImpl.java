package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BCollection;
import com.caiyide.primary.mapper.BCollectionMapper;
import com.caiyide.primary.service.BCollectionService;
import com.caiyide.primary.util.LoginUtil;
import com.caiyide.primary.web.param.BCollectionParam;
import com.caiyide.primary.web.param.CollectParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 收藏表 服务实现类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Service
@Transactional
public class BCollectionServiceImpl extends ServiceImpl<BCollectionMapper, BCollection> implements BCollectionService {

    private static Logger logger = LoggerFactory.getLogger(BCollectionServiceImpl.class);

    @Autowired
    private BCollectionMapper bCollectionMapper;

    @Override
    public BCollection getById(String id){
        return bCollectionMapper.getById(id);
    }

    @Override
    public ResponseResult addcollect(CollectParam collectParam) {
        String userId = LoginUtil.getLoginSysUser().getUserId();
        collectParam.setUserId( userId );
        //商家id
        String shopId= collectParam.getShopId();
        if (shopId==null){
            return ResponseResult.error( "请选择商家" );
        }
        BCollection bCollection = bCollectionMapper.selectByproductId(userId,shopId);
        if (bCollection==null) {
            bCollectionMapper.addcollect( collectParam );
            return ResponseResult.success( "收藏成功" );
        }
        return ResponseResult.error( "该商家已收藏" );
    }

    @Override
    public Paging getPageList(BCollectionParam bCollectionParam){
        String userId = LoginUtil.getLoginSysUser().getUserId();
        Page page = new Page<>();
        bCollectionParam.convert(page);
        page.setRecords(bCollectionMapper.getPageList(page,bCollectionParam,userId));
        return new Paging(page);
    }

    @Override
    public ResponseResult deleteById(String id) {
        bCollectionMapper.deleteById( id );
        return ResponseResult.success("删除成功！");
    }
}
