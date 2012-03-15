package mx.com.sintelti.dao;

/**
 * @author 	Joxebus
 * Date	   	12/2011
 * e-mail	joxebus@hotmail.com
 */

public interface OperacionesCrud {
	
	void insertar(Object o); //Create
	void eliminar(Object o); //Delete
	void actualizar (Object o); //Update
	void listar(); //Read

}
