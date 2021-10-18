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
	
	private void cargarNuevoLote(String archivoLote, ControladorInventario controladorInventario) throws FileNotFoundException, IOException
	{
		
		try {
			LoaderArchivos.leerArchivoLote(archivoLote, controladorInventario);
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public Producto consultarProducto(int id) {
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

