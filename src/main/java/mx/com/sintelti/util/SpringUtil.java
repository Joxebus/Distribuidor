package mx.com.sintelti.util;

/**
 * @author Jorge Omar Bautista Valenzuela
 * Date: 15/Marzo/2012
 * Hout: 10:24 hrs
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
	private static final ApplicationContext CONTEXT = buildSpringContext(); 
	
	private static ClassPathXmlApplicationContext buildSpringContext(){		
			try{
				return new ClassPathXmlApplicationContext("/applicationContext.xml");
			}catch(BeansException ace){
				throw new ExceptionInInitializerError(ace);
			}			
	}
	
	public static final ApplicationContext getContext(){
		return CONTEXT;
	}

}
