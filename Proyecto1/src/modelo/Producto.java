package modelo;

import java.util.ArrayList;

public class Producto {
	public int id;
	private int idProducto;
	private String nombre;
	private int temperaturaConservacion;
	private Parte ubicacion;
	public int precio;
	public int precioUnidad;
	private String unidad;
	private boolean empacado;
	public int peso;
	private Subcategoria subcategoria;
	private LoteProducto lote;
	private boolean disponible;
	
	public Producto(int id, String nombre, int temperaturaConservacion, Parte ubicacion, int precio, 
			int precioUnidad, String unidad, boolean empacado, int peso, Subcategoria subcategoria, LoteProducto lote) {
		
		this.id = id;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.temperaturaConservacion = temperaturaConservacion;
		this.ubicacion = ubicacion;
		this.precio = precio;
		this.precioUnidad = precioUnidad;
		this.unidad = unidad;
		this.empacado = empacado;
		this.peso = peso;
		this.subcategoria = subcategoria;
		this.lote = lote; 
		this.disponible = true;
	}

	
public boolean getempacado()
{
	return empacado;
}
public int getprecio()
{
	return precio;
}
public int getprecioUnidad()
{
	return precioUnidad;
}
public int getpeso()
{
	return peso;
}
public int getid() {
	// TODO Auto-generated method stub
	return id;
}
public String getnombre() 
{
	// TODO Auto-generated method stub
	return nombre;
}
public boolean getdisponibilidad() 
{
	// TODO Auto-generated method stub
	return disponible;
			}
public void cambiardisp() 
{ disponible= false;
}
}