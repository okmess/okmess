package cn.edu.jsu.yym.service;

import java.util.Vector;

import cn.edu.jsu.yym.vo.Orders;

/**
 * Orders���ݱ����������׼
 * @author 86152
 *
 */
public interface IOrdersService {
	/**
	 * ����µĶ�����Ϣ
	 * @param vo ��������ӵĶ�����Ϣ
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean insert(Orders vo); 
	
	/**
	 * ���¶���״̬
	 * @param vo ���������ĵĶ���״̬
	 * @return ���³ɹ�����true�����򷵻�false
	 */
	public boolean update(Orders vo);
	
	/**
	 * �����û�����ѯ������Ϣ
	 * @param userName �û���
	 * @param i ��ѯģʽ
	 * @return ��ѯ���Ľ����������ΪVectorǶ�׼���
	 */
	public Vector<Vector> selectAll(String userName,Integer i);
	
	/**
	 * ���¶�����Ϣ
	 * @param userName ���������ĵĶ����û���
	 * @param newUserName �����ĵĶ����û���
	 * @return ���³ɹ�����true�����򷵻�false
	 */
	public boolean update(String userName, String newUserName);
}
