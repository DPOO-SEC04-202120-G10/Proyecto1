package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class LoteProducto {
	
	public int id;
	private String fechaVencimiento;
	public int idProducto;
	private int cantidadOriginal;
	private int cantidadDisponibles;
	public int precioCompraProducto; 
	public int precioVentaProducto;
	public ArrayList<Producto> productos;
	
	
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
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
}
