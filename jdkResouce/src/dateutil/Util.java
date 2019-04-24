package dateutil;

import cn.hutool.core.date.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Util {


    public static void main(String[] args) throws Exception {
//        Date nowDate = new Date();
//        System.out.println(dateDiff(nowDate,getFirstDay()));

        Connection conn1 = DataSourceStatic.getInstance().ds.getConnection();
        Connection conn2 = DataSourceStatic.getInstance().ds.getConnection();
        Connection conn3 = DataSourceStatic.getInstance().ds.getConnection();
        conn1.close();
        Connection conn4 = DataSourceStatic.getInstance().ds.getConnection();
        System.out.println(DataSourceStatic.getInstance().ds.getConnectCount());
        System.out.println(DataSourceStatic.getInstance().ds.getActiveCount());
        conn2.close();
        conn3.close();
        conn4.close();

        /*LinkedList<Date> allList = getWDateBase();
        LinkedList<Date> cmpList = new LinkedList<Date>();
        Date nowDate = new Date();
        for (Date oDate: allList) {
            if (dateDiff(nowDate,oDate)<=6)
            cmpList.add(oDate);
        }
        *//*System.out.println("到目前为止所有的工作日:");
        for (Date oDate: cmpList) {
            System.out.println(dateToString(oDate,"yyyy-MM-dd"));
        }*//*

        for (int i = 0; i < allList.size(); i++) {
            if (i%2==0){
                System.out.println(allList.get(i));
            }
        }

        System.out.println("距离间隔的今天:"+cmpList.size()%2);*/

//        Date g2Date = DateUtil.offsetDay(getFirstDay(), 2);
        //insertDataBase();

        /*//存放平年每月的天数
        int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //存放闰年每月的天数
        int[] b = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println(leap(2019));
        int sum = 0;
        for (int i = 0; i < 4-1; i++) {
            System.out.println(a[i]);
            sum+=a[i];
        }
        System.out.println(sum%14);
        System.out.println(14-(sum%14));*/
    }

    public static boolean insertDataBase() throws Exception {
        Connection conn = DataSourceStatic.getInstance().ds.getConnection();
        Date startDate = getFirstDay();
        for (int i = 0; i < 365; i++) {
            try {
                String sql = "insert into T_P_BI_HDAY_SUB (C_IDEN, C_HDAY_CODE, D_HDAY, C_DATE_TYPE, C_DESC, N_CHECK_STATE, C_UPDATE_BY, C_UPDATE_TIME, C_CHECK_BY, C_CHECK_TIME, N_YEAR) values (SEQU_P_BI_HDAY_SUB.NEXTVAL, 'CN', to_date('" + dateToString(startDate, "yyyy-MM-dd") + "', 'yyyy-MM-dd'), 'W', null, 1, 'GM', '20190226 11:05:56', 'GM', '20190226 11:06:29', 2019)";
                startDate = DateUtil.offsetDay(startDate, 1);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        conn.close();
        return true;
    }

    public static Date DateGetUtilNOW(Date g2Date) throws Exception {
        while (getDataBase(g2Date)){
            g2Date = DateUtil.offsetDay(getFirstDay(),1);
        }
        return g2Date;
    }

    public static LinkedList<Date> getWDateBase() throws Exception {
        LinkedList<Date> returnList = new LinkedList<Date>();
        Connection conn = DataSourceStatic.getInstance().ds.getConnection();
        String sql = "SELECT * FROM T_P_BI_HDAY_SUB where C_DATE_TYPE = 'W' ORDER BY d_HDAY ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Date jzDate = null;
        while (rs.next()) {
            jzDate = rs.getDate("D_HDAY");
            returnList.add(jzDate);
        }
        rs.close();
        pstmt.close();
        conn.close();
        return returnList;
    }

    public static boolean getDataBase(Date cDate) throws Exception {
        Connection conn = DataSourceStatic.getInstance().ds.getConnection();
        String sql = "SELECT * FROM T_P_BI_HDAY_SUB WHERE d_HDAY=TO_DATE('"+dateToString(cDate,"yyyy-MM-dd")+"','yyyy-mm-dd') AND c_Date_Type = 'H' and N_Check_State = 1";
//        System.out.println(sql);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Date jzDate = null;
        if (rs.next()) {
            jzDate = rs.getDate("D_HDAY");
        }
        rs.close();
        pstmt.close();
        conn.close();
        if (jzDate == null){
            return false;
        }

        return dateDiff(cDate,jzDate) ==0 ? true: false;
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

    public static String dateToString(java.util.Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
            // log.error(e);
        }
        return result;
    }

    //判断是否是闰年
    public static boolean leap(int a) {
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Date getFirstDay() {
        Date baseDate = new Date();
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

}
