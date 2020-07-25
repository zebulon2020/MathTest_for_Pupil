  /*MathExam.java*/
package main;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

class Program extends JFrame{
	private static final long serialVersionUID=-1758475247807861408L;
	private JLabel lb_Tell = new JLabel("��ʾ");  // ���Խ����Ϸ���ʾ�ı�ǩ
	private JLabel lb_Exam = new JLabel("��Ŀ");  //��ǩ����Ŀ��
	private JLabel lb_Answer = new JLabel("�ش�");  // ��ǩ���ش�
	private JLabel lb_Evaluation = new JLabel("����");  // ��ǩ�����ۡ�
	private JLabel lb_Grade = new JLabel("����");  // ��ǩ��������
	private JButton bt_Sure = new JButton("ȷ��");  //��ť��ȷ�ϡ�
	private JButton bt_End= new JButton("����"); // ��ť��������
	private JTextField tt_tell = new JTextField("ѡ��ӷ��������Ȼ����ȷ�Ͽ�ʼ����");  // ��ʾ���ı���
	private JTextField tt_exam = new JTextField("");  // ��Ŀ���ı���
	private JTextField tt_answer = new JTextField(""); // �ش���ı���
	private JTextField tt_evaluation = new JTextField("");  // ���۵��ı���
	private JTextField tt_grade = new JTextField("");  // �ɼ����ı���
	private JRadioButton rbt_Add=new JRadioButton("�ӷ�"); //��ѡť���ӷ�
	private JRadioButton rbt_Sub=new JRadioButton("����"); // ��ѡť������
	private ButtonGroup group = new ButtonGroup();
	public Program() {
		this.setTitle("Сѧ������С����");  
		this.setBounds(500,200,475,300);
		Container contentPane=this.getContentPane();
		contentPane.setLayout(null);
		bt_Sure.setBounds(25, 225, 100, 25);
		bt_End.setBounds(325, 225, 100, 25);
		rbt_Add.setBounds(350, 70, 75, 25);
		rbt_Sub.setBounds(350, 95, 75, 25);
		lb_Tell.setBounds(25,25,50,25);
		lb_Exam.setBounds(25, 120, 50, 25);
		lb_Answer.setBounds(25, 165, 50, 25);
		lb_Evaluation.setBounds(175, 120, 50, 25);
		lb_Grade.setBounds(175,165,50,25);
		tt_tell.setBounds(60, 25, 325, 25);
		tt_tell.setEditable(false); 
		tt_exam.setBounds(60, 120, 100, 25);
		tt_exam.setEditable(false);
		tt_answer.setBounds(60, 165, 100, 25);
		tt_answer.setEditable(false);
		tt_evaluation.setBounds(210, 120, 100, 25);
		tt_evaluation.setEditable(false);
		tt_grade.setBounds(210, 165, 100, 25);
		tt_grade.setEditable(false);
		group.add(rbt_Add);
		group.add(rbt_Sub);
		contentPane.add(bt_Sure);
		contentPane.add(bt_End);
		contentPane.add(lb_Tell);
		contentPane.add(lb_Exam);
		contentPane.add(lb_Answer);
		contentPane.add(lb_Evaluation);
		contentPane.add(lb_Grade);
		contentPane.add(tt_tell);
		contentPane.add(tt_exam);
		contentPane.add(tt_answer);
		contentPane.add(tt_evaluation);
		contentPane.add(tt_grade);
		contentPane.add(rbt_Add);
		contentPane.add(rbt_Sub);
		setBackground();  // �������ñ����ķ���
		JPanel jp = new JPanel();
		jp.setOpaque(false);
		contentPane.add(jp);
		this.setVisible(true);
		bt_Sure.addActionListener(new SureAction(lb_Evaluation,lb_Grade,bt_Sure,
				tt_exam,tt_answer,tt_tell,tt_evaluation,tt_grade,rbt_Add,rbt_Sub));
		bt_End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_EndActionPerformed(e);
			}
		});
	}	
	
	public void bt_EndActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	public void setBackground() {  
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon(".\\picture\\Matin3.jpg");  // ����ͼƬ
		JLabel back = new JLabel(img);
		this.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
		back.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
}

class SureAction implements ActionListener{  // ȷ��
	int wrong1=0; // ��һ�εĴ���
	int wrong2=0; // ����εĴ���
	int wrong3=0; // �����εĴ���
	int num=0; // �����������ȷ�ϰ�ť�Ĵ�����
	int num2=0; 
	int answer=0;
	String rightIt="a";
	private JLabel lb_Evaluation;
	private JLabel lb_Grade;
	private JButton bt_Sure;
	private JTextField tt_exam;
	private JTextField tt_answer;
	private JTextField tt_tell;
	private JTextField tt_evaluation;
	private JTextField tt_grade;
	private JRadioButton rbt_Add;
	private JRadioButton rbt_Sub;
	
	public SureAction(JLabel lb_Evaluation,JLabel lb_Grade,JButton bt_Sure,
			JTextField tt_exam,JTextField tt_answer,JTextField tt_tell,
			JTextField tt_evaluation,JTextField tt_grade,JRadioButton rbt_Add,JRadioButton rbt_Sub){
		this.lb_Evaluation = lb_Evaluation;
		this.lb_Grade = lb_Grade;
		this.bt_Sure = bt_Sure;
		this.tt_exam = tt_exam;
		this.tt_answer = tt_answer;
		this.tt_tell = tt_tell;
		this.tt_evaluation = tt_evaluation;
		this.tt_grade = tt_grade;
		this.rbt_Add = rbt_Add;
		this.rbt_Sub = rbt_Sub;
	}
	
	public void actionPerformed(ActionEvent e) {
		tt_exam.setVisible(true);
		tt_answer.setVisible(true);
		tt_answer.setEditable(true);
		tt_tell.setVisible(true);
		tt_evaluation.setVisible(true);
		tt_grade.setVisible(true);
		lb_Evaluation.setVisible(true);
		lb_Grade.setVisible(true);
		tt_tell.setText("��"+(int)(num+1)+"��");
		String temp = this.tt_exam.getText();
		String temp2 = "";
		String temp3 = this.tt_answer.getText();
		if(temp2.contentEquals(temp)==false && temp3.contentEquals(rightIt)==false) {  // �ش����
			num2++;
			switch(num2) {
			case 1:
				tt_tell.setText("���һ�Σ����»ش�");
				wrong1++;
				tt_answer.setText(null);
				break;
			case 2:
				tt_tell.setText("������Σ����»ش�");
				wrong2++;
				tt_answer.setText(null);
				break;
			case 3:
				tt_tell.setText("������Σ�");
				wrong3++;
				tt_answer.setEditable(false);
				JOptionPane.showMessageDialog(null, "��ȷ����"+answer);
				tt_answer.setText(null);
				break;
			case 4:
			{
				num2=0;
				if(rbt_Add.isSelected()) {  // �ӷ�
					int x = (int)(Math.random()*50);
					int y = (int)(Math.random()*(50-x));
					tt_exam.setText(x+"+"+y+"=");
					answer = x + y;
				}
				if(rbt_Sub.isSelected()) {  // ����
					Random random = new Random();
					int x = (int)(Math.random()*50);
					int y = random.nextInt(x)%(x+1);
					tt_exam.setText(x+"-"+y+"=");
					answer = x - y;
				}
				rightIt = answer + "";
				num++;
				num2=0;
				break;
			}
			}
		}
		if(temp2.contentEquals(temp) || temp3.contentEquals(rightIt)) {  // �ش���ȷ
			if(rbt_Add.isSelected()) {  // �ӷ�
				int x = (int)(Math.random()*50);
				int y = (int)(Math.random()*(50-x));
				tt_exam.setText(x+"+"+y+"=");
				answer = x + y;
			}
			if(rbt_Sub.isSelected()) {  // ����
				Random random = new Random();
				int x = (int)(Math.random()*50);
				int y = random.nextInt(x)%(x+1);
				tt_exam.setText(x+"-"+y+"=");
				answer = x - y;
			}
			rightIt = answer + "";
			tt_answer.setText(null);
			num++;
			num2=0;
		}
		if(num==11) {
			tt_tell.setText("��������鿴���ۼ��ɼ���");
			bt_Sure.setEnabled(false);
			tt_exam.setEditable(false);
			tt_answer.setEditable(false);
			tt_evaluation.setEditable(true);
			tt_grade.setEditable(true);
			int grade = (num-1-wrong1)*10+(wrong1-wrong2)*7+(wrong2-wrong3)*5;  // �������
			tt_grade.setText(grade+"");
			/*�ж�����*/
			if(grade>=90) {
				tt_evaluation.setText("SMART");
			}
			if(grade>=80 && grade<90) {
				tt_evaluation.setText("GOOD");
			}
			if(grade>=70 && grade<80) {
				tt_evaluation.setText("OK");
			}
			if(grade>=60 && grade<70) {
				tt_evaluation.setText("PASS");
			}
			if(grade<60) {
				tt_evaluation.setText("TRY AGAIN");
			}
		}
	}
}

public class MathExam {
	public MathExam() {
		new Program();
	}	
}
