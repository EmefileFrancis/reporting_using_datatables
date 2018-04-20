package com.flutterwavereport.model;

/**
 * Created by SP on 9/13/2017.
 */
public class FlutterResponse {
    private String id;
    private String fRequest_ID;
    private String responseCode;
    private String transStatus;
    private String responseMessage;
    private String respID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfRequest_ID() {
        return fRequest_ID;
    }

    public void setfRequest_ID(String fRequest_ID) {
        this.fRequest_ID = fRequest_ID;
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

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getRespID() {
        return respID;
    }

    public void setRespID(String respID) {
        this.respID = respID;
    }
}
