package com.zenin.nepschedule.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 86227
 * @date 2021/8/29 21:07
 */
public class DateFormatter {

    public static final int MILLISECOND_MINUTE = 60000;
    public static final int MILLISECOND_DAY = 3600000;
    public static final String YYYY_MM_DD = "yyyyMMdd";


    public static String dateToStr(Date dateDate, String exp) {
        if(dateDate == null) {
            dateDate = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(exp);
        return formatter.format(dateDate);
    }
}
