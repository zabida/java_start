package com.chinadep.dacp.common.api;

/**
 * 枚举了一些常用API操作码
 * Created by eagle on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    NOT_FOUND(404, "资源不存在"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),

    FILE_ENCODINNG_FAILED(1001, "文件名编码失败"),
    CONTENT_WRITE_FAILED(1002, "文件内容写入失败"),
    SAVE_DB_FAILED(1003, "入库失败"),
    REPEATED_ADDITION(1004, "提交重复"),
    UPLOAD_IS_NOT_EMPTY(1005, "上传文件不能为空"),
    NOT_FOUND_OR_NOT_UPDATE(404, "资源不存在或不允许更新"),
    SELECT_NO_DATA(1006, "查无数据"),
    PARAMS_NOT_VALID(1007,"参数错误"),
    USER_NOT_VERIFYED(1008,"您还未签署需方协议"),
    ;

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
