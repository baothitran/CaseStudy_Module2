package com.codegym.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("hh:mm dd-MM-yyyy");
    public static Date convertStringToDate(String strDate) {
        try {
            return formatter.parse(strDate);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return null;
    }

    public static String convertDateToString(Date date) {
        return formatter.format(date);
    }
}
