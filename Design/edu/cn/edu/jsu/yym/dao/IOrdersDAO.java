package cn.edu.jsu.yym.dao;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Orders;

/**
 * ����Orders������ݲ������׼
 * @author �����
 */
public interface IOrdersDAO {
	/**
	 * ����µĶ�����Ϣ
	 * @param vo �����¶���������
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean doCreate(Orders vo);
	
	/**
	 * ����״̬����
	 * @param vo ��������״̬��Ϣ
	 * @return ���³ɹ�����true,���򷵻�false
	 */
	public boolean doUpdate(Orders vo);
	
	/**
     * �����û�����ѯ������Ϣ
     *@param userName �û������߶�����,iΪ��ѯ��ģʽ
     *@param i ��ѯģʽ
     * @return ��ѯ���Ľ����������ΪVectorǶ�׼���
     */
	 public Vector<Vector> getSelectAll(String userName,Integer i);
	 
	 /**
		 * ���¶�����Ϣ
		 * @param userName �����ĵĶ����û���
		 * @param newUserName �����ĵĶ����û���
		 * @return ���³ɹ�����true�����򷵻�false
		 */
	public boolean doUpdate(String userName, String newUserName);
	 
	 
}
