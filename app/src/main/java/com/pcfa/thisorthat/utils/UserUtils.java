package com.pcfa.thisorthat.utils;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;

import com.pcfa.thisorthat.security.SecurePreferences;

/**
 * Created by Dpswtf on 09/07/2017.
 */

public class UserUtils {

    public static boolean isLoggedIn(Context context) {
        AccountManager manager = AccountManager.get(context);
        SharedPreferences securePreferences = SecurePreferences.getInstance(context);
        String authTokenType = securePreferences.getString(Constants.ACCESS_TOKEN, null);
        return (manager.getAccountsByType(Constants.ACCOUNT_TYPE).length != 0 && authTokenType != null);
    }

}
