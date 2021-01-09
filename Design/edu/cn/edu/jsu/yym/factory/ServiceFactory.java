package cn.edu.jsu.yym.factory;

import cn.edu.jsu.yym.service.ILoginService;
import cn.edu.jsu.yym.service.IOrdersService;
import cn.edu.jsu.yym.service.IPersonal01Service;
import cn.edu.jsu.yym.service.IUseLoginService;
import cn.edu.jsu.yym.service.impl.LoginServiceImpl;
import cn.edu.jsu.yym.service.impl.OrdersServiceImpl;
import cn.edu.jsu.yym.service.impl.Personal01ServiceImpl;
import cn.edu.jsu.yym.service.impl.UseLoginServiceImpl;

/**
 * �������๤��
 * @author �����
 */
public class ServiceFactory {
	/**
	 * 
	 * @return �������������
	 */
	public static ILoginService getILoginServiceInstance() {
		return new LoginServiceImpl();
	}
	/**
	 * 
	 * @return �������������
	 */
	public static IUseLoginService getIUseLoginServiceInstance() {
		return new UseLoginServiceImpl();
	}
	/**
	 * 
	 * @return �������������
	 */
	public static IPersonal01Service getIPersonal01ServiceInstance() {
		return new Personal01ServiceImpl();
	}
	/**
	 * 
	 * @return �������������
	 */
	public static IOrdersService getIOrdersServiceInstance(){
		return new OrdersServiceImpl();
		
	}
}
