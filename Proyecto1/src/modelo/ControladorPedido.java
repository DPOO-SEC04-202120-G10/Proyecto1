package modelo;
import java.util.ArrayList;


public class ControladorPedido {
private ArrayList<Pedido> historialPedidos;

public ControladorPedido ()
{
		this.historialPedidos= new ArrayList<Pedido>();
	}

public Pedido nuevoPedido (int idPedido,String fecha) {
	
	Pedido pedido= new Pedido(idPedido,fecha,0);
	return pedido; 
	
	}

public String generarFactura(Pedido pedido, Cliente cliente)
{
	String textoFactura = "";
	int puntosn = 0;
	ArrayList<Producto> productos = pedido.getProductos();
	for (int i = 0; i < productos.size(); i++){
		Producto elItem = productos.get(i);
		
		var costo = precioProducto(elItem);
		puntosn = puntosn + costo/1000;
		cliente.anadirPuntos(costo);
		
		textoFactura = textoFactura + "\n" + elItem.getnombre() + ":     " + costo;
	}
	int puntos= cliente.puntos();
	textoFactura = textoFactura + "\n" + "Precio Total:     " + pedido.getcosto() + "\n" + "Puntos nuevos: " + puntosn +
					"Puntos totales: " + puntos;
	
	return textoFactura;
}

public void anadirProducto (Pedido pedido,int id, ControladorInventario controladorInventario)
{
	Producto producto = controladorInventario.consultarProducto(id);
	int idp= producto.getidP();
	int costo= precioProducto(producto);
	boolean disp=ControladorInventario.disponibilidadProducto(producto);
	
	if (disp==true) 
	{
		pedido.anadirProducto(producto, costo);
		controladorInventario.actualizar(id, idp);
}
	else
	{
		System.out.println("Este producto no se encuentra disponible."); 
		}
	
}
 
public int precioProducto(Producto producto)
{
	boolean como = producto.getempacado();
	int price= 0;
	if (como==true)
	{
		price= producto.getprecio();
	}	
	else
	{
		price=(producto.getpeso()*producto.getprecioUnidad());
	}
	return price;
	}
public void anadiraHistorial (Pedido pedido) 
{
	historialPedidos.add(pedido);
}
}
 