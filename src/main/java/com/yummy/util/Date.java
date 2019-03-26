package com.yummy.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期格式统一为year-month-day
 */
@Component
public class Date {

    /**
     *
     * @param date1
     * @param date2
     * @return 1:date1>date2
     *         -1:date1<date2
     *         0: date1=date2
     */
    public int compareTo(String date1,String date2){
        String[]date1Sep=date1.split("-");
        String[]date2Sep=date2.split("-");
        LocalDate localDate1=LocalDate.of(Integer.parseInt(date1Sep[0]),
                Integer.parseInt(date1Sep[1]),
                Integer.parseInt(date1Sep[2]));
        LocalDate localDate2=LocalDate.of(Integer.parseInt(date2Sep[0]),
                Integer.parseInt(date2Sep[1]),
                Integer.parseInt(date2Sep[2]));
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
     * 比较当前时间
     * @param time1
     * @param time2
     * @return 1 time1>time2
     *          -1 time1<time2
     *          0 time1=time2
     */
    public int compareTime(String time1,String time2){
        LocalDate localDate=LocalDate.parse(time1,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDate localDate1=LocalDate.parse(time2,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return getCompareResult(localDate,localDate1);
    }

    /**
     * 获得当前时间
     *
     * @return such as '2011-12-03T10:15:30'.
     */
    public String getDateAndTime(){
        LocalDate localDate=LocalDate.now();
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
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
