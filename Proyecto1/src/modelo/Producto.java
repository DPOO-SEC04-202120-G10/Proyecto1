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
	
	public Producto(int id, int idProducto, String nombre, int temperaturaConservacion, int precio, 
			int precioUnidad, String unidad, boolean empacado, int peso, LoteProducto lote) {
		
		this.id = id;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.temperaturaConservacion = temperaturaConservacion;
		this.precio = precio;
		this.precioUnidad = precioUnidad;
		this.unidad = unidad;
		this.empacado = empacado;
		this.peso = peso;
		this.lote = lote; 
		this.disponible = true;

	}

	public void agregarUbicacion(Parte parte) {
		this.ubicacion = parte;
		
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
