package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.caiyide.primary.entity.BUser;
import com.caiyide.primary.web.param.BUserParam;
import com.caiyide.primary.web.vo.UserInfoVo;
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

    UserInfoVo getById(String id);

    List<com.caiyide.primary.web.vo.getUserPageListVo> getPageList(Page page, BUserParam bUserParam);

    String searchUserByweixinCode(@Param("weixinCode") String weixinCode);

    BUser  searchUserByphone(@Param("phone") String phone);

    void addUserByweixin(com.caiyide.primary.web.vo.AddUserVo addUserVo);

    void addUserByphone(com.caiyide.primary.web.vo.AddUserPhoneVo addUserPhoneVo);

    BUser getByweiXinCode(String param);

    void updateLastLoginDate(@Param("userId") String userId);

    void updateUserInfo(com.caiyide.primary.web.vo.UpdateUserVo updateUserVo);

    List<BUser> UserList(com.caiyide.primary.web.vo.Pagevo pagevo);

     com.caiyide.primary.web.vo.ShopDetail getByuserId(@Param("singleParma") String singleParma);
      com.caiyide.primary.web.vo.ShopDetail getByProducter(@Param("productCreater") String productCreater);
}