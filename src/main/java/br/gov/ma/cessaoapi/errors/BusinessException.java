package br.gov.ma.cessaoapi.errors;

import java.util.HashMap;
import java.util.Map;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 27573585959466806L;

    private String code;
    private Map<String, String> errorMap = new HashMap<>();

    public BusinessException(String code) {
        super(code);
        this.code = code;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
