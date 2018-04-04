package com.wsp.enums;

public enum BusinessEnum {
    BUSINESS_EXCEPTION("DB0001","系统业务异常"),
    ;

    private String code;
    private String message;

    BusinessEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
