package druid;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OConnection {
    public static void main(String[] args) throws SQLException {
        DruidDataSource ds =  getDSResource();
        Connection conn = ds.getConnection();
        String sql = "select getDay_HDay('CN',date'2019-04-16',5, 'D') as ywDate from dual";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Date jzDate = new Date();
        if (rs.next()) {
            jzDate = rs.getDate("ywDate");
        }
        System.out.println(jzDate);
        rs.close();
        pstmt.close();
        ds.close();
    }

    public static DruidDataSource getDSResource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:oracle:thin:@10.10.90.35:1521:ams");
        ds.setUsername("v45_zynjgz");
        ds.setPassword("1");
        ds.setMaxActive(1);
        return ds;
    }
}
