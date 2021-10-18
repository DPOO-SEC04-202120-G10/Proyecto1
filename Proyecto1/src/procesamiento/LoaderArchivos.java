package procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.ControladorInventario;
import modelo.Gondola;
import modelo.LoteProducto;
import modelo.Parte;
import modelo.Producto;
import modelo.Subcategoria;


public class LoaderArchivos {


	/**
	 * Lectura del archivo de Productos Menu
	 * @param rutaArchivo ruta de la ubicacion del archivo de productos menu en memoria secuendaria
	 * @return Lista de ProductoMenu cargados desde el archivo de productos menu
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void leerArchivoLote(String rutaArchivo, ControladorInventario controladorInventario) throws FileNotFoundException, IOException
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
			boolean empacado = (1 == Integer.parseInt(partes[10]));
			String categoriaStr = partes[11];
			String subcategoriaStr = partes[12];
			int idCategoria = Integer.parseInt(partes[13]);
			int idSubcategoria = Integer.parseInt(partes[14]);
			
			System.out.println("pasa\n");
			
			var mapa = controladorInventario.adminProductos.disponiblesPorProducto;
			
			if (mapa.get(idProducto)!= null) {
				mapa.put(idProducto, mapa.get(idProducto) + cantidadOriginal);
			}
			else {
				mapa.put(idProducto, cantidadOriginal);
			}
			
			LoteProducto loteProducto = new LoteProducto(id, fechaVencimiento, idProducto, cantidadOriginal, cantidadDisponibles,
					precioCompraProducto, precioVentaProducto); 
			
			
			
			if (controladorInventario.adminOrganizador.existeCategoria(idCategoria, controladorInventario.adminOrganizador.categorias)) {
				var categoria = controladorInventario.adminOrganizador.retornarCategoria(idCategoria,controladorInventario.adminOrganizador.categorias);
				var gondola = categoria.retornarGondola();
				
				if (categoria.existeSubcategoria(idSubcategoria, categoria.subcategorias)) {
					var subcategoria = categoria.retornarSubcategoria(idSubcategoria, categoria.subcategorias); 
					var parte = gondola.retornarParte(idSubcategoria);
					
					int i = 0;
					while (i < cantidadOriginal) {
						int id1 = controladorInventario.numeroProductos()+1;
						var producto = new Producto(id1, idProducto, nombre, temperaturaConservacion, precioVentaProducto, 
								precioUnidad, unidad, empacado, peso, loteProducto);
						producto.agregarUbicacion(parte);
						loteProducto.agregarProducto(producto);
						controladorInventario.adminProductos.agregarProducto(producto);
						
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
						int id1 = controladorInventario.numeroProductos()+1;
						var producto = new Producto(id1, idProducto, nombre, temperaturaConservacion, precioVentaProducto, 
								precioUnidad, unidad, empacado, peso, loteProducto);
						producto.agregarUbicacion(parte);
						loteProducto.agregarProducto(producto);
						controladorInventario.adminProductos.agregarProducto(producto);
						
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
				
				controladorInventario.adminOrganizador.agregarCategoria(categoria);
				
				int i = 0;
				while (i < cantidadOriginal) {
					int id1 = controladorInventario.numeroProductos()+1;
					var producto = new Producto(id1, idProducto, nombre, temperaturaConservacion, precioVentaProducto, 
							precioUnidad, unidad, empacado, peso, loteProducto);
					producto.agregarUbicacion(parte);
					loteProducto.agregarProducto(producto);
					controladorInventario.adminProductos.agregarProducto(producto);
					
					i+=1;
				}
			}
			
			controladorInventario.actualizarPrecios(loteProducto);
			controladorInventario.adminProductos.agregarLote(loteProducto);
			System.out.println(controladorInventario.adminProductos.productos);
			
			
			linea = br.readLine(); 
		}
		br.close();
		
	}
}