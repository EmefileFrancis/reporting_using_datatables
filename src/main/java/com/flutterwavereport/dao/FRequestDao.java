package com.flutterwavereport.dao;

import com.flutterwavereport.model.FRequest;
import com.flutterwavereport.model.FRequestSearch;

import java.util.List;

/**
 * Created by SP on 9/14/2017.
 */
public interface FRequestDao {

    public List<FRequest> getAllFRequests();

    public List<FRequest> getAllFRequestsBasedOnSearchCriteria(FRequestSearch fRequest);
}
