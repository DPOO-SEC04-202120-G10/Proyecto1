package modelo;

import java.util.ArrayList;

public class Gondola {
	private int id; 
	private Categoria categoria;
	private ArrayList<Parte> partes;
	
	public Gondola(int id,Categoria categoria) {
		this.id = id;
		this.categoria = categoria;
	}
	
	public void agregarParte(Parte parte){
		partes.add(parte);
	}
	
	public Parte retornarParte(int id) {
		int i = 0;
		var lista = partes;
		while (i < lista.size()) {
			Parte parte = lista.get(i);
			var x = id;
			if (parte.id == x) {
				return parte;
			}
			}
		return null;
	}
	
}
