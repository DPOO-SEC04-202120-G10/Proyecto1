package modelo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class ControladorInventario {

	private AdministradorOrganizador adminOrganizador;
	private AdministradorProductos adminProductos;
	
	
	public ControladorInventario(){
		this.adminOrganizador = new AdministradorOrganizador();
		this.adminProductos = new AdministradorProductos();
		
	}
	
	private void cargarNuevoLote(String archivoLote) throws FileNotFoundException, IOException
	{
		
		try {
			LoteProducto lote = LoaderArchivos.leerInfoArchivoLote(archivoLote);
			adminProductos.lotes.add(lote);
			
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Producto consultarProducto(int id) {
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
		
		productoNulo = new Producto();
		return productoNulo;
			
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
		
		loteNulo = new LoteProducto();
		return loteNulo;
			
	}

	

	public static boolean disponibilidadProducto(Producto producto)
	{
		boolean disp=producto.getdisponibilidad();
		return disp;
	}
	
	private void actualizar(int idProducto, int id, AdministradorProductos admin)
	{ 
		int total= admin.disponiblesPorProducto.get(idProducto);
		int totales=total-1;
		admin.disponiblesPorProducto.replace(idProducto, total, totales);
		Producto prod= consultarProducto(id);
		prod.cambiardisp();
		
	}
	



}

