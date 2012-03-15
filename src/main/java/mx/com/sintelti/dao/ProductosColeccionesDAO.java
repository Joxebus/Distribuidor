package mx.com.sintelti.dao;

/**
 * @author 	Joxebus
 * Date	   	12/2011
 * e-mail	joxebus@hotmail.com
 */

import java.util.List;

import mx.com.sintelti.domain.ProductosEntity;

public class ProductosColeccionesDAO implements OperacionesCrud {

	private List<ProductosEntity> listaProductos;
	
	public void insertar(Object producto) {
		if(producto instanceof ProductosEntity){
			listaProductos.add((ProductosEntity)producto);
		}

	}

	public void eliminar(Object producto) {		
		if(producto instanceof ProductosEntity){
			listaProductos.remove((ProductosEntity)producto);
		}
	}

	public void actualizar(Object productoA) {/*
		if(productoA instanceof ProductosEntity && productoB instanceof ProductosEntity){
			int x = listaProductos.indexOf((ProductosEntity)productoA);
			if(x!=-1)
				listaProductos.add(x, (ProductosEntity)productoB);
			else
				listaProductos.add((ProductosEntity)productoB);
		}
		*/
	}

	public void listar() {	
		for(ProductosEntity producto : listaProductos){
			System.out.println(producto);
		}
	}
	
	public void setListaProductos(List<ProductosEntity> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	

}
