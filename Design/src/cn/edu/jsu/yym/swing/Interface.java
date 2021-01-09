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
 * 登陆模式操作类
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
	 * @param args 数组
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
	 * 摄影师登录
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPhotographer = new JButton("\u6444\u5F71\u5E08\u767B\u5F55\u754C\u9762");//摄影师登录界面入口按钮
		btnPhotographer.setFont(new Font("宋体", Font.PLAIN, 20));
		btnPhotographer.setBackground(Color.GRAY);
		btnPhotographer.setForeground(Color.PINK);
		btnPhotographer.setBounds(112, 162, 218, 75);
		contentPane.add(btnPhotographer);
		btnPhotographer.setContentAreaFilled(false);
		btnPhotographer.setBorder(null);
		btnPhotographer.addActionListener(new ActionListener() {//点击即跳转至摄影师登录界面

			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn1();
				setVisible(false);
			}
		});
		
		
		/***
		 * 用户登录
		 */
		JButton btnUser = new JButton("\u7528\u6237\u767B\u5F55\u754C\u9762");//用户登录界面入口按钮
		btnUser.setFont(new Font("宋体", Font.PLAIN, 20));
		btnUser.setForeground(Color.PINK);
		btnUser.setBackground(Color.GRAY);
		btnUser.setBounds(112, 338, 218, 75);
		contentPane.add(btnUser);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorder(null);
		btnUser.addActionListener(new ActionListener() {//点击即调整至用户登录界面

			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn2();
				setVisible(false);
			}
			
		});
		
		/***
		 * 背景图片添加
		 */
		ImageIcon img=new ImageIcon("D:\\picture\\apic28030.jpg");
		BackgroundPicture(this,img);
		this.setLocationRelativeTo(null);//界面居中
	}
	
	@SuppressWarnings("deprecation")
	/*
	 * 为界面添加图片
	 */
	/**
	 * 
	 * @param frame 当前界面
	 * @param img 图片
	 */
	public static void BackgroundPicture(JFrame frame,ImageIcon img) {
		JLabel background = new JLabel(img);
		frame.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));//将背景标签添加到JFrame的LayeredPane面板里
		background.setBounds(0, 0, img.getIconWidth(),img.getIconHeight());//设置背景标签位置
		Container cp=frame.getContentPane();
		((JPanel)cp).setOpaque(false);//将内容面板设为透明
		frame.setSize(img.getIconWidth(),img.getIconHeight());
		frame.setResizable(false);
	}
}
