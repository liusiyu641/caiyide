package com.caiyide.primary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BUser;
import com.caiyide.primary.mapper.BUserMapper;
import com.caiyide.primary.service.BUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.caiyide.primary.web.param.BUserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-26
 */
@Service
@Transactional
public class BUserServiceImpl extends ServiceImpl<BUserMapper, BUser> implements BUserService {

    private static Logger logger = LoggerFactory.getLogger(BUserServiceImpl.class);

    @Autowired
    private BUserMapper bUserMapper;

    @Override
    public BUser getById(String id){
        return bUserMapper.getById(id);
    }

    @Override
    public Paging getPageList(BUserParam bUserParam){
        Page page = new Page<>();
        bUserParam.convert(page);
        page.setRecords(bUserMapper.getPageList(page,bUserParam));
        return new Paging(page);
    }

    @Override
    public String weiXinCodeByUserId(String weixinCode) {
        return bUserMapper.weiXinCodeByUserId( weixinCode );
    }
}
