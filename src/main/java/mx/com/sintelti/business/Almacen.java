package mx.com.sintelti.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;

import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.ProductosEntity;
import mx.com.sintelti.util.SpringUtil;

public class Almacen {
	private static ApplicationContext context;
	private static BufferedReader br;
	private static OperacionesCRUD<ProductosEntity> crudProductos;
	private ProductosEntity producto;	
	
	
	public static void init(){
		context = SpringUtil.getContext();
		br = new BufferedReader(new InputStreamReader(System.in));
		crudProductos = new OperacionesCRUD<ProductosEntity>();
	}
	
	public void agregarProducto(){
		producto = context.getBean("producto",ProductosEntity.class);
		leerDatosProducto();
		crudProductos.create(producto);		
	}
	
	public ProductosEntity obtenerProducto(long id){
		producto = context.getBean("producto",ProductosEntity.class);
		producto.setId(id);
		return crudProductos.read(producto);		
	}
	
	public void actualizarProducto(long id){
		producto = context.getBean("producto",ProductosEntity.class);
		producto.setId(id);
		producto = crudProductos.read(producto);
		System.out.println("::::: Actualizando :::::");
		System.out.println(producto);
		System.out.println("::::::::::::::::::::::::");
		leerDatosProducto();
		crudProductos.update(producto);
	}
	
	private void leerDatosProducto(){
		try{
			System.out.print("Nombre: ");
			producto.setNombre(br.readLine());
			System.out.print("Precio: ");
			producto.setPrecio(Float.parseFloat(br.readLine()));
			System.out.print("Existencia: ");
			producto.setExistencia(Integer.parseInt(br.readLine()));		
		}catch (IOException ioe){
			System.out.println(ioe);			
		}catch(NumberFormatException ex){
			System.out.println("La existencia y el precio deben ser valores númericos");
			producto.setExistencia(0);
			producto.setPrecio(0);
		}
	}

}
