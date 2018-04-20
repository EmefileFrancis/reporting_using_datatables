package com.flutterwavereport.dao;

import com.flutterwavereport.model.FlutterResponse;
import com.flutterwavereport.model.FlutterResponseSearch;

import java.util.List;

/**
 * Created by SP on 9/15/2017.
 */
public interface FlutterResponseDao {
    public List<FlutterResponse> getAllFlutterResponses();

    public List<FlutterResponse> getAllFlutterResponsesBasedOnSearch(FlutterResponseSearch flutterResponseSearch);
}
