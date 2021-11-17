package modelo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import procesamiento.LoaderArchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ControladorInventario {

	public AdministradorOrganizador adminOrganizador;
	public AdministradorProductos adminProductos;
	
	
	public ControladorInventario(){
		this.adminOrganizador = new AdministradorOrganizador();
		this.adminProductos = new AdministradorProductos();
		
	}
	
	public void cargarNuevoLote(String rutaArchivo) throws FileNotFoundException, IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine();    
		
		while (linea != null) 
		{
			
			
			String[] partes = linea.split(";");
			
			
			int id = Integer.parseInt(partes[0]);
			
			String fechaVencimiento = partes[1];
			
			int idProducto = Integer.parseInt(partes[2]);
			int cantidadOriginal = Integer.parseInt(partes[3]);
			int cantidadDisponibles = cantidadOriginal;
			int precioCompraProducto = Integer.parseInt(partes[4]);
			int precioVentaProducto = Integer.parseInt(partes[5]);
			String nombre = partes[6];
			int temperaturaConservacion = Integer.parseInt(partes[7]);
			String unidad = partes[8];
			
			int peso = Integer.parseInt(partes[9]);
			
			int precioUnidad = peso/precioVentaProducto;
			
			boolean empacado = Boolean.parseBoolean(partes[10]);

			String categoriaStr = partes[11];
			String subcategoriaStr = partes[12];
		
			int idCategoria = Integer.parseInt(partes[13]);
			int idSubcategoria = Integer.parseInt(partes[14]);
			
			
			
			var mapa = adminProductos.disponiblesPorProducto;
	
			if (mapa.get(idProducto)!= null) {
				mapa.put(idProducto, mapa.get(idProducto) + cantidadOriginal);
			}
			else {
				mapa.put(idProducto, cantidadOriginal);
			}
			
			LoteProducto loteProducto = new LoteProducto(id, fechaVencimiento, idProducto, cantidadOriginal, cantidadDisponibles,
					precioCompraProducto, precioVentaProducto); 
			
			
		
			if (adminOrganizador.existeCategoria(idCategoria, adminOrganizador.categorias)) {
				var categoria = adminOrganizador.retornarCategoria(idCategoria,adminOrganizador.categorias);
				var gondola = categoria.retornarGondola();
				
				if (categoria.existeSubcategoria(idSubcategoria, categoria.subcategorias)) {
					var subcategoria = categoria.retornarSubcategoria(idSubcategoria, categoria.subcategorias); 
					var parte = gondola.retornarParte(idSubcategoria);
					
					int i = 0;
					while (i < cantidadOriginal) {
						int id1 = numeroProductos()+1;
						var producto = new Producto(id1, idProducto, nombre, temperaturaConservacion, precioVentaProducto, 
								precioUnidad, unidad, empacado, peso, loteProducto);
						producto.agregarUbicacion(parte);
						loteProducto.agregarProducto(producto);
						adminProductos.agregarProducto(producto);
						
						i+=1;
					}
				}
				else {
					Subcategoria subcategoria = new Subcategoria(idSubcategoria,subcategoriaStr,categoria);
					categoria.agregarSubcategoria(subcategoria);
					
					Parte parte = new Parte(idSubcategoria,gondola,subcategoria);
					gondola.agregarParte(parte);
					
					int i = 0;
					while (i < cantidadOriginal) {
						int id1 = numeroProductos()+1;
						var producto = new Producto(id1, idProducto, nombre, temperaturaConservacion, precioVentaProducto, 
								precioUnidad, unidad, empacado, peso, loteProducto);
						producto.agregarUbicacion(parte);
						loteProducto.agregarProducto(producto);
						adminProductos.agregarProducto(producto);
						
						i+=1;
					}
					
				}
				}
				
	
			
			else {
				
	
				Categoria categoria = new Categoria(idCategoria, categoriaStr);
				
				Subcategoria subcategoria = new Subcategoria(idSubcategoria,subcategoriaStr,categoria);
				categoria.agregarSubcategoria(subcategoria);
				
				Gondola gondola = new Gondola(idCategoria, categoria);
				categoria.agregarGondola(gondola);
				
				Parte parte = new Parte(idSubcategoria,gondola,subcategoria);
				gondola.agregarParte(parte);
				
				adminOrganizador.agregarCategoria(categoria);
				
				int i = 0;
				while (i < cantidadOriginal) {
					int id1 = numeroProductos()+1;
					var producto = new Producto(id1, idProducto, nombre, temperaturaConservacion, precioVentaProducto, 
							precioUnidad, unidad, empacado, peso, loteProducto);
					producto.agregarUbicacion(parte);
					loteProducto.agregarProducto(producto);
					adminProductos.agregarProducto(producto);
					
					i+=1;
				}
			}
			
			
			actualizarPrecios(loteProducto);
			adminProductos.agregarLote(loteProducto);
			System.out.println(adminProductos.productos);
			
			
			linea = br.readLine(); 
		}
		br.close();
		
	}
	

	public Producto consultarProducto(int id) {
		var producto = buscarEnListaProducto(id,adminProductos.productos);
		return producto;
	}
	
	public LoteProducto consultarLote(int id) {
		var lote = buscarEnListaLote(id,adminProductos.lotes);
		return lote;
	}
	
	public Producto buscarEnListaProducto(int id, ArrayList<Producto> lista) {
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
	
	public LoteProducto buscarEnListaLote(int id, ArrayList<LoteProducto> lista) {
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
		var precioVentaNuevo = lote.precioVentaProducto;
		var idProducto = lote.idProducto;
		var lotes = adminProductos.lotes;
		int i = 0;
		while (i<lotes.size()) {
			var lote1 = lotes.get(i);
			if (lote1.idProducto==idProducto) {
				int e = 0;
				var listaPs = lote.productos;
				while (e<listaPs.size()) {
					Producto producto = listaPs.get(e);
					if (producto.disponible) {
						producto.actualizarPrecio(precioVentaNuevo);
					}
				}
			}
		}
	}

	public static boolean disponibilidadProducto(Producto producto)
	{
		boolean disp=producto.getdisponibilidad();
		return disp;
	}
	
	public void actualizar( int id,int idProducto)
	{ 
		int total= adminProductos.disponiblesPorProducto.get(idProducto);
		int totales=total-1;
		adminProductos.disponiblesPorProducto.replace(idProducto, total, totales);
		Producto prod= consultarProducto(id);
		prod.cambiardisp();
		LoteProducto lote=prod.getLote();
		lote.cambiardispo();
		
	}
	
	public void vencido (int id, String fecha)
	{
		
	
		Producto prod= consultarProducto(id);
		int idp= prod.getidP();
		LoteProducto lote=prod.getLote();
		String fechav=lote.getVencimiento();
		String[] partes = fechav.split(";");
		int av = Integer.parseInt(partes[0]);
		int mv = Integer.parseInt(partes[1]);
		int dv= Integer.parseInt(partes[2]);
		
		String[] partess = fecha.split(";");
		int ap = Integer.parseInt(partess[0]);
		int mp = Integer.parseInt(partess[1]);
		int dp= Integer.parseInt(partess[2]);
		boolean a=(av<=ap);
		boolean b= (mv<=mp);
		boolean c= (dv<=dp);
		if  (a&&b&&c)
		{
		prod.cambiarvencido();
		int total= adminProductos.disponiblesPorProducto.get(idp);
		int totales=total-1;
		adminProductos.disponiblesPorProducto.replace(idp, total, totales);

}}
	

}

