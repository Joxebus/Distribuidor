package mx.com.sintelti.dao;

/**
 * @author 	Joxebus
 * Date	   	12/2011
 * e-mail	joxebus@hotmail.com
 */

import java.util.List;

import mx.com.sintelti.domain.ProductosEntity;
import mx.com.sintelti.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ProductosBDDAO implements OperacionesCrud {

	public void insertar(Object o) {
		Session session = 
        	HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();        
        session.save((ProductosEntity)o);
        session.getTransaction().commit();		
	}

	public void eliminar(Object o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	ProductosEntity producto = (ProductosEntity) session.createCriteria(ProductosEntity.class)
						.add(Restrictions.idEq(((ProductosEntity)o).getId()))
						.uniqueResult();    	
    	session.delete(producto);
    	session.getTransaction().commit();		
	}

	public void actualizar(Object o) {
		Session session = 
			HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        ProductosEntity producto = (ProductosEntity) session.createCriteria(ProductosEntity.class)
        				.add(Restrictions.idEq(((ProductosEntity)o).getId()))
    					.uniqueResult();
        producto.setNombre(((ProductosEntity)o).getNombre());
        producto.setPrecio(((ProductosEntity)o).getPrecio());
        producto.setExistencia(((ProductosEntity)o).getExistencia());
        session.update(producto);
        
        session.getTransaction().commit();
		
	}

	public void listar() {
		Session session = 
    		HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Criteria crit = session.createCriteria(ProductosEntity.class);    	
    	@SuppressWarnings("unchecked")
    	List<ProductosEntity> productos = crit.list();    	
    	for (ProductosEntity producto : productos){
    		System.out.println(producto);
    	}
		
	}
	

}
