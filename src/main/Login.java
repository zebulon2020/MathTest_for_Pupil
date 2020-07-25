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
		this.setTitle("��¼");
		this.setLayout(null);
		this.setSize(260,170);
		/*��ǩ���ı���*/
		Label lb_User = new Label("�û�����");
		Label lb_Pass = new Label("���룺");
		Button bt_OK =new Button("ȷ��");
		Button bt_About = new Button("����");
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
		/*�رմ���*/
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				DbOp.Close();//�ر����ݿ�
				System.exit(0);
			}
		});
		add(lb_User);	add(lb_Pass);	add(tt_username);	add(tt_password);
		add(bt_OK);		add(bt_About);
		setLocationRelativeTo(null);  // ʹ��������Ļ����
		this.setBackground(Color.LIGHT_GRAY); // ���õ�¼����ı���ɫ
		this.setVisible(true);  // ʹ���ڿɼ�
	}
    
	public void bt_OKActionPerformed(ActionEvent e) {
		String user = tt_username.getText();
		String pass = tt_password.getText();
		//����û�����������һΪ�գ�����ֹ��������
		if(user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ�գ�");
			return;
		}
		try {
			// �˶��û���������
			String sql="select * from users where username="+"'"+user+"'and password="+"'"+pass+"'";
			ResultSet rs=DbOp.executeQuery(sql);
		   //�û��Ƿ����
			if(rs.next()) {
			}else {
				JOptionPane.showMessageDialog(null,"�û��������벻�ԣ�");
				return;
			}
			new Tips();  // ����"��ʾ"����
			dispose();  // �ͷŵ�ǰ����
		}catch(SQLException el) {
			JOptionPane.showMessageDialog(null,"�û����ݿ�����");
		}
	}
	
	public void bt_AboutActionPerformed(ActionEvent ee) {
		JOptionPane.showMessageDialog(null,"----------------------------------\n"
				+"�������ƣ�Сѧ������С����"+"\n"
				+"���������ߣ�XXX"+"\n"
				+"ѧ�ţ�XXXXXXXX"+"\n"
				+"�༶��XXXX"+"\n"
				+"�汾�ţ�V1.0.0-2019.12");	
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
