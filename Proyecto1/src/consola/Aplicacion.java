package consola;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.ControladorCliente;
import modelo.ControladorInventario;
import modelo.ControladorPedido;
import modelo.Pedido;
import modelo.Cliente;

import java.io.*;



public class Aplicacion {
	
	private static Scanner inputScanner = new Scanner(System.in);
	private static int idPedido;
	
		public static void main(String[] args)   {
			// TODO Auto-generated method stub
			System.out.println("Inicio de ejecucion de la aplicacion");
			ControladorCliente  elContC = new ControladorCliente();
			ControladorInventario elContI = new ControladorInventario ();
			ControladorPedido elContP = new ControladorPedido();
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("Fecha de hoy (ano/mes/dia)");
			String fecha = inputScanner.next();
			ejecutarAplicacion(elContC,elContI, idPedido, fecha,  elContP);
			
		}
		public static void ejecutarAplicacion(ControladorCliente  elContC, ControladorInventario elContI, int idPedido, String fecha,ControladorPedido elContP)
		{
			//System.out.println("Bienvenido al Supermercado\n");
				
			
			boolean continuar = true;
			while (continuar) 
			{
				try
				{
					mostrarMenu();
					inputScanner.useDelimiter(System.lineSeparator());
			        System.out.println("Por favor seleccione una opcion");
			        int opcion_seleccionada = inputScanner.nextInt();
			        
					if (opcion_seleccionada == 1)
					    ejecutarInv(elContI);
						
				
					else if (opcion_seleccionada == 2)
						ejecutarPOS(elContC, elContI, idPedido,fecha, elContP);
	
					else if (opcion_seleccionada == 3)
					{
						System.out.println("Saliendo de la aplicacion ...");
						continuar = false;
					}
					else
					{
						System.out.println("Por favor seleccione una opcion valida.");
					}}
				
				catch (NumberFormatException e)
				{
				System.out.println("Debe seleccionar uno de los números de las opciones.");}
				}
				}
				
		
			
		
		
		public static void mostrarMenu()
		{
			System.out.println("\nOpciones de la aplicacion\n");
			System.out.println("1. Sistema Inventario");
			System.out.println("2. Sistema POS");
			System.out.println("3. Salir de la aplicacion\n");
		}
	
		private static void ejecutarMostrarMenu1 ()
		{
	
			}
				
			
		private static void MostrarMenu2()
		{
			System.out.println("\nOpciones de la aplicacion POS\n");
			System.out.println("1. Registrar Nuevo Cliente");
			System.out.println("2. Ingresar Cliente");
			System.out.println("3. Salir de la aplicacion POS\n");
			idPedido= 0;
		}
	

	private static void ejecutarPOS(ControladorCliente  elContC, ControladorInventario contI, int idPedido, String fecha,ControladorPedido elContP ) 
	{
			
		boolean continuar = true;
		while (continuar)

		{


			try
			{
				MostrarMenu2();
				inputScanner.useDelimiter(System.lineSeparator());
		        System.out.println("Por favor seleccione una opcion");
		        int opcion_seleccionada = inputScanner.nextInt();
	
				Cliente cliente = null;
				if (opcion_seleccionada == 1) {
					cliente= ejecutarRegistrar(elContC);
					ejecutarPedido(cliente, elContP, contI, idPedido,fecha);
					}
					
				 if (opcion_seleccionada == 2) {
					cliente= ejecutarIngresar(elContC);
					ejecutarPedido(cliente, elContP, contI, idPedido, fecha);
					}

				 if (opcion_seleccionada == 3)
					{
					System.out.println("Saliendo de la aplicacion ...");
					continuar = false;
					}
				else
					{
					System.out.println("Por favor seleccione una opcion valida.");
					}
				}
			catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
			}
		}
	
		private static  Cliente ejecutarRegistrar(ControladorCliente  elContC)
		

		{	inputScanner.useDelimiter(System.lineSeparator());
	    	System.out.println("Cedula:");
	    	int cedula = inputScanner.nextInt();
			elContC.registrarNuevoCliente (cedula);
			Cliente elCliente = elContC.buscarCliente(cedula);
			return elCliente;
		}
			
			private static Cliente ejecutarIngresar(ControladorCliente  elContC)
			{	
				inputScanner.useDelimiter(System.lineSeparator());
				System.out.println("Cedula:");
				int cedula = inputScanner.nextInt();
				Cliente elCliente = elContC.buscarCliente(cedula);
				return elCliente;
				
			}
		
	
		private static void ejecutarPedido(Cliente cliente, ControladorPedido elContP, ControladorInventario elContI,int idPedido, String fecha)

		{
			Pedido pedido = elContP.nuevoPedido(idPedido,fecha); 
			ejecutaranadirProd(pedido,elContP, cliente, elContI);
			cliente.anadirPedido(pedido);
		}
	
	
		private static void ejecutaranadirProd(Pedido pedido, ControladorPedido contp, Cliente cliente, ControladorInventario elContI)
		{
		boolean mas= true;
		while (mas)
		
		{
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("1. Anadir un  producto \\n 2. Finalizar:");
			int si = inputScanner.nextInt();
			
		if (si==1)
			{
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("Escanee el producto o ingrese el id del producto:");
			String idd = inputScanner.next();
			
			
			int id= Integer.parseInt(idd);
			contp.anadirProducto(pedido, id, elContI);
		}
		if (si==2)
		{
			ejecutarCerrarPedido(idPedido, contp, pedido, cliente);
			mas= false;
			
			 
			
		}
			
		}}
	  
		
		private static  void ejecutarCerrarPedido(int idPedido, ControladorPedido contp,Pedido pedido, Cliente cliente)
		{
			idPedido=1+ idPedido;
			contp.anadiraHistorial(pedido);
			System.out.println(contp.generarFactura(pedido,cliente));
			
			
			
			
		}
	
		
		private static String input(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		
		private static void ejecutarInv(ControladorInventario elContI) {
	        
	        boolean continuar = true;
			while (continuar) 
			{
				try
				{
					mostrarMenu3();
					inputScanner.useDelimiter(System.lineSeparator());
			        System.out.println("Por favor seleccione una opcion");
			        int opcion_seleccionada = inputScanner.nextInt();
			        
					if (opcion_seleccionada == 1) {
					   ejecutarCargarNuevoCargamento(elContI);
					
					}
				
					else if (opcion_seleccionada == 2) {
						ejecutarConsultarProducto(elContI);
					}
					
					else if (opcion_seleccionada == 3) {
						ejecutarConsultarLote(elContI);
					}	
					
					else if (opcion_seleccionada == 4)
					{
						System.out.println("Saliendo ...");
						continuar = false;
					}
					else
					{
						System.out.println("Por favor seleccione una opcion valida.");
					}}
				
				catch (NumberFormatException e)
				{
				System.out.println("Debe seleccionar uno de los números de las opciones.");}
				}
				}
				
	        
		
		
		
		private static void mostrarMenu3()
		{
			System.out.println("\nOpciones\n");
			System.out.println("1. Cargar nuevo cargamento");
			System.out.println("2. Consultar informacion producto");
			System.out.println("3. Consultar informacion lote");
			System.out.println("4. Salir \n");
		
		}
		
		private static void ejecutarCargarNuevoCargamento(ControladorInventario elContI) {
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("Ingrese direccion archivo: ");
			String archivo = inputScanner.next();
			try {
				
				elContI.cargarNuevoLote(archivo);
			
			}
		
			catch (FileNotFoundException e) {
				e.printStackTrace();
		}
			catch (IOException e) {
				e.printStackTrace();
		}}
		
		private static void ejecutarConsultarProducto(ControladorInventario elContI) {
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("Ingrese el id: ");
			int id = inputScanner.nextInt();
			var producto = elContI.buscarEnListaProducto(id, elContI.adminProductos.productos);
			var info = producto.darInformacion();
			System.out.println(info);
			
		}
		
		private static void ejecutarConsultarLote(ControladorInventario elContI) {
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("Ingrese el id: ");
			int id = inputScanner.nextInt();
			var lote = elContI.buscarEnListaLote(id, elContI.adminProductos.lotes);
			var info = lote.darInformacion();
			System.out.println(info);
		}
		
		
		
			
			
	        
	
	}
	
