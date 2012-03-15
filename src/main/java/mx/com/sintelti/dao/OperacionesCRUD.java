package mx.com.sintelti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import mx.com.sintelti.domain.Persistible;
import mx.com.sintelti.util.HibernateUtil;


public class OperacionesCRUD<T>  {
	private Session session;
	
	
	public final void create(T objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save((T)objeto);
		session.getTransaction().commit();
	}
	
	public final T read(Persistible objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T objetoNuevo = (T) session.createCriteria(objeto.getClass())
		.add(Restrictions.idEq(objeto.getId()))
		.uniqueResult();
		return objetoNuevo;
		
	}
	
	public final void update(T objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update((T)objeto);
		session.getTransaction().commit();
	}
	
	
	public final void delete(T objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete((T)objeto);
		session.getTransaction().commit();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> list(Persistible objeto){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return (List<T>)session.createCriteria(objeto.getClass()).list();		
	}
}
