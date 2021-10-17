package modelo;

import java.util.ArrayList;

public class ControladorPedido {
private ArrayList<Pedido> historialPedidos;

public Pedido nuevoPedido (int idPedido)
{
	Pedido pedido= new Pedido(idPedido,01,0);
	return pedido; 
	}
public String generarFactura(Pedido pedido)
{
	String textoFactura = "";
	ArrayList<Producto> productos=pedido.getProductos();
	for (int i = 0; i < productos.size(); i++){
		Producto elItem = productos.get(i);
		var costo = precioProducto(elItem);
		textoFactura = textoFactura + "%n" + elItem + ":     " + costo;
	}
	
	textoFactura = textoFactura + "%n" + "Precio Total:     " + pedido.getcosto();
	return textoFactura;
}

public void anadirProducto (Pedido pedido,int id)
{
	Producto producto =ControladorInventario.consultarProducto(id);
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
 