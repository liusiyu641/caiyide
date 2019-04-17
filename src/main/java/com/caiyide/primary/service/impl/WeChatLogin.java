package com.caiyide.primary.service.impl;

import com.caiyide.primary.common.constant.CommonConstant;
import com.caiyide.primary.common.constant.ResponseCode;
import com.caiyide.primary.common.util.LoginUtil;
import com.caiyide.primary.common.vo.ResponseResult;
import com.caiyide.primary.entity.BUser;
import com.caiyide.primary.mapper.BUserMapper;
import com.caiyide.primary.util.TokenUtil;
import com.caiyide.primary.util.UUIDUtil;
import com.caiyide.primary.web.vo.AddUserVo;
import com.caiyide.primary.web.vo.LoginUserVo;
import com.caiyide.primary.web.vo.WeChatSession;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @outhor liusiyu
 * @create 2018-12-27-10:26
 */
@Service
public class WeChatLogin extends ActionSupport {
    /**
     *author liusiyu
     *2018-12-26
     */
    private static final long serialVersionUID = 1L;

    private static final String APPID = "wxa29257fc005feef6";
    private static final String SECRET = "721dd35d51d936e0fa293c27a5ff6cd6";
     @Autowired
    private BUserMapper bUserMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    //获取凭证校检接口
    public ResponseResult login(String code)
    {
        System.out.println( "code = " + code );
        //微信的接口
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+
                "&secret="+SECRET+"&js_code="+ code +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        //进行网络请求,访问url接口
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        //根据返回值进行后续操作
        if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK)
        {
            String sessionData = responseEntity.getBody();
            Gson gson = new Gson();
            //解析从微信服务器获得的openid和session_key;
            WeChatSession weChatSession = gson.fromJson(sessionData, WeChatSession.class);
            //获取用户的唯一标识
            String openid = weChatSession.getOpenid();
            //获取会话秘钥
            String session_key = weChatSession.getSession_key();


            if (openid==null) {
                return  ResponseResult.error( "没有获取到openid" );
            }
            System.out.println( "openid = " + openid );
            return new ResponseResult("获取到openid"+openid);

            //查询是否存在用户
//            LoginUserVo loginUserVo =new LoginUserVo();
//
//            BUser bUser= bUserMapper.getByweiXinCode( openid );
//            // 将sysUser的属性复制到loginSysUserVo对象中
//            if (bUser!=null) {
//                BeanUtils.copyProperties( bUser, loginUserVo );
//            }
//            if (bUser==null){
//                AddUserVo addUserVo =new AddUserVo();
//                addUserVo.setWeixinCode( openid );
//                addUserVo.setUserId( UUIDUtil.getUUID());
//                bUserMapper.addUserByweixin( addUserVo );
//                //存入redis
//                String firstLoginRestPwdToken = TokenUtil.generateFirstLoginRestPwdToken();
//                Map<String,Object> map = new HashMap<>();
//                map.put( CommonConstant.X_AUTH_TOKEN,firstLoginRestPwdToken);
//                redisTemplate.opsForValue().set(firstLoginRestPwdToken, loginUserVo,10,TimeUnit.MINUTES);
//                return new ResponseResult( ResponseCode.NOT_INFO_PERFECT,"第一次登录，请选择商家或者批发商",map);
//            }
//
//            String UserId = loginUserVo.getUserId();
//            // 保存的登录对象
//            // 生成token
//            String xAuthToken = TokenUtil.generateXAuthToken();
//            redisTemplate.opsForValue().set(xAuthToken, loginUserVo, LoginUtil.TOKEN_VALID_TIME_MINUTE,TimeUnit.MINUTES);
//
//            // 修改用户最后一次登录的时间
//            bUserMapper.updateLastLoginDate(UserId);
//
//
//
//            // 输出token和登录对象
//            Map<String,Object> map = new HashMap<>();
//            map.put(CommonConstant.X_AUTH_TOKEN,xAuthToken);
//            map.put(CommonConstant.LOGIN_SYS_USER, loginUserVo);
//
//            ResponseResult responseResult = new ResponseResult();
//            responseResult.setCode(200);
//            responseResult.setMsg("登录成功");
//            responseResult.setData(map);
//            return responseResult;
        }
        return null;
    }
    }
