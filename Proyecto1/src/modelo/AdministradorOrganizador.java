package modelo;

import java.util.ArrayList;

public class AdministradorOrganizador {
	public ArrayList<Gondola> gondolas;
	public ArrayList<Categoria> categorias; 
	
	public AdministradorOrganizador(){
		this.gondolas = new ArrayList<Gondola>();
		this.categorias = new ArrayList<Categoria>();
	}
	
	public void agregarGondola(Gondola gondola) {
		gondolas.add(gondola);
	}
	
	public void agregarCategoria(Categoria categoria){
		categorias.add(categoria);
	}
	
	
	public boolean existeCategoria(int id,ArrayList<Categoria> lista) {
		int i = 0;
		while (i < lista.size()) {
			Categoria categoriaLista = lista.get(i);
			var x = id;
			if (categoriaLista.id == x) {
				return true;
			}
			}
		return false;
	}
	
	
	public Categoria retornarCategoria(int id, ArrayList<Categoria> lista) {
		
		int i = 0;
		while (i < lista.size()) {
			Categoria categoriaLista = lista.get(i);
			var x = id;
			if (categoriaLista.id == x) {
				return categoriaLista;
			}
			i+=1;
		}
		
	
		return null;
				
		
	}
	
	

}
