package com.test;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by ListenYoung on 2017/4/13.
 */
public class DateTest {
    public static void main(String[] args){
        System.out.println(new Date());
        Long date1 = System.currentTimeMillis();
        Date date = new Date(date1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

        Date resultDate1 = calendar.getTime();
        System.out.println("woaodsd:" + resultDate1);
        //特么月份竟然是从0开始ide 真是坑爹不偿命
        calendar.set(2018, 5, 12, 23, 59, 59);
        System.out.println("~~~~~~~~~~" + calendar.getTime());
        System.out.println("~~~~~~~~~~" + calendar.getTime().getTime());
        Timestamp timestamp = new Timestamp(new Long(1507910399999L));
        System.out.println("~~~~~~~~~~" + timestamp);
        System.out.println("~~~~~~~~~~" + new Date(calendar.getTime().getTime()));
        Date resultDate2 = calendar.getTime();

        resultDate1 = new Date(resultDate1.getTime() - 365L * 24 * 3600 * 1000);

        Long result = (resultDate1.getTime() - resultDate2.getTime()) / 1000 / 3600 / 24;

        System.out.println(result);


        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        c1.setTimeInMillis(1507910399999L);

    }
}
