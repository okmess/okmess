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
 * 开发层类工厂
 * @author 李书豪
 */
public class ServiceFactory {
	/**
	 * 
	 * @return 表开发层操作对象
	 */
	public static ILoginService getILoginServiceInstance() {
		return new LoginServiceImpl();
	}
	/**
	 * 
	 * @return 表开发层操作对象
	 */
	public static IUseLoginService getIUseLoginServiceInstance() {
		return new UseLoginServiceImpl();
	}
	/**
	 * 
	 * @return 表开发层操作对象
	 */
	public static IPersonal01Service getIPersonal01ServiceInstance() {
		return new Personal01ServiceImpl();
	}
	/**
	 * 
	 * @return 表开发层操作对象
	 */
	public static IOrdersService getIOrdersServiceInstance(){
		return new OrdersServiceImpl();
		
	}
}
