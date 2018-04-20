package com.flutterwavereport.dao.impl;

import com.flutterwavereport.dao.FlutterResponseDao;
import com.flutterwavereport.model.FRequest;
import com.flutterwavereport.model.FlutterResponse;
import com.flutterwavereport.model.FlutterResponseSearch;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SP on 9/15/2017.
 */
public class FlutterResponseDaoImpl implements FlutterResponseDao{
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<FlutterResponse> getAllFlutterResponses(){
        String sql = "SELECT * FROM fResponse";
        List<FlutterResponse> flutterResponseList = new ArrayList<FlutterResponse>();
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                FlutterResponse flutterResponse = new FlutterResponse();
                flutterResponse.setId(rs.getString("id"));
                flutterResponse.setfRequest_ID(rs.getString("fRequest_ID"));
                flutterResponse.setResponseCode(rs.getString("responseCode"));
                flutterResponse.setTransStatus(rs.getString("transStatus"));
                flutterResponse.setResponseMessage(rs.getString("responseMessage"));
                flutterResponse.setRespID(rs.getString("respID"));
                flutterResponseList.add(flutterResponse);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flutterResponseList;
    }

    public List<FlutterResponse> getAllFlutterResponsesBasedOnSearch(FlutterResponseSearch flutterResponseSearch){
        String id = flutterResponseSearch.getId();
        String responseCode = flutterResponseSearch.getResponseCode();
        String transStatus = flutterResponseSearch.getTransStatus();
        String respID = flutterResponseSearch.getRespID();

        StringBuilder mainQuery = new StringBuilder("SELECT * FROM fResponse");

        if(!id.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and id=" + id);
            }else{
                mainQuery.append(" where id=" + id);
            }
        }

        if(!responseCode.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and responseCode=" + responseCode);
            }else{
                mainQuery.append(" where responseCode=" + responseCode);
            }
        }

        if(!transStatus.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and transStatus='" + transStatus + "'");
            }else{
                mainQuery.append(" where transStatus='" + transStatus + "'");
            }
        }

        if(!respID.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and respID=" + respID);
            }else{
                mainQuery.append(" where respID=" + respID);
            }
        }

        List<FlutterResponse> flutterResponseList = new ArrayList<FlutterResponse>();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(mainQuery.toString());
            while(rs.next()){
                FlutterResponse flutterResponse = new FlutterResponse();
                flutterResponse.setId(rs.getString("id"));
                flutterResponse.setfRequest_ID(rs.getString("fRequest_ID"));
                flutterResponse.setResponseCode(rs.getString("responseCode"));
                flutterResponse.setTransStatus(rs.getString("transStatus"));
                flutterResponse.setResponseMessage(rs.getString("responseMessage"));
                flutterResponse.setRespID(rs.getString("respID"));
                flutterResponseList.add(flutterResponse);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flutterResponseList;
    }
}
