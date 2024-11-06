package com.redhat.demo.selenium.helper;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.redhat.demo.selenium.config.OffsetDateTimeDeserializer;
import com.redhat.demo.selenium.config.OffsetDateTimeSerializer;

public class ErrorResponse {

    private static final String OFFSET_DATE_TIME_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSSZ";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = OFFSET_DATE_TIME_FORMAT)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timestamp;

    private long status;

    private String error;

    private String message;

    private String path;

    public OffsetDateTime getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {

        this.timestamp = timestamp;
    }

    public long getStatus() {

        return status;
    }

    public void setStatus(long status) {

        this.status = status;
    }

    public String getError() {

        return error;
    }

    public void setError(String error) {

        this.error = error;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

}
