package modelo;

import java.util.ArrayList;

public class Categoria {
	public int id;
	private String nombre; 
	public ArrayList<Subcategoria> subcategorias;
	public Gondola gondola; 
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre; 
	}
	
	public void agregarSubcategoria(Subcategoria subcategoria) {
		subcategorias.add(subcategoria);
	}
	
	public boolean existeSubcategoria(int id, ArrayList<Subcategoria> lista) {
		int i = 0;
		while (i < lista.size()) {
			Subcategoria subcategoriaLista = lista.get(i);
			var x = id;
			if (subcategoriaLista.id == x) {
				return true;
			}
			}
		return false;
	}
	
	public Subcategoria retornarSubcategoria(int id, ArrayList<Subcategoria> lista) {
		int i = 0;
		while (i < lista.size()) {
			Subcategoria subcategoriaLista = lista.get(i);
			var x = id;
			if (subcategoriaLista.id == x) {
				return subcategoriaLista;
			}
			i+=1;
		}
		
		return null;
	}
	
	public void agregarGondola(Gondola gondola) {
		this.gondola = gondola;
	}
	
	public Gondola retornarGondola() {
		return gondola;
	}
}
