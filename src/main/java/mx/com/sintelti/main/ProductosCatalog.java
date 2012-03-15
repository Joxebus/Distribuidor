package mx.com.sintelti.main;

/**
 * @author 	Joxebus
 * Date	   	12/2011
 * e-mail	joxebus@hotmail.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mx.com.sintelti.dao.OperacionesCrud;
import mx.com.sintelti.domain.ProductosEntity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductosCatalog {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ProductosEntity nuevoProducto;
	private OperacionesCrud operaciones;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ProductosCatalog catalogo = context.getBean("productosCatalog", ProductosCatalog.class);
		//catalogo.insertar();
		for(int i=0; i<5; i++){
			System.out.println("Ingrese los datos del producto");
			catalogo.insertar();
		}
		//catalogo.actualizar();
		catalogo.listar();
	}
	
	public void setNuevoProducto(ProductosEntity nuevoProducto) {
		this.nuevoProducto = nuevoProducto;
	}
	
	public void setOperaciones(OperacionesCrud operaciones) {
		this.operaciones = operaciones;
	}
	
	ProductosEntity datosDelProducto(){
		try{
			System.out.print("Nombre: ");
			nuevoProducto.setNombre(br.readLine());
			System.out.print("Precio: ");
			nuevoProducto.setPrecio(Float.parseFloat(br.readLine()));
			System.out.print("Existencia: ");
			nuevoProducto.setExistencia(Integer.parseInt(br.readLine()));		
		}catch (IOException ioe){
			System.out.println(ioe);
			return null;
		}
		
		return nuevoProducto;
	}
	
	void insertar(){		
		operaciones.insertar(datosDelProducto());
	}
	
	void eliminar(){
		operaciones.eliminar(datosDelProducto());
	}
	
	void actualizar(){
		operaciones.actualizar(datosDelProducto());
	}
	
	void listar(){
		operaciones.listar();
	}

}
