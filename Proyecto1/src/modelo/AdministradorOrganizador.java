package modelo;

import java.util.ArrayList;

public class AdministradorOrganizador {
	private ArrayList<Gondola> gondolas;
	private ArrayList<Categoria> categorias; 
	
	public AdministradorOrganizador(){
		this.gondolas = new ArrayList<Gondola>();
		this.categorias = new ArrayList<Categoria>();
	}
	
}
