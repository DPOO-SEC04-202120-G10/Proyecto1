package modelo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import procesamiento.LoaderArchivos;


public class ControladorInventario {

	public AdministradorOrganizador adminOrganizador;
	public AdministradorProductos adminProductos;
	
	
	public ControladorInventario(){
		this.adminOrganizador = new AdministradorOrganizador();
		this.adminProductos = new AdministradorProductos();
		
	}
	
	private void cargarNuevoLote(String archivoLote) throws FileNotFoundException, IOException
	{
		
		try {
			ArrayList<LoteProducto> lotes = LoaderArchivos.leerArchivoLote(archivoLote,numeroProductos());
			int i = 0;
			while (i < lotes.size()) {
				var lote = lotes.get(i);
				adminProductos.lotes.add(lote);
				i+=1;
			}
			
			
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private Producto consultarProducto(int id) {
		var producto = buscarEnListaProducto(id,adminProductos.productos);
		return producto;
	}
	
	private LoteProducto consultarLote(int id) {
		var lote = buscarEnListaLote(id,adminProductos.lotes);
		return lote;
	}
	
	private Producto buscarEnListaProducto(int id, ArrayList<Producto> lista) {
		int i = 0;
		while (i < lista.size()) {
			Producto productoLista = lista.get(i);
			var x = id;
			if (productoLista.id == x) {
				return productoLista;
			}
			i+=1;
		}
		
	
		return null;
			
	}
	
	private LoteProducto buscarEnListaLote(int id, ArrayList<LoteProducto> lista) {
		int i = 0;
		while (i < lista.size()) {
			LoteProducto loteLista = lista.get(i);
			var x = id;
			if (loteLista.id == x) {
				return loteLista;
			}
			i+=1;
		}
		
		return null;
			
	}

	public int numeroProductos() {
		int tamano = adminProductos.productos.size();
		return tamano;
	}
	
	public int numeroLotes() {
		int tamano = adminProductos.lotes.size();
		return tamano;
	}
	
	public int numeroGondolas() {
		int tamano = adminOrganizador.gondolas.size();
		return tamano;
	}
	
	public int numeroCategorias() {
		int tamano = adminOrganizador.categorias.size();
		return tamano;
	}
	
	public void actualizarPrecios(LoteProducto lote) {
		
		
	}

	public boolean disponibilidadProducto(Producto producto)
	{
		return true;
	}
	
	private void actualizar(Producto producto)
	{
	{
	}
		for (Producto i:getProductos())
	{

	if (i==producto)
	{
		productos.remove(i);
		
	}
	}
}
public  ArrayList<Producto> getProductos()
{
	return productos;
}

}

