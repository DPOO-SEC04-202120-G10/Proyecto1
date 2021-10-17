package modelo;

import java.util.ArrayList;


public class ControladorCliente 
{
	private static Cliente elCliente = null;
	private ArrayList<Cliente> clientes;
private void registrarNuevoCliente () 
{
	
}
private Cliente buscarCliente(int id)
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
private void ingresarCliente (int id)
{
	
}
public ArrayList<Cliente> getCLientes()
{
	return clientes;
}
}
