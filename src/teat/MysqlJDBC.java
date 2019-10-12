package teat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlJDBC {
    public static <ClassNotFoundExceptione> void main(String[] args) throws SQLException {
        Connection cn = null;
        //JDBC驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库
        String url = "jdbc:mysql://localhost/jtdb";
        String user = "root";
        String pass = "root";
        try{
            //注册JDBC驱动程序
            Class.forName(driver);
            cn = DriverManager.getConnection(url,user,pass);
            if (!cn.isClosed()){
                 System.out.println("数据库连接成功");
            }
        }catch (ClassNotFoundException e){
            System.out.println("数据库没有安装");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }  finally {
            cn.close();
        }
    }
}
