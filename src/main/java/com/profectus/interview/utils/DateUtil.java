package com.profectus.interview.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public static Date convertToPureDate(Date date) {
        String dateStr = SDF.format(date);
        try{
            return SDF.parse(dateStr);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

}
