/*DbOp.java*/
package PublicModule;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbOp {
    private static Connection con=null;
    // 构造方法
    private DbOp() {
    	try {
    		
    		if(con==null) {
    			// 加载数据库驱动
    			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		   // 数据库连接字符串
    			// jdbc:sqlserver             连接协议
    			// localhost                  连接地址
    			// 1433                                         连接端口
    			// MyDatabase                 连接的数据库
    			String url = "jdbc:sqlserver://localhost:1433;databaseName=mydbname";
    			// 打开数据库连接
    			// sa   用户名
    			// 216059    数据库设置的密码
    			con = DriverManager.getConnection(url, "sa", "216059");
    		}
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null,"数据库未能打开！");
    	}
    }
    // 执行数据库查询工作。如果出现异常，返回null
    public static ResultSet executeQuery(String sql) {
    	try {
    		if(con==null) {
    			new DbOp();
    		}
    		return con.createStatement().executeQuery(sql);
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,"数据库不存在或错误！");
    		return null;
    	}
    }
    // 执行数据库更新操作。如果有问题返回-1
    public static int executeUpdate(String sql) {
    	try {
    		if(con==null) {
    			new DbOp();	
    		}
    		return con.createStatement().executeUpdate(sql);
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,"数据有误，记录无法正常保存或更新！");
    		return -1;
    	}
    }
    // 关闭数据库
    public static void Close() {
    	try {
    		//如果数据库已打开，则关闭
    		if(con!=null) {
    			con.close();
    		}
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,"数据库未打开！");
    	}
    }
}
