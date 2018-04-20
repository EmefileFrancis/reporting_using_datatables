package com.flutterwavereport.dao.impl;

import com.flutterwavereport.dao.FRequestDao;
import com.flutterwavereport.model.FRequest;
import com.flutterwavereport.model.FRequestSearch;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SP on 9/14/2017.
 */

public class FRequestDaoImpl implements FRequestDao {

     private DataSource dataSource;

     public void setDataSource(DataSource dataSource){
       this.dataSource = dataSource;
     }

    public List<FRequest> getAllFRequests(){

        String sql = "SELECT * FROM fRequest";
        List<FRequest> fRequestList = new ArrayList<FRequest>();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                FRequest fRequest = new FRequest();
                fRequest.setId(rs.getString("id"));
                fRequest.setFirstName(rs.getString("firstname"));
                fRequest.setLastName(rs.getString("lastname"));
                fRequest.setPhoneNumber(rs.getString("phonenumber"));
                fRequest.setEmail(rs.getString("email"));
                fRequest.setCard_no(rs.getString("card_no"));
                fRequest.setAmount(rs.getDouble("amount"));
                fRequest.setRefNO(rs.getString("refNO"));
                fRequest.setStatus(rs.getString("status"));
                fRequestList.add(fRequest);
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
        return fRequestList;
    }

    public List<FRequest> getAllFRequestsBasedOnSearchCriteria(FRequestSearch fRequest){

        String id = fRequest.getId();
        String card_no = fRequest.getCard_no();
        String refNO = fRequest.getRefNO();
        String status = fRequest.getStatus();

        StringBuilder mainQuery = new StringBuilder("SELECT * FROM fRequest");

        if(!id.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and id=" + id);
            }else{
                mainQuery.append(" where id=" + id);
            }
        }

        if(!card_no.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and card_no='" + card_no + "'");
            }else{
                mainQuery.append(" where card_no='" + card_no + "'");
            }
        }

        if(!refNO.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and refNO='" + refNO + "'");
            }else{
                mainQuery.append(" where refNO='" + refNO + "'");
            }
        }

        if(!status.equals("empty")){
            if(mainQuery.toString().contains("where")){
                mainQuery.append(" and status=" + status);
            }else{
                mainQuery.append(" where status=" + status);
            }
        }

        List<FRequest> fRequestList = new ArrayList<FRequest>();

        Connection conn;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(mainQuery.toString());
            while (rs.next()){
                FRequest fRequest1 = new FRequest();
                fRequest1.setId(rs.getString("id"));
                fRequest1.setFirstName(rs.getString("firstname"));
                fRequest1.setLastName(rs.getString("lastname"));
                fRequest1.setPhoneNumber(rs.getString("phonenumber"));
                fRequest1.setEmail(rs.getString("email"));
                fRequest1.setCard_no(rs.getString("card_no"));
                fRequest1.setAmount(rs.getDouble("amount"));
                fRequest1.setRefNO(rs.getString("refNO"));
                fRequest1.setStatus(rs.getString("status"));
                fRequestList.add(fRequest1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fRequestList;
    }
}
