package com.yummy.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期格式统一为year-month-day
 */
@Component
public class MyOwnDate {

    /**
     *
     * @param date1
     * @param date2
     * @return 1:date1>date2
     *         -1:date1<date2
     *         0: date1=date2
     */
    public int compareTo(String date1,String date2){
        String date1Sep=date1.split("T")[0];
        String date2Sep=date2.split("T")[0];
        LocalDate localDate1=LocalDate.parse(date1Sep,DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate localDate2=LocalDate.parse(date2Sep,DateTimeFormatter.ISO_LOCAL_DATE);
//        LocalDate localDate1=LocalDate.of(Integer.parseInt(date1Sep[0]),
//                Integer.parseInt(date1Sep[1]),
//                Integer.parseInt(date1Sep[2]));
//        LocalDate localDate2=LocalDate.of(Integer.parseInt(date2Sep[0]),
//                Integer.parseInt(date2Sep[1]),
//                Integer.parseInt(date2Sep[2]));
        return getCompareResult(localDate1,localDate2);
    }

    private int getCompareResult(LocalDate localDate1,LocalDate localDate2){
        if(localDate1.isBefore(localDate2)){
            return -1;
        }else if(localDate1.isAfter(localDate2)){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 获得当前日期
     * @return such as '2011-12-03'.
     */
    public String getDate(){
        LocalDate localDate=LocalDate.now();
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
