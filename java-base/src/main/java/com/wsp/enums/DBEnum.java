package com.wsp.enums;

public enum DBEnum {
    DB_SQL_EXECUTE_EXCEPTION("DB0001","数据库执行异常"),
    DB_SQL_DRIVER_NOT_FOUND_EXCEPTION("DB0002","数据库驱动类找不到"),
    ;

    private String code;
    private String message;

    DBEnum(String code, String message) {
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
