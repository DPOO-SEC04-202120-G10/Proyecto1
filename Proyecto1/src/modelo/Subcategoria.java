package modelo;

public class Subcategoria extends Categoria{
	
	private Categoria categoriaPadre;
	
	public Subcategoria(int id, String nombre, Categoria categoriaPadre) {
		super(id, nombre);
		this.categoriaPadre = categoriaPadre;
		
	}

	
	
}
