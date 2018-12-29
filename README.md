### 登录流程
- 1.调用/verificationCode获取验证码token和验证码图片的base64编码,响应内容
```json
{
  "code": 200,
  "msg": null,
  "data": {
    "verificationCodeToken": "verification-code-token-20fa12e9-24d0-45bb-8263-4cb02fe4bfe4",
    "code": "data:image/png;base64,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"
  },
  "time": "2018-08-08 16:56:28"
}
```
- 2.调用/login登录接口传入账号，密码，验证码token和验证码内容，请求参数,前台使用sha1加密
```json
{
  "account": "admin",
  "code": "xhhn",
  "pwd": "7c4a8d09ca3762af61e59520943dc26494f8941b",
  "verificationCodeToken": "verification-code-token-20fa12e9-24d0-45bb-8263-4cb02fe4bfe4"
}
```
- 3.登录成功,返回登录x-auth-token,以后请求在请求头或者请求参数中传递，建议使用请求头
```json
 {
   "code": 200,
   "msg": "登录成功",
   "data": {
     "loginSysUser": {
       "userId": "1",
       "account": "admin",
       "userName": "admin"
     },
     "x-auth-token": "x-auth-token-82bc82ea-0e65-4346-b4fd-33a60a4fdfad"
   },
   "time": "2018-08-08 16:56:59"
 }
```