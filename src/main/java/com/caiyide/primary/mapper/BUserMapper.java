package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.caiyide.primary.web.param.BUserParam;
import com.caiyide.primary.web.vo.AddUserVo;
import com.caiyide.primary.web.vo.UpdateUserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-26
 */
@Repository
public interface BUserMapper extends BaseMapper<BUser> {

    BUser getById(String id);

    List<BUser> getPageList(Page page, BUserParam bUserParam);

    String weiXinCodeByUserId(String weixinCode);

    void addUser(AddUserVo  addUserVo);

    BUser getByweiXinCode(String param);

    void updateLastLoginDate(@Param("userId") String userId);

    void updateUserInfo(UpdateUserVo updateUserVo);

}