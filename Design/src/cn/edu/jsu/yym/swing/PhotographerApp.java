package cn.edu.jsu.yym.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yym.factory.ServiceFactory;
import cn.edu.jsu.yym.vo.Login;
import cn.edu.jsu.yym.vo.Orders;
import cn.edu.jsu.yym.vo.Personal01;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.SystemColor;

/**
 * 摄影师用户主页类
 * @author 86152
 *
 */
public class PhotographerApp {

	private JFrame frame;
	private JTextField textName;
	private JTextField textWorkPlace;
	private JTextField textSex;
	private JTextField textStyle;
	private JTextField textPhone;
	private JPasswordField textPasswordOld;
	private JPasswordField textPasswordNew;
	private JPasswordField textPasswordNew1;
	private JTable table;
	private DefaultTableModel tableModel=null;
	private JTextField textSearchStatus;
	private JTextField textSearchResult;
	private JTextField textSearchResult1;
	private JButton btnSearchResult;
	private Vector<Vector> ordersVo;
	private Vector<String> orderVo;
	private JScrollPane scrollPane;
	
	/**
	 * Create the application.
	 */
	
	/**
	 * 
	 * @param v 传入账户名
	 */
	public PhotographerApp(Login v) {
		initialize();
		this.frame.setVisible(true);
		this.frame.setLocationRelativeTo(null);//界面居中
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);//设置面板提供选择
		tabbedPane.setBounds(10, 10, 776, 563);
		frame.getContentPane().add(tabbedPane);
		
		/**
		 * 个人信息面板
		 */
		JPanel panelPersonal = new JPanel();
		panelPersonal.setBackground(Color.PINK);
		panelPersonal.setToolTipText("");
		tabbedPane.addTab("个人信息", null, panelPersonal, null);
		panelPersonal.setLayout(null);
		
		JLabel lblHeadPortrait = new JLabel("\u5934\u50CF");
		lblHeadPortrait.setBounds(360, 37, 66, 25);
		panelPersonal.add(lblHeadPortrait);
		
		JLabel lblName = new JLabel("\u6635\u79F0");
		lblName.setBounds(143, 99, 58, 15);
		panelPersonal.add(lblName);
		
		JLabel lblWorkPlace = new JLabel("\u5DE5\u4F5C\u5730\u70B9");
		lblWorkPlace.setBounds(143, 188, 58, 15);
		panelPersonal.add(lblWorkPlace);
		
		JLabel lblSex = new JLabel("\u6027\u522B");
		lblSex.setBounds(141, 146, 43, 15);
		panelPersonal.add(lblSex);
		
		JLabel lblStyle = new JLabel("\u64C5\u957F\u62CD\u6444\u98CE\u683C");
		lblStyle.setBounds(143, 233, 86, 15);
		panelPersonal.add(lblStyle);
		
		JLabel lblDescribe = new JLabel("\u4E2A\u4EBA\u63CF\u8FF0");
		lblDescribe.setBounds(143, 310, 63, 15);
		panelPersonal.add(lblDescribe);
		
		Personal01 vo1=ServiceFactory.getIPersonal01ServiceInstance().select(v.getUserName(),1);
		textName = new JTextField();
		textName.setBounds(229, 96, 215, 21);
		panelPersonal.add(textName);
		textName.setColumns(10);
		textName.setText(vo1.getName());
		textName.setEditable(false);
		
		
		textWorkPlace = new JTextField();
		textWorkPlace.setBounds(229, 185, 267, 21);
		panelPersonal.add(textWorkPlace);
		textWorkPlace.setColumns(10);
		textWorkPlace.setText(vo1.getWorkPlace());
		textWorkPlace.setEditable(false);
		
		textSex = new JTextField();
		textSex.setBounds(229, 143, 66, 21);
		panelPersonal.add(textSex);
		textSex.setColumns(10);
		textSex.setText(vo1.getSex());
		textSex.setEditable(false);
		
		textStyle = new JTextField();
		textStyle.setBounds(229, 230, 267, 21);
		panelPersonal.add(textStyle);
		textStyle.setColumns(10);
		textStyle.setText(vo1.getStyle());
		textStyle.setEditable(false);
		
		JTextArea textAreaDescribe = new JTextArea();
		textAreaDescribe.setBounds(201, 331, 300, 144);
		panelPersonal.add(textAreaDescribe);
		textAreaDescribe.setText(vo1.getDescribe());
		textAreaDescribe.setEditable(false);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539");
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setText("修改");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnUpdate.getText().equals("修改"))
				{
					textName.setEditable(true);
					textWorkPlace.setEditable(true);
					textSex.setEditable(true);
					textStyle.setEditable(true);
					textPhone.setEditable(true);
					textAreaDescribe.setEditable(true);
					btnUpdate.setText("确认修改");
				} else if(btnUpdate.getText().equals("确认修改")) {
					Personal01 personalVo = new Personal01();
					personalVo.setUseName(v.getUserName());
					personalVo.setName(textName.getText());
					personalVo.setSex(textSex.getText());
					personalVo.setWorkPlace(textWorkPlace.getText());
					personalVo.setStyle(textStyle.getText());
					personalVo.setPhone(textPhone.getText());
					personalVo.setDescribe(textAreaDescribe.getText());
					ServiceFactory.getIPersonal01ServiceInstance().update(personalVo);
					btnUpdate.setText("修改");
					textName.setEditable(false);
					textWorkPlace.setEditable(false);
					textSex.setEditable(false);
					textStyle.setEditable(false);
					textPhone.setEditable(false);
					textAreaDescribe.setEditable(false);
				}
			}
		});
		btnUpdate.setBounds(400, 491, 97, 23);
		panelPersonal.add(btnUpdate);
		
		JLabel lblPhone = new JLabel("\u7535\u8BDD");
		lblPhone.setBounds(143, 277, 58, 15);
		panelPersonal.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setBounds(229, 274, 215, 21);
		panelPersonal.add(textPhone);
		textPhone.setColumns(10);
		textPhone.setText(vo1.getPhone());
		textPhone.setEditable(false);
		
		JButton btnCancellation = new JButton("\u6CE8\u9500");//注销
		btnCancellation.setBounds(664, 10, 97, 23);
		panelPersonal.add(btnCancellation);
		btnCancellation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean i=false;
				String newUserName=v.getUserName()+"(已注销)";
				ServiceFactory.getIOrdersServiceInstance().update(v.getUserName(),newUserName);
				i=ServiceFactory.getILoginServiceInstance().remove(v.getUserName());
				if(i) {
					JOptionPane.showMessageDialog(null, "注销成功");
					System.exit(1);
				}
			}
			
		});
		
		/**
		 * //订单面板
		 */
		JPanel panelSearchStatus = new JPanel();
		panelSearchStatus.setBackground(Color.GRAY);
		tabbedPane.addTab("订单", null, panelSearchStatus, null);
		panelSearchStatus.setLayout(null);
		
		Vector<String> titles=new Vector<String>();//形成表格
		Collections.addAll(titles, "订单号","客户姓名","客户性别","约拍风格","订单状态","客户名");
		ordersVo=null;
		ordersVo=ServiceFactory.getIOrdersServiceInstance().selectAll(v.getUserName(),1);
		tableModel=new DefaultTableModel(ordersVo,titles);
		this.table=new JTable(tableModel);
		this.table.setBounds(88, 87, 559, 321);
		panelSearchStatus.add(table);
		scrollPane = new JScrollPane(this.table);
		scrollPane.setBounds(69, 268, 615, 245);
		panelSearchStatus.add(scrollPane);
		
		JLabel lblSearchStatus = new JLabel("\u8BA2\u5355\u72B6\u6001\u68C0\u7D22");
		lblSearchStatus.setBounds(139, 33, 105, 15);
		panelSearchStatus.add(lblSearchStatus);
		
		textSearchStatus = new JTextField();
		textSearchStatus.setBounds(266, 30, 190, 21);
		panelSearchStatus.add(textSearchStatus);
		textSearchStatus.setColumns(10);
		
		JButton btnSearchStatus = new JButton("\u68C0\u7D22");
		btnSearchStatus.setBounds(480, 29, 97, 23);
		panelSearchStatus.add(btnSearchStatus);
		btnSearchStatus.addActionListener(new ActionListener() {//查询订单的订单状态
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderNumber=textSearchStatus.getText();
				if("".equals(orderNumber)) {
					JOptionPane.showMessageDialog(null, "请输入订单号");
				}else {
					orderVo=selectOrder(orderNumber,ordersVo);
					String vo2 = null;
					int i=3;
					if(orderVo!=null) {
						Iterator<String> iter1=orderVo.iterator();
						if(iter1.hasNext()) {
							vo2=iter1.next();
							while(i!=0) {
								vo2=vo2+" "+iter1.next();
								i--;
							}
						}
						textSearchResult.setText(vo2);
						textSearchResult1.setText(iter1.next());
						textSearchResult.setVisible(true);
						textSearchResult1.setVisible(true);
						btnSearchResult.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "查询的订单不存在");
					}
				}
			}
		});
		
		
		textSearchResult = new JTextField();
		textSearchResult.setBounds(69, 80, 293, 21);
		panelSearchStatus.add(textSearchResult);
		textSearchResult.setColumns(10);
		textSearchResult.setEditable(false);
		textSearchResult.setVisible(false);
		
		textSearchResult1 = new JTextField();
		textSearchResult1.setBounds(372, 80, 84, 21);
		panelSearchStatus.add(textSearchResult1);
		textSearchResult1.setColumns(10);
		textSearchResult1.setEditable(false);
		textSearchResult1.setVisible(false);
		
		btnSearchResult = new JButton("\u66F4\u6539\u8BA2\u5355\u72B6\u6001");
		btnSearchResult.setBounds(480, 79, 152, 23);
		panelSearchStatus.add(btnSearchResult);
		btnSearchResult.setVisible(false);
		btnSearchResult.addActionListener(new ActionListener() {//对订单的状态进行修改

			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnSearchResult.getText().equals("更改订单状态")) {
					textSearchResult1.setEditable(true);
					btnSearchResult.setText("确认修改");
				}else if(btnSearchResult.getText().equals("确认修改")) {
					String status=textSearchResult1.getText();
					Iterator<String> iter=orderVo.iterator();
					Orders vo=new Orders();
					vo.setOrderNumber(iter.next());
					vo.setName(iter.next());
					vo.setSex(iter.next());
					vo.setStyle(iter.next());
					vo.setStatus(status);
					ServiceFactory.getIOrdersServiceInstance().update(vo);
					textSearchResult1.setEditable(false);
					btnSearchResult.setText("更改订单状态");
				}
				
			}
			
		});
				
		JButton btnRefresh = new JButton("\u5237\u65B0");//刷新订单
		btnRefresh.setBounds(587, 220, 97, 23);
		panelSearchStatus.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordersVo=ServiceFactory.getIOrdersServiceInstance().selectAll(v.getUserName(),1);
				Iterator iter=ordersVo.iterator();
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
		
		JButton btnSearchDone = new JButton("\u5DF2\u5B8C\u6210\u8BA2\u5355");//获得全部已完成订单
		btnSearchDone.setBounds(439, 220, 97, 23);
		panelSearchStatus.add(btnSearchDone);
		btnSearchDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					Vector<Vector> ordersVo1=selectOrder(ordersVo,1);
					Iterator iter=ordersVo1.iterator();
					int count=tableModel.getRowCount()-1;
					while(count>=0) {
						tableModel.removeRow(count);
						count--;
					}
					while(iter.hasNext()) {
						Vector<String> ordersVo2=(Vector<String>) iter.next();
						tableModel.addRow(ordersVo2);
					}
			}
		});
		
		JButton btnSearchDoing = new JButton("\u672A\u5B8C\u6210\u8BA2\u5355");//获得全部未完成订单
		btnSearchDoing.setBounds(304, 220, 97, 23);
		panelSearchStatus.add(btnSearchDoing);
		btnSearchDoing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> ordersVo1=selectOrder(ordersVo,2);
				Iterator iter=ordersVo1.iterator();
				int count=tableModel.getRowCount()-1;
				while(count>=0) {
					tableModel.removeRow(count);
					count--;
				}
				while(iter.hasNext()) {
					Vector<String> ordersVo2=(Vector<String>) iter.next();
					tableModel.addRow(ordersVo2);
				}
			}
			
		});

		
		
		
		/**
		 * 密码修改面板
		 */
		JPanel panelPassword = new JPanel();
		panelPassword.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("密码", null, panelPassword, null);
		panelPassword.setLayout(null);
		
		JLabel lblOldPassword = new JLabel("\u65E7\u5BC6\u7801");
		lblOldPassword.setBounds(171, 117, 84, 30);
		panelPassword.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("\u65B0\u5BC6\u7801");
		lblNewPassword.setBounds(171, 187, 84, 30);
		panelPassword.add(lblNewPassword);
		
		JLabel lblNewPassword1 = new JLabel("\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801");
		lblNewPassword1.setBounds(171, 264, 96, 30);
		panelPassword.add(lblNewPassword1);
		
		textPasswordOld = new JPasswordField();
		textPasswordOld.setBounds(300, 117, 174, 30);
		panelPassword.add(textPasswordOld);
		
		textPasswordNew = new JPasswordField();
		textPasswordNew.setBounds(300, 187, 174, 30);
		panelPassword.add(textPasswordNew);
		
		textPasswordNew1 = new JPasswordField();
		textPasswordNew1.setBounds(300, 264, 174, 30);
		panelPassword.add(textPasswordNew1);
		
		JButton btnUpdatePassword = new JButton("\u786E\u8BA4");
		btnUpdatePassword.setBounds(257, 361, 97, 23);
		panelPassword.add(btnUpdatePassword);
		
		JLabel lblPasswordWarning = new JLabel("");
		lblPasswordWarning.setForeground(Color.RED);
		lblPasswordWarning.setBounds(508, 264, 209, 30);
		panelPassword.add(lblPasswordWarning);
		
		JLabel lblPasswordWarning1 = new JLabel("");
		lblPasswordWarning1.setForeground(Color.RED);
		lblPasswordWarning1.setBounds(522, 117, 96, 23);
		panelPassword.add(lblPasswordWarning1);
		
		
		btnUpdatePassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login vo1=new Login();
				vo1.setUserName(v.getUserName());
				if(!new String(textPasswordOld.getPassword()).equals(v.getPassword())) {
					lblPasswordWarning1.setText("原密码不正确");
					lblPasswordWarning.setText("");
				}else if(new String(textPasswordNew.getPassword()).equals(new String(textPasswordNew1.getPassword()))) {
					vo1.setPassword(new String(textPasswordNew.getPassword()));
					ServiceFactory.getILoginServiceInstance().update(vo1);
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
		frame.setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
		frame.setBounds(100, 100, 800, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 * @param orderNumber 传入订单号
	 * @param ordersVo 订单集合
	 * @return 查询得到的订单信息
	 */
	public Vector<String> selectOrder(String orderNumber,Vector<Vector> ordersVo){
		Iterator<Vector> iter=ordersVo.iterator();
		Vector<String> orderVo1 = null;
		int t=1;
		while(iter.hasNext()&&t==1) {
			orderVo1=iter.next();
			Iterator<String> iter1=orderVo1.iterator();
			String orderNumber1=iter1.next();
			if(orderNumber.equals(orderNumber1)) {
				t=0;
			}
		}
		if(t==0) {
			return orderVo1;
		}else {
			return null;
		}
	}
	
	/**
	 * 查询已完成和未完成订单
	 * @param ordersVo 订单集合
	 * @param i 模式
	 * @return 查询得到的订单集合
	 */
	public Vector<Vector> selectOrder(Vector<Vector> ordersVo,int i){
		Iterator<Vector> iter=ordersVo.iterator();
		Vector<String> Vo=null;
		Vector<Vector> Order1=new Vector<Vector>();
		Vector<Vector> Order2=new Vector<Vector>();
		while(iter.hasNext()) {
			Vo=iter.next();
			Object[] vo= Vo.toArray();
			if(vo[4].equals("完成")) {
				Order1.add(Vo);
			}else if(vo[4].equals("未完成")) {
				Order2.add(Vo);
			}
		}
		if(i==1) {
			return Order1;
		}else {
			return Order2;
		}
	}
}
