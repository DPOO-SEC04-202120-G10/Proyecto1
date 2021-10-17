package modelo;

public class Producto {
	public int id;
	private int idProducto;
	private String nombre;
	private int temperaturaConservacion;
	private Parte ubicacion;
	private int precio;
	private int precioUnidad;
	private String unidad;
	private boolean empacado;
	private int peso;
	private Subcategoria subcategoria;
	private LoteProducto lote;
	private boolean disponible;
	
	public Producto(int id, String nombre, int temperaturaConservacion, Parte ubicacion, int precio, 
			int precioUnidad, String unidad, boolean empacado, int peso, Subcategoria subcategoria, LoteProducto lote) {
		
		this.id = id;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.temperaturaConservacion = temperaturaConservacion;
		this.ubicacion = ubicacion;
		this.precio = precio;
		this.precioUnidad = precioUnidad;
		this.unidad = unidad;
		this.empacado = empacado;
		this.peso = peso;
		this.subcategoria = subcategoria;
		this.lote = lote; 
		this.disponible = true;
	}
	
	


}
