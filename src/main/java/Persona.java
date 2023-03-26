import java.util.ArrayList;

public class Persona {

	public Persona(String nombre, ArrayList<Pronostico> pronosticos) {
		super();
		this.nombre = nombre;
		this.pronosticos = pronosticos;
	}
	public String nombre;
	public ArrayList<Pronostico> pronosticos = new ArrayList();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Pronostico> getPronosticos() {
		return pronosticos;
	}
	public void setPronosticos(ArrayList<Pronostico> pronosticos) {
		this.pronosticos = pronosticos;
	} 
	
	

}
