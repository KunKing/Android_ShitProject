package com.edu.android_shitproject.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ming on 2015/12/31.
 */
public class DateUtil {

    public static String getTime(int time){
        long date = time * 1000;
        Date d = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:ss:mmm");
        return format.format(d);
    }
}
