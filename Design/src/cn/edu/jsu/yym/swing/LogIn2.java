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
public class LogIn2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField textFieldPassword;
	private JLabel lblNameWarning;
	private JLabel lblPasswordWarning;
	private Integer i=0;

	/**
	 * Create the frame.
	 */
	public LogIn2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("\u7528\u6237\u540D");
		lblUserName.setFont(new Font("宋体", Font.PLAIN, 20));
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setBounds(128, 70, 87, 35);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("\u5BC6\u7801");
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 20));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(128, 157, 87, 35);
		contentPane.add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(217, 79, 176, 21);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(217, 164, 176, 21);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnSignIn = new JButton("\u767B\u5F55");
		btnSignIn.setBounds(217, 232, 97, 23);
		contentPane.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login vo=new Login();//实例化一个数据对象
				vo.setUserName(textFieldUserName.getText());
				vo.setPassword(new String(textFieldPassword.getPassword()));
				Login vo1=ServiceFactory.getIUseLoginServiceInstance().select(vo.getUserName());
				if(vo1==null) {
					lblPasswordWarning.setText("");
					lblNameWarning.setText("账户不存在");
				}
				else if(vo1.getPassword().equals(vo.getPassword())==false) {
					lblNameWarning.setText("");
					lblPasswordWarning.setText("密码错误");
				}
				else {//登陆成功，进入主界面
					new UserApp(vo1);
					setVisible(false);
				}
			}
			
		});
		
		JLabel lblRegister = new JLabel("\u6CA1\u6709\u8D26\u53F7\uFF0C\u7ACB\u5373\u6CE8\u518C");
		lblRegister.setBounds(156, 288, 120, 15);
		contentPane.add(lblRegister);
		
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.setBounds(315, 284, 97, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Register2();
				
			}
			
		});
		
		lblNameWarning = new JLabel("");
		lblNameWarning.setForeground(Color.RED);
		lblNameWarning.setBounds(403, 79, 115, 21);
		contentPane.add(lblNameWarning);
		
		lblPasswordWarning = new JLabel("");
		lblPasswordWarning.setForeground(Color.RED);
		lblPasswordWarning.setBounds(406, 164, 127, 21);
		contentPane.add(lblPasswordWarning);
		ImageIcon img=new ImageIcon("D:\\picture\\apic29952.jpg");
		Interface.BackgroundPicture(this,img);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//界面居中
	}

}
