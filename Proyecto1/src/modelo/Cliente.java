package modelo;

import java.util.ArrayList;

public class Cliente {
private ArrayList<Pedido> historialPedidos;
private int cedula;
private int edad;
private String estadoCivil; 
private String sexo;
private String situacionLaboral; 
private int puntos; 
public Cliente(int cedula, int edad, String estadoCivil, String sexo,String situacionLaboral,int puntos ) 
{
	this.cedula = cedula;
	this.edad = edad;
	this.estadoCivil= estadoCivil;
	this.sexo=sexo;
	this.situacionLaboral=situacionLaboral;
	this.puntos=puntos;
	}
	
	
public void anadirPuntos (int costo) 
{ 
	int addpuntos=costo/1000;
	puntos=puntos+addpuntos;
}
public void anadirPedido (Pedido pedido) 
{
	historialPedidos.add(pedido);
	int costo= pedido.getcosto();
	anadirPuntos(costo);
}
public int getcedula()
{
	return cedula;
}
}
