package month09.day0919;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @hurusea
 * @create2020-09-19 18:23
 */
public class Main {
    public static void main(String[] args) {
        Integer a1 = 17, a2 = 17;
        Integer b1 = 2017, b2 = 2017;
        Integer c1 = new Integer(17);
        Integer c2 = new Integer(17);
        Integer d1 = new Integer(2017);
        int d2 = 2017;
        System.out.println(d1 == d2);
        System.out.println(b1 == b2);
        System.out.println(a1 == a2);
        System.out.println(c1 == c2);
    }

    /**
     * @descript:计算两个字符串日期相差的天数
     * @param date1 字符串日期1
     * @param date2 字符串日期2
     * @param format 日期格式化方式  format="yyyy-MM-dd"
     * @return
     */
    public static long dayDiff(String date1, String date2,String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        long diff=0l;
        try {
            long d1 = formater.parse(date1).getTime();
            long d2 = formater.parse(date2).getTime();
            diff=(Math.abs(d1-d2) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }
}
