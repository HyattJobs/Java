package HutoolNext;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.util.TimeZone;

public class HuTest {
    public static void main(String[] args) {
        /*System.out.println(DateUtil.lastWeek());
        System.out.println(TimeZone.getDefault());
        System.out.println(1 << 3);
    */
        //System.out.println(delLastSplitMark("2018-11-01 "," 00:00:00").trim());
        //.length()
    /*    System.out.println(delLengthTO("  2018-11-01 00:00:00",10,true,true));
        System.out.println(delLengthTO("  2018-11-01 ",10,true,true));
        System.out.println(delLengthTO(" 2018-11-01",20,true,true));
*/
        String[] dsA = {"1101", "1102", "1104", "1210", "1211", "1212", "1213", "1221", "9005", "1223", "1224", "1227", "1228", "1231",
                "1232", "1302", "1303", "1304", "1305", "1308", "1351", "9001", "9002", "9003", "9004"};
        String[] formatA = {"standard", "pingan", "GSYH", "ZGRS", "CJ", "RB", "JXYL", "taikang"};
        int index=0;
        while (index<dsA.length) {
            index++;
            continue;
        }

        }

    public static String delLengthTO(String buf, int strLength,boolean isTrimBefore,boolean isTrimAfter) {
        if (buf==null || "".equals(buf)) {
            return "";
        }
        if(isTrimBefore){
            buf = buf.trim();
        }
        if(strLength > buf.length())
        {
            return buf;
        }
        try{
            buf = buf.substring(0, strLength);
        }catch(Exception e){
           e.printStackTrace();
        }
        if(isTrimAfter){
            buf = buf.trim();
        }
        return buf;
    }

    public static String delLastSplitMark(String str, String splitMark) {
        int bufLength, splitMarkLength;

        try {
            if (str.endsWith(splitMark)) {
                splitMarkLength = splitMark.length();
                bufLength = str.length();

                str = str.substring(0, (bufLength - splitMarkLength));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }
}
