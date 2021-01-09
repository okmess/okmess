package cn.edu.jsu.yym.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yym.factory.ServiceFactory;
import cn.edu.jsu.yym.vo.Login;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * 登陆操作类
 * @author 86152
 *
 */
public class LogIn1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField textFieldPassword;
	private JLabel lblNameWarning;
	private JLabel lblPasswordWarning;
	private Integer i=0;
	/**
	 * Create the frame.
	 */
	public LogIn1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/***
		 * 登录功能
		 */
		JLabel lblUserName = new JLabel("\u7528\u6237\u540D");
		lblUserName.setFont(new Font("宋体", Font.PLAIN, 20));
		lblUserName.setForeground(Color.YELLOW);
		lblUserName.setBounds(134, 70, 87, 35);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("\u5BC6\u7801");
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 20));
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setBounds(134, 157, 87, 35);
		contentPane.add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(231, 77, 176, 21);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(231, 164, 176, 21);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		lblNameWarning = new JLabel("");
		lblNameWarning.setForeground(Color.RED);
		lblNameWarning.setBounds(411, 80, 120, 15);
		contentPane.add(lblNameWarning);
		
		lblPasswordWarning = new JLabel("");
		lblPasswordWarning.setForeground(Color.RED);
		lblPasswordWarning.setBounds(411, 167, 131, 15);
		contentPane.add(lblPasswordWarning);
		
		JButton btnSignIn = new JButton("\u767B\u5F55");
		btnSignIn.setBounds(278, 237, 97, 23);
		contentPane.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener() {//登录按钮事件监听

			@Override
			public void actionPerformed(ActionEvent e) {
				Login vo=new Login();//实例化一个数据对象
				vo.setUserName(textFieldUserName.getText());//从文本框获得用户名
				vo.setPassword(new String(textFieldPassword.getPassword()));//从文本框获得密码
				Login vo1=ServiceFactory.getILoginServiceInstance().select(vo.getUserName());//通过文本框获得的用户名在数据库查找
				if(vo1==null) {//判断用户是否存在，如果vo1为空则提示账户不存在
					lblPasswordWarning.setText("");
					lblNameWarning.setText("账户不存在");
				}
				else if(vo1.getPassword().equals(vo.getPassword())==false) {//账户存在则判断密码是否正确
					lblNameWarning.setText("");
					lblPasswordWarning.setText("密码错误");
				}
				else {//登陆成功，进入主界面
					new PhotographerApp(vo1);
					setVisible(false);
				}
			}
			
		});
		
		/***
		 * 注册功能
		 */
		JLabel lblRegister = new JLabel("\u6CA1\u6709\u8D26\u53F7\uFF0C\u7ACB\u5373\u6CE8\u518C");
		lblRegister.setBounds(188, 288, 120, 15);
		contentPane.add(lblRegister);
		
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.setBounds(353, 284, 97, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener( new ActionListener() {//注册按钮监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				new Register1();
				
			}
			
		});
		
		ImageIcon img=new ImageIcon("D:\\picture\\apic29952.jpg");
		Interface.BackgroundPicture(this,img);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//界面居中
	}
}
