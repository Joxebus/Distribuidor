package mx.com.sintelti.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;

import mx.com.sintelti.dao.OperacionesCRUD;
import mx.com.sintelti.domain.ProductosEntity;
import mx.com.sintelti.domain.VentaEntity;
import mx.com.sintelti.util.SpringUtil;

public class Cajero {
	private static Almacen almacen;
	private static ApplicationContext context;
	private static BufferedReader br;
	private static OperacionesCRUD<VentaEntity> crudVentas;
	private ProductosEntity producto;		
	private VentaEntity venta;
	
	private static void init(){
		context = SpringUtil.getContext();
		almacen = context.getBean("almacen",Almacen.class);
		br = new BufferedReader(new InputStreamReader(System.in));
		crudVentas = new OperacionesCRUD<VentaEntity>();		
	}
	
	public void realizarVenta(){
		venta = context.getBean("venta",VentaEntity.class);
		menu();
	}
	
	private void agregarProducto(long id){
		producto = almacen.obtenerProducto(id);
		System.out.println("Cuantos "+producto.getNombre()+" desea agregar?");
		int cantidad = Integer.parseInt(leerOpcion());
		int extistencia = producto.getExistencia();
		if(cantidad > extistencia){
			System.out.println("Hay menos productos en existencia de los que solicita");
		}else{
			float precio = producto.getPrecio();
			double subTotal = venta.getSubTotal()+(cantidad*precio);
			producto.setExistencia(extistencia-cantidad);
			almacen.actualizarProducto(producto);
			venta.setSubTotal(subTotal);
			venta.agregarProducto(producto);
		}
	}
	
	private void cobrar(){
		double totalVenta = venta.getSubTotal()+(venta.getSubTotal()*0.16);
		venta.setTotalVenta(totalVenta);
		crudVentas.create(venta);
	}
	
	private void menu(){
		char opcion = 'S';
		do{
			System.out.println("1.- Listar productos");
			System.out.println("2.- Agregar producto");
			System.out.println("3.- Cobrar");
			opcion = leerOpcion().charAt(0);
			switch(opcion){		
				case '1':
					System.out.println(":::: Productos existentes ::::");
					almacen.productosExistentes();
					System.out.println("::::::::::::::::::::::::::::::");
					break;
				case '2':
					do{
						System.out.println("Ingrese el id del producto");					
						try{
							long id = Long.parseLong(leerOpcion());
							agregarProducto(id);
						}catch(NumberFormatException nfe){
							System.out.println("Debe ingresar un dato numérico");
						}
						System.out.println("¿Desea ingresar un nuevo producto?");
						opcion = leerOpcion().charAt(0);
					}while(opcion != 'S');
					break;
				case '3':
					cobrar();
					break;					
				default:
					System.out.println("La opción que escogió es inválida");
					break;
			}
			System.out.println("¿Desea realizar alguna otra operación? S/N");
			opcion = leerOpcion().charAt(0);
		}while(opcion != 'S');
	}
	
	private String leerOpcion(){
		String opcion = "";
		try{
			opcion = br.readLine();
		}catch(IOException ioe){
			System.out.println("Ocurrio un error de entrada");
		}
		return opcion;
	}
	

}
