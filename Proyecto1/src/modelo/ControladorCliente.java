package modelo;

import java.util.ArrayList;
import java.util.Scanner;


public class ControladorCliente 
{
	
	private static Scanner inputScanner = new Scanner(System.in);
	private ArrayList<Cliente> clientes;
public ControladorCliente ()
{
		this.clientes= new ArrayList<Cliente>();
	}
public void registrarNuevoCliente (int cedula) 
{
	  
	inputScanner.useDelimiter(System.lineSeparator());
    System.out.println("Edad");
    int edad = inputScanner.nextInt();
    
	inputScanner.useDelimiter(System.lineSeparator());
    System.out.println("Estado Civil");
	String estadoCivil = inputScanner.next();
	
	inputScanner.useDelimiter(System.lineSeparator());
    System.out.println("Sexo");
	String sexo = inputScanner.next();

	inputScanner.useDelimiter(System.lineSeparator());
    System.out.println("Situacion Laboral:");
	String situacionLaboral = inputScanner.next();
	
	int puntos= 0;
	
	Cliente elcliente= new Cliente(cedula,edad,estadoCivil,sexo,situacionLaboral, puntos );
	clientes.add(elcliente);
}
public Cliente buscarCliente(int id)
{Cliente elCliente = null;
	for (Cliente i:getCLientes())
	{
	int cedula= i.getcedula();
	if (id==cedula)
	{
		elCliente= i;
	}
}
	return elCliente;
	}

public ArrayList<Cliente> getCLientes()
{
	return clientes;
}
private static String input(String string) {
	// TODO Auto-generated method stub
	return null;}
}
