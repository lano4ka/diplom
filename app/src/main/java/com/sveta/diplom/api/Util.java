package com.sveta.diplom.api;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by User on 20.04.2016.
 */
public class Util {

    public static String convertToHeader(String login, String password) {
        String resultString = login + ":" + password;
        return "Basic " + android.util.Base64.encodeToString(resultString.getBytes(), android.util.Base64.DEFAULT).trim();
    }
}
