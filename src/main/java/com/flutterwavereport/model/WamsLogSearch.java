package com.flutterwavereport.model;

/**
 * Created by SP on 9/19/2017.
 */
public class WamsLogSearch {
    private String id;
    private String paycomNo;
    private String wamsResp;
    private String wamsResponseID;
    private double Amount;
    private String fRequest_ID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaycomNo() {
        return paycomNo;
    }

    public void setPaycomNo(String paycomNo) {
        this.paycomNo = paycomNo;
    }

    public String getWamsResp() {
        return wamsResp;
    }

    public void setWamsResp(String wamsResp) {
        this.wamsResp = wamsResp;
    }

    public String getWamsResponseID() {
        return wamsResponseID;
    }

    public void setWamsResponseID(String wamsResponseID) {
        this.wamsResponseID = wamsResponseID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getfRequest_ID() {
        return fRequest_ID;
    }

    public void setfRequest_ID(String fRequest_ID) {
        this.fRequest_ID = fRequest_ID;
    }
}
