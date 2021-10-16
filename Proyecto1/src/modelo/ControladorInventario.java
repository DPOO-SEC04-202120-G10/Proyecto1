package modelo;

import java.util.ArrayList;



public class ControladorInventario {
	private ArrayList<Producto>productos;

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
