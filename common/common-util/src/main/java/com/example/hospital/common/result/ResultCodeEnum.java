package com.example.hospital.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    // 状态
    SUCCESS(200,"成功"),
    FAIL(-1, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    // 登录/注册
    LOGIN_AUTH(3001, "未登陆"),
    PERMISSION(3002, "没有权限"),
    CODE_ERROR(3003, "验证码错误"),
    LOGIN_MOBLE_ERROR(3004, "账号不正确"),
    LOGIN_DISABLED_ERROR(3005, "该用户已被禁用"),
    REGISTER_MOBLE_ERROR(3006, "手机号已被使用"),
    //LOGIN_AURH(3007, "需要登录"),
    //LOGIN_ACL(3008, "没有权限"),

    // 鉴权
    URL_ENCODE_ERROR( 4001, "URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR( 4002, "非法回调请求"),
    FETCH_ACCESSTOKEN_FAILD( 4003, "获取accessToken失败"),
    FETCH_USERINFO_ERROR( 4004, "获取用户信息失败"),
    LOGIN_ERROR( 4005, "登录失败"),

    // 支付
    PAY_RUN(220, "支付中"),
    CANCEL_ORDER_FAIL(225, "取消订单失败"),
    CANCEL_ORDER_NO(225, "不能取消预约"),

    // 预约
    HOSCODE_EXIST(230, "医院编号已经存在"),
    NUMBER_NO(240, "可预约号不足"),
    TIME_NO(250, "当前时间不可以预约"),

    // 访问
    SIGN_ERROR(300, "签名错误"),
    HOSPITAL_OPEN(310, "医院未开通，暂时不能访问"),
    HOSPITAL_LOCK(320, "医院被锁定，暂时不能访问");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
