package cn.guimei_mall.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {
    public static Date stringToDate(String string){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
