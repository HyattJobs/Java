package dateutil;

import java.util.*;

public class Test {
    public static void main(String[] args){
     /* Date date = getFirstDay(new Date());
        System.out.println(date);
        System.out.println(getWeekDay1to7(date));*/
        //System.out.println(toDate(getToYear(),1,1));
//        System.out.println(addMonth(toDate(getToYear(),1,1),1));
        int weekNum = 4;
        System.out.println(getWeekOfMonth(2019,1,weekNum));

    }

    public static List<Date> getWeekOfMonth(int year, int month, int week){
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, year);
        c1.set(Calendar.MONTH, month-1);
        c1.set(Calendar.DAY_OF_MONTH, 1);

        int fistDayOfWeek =c1.get(Calendar.DAY_OF_WEEK)-1;
        int allDays = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date date = null;
        List<Date> dayList=new ArrayList<Date>() ;
        int day= 0;
        for(int i=0;i<5;i++){
            day = 1+(week-fistDayOfWeek)+i*7;
            if(day<1 || day >allDays){
                continue;
            }
            date = toDate(year, month, day);
            dayList.add(date);
        }
        return dayList;
    }


    //Month(M,1,T,E, ,D,21:00:00)

    // 得到月份
    public static int getMonth(Date dDate)
    {
        return getDateItems(dDate, Calendar.MONTH) + 1;
    }

    public static Date addDate(Date dDate, int amount, int field) {
        GregorianCalendar cl = new GregorianCalendar();
        cl.setTime(dDate);
        cl.add(field, amount);

        return cl.getTime();
    }

    public static final Date addMonth(Date dDate, int months) {
        return addDate(dDate, months, Calendar.MONTH);
    }

    /**
     * 获得当前年份
     *
     * @return int
     */
    public static int getToYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static java.util.Date toDate(int year,int month,int day){
        GregorianCalendar cl = new GregorianCalendar(year, month-1, day);
        return cl.getTime();
    }

    public static Date getFirstDay(Date baseDate) {
        Date firstDate = null;
        Calendar calendar = null;
        if (null != baseDate) {
            calendar = convertToCalendar(baseDate);
            calendar.set(calendar.get(Calendar.YEAR), 0, 1);
            firstDate = calendar.getTime();
        }
        return firstDate;
    }

    public static Calendar convertToCalendar(Date date) {
        Calendar calendar = null;
        if (null != date) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        }
        return calendar;
    }

    public static int dateDiff(java.util.Date dDate1, java.util.Date dDate2) {
        int year = 0;
        int month = 0;
        int day = 0;
        // 算法说明：这里考虑到了时分秒的差异可能造成的差一天，只设置年月日相减算出差异
        // 失败算法：毫秒数相减除一天毫秒；毫秒数先除再减；毫秒数弥补时区差后先除再减
        // 失败算法：设置calendar的时分秒为0后相减（有时设置不灵）
        GregorianCalendar cl1 = new GregorianCalendar();
        GregorianCalendar cl2 = null;

        cl1.setTime(dDate2);
        // cl1.set(Calendar.MONTH,YssFun.getMonth(dDa);
        year = cl1.get(Calendar.YEAR);
        month = cl1.get(Calendar.MONTH);
        day = cl1.get(Calendar.DAY_OF_MONTH);

        cl2 = new GregorianCalendar(year, month, day);

        cl1.setTime(dDate1);
        year = cl1.get(Calendar.YEAR);
        month = cl1.get(Calendar.MONTH);
        day = cl1.get(Calendar.DAY_OF_MONTH);
        cl1.clear();
        cl1.set(year, month, day);
        return (int) ((cl2.getTimeInMillis() - cl1.getTimeInMillis()) / (1000 * 3600 * 24));
    }

    /**
     * 获取星期一到星期日的值，从星期一开始计算值<br />
     * 解决获取星期几从周日开始计算，改为从周一开始计算<br />
     * Added STORY #28740 华泰证券：邮件自动发送功能需求
     * @param dDate
     * @author huangsq
     * @return
     */
    public static int getWeekDay1to7(Date dDate) {
        int dateItems = getDateItems(dDate, Calendar.DAY_OF_WEEK);
        dateItems = dateItems - 1;
        if (dateItems == 0) {
            dateItems = 7;
        }
        return dateItems;
    }

    /**
     * 返回日期中的任何元素
     *
     * @param field
     *            ：Calendar类中的常数，如YEAR/MONTH/DAY_OF_MONTH... <br>
     *            <b><big>注意返回的month一月份是从0开始的！</big></b>
     */
    public static final int getDateItems(Date dDate, int field)
    {
        GregorianCalendar cl = new GregorianCalendar();
        cl.setTime(dDate);
        return cl.get(field);
    }

}
