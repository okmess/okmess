package cn.edu.jsu.yym.dao;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Login;

/**
 * ����UseLogin������ݲ������׼
 * @author �����
 */
public interface IUseLoginDAO {
	/**
	 * �˻�ע������Ӳ�����ִ�е���INSERT���
	 * @param vo ������Ҫ���ӵ��˻���userName������password
	 * @return �˻�ע��ɹ�����true�����򷵻�false
	 */
	public boolean doCreate(Login vo);
	
	/**
	 * ������޸Ĳ�����ִ�е���UPDATE��䣬�����û���userName�޸�����password
	 * @param vo ������Ҫ�޸ĵ�������
	 * @return �����޸ĳɹ�����true�����򷵻�false
	 */
	public boolean doUpdate(Login vo);
	
	/**
	 * �˻���ע��������ִ�е���delete���
	 * @param userName ����Ҫע���˻����û���
	 * @return �˻�ע���ɹ�����true�����򷵻�false
	 */
	public boolean doRemove(String userName);
	
	/**
	 * �����˻��Ƿ��Ѿ����ڣ�ִ�е���select���
	 * @param userName ���ҵ��˺ŵ��û���
	 * @return ���ҵõ����˻����û���������
	 */
	public Login findByUserName(String userName);
	
	/**
	 * ����ȫ�����˻�����ִ�е���select���
	 * @return �õ����е��˻���
	 */
	public Vector<String> findAllUserName();
}