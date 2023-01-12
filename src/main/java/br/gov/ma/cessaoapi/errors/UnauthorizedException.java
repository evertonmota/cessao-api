package br.gov.ma.cessaoapi.errors;

import java.util.HashMap;
import java.util.Map;

public class UnauthorizedException extends Exception {

    private String code;
    private Map<String, String> errorMap = new HashMap<>();

    public UnauthorizedException(String code) {
        super(code);
        this.code = code;
    }

    public UnauthorizedException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UnauthorizedException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public UnauthorizedException(String code, String message, Throwable cause) {
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
