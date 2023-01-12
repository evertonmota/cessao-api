package br.gov.ma.cessaoapi.errors;

import java.util.HashMap;
import java.util.Map;

public class NotFoundException extends Exception {
    private static final long serialVersionUID = -6594993831322611627L;

    private String code;
    private Map<String, String> errorMap = new HashMap<>();

    public NotFoundException(String code) {
        super(code);
        this.code = code;
    }

    public NotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public NotFoundException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public NotFoundException(String code, String message, Throwable cause) {
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
