package com.flutterwavereport.controller;

import com.flutterwavereport.dao.FRequestDao;
import com.flutterwavereport.dao.FlutterResponseDao;
import com.flutterwavereport.dao.WamsLogDao;
import com.flutterwavereport.dao.impl.FRequestDaoImpl;
import com.flutterwavereport.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SP on 9/13/2017.
 */
@Controller
public class HomeController {

    @Autowired
    FRequestDao FRequestDao;

    @Autowired
    FlutterResponseDao flutterResponseDao;

    @Autowired
    WamsLogDao wamsLogDao;

    @RequestMapping("/")
    public String home1(){
        System.out.println("I am here");
        return "home";
    }

    @RequestMapping("/flutterWave")
    public String getFlutterResponses(Model model){
        //List<FlutterResponse> flutterResponseList = productDao.getAllProducts();
        //model.addAttribute("products", products);

        return "flutterwaveresponse";
    }

    @RequestMapping("/wamsLogs")
    public String getWamsLogs(Model model){
        //List<FlutterResponse> flutterResponseList = productDao.getAllProducts();
        //model.addAttribute("products", products);

        return "/wamslog";
    }

    @RequestMapping(value = "/searchFRequest", method = RequestMethod.GET)
    public String searchFRequest(@RequestParam("transID")String transID, @RequestParam("card_no")String card_no, @RequestParam("refNO")String refNO,
                       @RequestParam("status")String status, Model model) {
        FRequestSearch fRequest1 = new FRequestSearch();
        if(transID.equals("")){
            fRequest1.setId("empty");
        }else{
            fRequest1.setId(transID);
        }

        if(card_no.equals("")){
            fRequest1.setCard_no("empty");
        }else{
            fRequest1.setCard_no(card_no);
        }

        if(refNO.equals("")){
            fRequest1.setRefNO("empty");
        }else{
            fRequest1.setRefNO(refNO);
        }

        if(status.equals("")){
            fRequest1.setStatus("empty");
        }else{
            fRequest1.setStatus(status);
        }
        model.addAttribute("fRequstDetails",fRequest1);
        return "/freqsearchresult";
    }

    @RequestMapping(value = "/searchFlutterResponses", method = RequestMethod.GET)
    public String searchFlutterResponses(@RequestParam("id")String id, @RequestParam("responseCode")String responseCode,
                                         @RequestParam("transStatus")String transStatus, @RequestParam("respID")String respID, Model model) {
        FlutterResponseSearch flutterResponseSearch = new FlutterResponseSearch();
        if(id.equals("")){
            flutterResponseSearch.setId("empty");
        }else{
            flutterResponseSearch.setId(id);
        }

        if(responseCode.equals("")){
            flutterResponseSearch.setResponseCode("empty");
        }else{
            flutterResponseSearch.setResponseCode(responseCode);
        }

        if(transStatus.equals("")){
            flutterResponseSearch.setTransStatus("empty");
        }else{
            flutterResponseSearch.setTransStatus(transStatus);
        }

        if(respID.equals("")){
            flutterResponseSearch.setRespID("empty");
        }else{
            flutterResponseSearch.setRespID(respID);
        }
        model.addAttribute("flutterResponseSearch",flutterResponseSearch);
        return "/frespsearchresult";
    }

    @RequestMapping(value = "/searchWamsLog", method = RequestMethod.GET)
    public String searchWamsLog(@RequestParam("id")String id, @RequestParam("paycomNo")String paycomNo,
                                @RequestParam("wamsResp")String wamsResp, @RequestParam("wamsResponseID")String wamsResponseID,
                                @RequestParam("fRequest_ID")String fRequest_ID, Model model) {
        WamsLogSearch wamsLogSearch = new WamsLogSearch();
        if(id.equals("")){
            wamsLogSearch.setId("empty");
        }else{
            wamsLogSearch.setId(id);
        }

        if(paycomNo.equals("")){
            wamsLogSearch.setPaycomNo("empty");
        }else{
            wamsLogSearch.setPaycomNo(paycomNo);
        }

        if(wamsResp.equals("")){
            wamsLogSearch.setWamsResp("empty");
        }else{
            wamsLogSearch.setWamsResp(wamsResp);
        }

        if(wamsResponseID.equals("")){
            wamsLogSearch.setWamsResponseID("empty");
        }else{
            wamsLogSearch.setWamsResponseID(wamsResponseID);
        }

        if(fRequest_ID.equals("")){
            wamsLogSearch.setfRequest_ID("empty");
        }else{
            wamsLogSearch.setfRequest_ID(fRequest_ID);
        }
        wamsLogSearch.setAmount(0);
        model.addAttribute("wamsLogSearch",wamsLogSearch);
        return "/wamslogsearchresult";
    }
    /** WEB SERVICES **/
    @RequestMapping(value = "/searchAllFRequest", method = RequestMethod.GET)
    @ResponseBody
    public List<FRequest> searchAllFRequests(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<FRequest> FRequestList = new ArrayList<FRequest>();
        FRequestDao = (com.flutterwavereport.dao.FRequestDao)context.getBean("fRequestDao");
        FRequestList = FRequestDao.getAllFRequests();
        return FRequestList;

    }

    @RequestMapping(value = "/searchAllFlutterResponse", method = RequestMethod.GET)
    @ResponseBody
    public List<FlutterResponse> searchAllFlutterResponse(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<FlutterResponse> FlutterResponseList = new ArrayList<FlutterResponse>();
        flutterResponseDao = (com.flutterwavereport.dao.FlutterResponseDao)context.getBean("flutterResponseDao");
        FlutterResponseList = flutterResponseDao.getAllFlutterResponses();
        return FlutterResponseList;

    }

    @RequestMapping(value = "/searchAllWamsLog", method = RequestMethod.GET)
    @ResponseBody
    public List<WamsLog> searchAllWamsLog(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<WamsLog> wamsLogList = new ArrayList<WamsLog>();
        wamsLogDao = (com.flutterwavereport.dao.WamsLogDao)context.getBean("wamsLogDao");
        wamsLogList = wamsLogDao.getAllWamsLog();
        return wamsLogList;

    }

    @RequestMapping(value="/searchFRequestBasedOnCriteria/{id}/{card_no}/{refNO}/{status}", method = RequestMethod.GET)
    @ResponseBody
    public List<FRequest>  searchFRequestBasedOnCriteria(@PathVariable("id")String id, @PathVariable("card_no")String card_no,
                                                         @PathVariable("refNO")String refNO, @PathVariable("status")String status){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<FRequest> FRequestList = new ArrayList<FRequest>();
        FRequestDao = (com.flutterwavereport.dao.FRequestDao)context.getBean("fRequestDao");
        FRequestSearch fRequest = new FRequestSearch();
        fRequest.setId(id);
        fRequest.setCard_no(card_no);
        fRequest.setRefNO(refNO);
        fRequest.setStatus(status);
        FRequestList = FRequestDao.getAllFRequestsBasedOnSearchCriteria(fRequest);
        return FRequestList;
    }

    @RequestMapping(value = "/searchFlutterResponseBasedOnCriteria/{id}/{responseCode}/{transStatus}/{respID}", method = RequestMethod.GET)
    @ResponseBody
    public List<FlutterResponse> searchFlutterResponseBasedOnCriteria(@PathVariable("id")String id, @PathVariable("responseCode")String responseCode,
                                     @PathVariable("transStatus")String transStatus, @PathVariable("respID")String respID, Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<FlutterResponse> FResponseList = new ArrayList<FlutterResponse>();
        flutterResponseDao = (com.flutterwavereport.dao.FlutterResponseDao)context.getBean("flutterResponseDao");
        FlutterResponseSearch flutterResponseSearch = new FlutterResponseSearch();
        flutterResponseSearch.setId(id);
        flutterResponseSearch.setResponseCode(responseCode);
        flutterResponseSearch.setTransStatus(transStatus);
        flutterResponseSearch.setRespID(respID);
        FResponseList = flutterResponseDao.getAllFlutterResponsesBasedOnSearch(flutterResponseSearch);
        model.addAttribute("fResponses", FResponseList);
        return FResponseList;

    }

    @RequestMapping(value = "/searchWamsLogBasedOnCriteria/{id}/{paycomNo}/{wamsResp}/{wamsResponseID}/{fRequest_ID}", method = RequestMethod.GET)
    @ResponseBody
    public List<WamsLog> searchWamsLogBasedOnCriteria(@PathVariable("id")String id, @PathVariable("paycomNo")String paycomNo,
                                   @PathVariable("wamsResp")String wamsResp, @PathVariable("wamsResponseID")String wamsResponseID,
                                   @PathVariable("fRequest_ID")String fRequest_ID, Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<WamsLog> wamsLogList = new ArrayList<WamsLog>();
        wamsLogDao = (com.flutterwavereport.dao.WamsLogDao)context.getBean("wamsLogDao");
        WamsLogSearch wamsLogSearch = new WamsLogSearch();
        wamsLogSearch.setId(id);
        wamsLogSearch.setPaycomNo(paycomNo);
        wamsLogSearch.setWamsResp(wamsResp);
        wamsLogSearch.setWamsResponseID(wamsResponseID);
        wamsLogSearch.setfRequest_ID(fRequest_ID);
        wamsLogList = wamsLogDao.getAllWamsLogBasedOnSearch(wamsLogSearch);
        model.addAttribute("wamsLogs", wamsLogList);
        return wamsLogList;

    }
}
