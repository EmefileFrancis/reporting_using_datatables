package com.flutterwavereport.dao;

import com.flutterwavereport.model.WamsLog;
import com.flutterwavereport.model.WamsLogSearch;

import java.util.List;

/**
 * Created by SP on 9/15/2017.
 */
public interface WamsLogDao {
    public List<WamsLog> getAllWamsLog();

    public List<WamsLog> getAllWamsLogBasedOnSearch(WamsLogSearch wamsLogSearch);
}
