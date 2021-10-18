package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class LoteProducto {
	
	public int id;
	private String fechaVencimiento;
	private int idProducto;
	private int cantidadOriginal;
	private int cantidadDisponibles;
	private int precioCompraProducto; 
	private int precioVentaProducto;
	private ArrayList<Producto> productos;
	
	
	public LoteProducto(int id, String fechaVencimiento, int idProducto, int cantidadOriginal, int cantidadDisponibles,
			int precioCompraProducto, int precioVentaProducto) {
		
		this.id = id;
		this.fechaVencimiento = fechaVencimiento; 
		this.idProducto = idProducto;
		this.cantidadOriginal = cantidadOriginal;
		this.cantidadDisponibles = cantidadDisponibles;
		this.precioCompraProducto = precioCompraProducto;
		this.precioVentaProducto = precioVentaProducto; 
		this.productos = new ArrayList<Producto>();
		
	}
	public String getVencimiento()
	{
		return fechaVencimiento;
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	public void cambiardispo() {
		// TODO Auto-generated method stub
		this.cantidadDisponibles=cantidadDisponibles-1;
	}
	
}
