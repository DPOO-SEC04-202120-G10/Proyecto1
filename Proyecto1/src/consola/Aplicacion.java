package consola;
import java.util.ArrayList;

import uniandes.dpoo.modelo.Combo;
import uniandes.dpoo.modelo.Ingrediente;
import uniandes.dpoo.modelo.Pedido;
import uniandes.dpoo.modelo.ProductoAjustado;
import uniandes.dpoo.modelo.ProductoMenu;
import uniandes.dpoo.modelo.Restaurante;
import java.io.*;
import java.io.BufferedReader;



public class Aplicacion {
private static int idPedido;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio de ejecucion de la aplicacion");
		Restaurante elRestaurante= new Restaurante();
		ejecutarAplicacion(elRestaurante);
		
	}
	public static void ejecutarAplicacion(Restaurante elRestaurante)
	{
		System.out.println("Bienvenido al Supermercado\n");
		
		try {
				elRestaurante.cargarInformacionRestaurante("menu.txt", "ingredientes.txt" ,"combos.txt" );
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		idPedido= 0;

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				String opcion_seleccionadaa = input("Por favor seleccione una opcion");
				int opcion_seleccionada= Integer.parseInt(opcion_seleccionadaa);
	
				if (opcion_seleccionada == 1)
					ejecutarInv();
				else if (opcion_seleccionada == 2)
					ejecutarPOS();

				else if (opcion_seleccionada == 3)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	
	public static void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicacion\n");
		System.out.println("1. Sistema Inventario");
		System.out.println("2. Sistema POS");
		System.out.println("3. Salir de la aplicación\n");
	}

	private static void ejecutarMostrarMenu1 ()
	{

		}
			
		}
	private static void ejecutarMostrarMenu2()
	{
		System.out.println("\nOpciones de la aplicacion\n");
		System.out.println("1. Registrar Nuevo Cliente");
		System.out.println("2. Ingresar Cliente");
		System.out.println("3. Iniciar Pedido\n");
		System.out.println("4. Salir de la aplicación\n");
	}
}
private static void ejecutarPOS()
	
	private static void ejecutarMostrarCombo(Restaurante elRestaurante)
	{
		System.out.println("\n" + "Combo" + "\n");
		int a= 0;
		for (Combo i:elRestaurante.getCombo())
		{
			int b= a+1;
		System.out.println(String.valueOf(b) + i);
		a=a+1;
		}
}
	private static void anadirElementos(ProductoMenu elProducto, Restaurante elRestaurante)
	{
	ProductoAjustado elProductoAjustado= new ProductoAjustado(elProducto);
	String suma= input("Quiere añadir igredientes al producto?:"+ "\n 1. Si "
			+ "\n 2. No");
	if (suma=="1")
	{
		
		ejecutarMostrarIngredientes(elRestaurante);
		
		String ajuste=input("Ingrese el numero del ingrediente que quiere añadir"); 
		int a=1-Integer.valueOf(ajuste) ;
		int b=0;
		for (Ingrediente i:elRestaurante.getIngredientes())
{
	
	if (a==b)
	{
		elProductoAjustado.anadirIngrediente(i); 
	}
	b=b+1;
}
		
	}
	String resta= input("Quiere eliminar igredientes al producto?:"+ "\n 1. Si "
			+ "\n 2. No");
	if (resta=="1")
	{
		ejecutarMostrarIngredientes(elRestaurante);
		
		String ajuste=input("Ingrese el numero del ingrediente que quiere eliminar"); 
		int a=1-Integer.valueOf(ajuste) ;
		int b=0;
		for (Ingrediente i:elRestaurante.getIngredientes())
		{
			if (a==b)
			{
				elProductoAjustado.eliminarIngrediente(i); 
			}
			b=b+1;
			}
	}
	}


	private static void ejecutarNuevoPedido(Restaurante elRestaurante, int idPedido)
	{
		
		String cliente = input("Por favor ingrese su nombre");
		String direccion= input("Por favor ingrese su nombre");
		elRestaurante.iniciarPedido(cliente, direccion, idPedido);
		Pedido elPedido= elRestaurante.getPedidoEnCurso();
		ejecutarAgregarElemento(elPedido, elRestaurante);
		
	}

	private static void ejecutarAgregarElemento(Pedido elPedido, Restaurante elRestaurante)
	{
		boolean mas= true;
		while (mas==true)
		{String tipo= input("Por favor ingrese tipo de pedido: \n 1. Menu \n 2. Combo ");
				if (tipo=="1")
				{
					ejecutarMostrarMenu(elRestaurante);
					String pedidot= input("Por favor ingrese el numero del Producto.");
					int e=Integer.parseInt(pedidot);
							int a=1-e;
							int b=0;
							for (ProductoMenu i:elRestaurante.getMenuBase())
							{
								
								if (a==b)
								{
									anadirElementos(i, elRestaurante);
;
								Pedido.agregarProducto(i);
								
							}
								else
								{
									b=b+1; 
								}
							}
							
				}
				if (tipo=="2")
				{
					ejecutarMostrarCombo(elRestaurante);
				String pedidot= input("Por favor ingrese el numero del Producto.");
				int e=Integer.parseInt(pedidot);
				int a=1-e;
				int b=0;
				for (ProductoMenu i:elRestaurante.getMenuBase())
				{
					
					if (a==b)
					{
						anadirElementos(i, elRestaurante);

						Pedido.agregarProducto(i);
						}
					
					
				
					else
					{
						b=b+1; 
					}
				}					
}

				String otro= input("Quiere añadir otro producto?:"	+ "\n 1. Si "
						+ "\n 2. No");
				
				if (otro=="2")
				{
					mas=false;
				}
					
				
				
				
	
	}
		}
	private static  void ejecutarCerrarPedido(Restaurante elRestaurante)
	{
		elRestaurante.cerrarYGuardarPedido();
		idPedido=1+ idPedido;
	}
	private static void ejecutarVerPedidoPasado(Restaurante elRestaurante)
	{
		String id =input ("Ingrese el id de su pedido");
		int id1=Integer.parseInt(id);
		
		for (Pedido i:(elRestaurante.getPedidosCerrados()))
		{
		if (id1==(i.getIdPedido()))
				{
			System.out.println(i);
			
				}
		};
		
		
	}
	
	private static String input(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

