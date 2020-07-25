/*Login.java*/
package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import PublicModule.*;

public class Login extends Frame{
	private static final long serialVersionUID=-1758475247807861408L;
	TextField tt_username;
	TextField tt_password;
	public Login(){
		this.setTitle("登录");
		this.setLayout(null);
		this.setSize(260,170);
		/*标签和文本框*/
		Label lb_User = new Label("用户名：");
		Label lb_Pass = new Label("密码：");
		Button bt_OK =new Button("确定");
		Button bt_About = new Button("关于");
		tt_username = new TextField();
		tt_password = new TextField();
		lb_User.setBounds(40,53,60,20);
		lb_Pass.setBounds(40,83,60,20);
		tt_username.setBounds(100, 50, 120, 20);
		tt_password.setBounds(100, 80, 120, 20);
		bt_OK.setBounds(45, 120, 80, 25);
		bt_OK.addActionListener((new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bt_OKActionPerformed(e);
			}
		}));
		bt_About.setBounds(135,120, 80, 25);
		bt_About.addActionListener((new ActionListener(){
			public void actionPerformed(ActionEvent ee){
				bt_AboutActionPerformed(ee);
			}
		}));
		/*关闭窗口*/
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				DbOp.Close();//关闭数据库
				System.exit(0);
			}
		});
		add(lb_User);	add(lb_Pass);	add(tt_username);	add(tt_password);
		add(bt_OK);		add(bt_About);
		setLocationRelativeTo(null);  // 使窗口在屏幕中央
		this.setBackground(Color.LIGHT_GRAY); // 设置登录界面的背景色
		this.setVisible(true);  // 使窗口可见
	}
    
	public void bt_OKActionPerformed(ActionEvent e) {
		String user = tt_username.getText();
		String pass = tt_password.getText();
		//如果用户名或密码任一为空，则终止后续操作
		if(user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null,"用户名或密码不能为空！");
			return;
		}
		try {
			// 核对用户名、密码
			String sql="select * from users where username="+"'"+user+"'and password="+"'"+pass+"'";
			ResultSet rs=DbOp.executeQuery(sql);
		   //用户是否存在
			if(rs.next()) {
			}else {
				JOptionPane.showMessageDialog(null,"用户名或密码不对！");
				return;
			}
			new Tips();  // 调用"提示"程序
			dispose();  // 释放当前窗体
		}catch(SQLException el) {
			JOptionPane.showMessageDialog(null,"用户数据库有误！");
		}
	}
	
	public void bt_AboutActionPerformed(ActionEvent ee) {
		JOptionPane.showMessageDialog(null,"----------------------------------\n"
				+"程序名称：小学生测验小程序"+"\n"
				+"程序著作者：XXX"+"\n"
				+"学号：XXXXXXXX"+"\n"
				+"班级：XXXX"+"\n"
				+"版本号：V1.0.0-2019.12");	
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
