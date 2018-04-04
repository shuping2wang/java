package com.wsp.exception;

import com.wsp.enums.BusinessEnum;
import com.wsp.enums.DBEnum;

public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(BusinessEnum businessEnum) {
        super(businessEnum.getMessage());
        this.code = businessEnum.getCode();
    }
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code ;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public BusinessException(String code, String message, Throwable cause) {
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
