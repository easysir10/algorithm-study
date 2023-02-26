package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hwang
 * @data 2023/2/26
 * @description 根据日期判断是第几周
 */
public class WeekByDate {
    public static void main(String[] args) throws ParseException {
        System.out.println(getWeekByDate(4, "2023-01-01 00:00:00"));
    }


    /**
     * 根据日期判断是第几周
     *
     * @param minDaysInFirstWeek 一年中第一个星期所需最少天数
     * @param dateTime           日期
     * @return 周数
     */
    private static String getWeekByDate(int minDaysInFirstWeek, String dateTime) {

        // 日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date parse;
        try {
            // 字符串转换为日期
            parse = simpleDateFormat.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期格式有误！");
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        //设置星期一为一周开始的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //设置在一年中第一个星期所需最少天数
        calendar.setMinimalDaysInFirstWeek(minDaysInFirstWeek);
        calendar.setTime(parse);
        // 获取是第几周
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        // 获取月份
        int month = calendar.get(Calendar.MONTH);
        // 获取年份
        int year = calendar.get(Calendar.YEAR);

        // 1月前几天是第52周，说明算在了前一年最后一周里面
        if (week == 52 && month == 0) {
            year -= 1;
        } else if (week == 1 && month == 11) {// 12月最后几天是第1周，说明算在了后一年第一周里面
            year += 1;
        }


        return year + "-" + week;
    }
}
