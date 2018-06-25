package com.aaa.mvpapp.http;

public class Api {

    /**
     * http域名
     **/
    public static final String HTTP = "http://192.168.2.253/";//王
    /**
     * api前缀
     **/
    public static final String API = "?newapi&q=";//王
//    public static final String API = "http://192.168.2.253/?appapi&q=";//薛
    /**
     * 投资板块
     **/
    public static final String API_PROJECTS = API + "projects";
    /**
     * 投资详情
     **/
    public static final String API_DETAIL = API + "detail";
    /**
     * 投资确认
     **/
    public static final String API_CONFIRM = API + "confirm";

    /**
     * 我的卡券
     **/
    public static final String API_MY_KA_QUAN = API + "mycards";
    /**
     * 债权转让
     **/
    public static final String API_MINE_ASSIGN = API + "change";
    /**
     * 我的投资
     **/
    public static final String API_MY_INVESTMENT = API + "myinvestment";
    /**
     * 资金记录
     **/
    public static final String API_MONEY_RECORD = API + "capitalrecord";
    /**
     * 我的回款
     **/
    public static final String API_MY_RETURN = API + "Myreturn";
    /**
     * 系统消息
     **/
    public static final String API_SYSTEM_MESSAGE = API + "systemmsg";
    /**
     * 首页
     **/
    public static final String API_HOME = API + "homepage";

    /**
     * 注册
     **/
    public static final String API_REGISTER = API + "reg";
    /**
     * 获取验证码
     **/
    public static final String API_GET_VERTIFY_CODE = API + "getphoneyzm";
    /**
     * 登录 密码方式
     **/
    public static final String API_LOGIN_TYPE_PASS = API + "passwordLogin";
    /**
     * 登录 验证码方式
     **/
    public static final String API_LOGIN_TYPE_CODE = API + "yzmLogin";
    /**
     * 忘记密码验证身份
     **/
    public static final String API_CHECK_USER = API + "checkUser";
    /**
     * 忘记密码重置密码
     **/
    public static final String API_RESET_PASS = API + "resetPassword";

    /**
     * 设置支付密码
     **/
    public static final String API_SETTING_PAY_PASS = API + "setPayPwd";
    /**
     * 修改支付密码
     **/
    public static final String API_CHANGE_PAY_PASS = API + "changePwd";
    /**
     * 购买支付前支付密码判断
     **/
    public static final String API_NEED_PAY_PASS = API + "investConfirm";
    /**
     * 密码支付
     **/
    public static final String API_PAY_WITH_PASS = API + "addtender";

    /**
     * 实名认证
     **/
    public static final String API_REAL_NAME = API + "realname";
    /**
     * 手机绑定1
     **/
    public static final String API_BIND_PHONE_1 = API + "mobile";
    /**
     * 手机绑定2
     **/
    public static final String API_BIND_PHONE_2 = API + "setMobile";
    /**
     * 修改登陆密码
     **/
    public static final String API_LOGIN_PASS_FIX = API + "updatePassword";
    /**
     * 发送邮箱验证码
     **/
    public static final String API_SEND_EMAIL_CODE = API + "sendEmailCode";
    /**
     * 邮箱认证
     **/
    public static final String API_EMAIL_AUTH = API + "checkEmail";
    /**
     * 邮箱认证first
     **/
    public static final String API_EMAIL_LOGIN = API + "emailLogin";
    /**
     * 设置
     **/
    public static final String API_SETTING = API + "setting";

    /**
     * 提现明细
     **/
    public static final String API_DEPOSIT_DETAIL = API + "CashList";
    /**
     * 充值明细
     **/
    public static final String API_RECHARGE_DETAIL = API + "RechargeList";
}
