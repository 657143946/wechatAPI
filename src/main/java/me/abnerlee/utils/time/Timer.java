package me.abnerlee.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liwenjun on 14-4-12.
 */
public class Timer {
    public static long getCurrentTimestampMillis() {
        return System.currentTimeMillis();
    }

    public static long getTimestampMillisFromString(String yearMonthDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
            dt = sdf.parse(yearMonthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long lTime = dt.getTime();
        return lTime;
    }

    public static String getFormatStringFromLongTimestampMillis(long ts) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(ts);
    }

    public static String getFormatShortStringFromLongTimestampMillis(long ts) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(ts);
    }
}
