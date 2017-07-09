package com.pcfa.thisorthat.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Dpswtf on 09/07/2017.
 */

public class ErrorUtils {

    public static void handleException(String source, Exception e, String error) {
        if(!TextUtils.isEmpty(e.getMessage())){
            Log.e(source, e.getMessage());
            //Analytics.Error.sendErrorReport(source, e.getMessage(), e);
        }else {
            Log.e(source, error);
            //Analytics.Error.sendErrorReport(source, error, e);
        }
    }

    public static void handleException(String source, Throwable e, String error) {
        if(!TextUtils.isEmpty(e.getMessage())){
            Log.e(source, e.getMessage());
            //AptoideAnalytics.Error.sendErrorReport(source, e.getMessage(), e);
        }else {
            Log.e(source, error);
            //Analytics.Error.sendErrorReport(source, error, e);
        }
    }
}
