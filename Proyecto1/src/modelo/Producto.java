package modelo;

import java.util.ArrayList;

public class Producto {
	private int id;
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
	
public Producto (int id, String nombre, int precio,int temperaturaConservacion, int precioUnidad, boolean empacado, int peso) 
{
	this.id = id;
	this.nombre = nombre;
	this.precio= precio;
	this.temperaturaConservacion= temperaturaConservacion;
	this.empacado = empacado;
	this.precioUnidad=precioUnidad;
	this.peso=peso;
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
public String getnombre() {
	// TODO Auto-generated method stub
	return nombre;
}

}
