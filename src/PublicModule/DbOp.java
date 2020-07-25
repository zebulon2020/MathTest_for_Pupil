/*DbOp.java*/
package PublicModule;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbOp {
    private static Connection con=null;
    // ���췽��
    private DbOp() {
    	try {
    		
    		if(con==null) {
    			// �������ݿ�����
    			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		   // ���ݿ������ַ���
    			// jdbc:sqlserver             ����Э��
    			// localhost                  ���ӵ�ַ
    			// 1433                                         ���Ӷ˿�
    			// MyDatabase                 ���ӵ����ݿ�
    			String url = "jdbc:sqlserver://localhost:1433;databaseName=mydbname";
    			// �����ݿ�����
    			// sa   �û���
    			// 216059    ���ݿ����õ�����
    			con = DriverManager.getConnection(url, "sa", "216059");
    		}
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null,"���ݿ�δ�ܴ򿪣�");
    	}
    }
    // ִ�����ݿ��ѯ��������������쳣������null
    public static ResultSet executeQuery(String sql) {
    	try {
    		if(con==null) {
    			new DbOp();
    		}
    		return con.createStatement().executeQuery(sql);
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,"���ݿⲻ���ڻ����");
    		return null;
    	}
    }
    // ִ�����ݿ���²�������������ⷵ��-1
    public static int executeUpdate(String sql) {
    	try {
    		if(con==null) {
    			new DbOp();	
    		}
    		return con.createStatement().executeUpdate(sql);
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,"�������󣬼�¼�޷������������£�");
    		return -1;
    	}
    }
    // �ر����ݿ�
    public static void Close() {
    	try {
    		//������ݿ��Ѵ򿪣���ر�
    		if(con!=null) {
    			con.close();
    		}
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(null,"���ݿ�δ�򿪣�");
    	}
    }
}
