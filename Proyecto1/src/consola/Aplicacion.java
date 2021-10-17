package consola;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.ControladorCliente;
import modelo.ControladorInventario;
import modelo.ControladorPedido;
import modelo.Pedido;
import modelo.Cliente;

import java.io.*;
import java.io.BufferedReader;



public class Aplicacion {
private static int idPedido;
	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		System.out.println("Inicio de ejecucion de la aplicacion");
		ControladorCliente  elContC = new ControladorCliente();
		ControladorInventario elContI = new ControladorInventario ();
		ejecutarAplicacion(elContC,elContI, idPedido);
		
	}
	public static void ejecutarAplicacion(ControladorCliente  elContC, ControladorInventario elContI, int idPedido)
	{
		System.out.println("Bienvenido al Supermercado\n");
			
		
		
		boolean continuar = true;
		while (continuar) 
		{
			try
			{
				mostrarMenu();
				String opcion_seleccionadaa = input("Por favor seleccione una opcion");
				int opcion_seleccionada= Integer.parseInt(opcion_seleccionadaa);
	
				if (opcion_seleccionada == 1)
				//ejecutarInv();
					System.out.println("Hola");
			
				else if (opcion_seleccionada == 2)
					ejecutarPOS(elContC, elContI, idPedido);

				else if (opcion_seleccionada == 3)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			
			//catch (NumberFormatException e)
		//	{
			System.out.println("Debe seleccionar uno de los números de las opciones.");}
		//	}
			finally {{System.out.println("Hola.");}}
	
		
	}}
	
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
			
		
	private static void MostrarMenu2()
	{
		System.out.println("\nOpciones de la aplicacion\n");
		System.out.println("1. Registrar Nuevo Cliente");
		System.out.println("2. Ingresar Cliente");
		System.out.println("3. Salir de la aplicación\n");
		idPedido= 0;
	}

private static void ejecutarPOS(ControladorCliente  elContC, ControladorInventario contI, int idPedido) 
{
	ControladorPedido elContP = new ControladorPedido();
		
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			MostrarMenu2();
			String opcion_seleccionadaa = input("Por favor seleccione una opcion");
			int opcion_seleccionada= Integer.parseInt(opcion_seleccionadaa);

			Cliente cliente = null;
			if (opcion_seleccionada == 1)
				 cliente= ejecutarRegistrar(elContC);
				ejecutarPedido(cliente, elContP, contI, idPedido);
			 if (opcion_seleccionada == 2)
				cliente= ejecutarIngresar(elContC);
				ejecutarPedido(cliente, elContP, contI, idPedido);
			
			 if (opcion_seleccionada == 3)
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

private static  Cliente ejecutarRegistrar(ControladorCliente  elContC)
{	String cedulaa = input("Cedula");
	int cedula= Integer.parseInt(cedulaa);
	elContC.registrarNuevoCliente (cedula);
	Cliente elCliente = elContC.buscarCliente(cedula);
	return elCliente;
}
	
	private static Cliente ejecutarIngresar(ControladorCliente  elContC)
	{String cedulaa = input("Cedula");
	int cedula= Integer.parseInt(cedulaa);
	Cliente elCliente = elContC.buscarCliente(cedula);
	return elCliente;
		}

	private static void ejecutarPedido(Cliente cliente, ControladorPedido elContP, ControladorInventario elContI,int idPedido)
	{
		Pedido pedido = elContP.nuevoPedido(idPedido); 
		ejecutaranadirProd(pedido,elContP, cliente, elContI);
		
		cliente.anadirPedido(pedido);
	}


	private static void ejecutaranadirProd(Pedido pedido, ControladorPedido contp, Cliente cliente, ControladorInventario elContI)
	{boolean mas= true;
	while (mas==true)
	{
		String si= input("1. Añadir un  producto \n 2. Finalizar");
	if (si=="1")
		{String idd = input("Escanee el producto o ingrese el id del producto:");
		int id= Integer.parseInt(idd);
		contp.anadirProducto(pedido, id, elContI);
	}
	else
	{
		mas= false;
		ejecutarCerrarPedido(idPedido, contp, pedido, cliente);
		 
		
	}
		
	}}
  
	
	private static  void ejecutarCerrarPedido(int idPedido, ControladorPedido contp,Pedido pedido, Cliente cliente)
	{
		idPedido=1+ idPedido;
		contp.anadiraHistorial(pedido);
		contp.generarFactura(pedido,cliente);
		
		
		
	}

	
	private static String input(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

