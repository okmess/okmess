package cn.edu.jsu.yym.dao;

import cn.edu.jsu.yym.vo.Personal01;

/**
 * ����Personal01������ݲ������׼
 * @author �����
 */
public interface IPersonal01DAO {
	/**
	 * �����û�������������
	 * @param vo ������ӵ�����
	 * @return ��ӳɹ�����true�����򷵻�false��
	 */
	public boolean doCreate(Personal01 vo);
	
	/**
	 * �����û����޸�����
	 * @param vo �����޸ĵ�����
	 * @return �޸ĳɹ�����true�����򷵻�false
	 */
	public boolean doUpdate(Personal01 vo);
	
	/**
	 * �����û���ɾ������
	 * @param useName ΪҪɾ�����û���
	 * @return ɾ���ɹ�����true�����򷵻�false
	 */
	public boolean doRemove(String useName);
	
	/**
	 * �����û�����ѯ����
	 * @param useName ΪҪ��ѯ���û���������
	 * @param i Ϊ��ѯ��ģʽ
	 * @return ��ѯ�ɹ�����Personal01 vo
	 */
	public Personal01 doSelect(String useName,Integer i);
}
