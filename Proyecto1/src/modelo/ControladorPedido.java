package modelo;

import java.util.ArrayList;

public class ControladorPedido {
public int id;
private ArrayList<Pedido> historialPedidos;


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
public void anadirProducto (Pedido pedido,Producto producto, int costo)
{
	pedido.anadirProducto(producto, costo);
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
 