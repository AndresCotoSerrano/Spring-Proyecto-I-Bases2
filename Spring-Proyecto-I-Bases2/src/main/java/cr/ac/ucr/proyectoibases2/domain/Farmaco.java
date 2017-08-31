package cr.ac.ucr.proyectoibases2.domain;

public class Farmaco {

	private int id;
	private String nombre;
	private String desarrollador;
	private String indicaciones;
	
	
	public Farmaco(int id, String nombre, String desarrollador, String indicaciones) {
		
		this.id = id;
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.indicaciones = indicaciones;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDesarrollador() {
		return desarrollador;
	}


	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}


	public String getIndicaciones() {
		return indicaciones;
	}


	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	
 
}
