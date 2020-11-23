package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public String getToday(){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String dateArr[] = date.split("-");
        return  dateArr[0];
    }

    public String getFiveDaysAhead(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 5);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
        String dateArr[] = date.split("-");
        return  dateArr[0];
    }
}
