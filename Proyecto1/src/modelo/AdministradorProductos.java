package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class AdministradorProductos {
	public ArrayList<Producto> productos;
	public ArrayList<LoteProducto> lotes; 
	public HashMap<Integer,Integer> historico;
	public HashMap<Integer,Integer> disponiblesPorProducto;
	
	public AdministradorProductos(){
		this.lotes = new ArrayList<LoteProducto>();
		this.productos = new ArrayList<Producto>();
		this.historico = new HashMap<Integer, Integer>();
		this.disponiblesPorProducto = new HashMap<Integer, Integer>();
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
	public void agregarLote(LoteProducto lote) {
		lotes.add(lote);
	}

}
