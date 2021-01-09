package cn.edu.jsu.yym.swing;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 * ��½ģʽ������
 * @author 86152
 *
 */
public class Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * 
	 * @param args ����
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	/***
	 * ��Ӱʦ��¼
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPhotographer = new JButton("\u6444\u5F71\u5E08\u767B\u5F55\u754C\u9762");//��Ӱʦ��¼������ڰ�ť
		btnPhotographer.setFont(new Font("����", Font.PLAIN, 20));
		btnPhotographer.setBackground(Color.GRAY);
		btnPhotographer.setForeground(Color.PINK);
		btnPhotographer.setBounds(112, 162, 218, 75);
		contentPane.add(btnPhotographer);
		btnPhotographer.setContentAreaFilled(false);
		btnPhotographer.setBorder(null);
		btnPhotographer.addActionListener(new ActionListener() {//�������ת����Ӱʦ��¼����

			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn1();
				setVisible(false);
			}
		});
		
		
		/***
		 * �û���¼
		 */
		JButton btnUser = new JButton("\u7528\u6237\u767B\u5F55\u754C\u9762");//�û���¼������ڰ�ť
		btnUser.setFont(new Font("����", Font.PLAIN, 20));
		btnUser.setForeground(Color.PINK);
		btnUser.setBackground(Color.GRAY);
		btnUser.setBounds(112, 338, 218, 75);
		contentPane.add(btnUser);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorder(null);
		btnUser.addActionListener(new ActionListener() {//������������û���¼����

			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn2();
				setVisible(false);
			}
			
		});
		
		/***
		 * ����ͼƬ���
		 */
		ImageIcon img=new ImageIcon("D:\\picture\\apic28030.jpg");
		BackgroundPicture(this,img);
		this.setLocationRelativeTo(null);//�������
	}
	
	@SuppressWarnings("deprecation")
	/*
	 * Ϊ�������ͼƬ
	 */
	/**
	 * 
	 * @param frame ��ǰ����
	 * @param img ͼƬ
	 */
	public static void BackgroundPicture(JFrame frame,ImageIcon img) {
		JLabel background = new JLabel(img);
		frame.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));//��������ǩ��ӵ�JFrame��LayeredPane�����
		background.setBounds(0, 0, img.getIconWidth(),img.getIconHeight());//���ñ�����ǩλ��
		Container cp=frame.getContentPane();
		((JPanel)cp).setOpaque(false);//�����������Ϊ͸��
		frame.setSize(img.getIconWidth(),img.getIconHeight());
		frame.setResizable(false);
	}
}
