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
 * 随机生成数据
 * @author 86152
 *
 */
public class DataOperate {
	private static DatabaseConnectionSql dbc=new DatabaseConnectionSql();
	private static Connection conn=dbc.getConnection();//获取数据库接
	//定义姓氏
	private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑"
			+ "薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛"
			+ "林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧"
			+ "隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍"
			+ "却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶"
			+ "空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙"
			+ "慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东"
			+ "门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	//定义女生的名
	private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青"
			+ "倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	//定义男生的名
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚"
    		+ "先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    
    private static String[] place= {"张家界","张家口","西安","广州","深圳","郑州","上海","成都","长沙","株洲","岳阳","合肥","哈尔滨",
    		"长春","北京","济南","石家庄","重庆","杭州","福州","昆明","海口"};
    private static String[] style= {"古典","私房","棚拍","汉服","户外","风景"};
    private static String letter="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String[] describe= {"#古典#","#私服#","#风景#","拍照吗","POCO摄影红人","独立摄影师","知名摄影师","资深摄影师",
    		"#汉服#","#棚拍#"};
    
    /**
     * 
     * @param start 开始值
     * @param end 结束值
     * @return 随机值
     */
    public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
    
    /**
     * 
     * @return 随机用户名
     */
    public static StringBuilder getCount() {//生成4位数的账户
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
     * @return 返回随机密码
     */
    public static StringBuilder getPassword() {//不使用String，因为需要大量拼接字符串
    	int i=2;
    	int t=getNum(0,letter.length()-1);
    	StringBuilder password =new StringBuilder(letter.substring(t,t+1));
    	while(i>0) {
    		int index=getNum(0, letter.length()-1);
    		password=password.append(new StringBuilder(letter.substring(index,index+1)));//生成密码前3个字母
    		i--;
    	}
    	StringBuilder password1=new StringBuilder(String.valueOf(getNum(1,999999)));
    	password=password.append(password1);
    	return password;
    }
    
    static int sex=0;
    
    /**
     * 
     * @return 随机返回中文姓名
     */
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//随机取姓氏字符串中的任意位置
        String first=firstName.substring(index, index+1);//获取该位置的姓氏
        sex=getNum(0,1);//随机取性别，例如1为男生，0为女生
        String str=boy;//定义名字为男生字符串
        int length=boy.length();//获取男生名字符串的长度
        if(sex==0){//如果随机获取为0，则名字改为女生
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//随机获取名字的位置
        String second=str.substring(index, index+1);//获取该位置中的名字
        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
        String third="";//默认没有第三个字
        if(hasThird==1){//如果随机获取为1，则有第三个字
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//返回姓名
    }
    
    /**
     * 
     * @return 随机生成性别
     */
    public static String getSex() {
    	String Sex="男";
    	if(sex==0) {
    		Sex="女";
    	}
    	return Sex;
    }
    
    //随机生成工作地点
    public static String workPlace() {
    	int work=getNum(0,place.length-2);
    	String workPlace=place[work];
		return workPlace;
    	
    }
    
    //随机生成拍摄风格
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
    
    //随机生成电话号码
    public static StringBuilder phoneNumber() {
    	StringBuilder phone=new StringBuilder();
    	int i=11;
    	while(i>0) {
    		i--;
    		phone=phone.append(String.valueOf(getNum(0,8)));
    	}
		return phone;
    }
    
    //随机生成状态
    public static String status() {
    	int status=getNum(0,1);
    	String Status="完成";
    	if(status==0) {
    		Status="未完成";
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
    
    public static void addLogin() {//增加账户
    	String sql="insert into Login(useName,password) values(?,?)";//使用占位符定义插入语句
    	String sql2="insert into UseLogin(useName,password) values(?,?)";
    	try(PreparedStatement pstmt=conn.prepareStatement(sql);
    		PreparedStatement pstmt2=conn.prepareStatement(sql2);	){//实例化PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//定义集合
        	ArrayList<String> alist2=new ArrayList<String>();
    		for(int i=1;i<=10000;) {
    			String userName=getCount().toString();//随机获取账户
    			if(!alist.contains(userName)) {//判断账户是否唯一
    				alist.add(userName);//将账户加入集合
    				String password=getPassword().toString();//随机获取密码
    				pstmt.setString(1, userName);//定义第1个占位符的内容
    	    		pstmt.setString(2, password);//定义第2个占位符的内容
    	    		pstmt.addBatch();//加入批处理等待执行
    				i++;//循环继续往下执行
    			}
    		}
    		for(int i=1;i<=500000;) {//用户数据500000
    			String userName2=getCount().toString();
    			if(!alist2.contains(userName2)) {//判断账户是否唯一
    				alist.add(userName2);//将账户加入集合
    				String password2=getPassword().toString();//随机获取密码
    				pstmt2.setString(1, userName2);//定义第1个占位符的内容
    	    		pstmt2.setString(2, password2);//定义第2个占位符的内容
    	    		pstmt2.addBatch();//加入批处理等待执行
    				i++;//循环继续往下执行
    			}
    		}
    		pstmt.executeBatch();//批量执行插入操作
    		pstmt2.executeBatch();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void addPersonal() {//添加个人信息
    	String sql="insert into Personal01(useName,name,sex,workPlace,style,describe,phone) values(?,?,?,?,?,?,?)";//使用占位符定义插入语句
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
        		pstmt.addBatch();//加入批处理等待执行
    		}
    		pstmt.executeBatch();//批量执行插入操作

    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void addOrders() {
    	
    	String sql="insert into Orders(orderNumber,name,sex,style,status,photographUseName,useName) values(?,?,?,?,?,?,?)";//使用占位符定义插入语句
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
        			pstmt.addBatch();//加入批处理等待执行
    			}
    		}
    		pstmt.executeBatch();//批量执行插入操作
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	JOptionPane.showMessageDialog(null, "执行成功");
    }
      
    public static void main(String[] args) {
    	addLogin();
    	addPersonal();
    	addOrders();
    }
    
}