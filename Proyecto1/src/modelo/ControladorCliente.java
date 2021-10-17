package modelo;

import java.util.ArrayList;


public class ControladorCliente 
{
	private static Cliente elCliente = null;
	private ArrayList<Cliente> clientes;
public void registrarNuevoCliente (int cedula) 
{
	  
	String edadd = input("Edad:");
	int edad= Integer.parseInt(edadd);
	String estadoCivil = input("Estado Civil");
	String sexo= input("Sex:o");
	String situacionLaboral = input("Situacion Laboral:");
	int puntos= 0;
	
	Cliente elcliente= new Cliente(cedula,edad,estadoCivil,sexo,situacionLaboral, puntos );
	clientes.add(elcliente);
}
public Cliente buscarCliente(int id)
{
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
