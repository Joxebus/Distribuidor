package mx.com.sintelti.util;

/**
 * @author 	Joxebus
 * Date	   	12/2011
 * e-mail	joxebus@hotmail.com
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			//Aquí se crea la SessionFactory y carga la conf de hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();			
		}catch(Throwable ex){
			//Log de la excepción
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}		
	}
	
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY;
	}

}
