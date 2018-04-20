package com.flutterwavereport.model;

/**
 * Created by SP on 9/19/2017.
 */
public class FlutterResponseSearch {
    private String id;
    private String responseCode;
    private String transStatus;
    private String respID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getRespID() {
        return respID;
    }

    public void setRespID(String respID) {
        this.respID = respID;
    }
}
