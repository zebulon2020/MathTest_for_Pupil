package main;

import java.awt.event.*;
import java.awt.*;

class Tip extends Frame {
	private static final long serialVersionUID=-1758475247807861408L;
	static Label lb1 = new Label("请注意：");
	static Label lb2 = new Label("共10题加法/减法题");
	static Label lb3 = new Label("50以内的加减法");
	static Label lb4 = new Label("每题有3次机会");
	static Button start = new Button("开始答题");
	public Tip() {
		this.setTitle("提示");
		CloseHandler handler = new CloseHandler();
		this.addWindowListener(handler);
		this.setBackground(Color.DARK_GRAY); // 设置窗体背景色
		this.setForeground(Color.red);  // 设置窗体前景色
		this.setSize(400, 500);  // 设置窗体大小
		this.setLayout(new FlowLayout());  // 设置窗体布局
		// 设置标签字体
		lb1.setFont(new Font("Serif",Font.PLAIN,50));
		lb2.setFont(new Font("Serif",Font.PLAIN,40));
		lb3.setFont(new Font("Serif",Font.PLAIN,40));
		lb4.setFont(new Font("Serif",Font.PLAIN,40));
		start.setFont(new Font("Serif",Font.PLAIN,50));
		// 将标签和按钮添加到窗体中
		this.add(lb1);  
		this.add(lb2);
		this.add(lb3);
		this.add(lb4);
		this.add(start);
		//为按钮start注册侦听器MouseListener
		start.addActionListener((new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StartActionPerformed(e);
			}
		}));
		//使窗体处于屏幕正中央
		this.setLocationRelativeTo(null);
		// 使窗体可见
		this.setVisible(true);
	}
	
	public void StartActionPerformed(ActionEvent e) {
		dispose();  // 释放当前窗体
		new MathExam();  // 调用主程序  
	}
}
/*右上角X实现关闭窗口*/
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
