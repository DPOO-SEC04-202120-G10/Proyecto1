package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	public ArrayList<Producto> productos;
	public int idPedido;
	public LocalDate fecha;
	public int  costo; 
	public Pedido(int id, LocalDate fecha, int costo ) 
	{
		this.idPedido = id;
		this.fecha = fecha;
		this.costo= costo;
	}
	public void anadirProducto (Producto producto, int ncosto) 
	{
		productos.add(producto);
		costo=ncosto+costo;
	}
	public ArrayList<Producto> getProductos() {
		// TODO Auto-generated method stub
	
		return productos;
		
	}
	
	public int getcosto() {
		// TODO Auto-generated method stub
	
		return costo;
	}
}
