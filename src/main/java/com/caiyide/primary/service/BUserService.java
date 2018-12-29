package com.caiyide.primary.service;

import com.caiyide.primary.common.vo.Paging;
import com.caiyide.primary.entity.BUser;
import com.baomidou.mybatisplus.service.IService;
import com.caiyide.primary.web.param.BUserParam;
import com.caiyide.primary.web.vo.UpdateUserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-26
 */
public interface BUserService extends IService<BUser> {

    BUser getById(String id);

    Paging getPageList(BUserParam bUserParam);

    String weiXinCodeByUserId(String weixinCode);

}
