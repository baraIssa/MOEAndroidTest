package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static String getDate(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return date.toString ();
    }
}
