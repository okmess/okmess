package cn.edu.jsu.yym.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yym.factory.ServiceFactory;
import cn.edu.jsu.yym.vo.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 * 账户注册操作类
 * @author 86152
 *
 */
public class Register1 extends JFrame {

	private JPanel contentPane;
	private JTextField textNewUserName;
	private JPasswordField textNewPassword;
	private JPasswordField textNewPassword2;
	private JLabel lblPasswordWarning;

	/**
	 * Create the frame.
	 */
	public Register1() {//注册摄影师用户
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUserName = new JLabel("\u65B0\u7528\u6237");
		lblNewUserName.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewUserName.setBounds(145, 100, 67, 22);
		contentPane.add(lblNewUserName);
		
		JLabel lblNewPassword = new JLabel("\u5BC6\u7801");
		lblNewPassword.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewPassword.setBounds(145, 156, 58, 22);
		contentPane.add(lblNewPassword);
		
		JLabel lblNewPassword2 = new JLabel("\u91CD\u65B0\u8F93\u5165\u5BC6\u7801");
		lblNewPassword2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewPassword2.setBounds(145, 210, 121, 22);
		contentPane.add(lblNewPassword2);
		
		textNewUserName = new JTextField();
		textNewUserName.setBounds(276, 101, 133, 21);
		contentPane.add(textNewUserName);
		textNewUserName.setColumns(10);
		
		textNewPassword = new JPasswordField();
		textNewPassword.setColumns(10);
		textNewPassword.setBounds(276, 157, 133, 21);
		contentPane.add(textNewPassword);
		
		textNewPassword2 = new JPasswordField();
		textNewPassword2.setColumns(10);
		textNewPassword2.setBounds(276, 211, 133, 21);
		contentPane.add(textNewPassword2);
		
		lblPasswordWarning = new JLabel("");
		lblPasswordWarning.setForeground(Color.RED);
		lblPasswordWarning.setBounds(323, 157, 122, 15);
		contentPane.add(lblPasswordWarning);
		
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.setFont(new Font("宋体", Font.PLAIN, 15));
		btnRegister.setBounds(216, 273, 97, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {//注册按钮监听事件

			@Override
			public void actionPerformed(ActionEvent e) {
				Login vo=new Login();//实例化一个账户vo对象
				vo.setUserName(textNewUserName.getText());//从文本框获取新账户名
				String pat="^\\w+$";//判断是否为由数字、26个英文字母或者下划线组成的字符串
				Pattern p=Pattern.compile(pat);//定义正则标准
				Matcher m=p.matcher(vo.getUserName());
				Login vo1=null;
				vo1=ServiceFactory.getILoginServiceInstance().select(vo.getUserName());
				if("".equals(vo.getUserName())) {//账户名不能为空
					JOptionPane.showMessageDialog(null, "请输入要注册的账号");
				}else if(vo1!=null){
					JOptionPane.showMessageDialog(null, "账户已存在");
				}else if(!m.matches()) {//判断账户的格式
					JOptionPane.showMessageDialog(null, "用户名格式不正确，请重新输入");
				}else if("".equals(new String(textNewPassword.getPassword()))&&"".equals(new String(textNewPassword2.getPassword()))) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
				}else if(new String(textNewPassword.getPassword()).equals(new String(textNewPassword2.getPassword()))) {
					vo.setPassword(new String(textNewPassword.getPassword()));
					ServiceFactory.getILoginServiceInstance().insert(vo);
					JOptionPane.showMessageDialog(null, "注册成功");
					lblPasswordWarning.setText("");
					setVisible(false);
				}else {
					lblPasswordWarning.setText("两次输入的密码不相同");
				}
			}
			
		});
		
		ImageIcon img=new ImageIcon("D:\\picture\\apic29952.jpg");
		Interface.BackgroundPicture(this,img);
		this.setVisible(true);
		this.setResizable(false);//固定界面
		this.setLocationRelativeTo(null);//界面居中
	}

}
