package com.wsp.exception;

import com.wsp.enums.DBEnum;

public class DBException extends RuntimeException {

    private String code;
    private String message;

    public DBException(DBEnum dbEnum) {
        super(dbEnum.getMessage());
        this.code = dbEnum.getCode();
    }
    public DBException(String message) {
        super(message);
    }

    public DBException(String code,String message) {
        super(message);
        this.code = code ;
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
    public DBException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code ;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
