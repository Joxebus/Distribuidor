package mx.com.sintelti.domain;

import java.util.Set;

public class VentaEntity implements Persistible{
	
	private long id;
	private double subTotal;
	private double totalVenta;
	private Set<ProductosEntity> productos;
	
	public VentaEntity(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public Set<ProductosEntity> getProductos() {
		return productos;
	}
	public void setProductos(Set<ProductosEntity> productos) {
		this.productos = productos;
	}
	
	
}
