package com.flutterwavereport.dao.impl;

import com.flutterwavereport.dao.WamsLogDao;
import com.flutterwavereport.model.FlutterResponse;
import com.flutterwavereport.model.WamsLog;
import com.flutterwavereport.model.WamsLogSearch;
import org.springframework.beans.factory.annotation.Autowired;

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
public class WamsLogDaoImpl implements WamsLogDao {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<WamsLog> getAllWamsLog(){
        List<WamsLog> wamsLogList = new ArrayList<WamsLog>();

        String sql = "SELECT * FROM wamsLog";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                WamsLog wamsLog = new WamsLog();
                wamsLog.setId(rs.getString("id"));
                wamsLog.setPaycomNO(rs.getString("paycomNO"));
                wamsLog.setWamsResp(rs.getString("wamsResp"));
                wamsLog.setWamsRespID(rs.getString("wamsRespID"));
                wamsLog.setAmount(rs.getDouble("amount"));
                wamsLog.setfRequest_ID(rs.getString("fRequest_ID"));
                wamsLogList.add(wamsLog);
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
        return wamsLogList;
    }

    public List<WamsLog> getAllWamsLogBasedOnSearch(WamsLogSearch wamsLogSearch){
        String id = wamsLogSearch.getId();
        String paycomNo = wamsLogSearch.getPaycomNo();
        String wamsResp = wamsLogSearch.getWamsResp();
        String wamsResponseID = wamsLogSearch.getWamsResponseID();
        String fRequest_ID = wamsLogSearch.getfRequest_ID();

        StringBuilder mainQuery = new StringBuilder("SELECT * FROM wamsLog");

        if(!id.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and id=" + id);
            }else{
                mainQuery.append(" where id=" + id);
            }
        }

        if(!paycomNo.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and paycomNO='" + paycomNo + "'");
            }else{
                mainQuery.append(" where paycomNO='" + paycomNo + "'");
            }
        }

        if(!wamsResp.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and wamsResp='" + wamsResp + "'");
            }else{
                mainQuery.append(" where wamsResp='" + wamsResp + "'");
            }
        }

        if(!wamsResponseID.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and wamsRespID='" + wamsResponseID + "'");
            }else{
                mainQuery.append(" where wamsRespID='" + wamsResponseID + "'");
            }
        }

        if(!fRequest_ID.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and fRequest_ID=" + fRequest_ID);
            }else{
                mainQuery.append(" where fRequest_ID=" + fRequest_ID);
            }
        }

        List<WamsLog> wamsLogList = new ArrayList<WamsLog>();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(mainQuery.toString());
            while(rs.next()){
                WamsLog wamsLog = new WamsLog();
                wamsLog.setId(rs.getString("id"));
                wamsLog.setPaycomNO(rs.getString("paycomNO"));
                wamsLog.setWamsResp(rs.getString("wamsResp"));
                wamsLog.setWamsRespID(rs.getString("wamsRespID"));
                wamsLog.setAmount(rs.getDouble("amount"));
                wamsLog.setfRequest_ID(rs.getString("fRequest_ID"));
                wamsLogList.add(wamsLog);
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
        return wamsLogList;
    }
}
