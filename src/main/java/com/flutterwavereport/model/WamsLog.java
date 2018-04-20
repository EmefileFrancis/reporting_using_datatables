package com.flutterwavereport.model;

/**
 * Created by SP on 9/13/2017.
 */
public class WamsLog {
    private String id;
    private String paycomNO;
    private String wamsResp;
    private String wamsRespID;
    private double Amount;
    private String fRequest_ID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaycomNO() {
        return paycomNO;
    }

    public void setPaycomNO(String paycomNO) {
        this.paycomNO = paycomNO;
    }

    public String getWamsResp() {
        return wamsResp;
    }

    public void setWamsResp(String wamsResp) {
        this.wamsResp = wamsResp;
    }

    public String getWamsRespID() {
        return wamsRespID;
    }

    public void setWamsRespID(String wamsRespID) {
        this.wamsRespID = wamsRespID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        amount = amount;
    }

    public String getfRequest_ID() {
        return fRequest_ID;
    }

    public void setfRequest_ID(String fRequest_ID) {
        this.fRequest_ID = fRequest_ID;
    }
}
