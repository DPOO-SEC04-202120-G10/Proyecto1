package modelo;

import java.util.ArrayList;

public class Parte {
	public int id;
	private Gondola gondola;
	private ArrayList<Producto> productos;
	private Subcategoria subcategoria;
	
	public Parte(int id, Gondola gondola, Subcategoria subcategoria) {
		this.id = id;
		this.gondola = gondola;
		this.subcategoria = subcategoria;
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
}
