package com.br.artistas.external.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

public class SpotifyException extends  RuntimeException {

    private int httpStatus;
    private String errorCode;
    private Map<String, String> fields;

    public SpotifyException(int httpStatus, String errorCode, String description) {
        super(description);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }
    public int getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("httpStatus", httpStatus)
                .append("errorCode", errorCode)
                .append("fields", fields)
                .build();
    }
}
