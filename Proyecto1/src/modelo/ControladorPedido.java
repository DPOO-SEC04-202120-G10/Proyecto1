package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorPedido {
private ArrayList<Pedido> historialPedidos;
public ControladorPedido ()
{
		this.historialPedidos= new ArrayList<Pedido>();
	}
public Pedido nuevoPedido (int idPedido)
{var fecha= LocalDate.now();
	Pedido pedido= new Pedido(idPedido,fecha,0);
	return pedido; 
	}
public String generarFactura(Pedido pedido, Cliente cliente)
{
	String textoFactura = "";
	ArrayList<Producto> productos=pedido.getProductos();
	for (int i = 0; i < productos.size(); i++){
		Producto elItem = productos.get(i);
		
		var costo = precioProducto(elItem);
		int puntosn= costo/1000;
		int puntos= cliente.puntos();
		textoFactura = textoFactura + "%n" + elItem + ":     " + costo + "\n Puntos nuevos :"+ puntosn + "\n Puntos Acumulados Totales"+ puntos;
	}
	
	textoFactura = textoFactura + "%n" + "Precio Total:     " + pedido.getcosto();
	return textoFactura;
}

public void anadirProducto (Pedido pedido,int id, ControladorInventario controladorInventario)
{
	Producto producto = controladorInventario.consultarProducto(id);
	int idp= producto.getidP();
	controladorInventario.actualizar(id, idp);
	int costo= precioProducto(producto);
	boolean disp=ControladorInventario.disponibilidadProducto(producto);
	if (disp==true) 
	{
	pedido.anadirProducto(producto, costo);
}
	else
	{System.out.println("Este producto no se encuentra disponible."); }
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
 