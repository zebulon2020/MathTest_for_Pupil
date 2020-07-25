package main;

import java.awt.event.*;
import java.awt.*;

class Tip extends Frame {
	private static final long serialVersionUID=-1758475247807861408L;
	static Label lb1 = new Label("��ע�⣺");
	static Label lb2 = new Label("��10��ӷ�/������");
	static Label lb3 = new Label("50���ڵļӼ���");
	static Label lb4 = new Label("ÿ����3�λ���");
	static Button start = new Button("��ʼ����");
	public Tip() {
		this.setTitle("��ʾ");
		CloseHandler handler = new CloseHandler();
		this.addWindowListener(handler);
		this.setBackground(Color.DARK_GRAY); // ���ô��屳��ɫ
		this.setForeground(Color.red);  // ���ô���ǰ��ɫ
		this.setSize(400, 500);  // ���ô����С
		this.setLayout(new FlowLayout());  // ���ô��岼��
		// ���ñ�ǩ����
		lb1.setFont(new Font("Serif",Font.PLAIN,50));
		lb2.setFont(new Font("Serif",Font.PLAIN,40));
		lb3.setFont(new Font("Serif",Font.PLAIN,40));
		lb4.setFont(new Font("Serif",Font.PLAIN,40));
		start.setFont(new Font("Serif",Font.PLAIN,50));
		// ����ǩ�Ͱ�ť��ӵ�������
		this.add(lb1);  
		this.add(lb2);
		this.add(lb3);
		this.add(lb4);
		this.add(start);
		//Ϊ��ťstartע��������MouseListener
		start.addActionListener((new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StartActionPerformed(e);
			}
		}));
		//ʹ���崦����Ļ������
		this.setLocationRelativeTo(null);
		// ʹ����ɼ�
		this.setVisible(true);
	}
	
	public void StartActionPerformed(ActionEvent e) {
		dispose();  // �ͷŵ�ǰ����
		new MathExam();  // ����������  
	}
}
/*���Ͻ�Xʵ�ֹرմ���*/
class CloseHandler extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

public class Tips{
	public Tips() {
		new Tip();
	}
}
