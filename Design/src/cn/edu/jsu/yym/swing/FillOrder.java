package cn.edu.jsu.yym.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yym.factory.ServiceFactory;
import cn.edu.jsu.yym.vo.Login;
import cn.edu.jsu.yym.vo.Orders;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 订单填写操作类
 * @author 86152
 *
 */
public class FillOrder extends JFrame {
	private static String number="2021";
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSex;
	private JTextField textStyle;
	private static String numberNow;
	private static int nub=500001;

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 * @param userName 用户名
	 * @param photographUserName 摄影师用户名
	 */
	public FillOrder(String userName,String photographUserName) {
		readNumber();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("\u59D3\u540D");
		lblName.setBounds(207, 113, 69, 25);
		contentPane.add(lblName);
		
		JLabel lblSex = new JLabel("\u6027\u522B");
		lblSex.setBounds(205, 161, 58, 22);
		contentPane.add(lblSex);
		
		JLabel lblStyle = new JLabel("\u7EA6\u62CD\u98CE\u683C");
		lblStyle.setBounds(200, 218, 58, 23);
		contentPane.add(lblStyle);
		
		JLabel lblFillOrder = new JLabel("\u8BF7\u586B\u5199\u8BA2\u5355\u4FE1\u606F");
		lblFillOrder.setFont(new Font("宋体", Font.PLAIN, 20));
		lblFillOrder.setBounds(250, 34, 172, 24);
		contentPane.add(lblFillOrder);
		
		textName = new JTextField();
		textName.setBounds(300, 110, 119, 21);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSex = new JTextField();
		textSex.setColumns(10);
		textSex.setBounds(299, 160, 66, 21);
		contentPane.add(textSex);
		
		textStyle = new JTextField();
		textStyle.setColumns(10);
		textStyle.setBounds(300, 219, 139, 21);
		contentPane.add(textStyle);
		
		JButton btn = new JButton("\u786E\u5B9A");
		btn.setBounds(265, 327, 97, 23);
		contentPane.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Orders vo=new Orders();
				vo.setPhotographUserName(photographUserName);
				vo.setUserName(userName);
				vo.setName(textName.getText());
				vo.setSex(textSex.getText());
				vo.setStyle(textStyle.getText());
				vo.setStatus("未完成");
				numberNow=generateOrder();
				saveNumber();
				vo.setOrderNumber(numberNow);
				ServiceFactory.getIOrdersServiceInstance().insert(vo);
				JOptionPane.showMessageDialog(null, "订单创建成功");
				System.exit(1);
			}
			
		});
		this.setVisible(true);
	}
	/**
	 * 
	 * @return 当前订单号
	 */
	public static String generateOrder() {
		String Number = null;
		if(nub<10) {
			Number=number+"000000"+nub;
		}else if(nub<100){
			Number=number+"00000"+nub;
		}else if(nub<1000) {
			Number=number+"0000"+nub;
		}else if(nub<10000) {
			Number=number+"000"+nub;
		}else if(nub<100000) {
			Number=number+"00"+nub;
		}else if(nub<1000000) {
			Number=number+"0"+nub;
		}else if(nub<10000000) {
			Number=number+nub;
		}
		nub++;
		return Number;
	}
	/**
	 * 
	 */
	public static void saveNumber() {
		File f=new File("D:"+File.separator+"study"+File.separator+"orderNumber.txt");
		FileWriter write=null;
		try {
			write=new FileWriter(f);
			String n=String.valueOf(nub);
			write.write(n);
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 */
	public static void readNumber() {
		File f=new File("D:"+File.separator+"study"+File.separator+"orderNumber.txt");
			Scanner scan;
			try {
				scan = new Scanner(f);
				nub=scan.nextInt();
				scan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
