package com.quylua98.dto;

public class ResponseData {
    private String suid;
    private int point;
    private int status;
    private String message;

    public ResponseData() {
    }

    public ResponseData(String suid, int point, int status, String message) {
        this.suid = suid;
        this.point = point;
        this.status = status;
        this.message = message;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
