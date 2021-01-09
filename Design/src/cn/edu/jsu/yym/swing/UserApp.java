package cn.edu.jsu.yym.swing;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yym.factory.ServiceFactory;
import cn.edu.jsu.yym.vo.Login;
import cn.edu.jsu.yym.vo.Personal01;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Color;

/**
 * 用户主页类
 * @author 86152
 *
 */
public class UserApp {

	private JFrame frame;
	private JTextField textSearch;
	private JPasswordField textPasswordOld;
	private JPasswordField textPasswordNew;
	private JPasswordField textPasswordNew1;
	private DefaultTableModel tableModel=null;
	private JTable table;
	private JTextField textName;
	private JTextField textSex;
	private JTextField textWorkPlace;
	private JTextField textStyle;
	private JTextField textPhone;
	private JTextArea textAreaDescribe;
	private JLabel lblName;
	private JLabel lblSex;
	private JLabel lblWorkPlace;
	private JLabel lblStyle;
	private JLabel lblPhone;
	private JLabel lblDescribe;
	private JButton btnOrdering;
	private JButton btnRefresh;
	private Vector<Vector> OrdersVo;
	private JButton btnCancellation;

	/**
	 * Create the application.
	 */
	
	/**
	 * 
	 * @param v 传入的账号信息
	 */
	public UserApp(Login v) {
		initialize();
		this.frame.setVisible(true);
		this.frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);//设置面板提供选择
		tabbedPane.setBounds(10, 10, 776, 563);
		frame.getContentPane().add(tabbedPane);
		
		/**
		 * 搜索功能
		 */
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("搜索", null, panelSearch, null);
		panelSearch.setLayout(null);
		
		JLabel lblSearch = new JLabel("\u641C\u7D22\u6444\u5F71\u5E08");
		lblSearch.setFont(new Font("宋体", Font.PLAIN, 17));
		lblSearch.setBounds(135, 76, 97, 24);
		panelSearch.add(lblSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(256, 78, 269, 23);
		panelSearch.add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnSearch = new JButton("\u641C\u7D22");
		btnSearch.setBounds(559, 78, 97, 23);
		panelSearch.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=textSearch.getText();
				int i=2;
				String pat="^\\w+$";//判断是否为由数字、26个英文字母或者下划线组成的字符串
				Pattern p=Pattern.compile(pat);
				Matcher m=p.matcher(name);
				if(m.matches()) {
					i=1;
				}
				Personal01 vo=ServiceFactory.getIPersonal01ServiceInstance().select(name, i);
				if(vo.getUseName()==null) {
					JOptionPane.showMessageDialog(null, "未查找到该摄影师用户或该摄影师用户还未编辑个人信息");
				}else {
					textName.setText(vo.getName());
					textSex.setText(vo.getSex());
					textWorkPlace.setText(vo.getWorkPlace());
					textStyle.setText(vo.getStyle());
					textPhone.setText(vo.getPhone());
					textAreaDescribe.setText(vo.getDescribe());
					lblName.setVisible(true);
					lblSex.setVisible(true);
					lblWorkPlace.setVisible(true);
					lblStyle.setVisible(true);
					lblPhone.setVisible(true);
					lblDescribe.setVisible(true);
					textName.setVisible(true);
					textSex.setVisible(true);
					textWorkPlace.setVisible(true);
					textStyle.setVisible(true);
					textPhone.setVisible(true);
					textAreaDescribe.setVisible(true);
					btnOrdering.setVisible(true);
					btnOrdering.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							new FillOrder(v.getUserName(),vo.getUseName());
							
						}
						
					});
				}		
			}
			
		});
		
		lblName = new JLabel("\u6635\u79F0");
		lblName.setBounds(189, 174, 80, 21);
		panelSearch.add(lblName);
		lblName.setVisible(false);
		
		lblSex = new JLabel("\u6027\u522B");
		lblSex.setBounds(189, 205, 58, 21);
		panelSearch.add(lblSex);
		lblSex.setVisible(false);
		
		lblWorkPlace = new JLabel("\u5DE5\u4F5C\u5730\u70B9");
		lblWorkPlace.setBounds(189, 236, 58, 24);
		panelSearch.add(lblWorkPlace);
		lblWorkPlace.setVisible(false);
		
		lblStyle = new JLabel("\u62CD\u6444\u98CE\u683C");
		lblStyle.setBounds(189, 270, 58, 18);
		panelSearch.add(lblStyle);
		lblStyle.setVisible(false);
		
		lblPhone = new JLabel("\u7535\u8BDD");
		lblPhone.setBounds(189, 298, 58, 18);
		panelSearch.add(lblPhone);
		lblPhone.setVisible(false);
		
		lblDescribe = new JLabel("\u63CF\u8FF0");
		lblDescribe.setBounds(189, 326, 58, 21);
		panelSearch.add(lblDescribe);
		lblDescribe.setVisible(false);
		
		textName = new JTextField();
		textName.setBounds(301, 174, 198, 21);
		panelSearch.add(textName);
		textName.setColumns(10);
		textName.setEditable(false);
		textName.setVisible(false);
		
		textSex = new JTextField();
		textSex.setColumns(10);
		textSex.setBounds(301, 205, 198, 21);
		panelSearch.add(textSex);
		textSex.setEditable(false);
		textSex.setVisible(false);
		
		textWorkPlace = new JTextField();
		textWorkPlace.setColumns(10);
		textWorkPlace.setBounds(301, 238, 198, 21);
		panelSearch.add(textWorkPlace);
		textWorkPlace.setEditable(false);
		textWorkPlace.setVisible(false);
		
		textStyle = new JTextField();
		textStyle.setColumns(10);
		textStyle.setBounds(301, 269, 198, 21);
		panelSearch.add(textStyle);
		textStyle.setEditable(false);
		textStyle.setVisible(false);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(301, 300, 198, 21);
		panelSearch.add(textPhone);
		textPhone.setEditable(false);
		textPhone.setVisible(false);
		
		textAreaDescribe = new JTextArea();
		textAreaDescribe.setBounds(301, 330, 269, 101);
		panelSearch.add(textAreaDescribe);
		textAreaDescribe.setEditable(false);
		textAreaDescribe.setVisible(false);
		
		btnOrdering = new JButton("\u521B\u5EFA\u8BA2\u5355");
		btnOrdering.setBackground(new Color(175, 238, 238));
		btnOrdering.setBounds(473, 466, 97, 23);
		panelSearch.add(btnOrdering);
		btnOrdering.setVisible(false);
		
		
		/**
		 * 个人中心
		 */
		JPanel panelPersonal = new JPanel();
		panelPersonal.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("个人中心", null, panelPersonal, null);
		panelPersonal.setLayout(null);
		
		JTabbedPane tabbedPersonal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPersonal.setBounds(31, 23, 667, 414);
		panelPersonal.add(tabbedPersonal);
		
		/***
		 * 订单
		 */
		JPanel panelorders = new JPanel();
		panelorders.setBackground(Color.PINK);
		tabbedPersonal.addTab("订单", null, panelorders, null);
		panelorders.setLayout(null);
		
		Vector<String> titles=new Vector<String>();//形成表格
		Collections.addAll(titles, "订单号","客户姓名","客户性别","约拍风格","订单状态","摄影师");
		OrdersVo=null;
		OrdersVo=ServiceFactory.getIOrdersServiceInstance().selectAll(v.getUserName(),2);
		tableModel=new DefaultTableModel(OrdersVo,titles);
		table=new JTable(tableModel);
		table.setBounds(80, 127, 512, 223);
		panelorders.add(table);
		JScrollPane scrollPane = new JScrollPane(this.table);
		scrollPane.setBounds(62, 108, 547, 251);
		panelorders.add(scrollPane);
		
		JLabel lblMyOrders = new JLabel("\u6211\u7684\u8BA2\u5355");
		lblMyOrders.setBounds(36, 24, 74, 24);
		panelorders.add(lblMyOrders);
		
		btnRefresh = new JButton("\u5237\u65B0");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdersVo=ServiceFactory.getIOrdersServiceInstance().selectAll(v.getUserName(),2);
				Iterator iter=OrdersVo.iterator();
				int count=tableModel.getRowCount()-1;
				while(count>=0) {
					tableModel.removeRow(count);
					count--;
				}
				while(iter.hasNext()) {
					Vector<String> ordersVo1=(Vector<String>) iter.next();
					tableModel.addRow(ordersVo1);
				}
			}
			
		});
		btnRefresh.setBounds(466, 55, 97, 23);
		panelorders.add(btnRefresh);
		
		btnCancellation = new JButton("\u6CE8\u9500");//注销
		btnCancellation.setBounds(512, 10, 97, 23);
		panelorders.add(btnCancellation);
		btnCancellation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean i=false;
				i=ServiceFactory.getIUseLoginServiceInstance().remove(v.getUserName());
				if(i) {
					JOptionPane.showMessageDialog(null, "注销成功");
					System.exit(1);
				}
			}
			
		});
		
		/***
		 * 密码修改
		 */
		JPanel panelPasswordChange = new JPanel();
		panelPasswordChange.setBackground(new Color(169, 169, 169));
		tabbedPersonal.addTab("修改密码", null, panelPasswordChange, null);
		panelPasswordChange.setLayout(null);
		
		JLabel lblOldPassword = new JLabel("\u65E7\u5BC6\u7801");
		lblOldPassword.setBounds(153, 93, 58, 21);
		panelPasswordChange.add(lblOldPassword);
		
		textPasswordOld = new JPasswordField();
		textPasswordOld.setBounds(276, 93, 180, 21);
		panelPasswordChange.add(textPasswordOld);
		
		JLabel lblNewPassword = new JLabel("\u65B0\u5BC6\u7801");
		lblNewPassword.setBounds(153, 148, 58, 21);
		panelPasswordChange.add(lblNewPassword);
		
		JLabel lblNewPassword1 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
		lblNewPassword1.setBounds(153, 207, 83, 21);
		panelPasswordChange.add(lblNewPassword1);
		
		textPasswordNew = new JPasswordField();
		textPasswordNew.setBounds(276, 148, 180, 21);
		panelPasswordChange.add(textPasswordNew);
		
		textPasswordNew1 = new JPasswordField();
		textPasswordNew1.setBounds(276, 207, 180, 21);
		panelPasswordChange.add(textPasswordNew1);
		
		JLabel lblPasswordWarning1 = new JLabel("");
		lblPasswordWarning1.setForeground(Color.RED);
		lblPasswordWarning1.setBounds(466, 96, 123, 15);
		panelPasswordChange.add(lblPasswordWarning1);
		
		JLabel lblPasswordWarning = new JLabel("");
		lblPasswordWarning.setForeground(Color.RED);
		lblPasswordWarning.setBounds(475, 210, 163, 15);
		panelPasswordChange.add(lblPasswordWarning);
		tabbedPane.setBounds(15, 15, 776, 563);
		
		JButton btnPasswordChange = new JButton("\u786E\u8BA4");
		btnPasswordChange.setBounds(244, 287, 97, 23);
		panelPasswordChange.add(btnPasswordChange);
		btnPasswordChange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login vo1=new Login();
				vo1.setUserName(v.getUserName());
				if(!new String(textPasswordOld.getPassword()).equals(v.getPassword())) {
					lblPasswordWarning1.setText("原密码不正确");
					lblPasswordWarning.setText("");
				}else if(new String(textPasswordNew.getPassword()).equals(new String(textPasswordNew1.getPassword()))) {
					vo1.setPassword(new String(textPasswordNew.getPassword()));
					ServiceFactory.getIUseLoginServiceInstance().update(vo1);
					lblPasswordWarning.setText("");
					lblPasswordWarning1.setText("");
					JOptionPane.showMessageDialog(null, "密码修改成功");
					textPasswordOld.setText("");
					textPasswordNew.setText("");
					textPasswordNew1.setText("");
				}else {
					lblPasswordWarning1.setText("");
					lblPasswordWarning.setText("两次输入的密码不相同");
				}
				
			}
			
		});
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
