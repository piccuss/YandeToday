package yandetoday.common;

import java.text.SimpleDateFormat;

public class Tools {

    public static String formatDate(long times, String formatter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatter);
        return dateFormat.format(times);
    }

    public static String now() {
        return formatDate(System.currentTimeMillis(), "yy/MM/dd");
    }

    public static String nowForFile() {
        return formatDate(System.currentTimeMillis(), "yyMMdd");
    }

    public static String nowForTitle() {
        return formatDate(System.currentTimeMillis(), "yyyy-MM-dd");
    }
}
