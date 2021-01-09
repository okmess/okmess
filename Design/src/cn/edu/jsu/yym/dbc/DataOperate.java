package cn.edu.jsu.yym.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.yym.factory.ServiceFactory;
import cn.edu.jsu.yym.swing.FillOrder;

/**
 * �����������
 * @author 86152
 *
 */
public class DataOperate {
	private static DatabaseConnectionSql dbc=new DatabaseConnectionSql();
	private static Connection conn=dbc.getConnection();//��ȡ���ݿ��
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����"
			+ "Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ"
			+ "�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹���"
			+ "��ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻ"
			+ "ȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ���"
			+ "������ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������"
			+ "Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�����������������"
			+ "��������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������"
			+ "ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩��"
    		+ "�Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    
    private static String[] place= {"�żҽ�","�żҿ�","����","����","����","֣��","�Ϻ�","�ɶ�","��ɳ","����","����","�Ϸ�","������",
    		"����","����","����","ʯ��ׯ","����","����","����","����","����"};
    private static String[] style= {"�ŵ�","˽��","����","����","����","�羰"};
    private static String letter="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String[] describe= {"#�ŵ�#","#˽��#","#�羰#","������","POCO��Ӱ����","������Ӱʦ","֪����Ӱʦ","������Ӱʦ",
    		"#����#","#����#"};
    
    /**
     * 
     * @param start ��ʼֵ
     * @param end ����ֵ
     * @return ���ֵ
     */
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    
    /**
     * 
     * @return ����û���
     */
    public static StringBuilder getCount() {//����4λ�����˻�
    	int i=5;
    	int t=getNum(0,letter.length()-1);
    	StringBuilder userName=new StringBuilder(letter.substring(t,t+1));
    	while(i>0) {
    		int index=getNum(0, letter.length()-1);
    		userName=userName.append(new StringBuilder(letter.substring(index,index+1)));
    		i--;
    	}
    	return userName;
    }
    
    /**
     * 
     * @return �����������
     */
    public static StringBuilder getPassword() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	int i=2;
    	int t=getNum(0,letter.length()-1);
    	StringBuilder password =new StringBuilder(letter.substring(t,t+1));
    	while(i>0) {
    		int index=getNum(0, letter.length()-1);
    		password=password.append(new StringBuilder(letter.substring(index,index+1)));//��������ǰ3����ĸ
    		i--;
    	}
    	StringBuilder password1=new StringBuilder(String.valueOf(getNum(1,999999)));
    	password=password.append(password1);
    	return password;
    }
    
    static int sex=0;
    
    /**
     * 
     * @return ���������������
     */
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�������ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    
    /**
     * 
     * @return ��������Ա�
     */
    public static String getSex() {
    	String Sex="��";
    	if(sex==0) {
    		Sex="Ů";
    	}
    	return Sex;
    }
    
    //������ɹ����ص�
    public static String workPlace() {
    	int work=getNum(0,place.length-2);
    	String workPlace=place[work];
		return workPlace;
    	
    }
    
    //�������������
    public static String styleKind() {
    	int kinds=getNum(1,4);
    	String Sty=new String();
    	while(kinds>0) {
    		int index=getNum(0,style.length-1);
    		Sty=Sty+" "+style[index];
    		kinds--;
    	}
		return Sty;
    }
    
    //������ɵ绰����
    public static StringBuilder phoneNumber() {
    	StringBuilder phone=new StringBuilder();
    	int i=11;
    	while(i>0) {
    		i--;
    		phone=phone.append(String.valueOf(getNum(0,8)));
    	}
		return phone;
    }
    
    //�������״̬
    public static String status() {
    	int status=getNum(0,1);
    	String Status="���";
    	if(status==0) {
    		Status="δ���";
    	}
		return Status;
    }
    
    public static String describes(){
    	int kinds=getNum(1,5);
    	String Describe=new String();
    	while(kinds>0) {
    		int index=getNum(0,describe.length-1);
    		Describe=Describe+" "+describe[index];
    		kinds--;
    	}
		return Describe;
    	
    }
    
    public static void addLogin() {//�����˻�
    	String sql="insert into Login(useName,password) values(?,?)";//ʹ��ռλ������������
    	String sql2="insert into UseLogin(useName,password) values(?,?)";
    	try(PreparedStatement pstmt=conn.prepareStatement(sql);
    		PreparedStatement pstmt2=conn.prepareStatement(sql2);	){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
        	ArrayList<String> alist2=new ArrayList<String>();
    		for(int i=1;i<=10000;) {
    			String userName=getCount().toString();//�����ȡ�˻�
    			if(!alist.contains(userName)) {//�ж��˻��Ƿ�Ψһ
    				alist.add(userName);//���˻����뼯��
    				String password=getPassword().toString();//�����ȡ����
    				pstmt.setString(1, userName);//�����1��ռλ��������
    	    		pstmt.setString(2, password);//�����2��ռλ��������
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѭ����������ִ��
    			}
    		}
    		for(int i=1;i<=500000;) {//�û�����500000
    			String userName2=getCount().toString();
    			if(!alist2.contains(userName2)) {//�ж��˻��Ƿ�Ψһ
    				alist.add(userName2);//���˻����뼯��
    				String password2=getPassword().toString();//�����ȡ����
    				pstmt2.setString(1, userName2);//�����1��ռλ��������
    	    		pstmt2.setString(2, password2);//�����2��ռλ��������
    	    		pstmt2.addBatch();//����������ȴ�ִ��
    				i++;//ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		pstmt2.executeBatch();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void addPersonal() {//��Ӹ�����Ϣ
    	String sql="insert into Personal01(useName,name,sex,workPlace,style,describe,phone) values(?,?,?,?,?,?,?)";//ʹ��ռλ������������
    	try(PreparedStatement pstmt=conn.prepareStatement(sql);){
    		Vector<String> phoUserName=ServiceFactory.getILoginServiceInstance().getAllUserName();
    		Iterator iter=phoUserName.iterator();
    		while(iter.hasNext()) {
    			pstmt.setString(1, (String) iter.next());
        		pstmt.setString(2,getChineseName() );
        		pstmt.setString(3,getSex());
        		pstmt.setString(4,workPlace());
        		pstmt.setString(5,styleKind());
        		pstmt.setString(6,describes());
        		pstmt.setString(7,phoneNumber().toString());
        		pstmt.addBatch();//����������ȴ�ִ��
    		}
    		pstmt.executeBatch();//����ִ�в������

    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void addOrders() {
    	
    	String sql="insert into Orders(orderNumber,name,sex,style,status,photographUseName,useName) values(?,?,?,?,?,?,?)";//ʹ��ռλ������������
    	try(PreparedStatement pstmt=conn.prepareStatement(sql);){
    		Vector<String> phoUserName=ServiceFactory.getILoginServiceInstance().getAllUserName();
    		Vector<String> userName1=ServiceFactory.getIUseLoginServiceInstance().getAllUserName();
    		Object[] userName= userName1.toArray();
    		int i=0;
    		for(String pho:phoUserName) {
    			int t;
    			for(t=1;t<=50;t++) {
    				pstmt.setString(1,FillOrder.generateOrder());
        			pstmt.setString(2,getChineseName() );
        			pstmt.setString(3,getSex());
        			pstmt.setString(4,styleKind());
        			pstmt.setString(5,status() );
        			pstmt.setString(6,pho);
        			pstmt.setString(7, (String)userName[i++]);
        			pstmt.addBatch();//����������ȴ�ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	JOptionPane.showMessageDialog(null, "ִ�гɹ�");
    }
      
    public static void main(String[] args) {
    	addLogin();
    	addPersonal();
    	addOrders();
    }
    
}