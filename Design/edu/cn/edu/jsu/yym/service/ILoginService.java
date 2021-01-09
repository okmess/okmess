package cn.edu.jsu.yym.service;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Login;

/**
 * Login���ݱ����������׼
 * @author 86152
 *
 */
public interface ILoginService {
	/**
	 * ʵ���˻���ע�����Ӳ��������õ���ILoginDAO.doCreate()��ILoginDAO.findByuserName����
	 * @param vo ������Ҫ���ӵ��˻���userName������password
	 * @return ����˻�ע��ɹ�����true�����򷵻�false
	 */
	public boolean insert(Login vo);
	
	/**
	 * �˻������޸ģ����õ���ILoginDAO.daUpdate()����
	 *@param vo ������Ҫ���ӵ��˻���userName������password
	 *@return ����˻������޸ĳɹ�����true�����򷵻�false
	 */
	public boolean update(Login vo);
	
	/**
	 * �˻�ע�������õ���ILoginDAO.DoRemove()����
	 * @param userName ������Ҫע�����˻���userName
	 *@return ����˻�ע���ĳɹ�����true�����򷵻�false
	 */
	public boolean remove(String userName);
	
	/**
	 * �˻����û����������ѯ�����õ���ILoginDAO.findByuserName����
	 * @param userName �����˲��ҵ��û���
	 * @return �����ѯ���û������ز�ѯ�����û���������
	 */
	public Login select(String userName);
	
	/**
	 * ����ȫ�����˻�����ִ�е���select���
	 * @return �õ����е��˻���
	 */
	public Vector<String> getAllUserName();
}
