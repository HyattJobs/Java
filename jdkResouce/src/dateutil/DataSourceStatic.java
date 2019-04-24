package dateutil;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceStatic {

    private volatile static DataSourceStatic dataSourceStatic= null;

    public  static DruidDataSource ds = new DruidDataSource();

    public DataSourceStatic() {
        getDSResource();
    }

    public static  DataSourceStatic getInstance(){
        if (dataSourceStatic == null){
            synchronized (DataSourceStatic.class){
                if (dataSourceStatic == null){
                    dataSourceStatic = new DataSourceStatic();
                   /* DruidDataSource ds2 = new DruidDataSource();
                    ds2.setUrl("jdbc:oracle:thin:@10.10.90.35:1521:ams");
                    ds2.setUsername("V45_ZYNJGZ");
                    ds2.setPassword("1");
                    ds2.setMaxActive(3);
                    try {
                        Connection c = ds2.getConnection();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        }
        return dataSourceStatic;
    }

    public static void getDSResource(){
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("YSSTECH");
        ds.setPassword("YSSTECH");
        ds.setMaxActive(3);
    }
}
