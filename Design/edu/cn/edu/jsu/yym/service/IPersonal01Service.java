package cn.edu.jsu.yym.service;

import cn.edu.jsu.yym.vo.Personal01;

/**
 * Personal01���ݱ����������׼
 * @author 86152
 *
 */
public interface IPersonal01Service {
	/**
	 * ʵ�ָ����û����������,����IPersonal01DAO.doCreate()����
	 * @param vo ������ӵ�����
	 * @return ��ӳɹ�����true�����򷵻�false��
	 */
	public boolean insert(Personal01 vo);
	
	/**
	 * ʵ�ָ����û����޸����ݣ�����IPersonal01DAO.doUpdate()����
	 * @param vo �����޸ĵ�����
	 * @return �޸ĳɹ�����true�����򷵻�false
	 */
	public boolean update(Personal01 vo);
	
	/**
	 * ʵ�ָ����û���ɾ�����ݣ�����IPersonal01DAO.doRemove()����
	 * @param useName ΪҪɾ�����û���
	 * @return ɾ���ɹ�����true�����򷵻�false
	 */
	public boolean delete(String useName);
	
	/**
	 * ʵ�ָ����û����������ݣ�����IPersona01DAO.doselect()����
	 * @param useName Ϊ�����ҵ��û���,������
	 * @param i Ϊѡ��ģʽ
	 * @return ���ز��ҵ�������
	 */
	public Personal01 select(String useName,Integer i);
}
