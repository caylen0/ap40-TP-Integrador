import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		//

		String archivo_pronostico = new File("src\\main\\resources\\pronostico.csv").getAbsolutePath();
		String archivo_resultados = new File("src\\main\\resources\\resultados.csv").getAbsolutePath();

		ArrayList<Persona> personas = new ArrayList();
		ArrayList<Ronda> rondas = new ArrayList();
		ArrayList<Partido> partidos = new ArrayList();
		ArrayList<Pronostico> pronosticos = new ArrayList();

		int indice_partidos = 0;
		int puntos_totales = 0;
		int numero_ronda = 1;
		String resultado_pronostico = "";
		String resultado_partido = "";
		String nombre_persona = "";

		for (String linea : Files.readAllLines(Paths.get(archivo_resultados))) {
			// leo cada linea del archivo y le doy los valores correspondistes y despues
			// agrego partido a una lista de partidos

			String[] campos_linea = linea.split(",");

			String nombre_equipo1 = campos_linea[1];
			String goles_equipo1 = campos_linea[2];
			String goles_equipo2 = campos_linea[3];
			String nombre_equipo2 = campos_linea[4];

			Equipo equipo1 = new Equipo(nombre_equipo1);
			Equipo equipo2 = new Equipo(nombre_equipo2);
			int goles_equipo1_int = Integer.parseInt(goles_equipo1);
			int goles_equipo2_int = Integer.parseInt(goles_equipo2);

			Partido partido = new Partido(equipo1, equipo2, goles_equipo1_int, goles_equipo2_int);

			if (numero_ronda == Integer.parseInt(campos_linea[0])) {
				partidos.add(partido);
			} else {
				Ronda ronda = new Ronda(numero_ronda, partidos);
				rondas.add(ronda);
				partidos = new ArrayList();
				partidos.add(partido);
			}

			numero_ronda = Integer.parseInt(campos_linea[0]);
		}

		for (String linea : Files.readAllLines(Paths.get(archivo_pronostico))) {

			String[] campos_linea = linea.split(",");

			if (nombre_persona == "") {
				nombre_persona = campos_linea[0];
			}

			String nombre_equipo1 = campos_linea[1];
			int gana1 = Integer.parseInt(campos_linea[2]);
			int empata = Integer.parseInt(campos_linea[3]);
			int gana2 = Integer.parseInt(campos_linea[4]);
			String nombre_equipo2 = campos_linea[5];

			if (gana1 == 1) {
				resultado_pronostico = "ganador";
			}
			if (empata == 1) {
				resultado_pronostico = "empate";
			}
			if (gana2 == 1) {
				resultado_pronostico = "perdedor";
			}

			Equipo equipo1 = new Equipo(nombre_equipo1);

			Partido partido_pronostico = buscar_partido(partidos, nombre_equipo1, nombre_equipo2); // verifico que el
																									// partido no sea
																									// null
			if (partido_pronostico ==null) { //crear excepcion para que el programa termine
				System.out.println("no se encontro partido");
				
			}
			

			Pronostico pronostico = new Pronostico(partido_pronostico, equipo1,
					resultado_pronostico); 
			if (nombre_persona == campos_linea[0]) {
				pronosticos.add(pronostico);
			} else {
				Persona persona = new Persona(nombre_persona, pronosticos);
				personas.add(persona);
				pronosticos = new ArrayList();
				pronosticos.add(pronostico);
			}

			nombre_persona = campos_linea[0];

			indice_partidos++;

		}

		for (Persona persona : personas) {

			for (Pronostico pronostico : persona.getPronosticos()) {

				resultado_partido = pronostico.getPartido().resultado(pronostico.getEquipo());

				if (resultado_partido == pronostico.getResultado()) {
					puntos_totales = puntos_totales + pronostico.puntos();
				}

			}

			System.out.println("La persona" + persona.getNombre() + "tuvo: " + puntos_totales + "/n");
		}
	}

	public static Partido buscar_partido(ArrayList<Partido> partidos, String nombre_equipo1, String nombre_equipo2) { // creo
																												// funcion
																												// de
																												// buscar
																												// partido
																												// para
																												// rectificar
																												// que
																												// el
																												// partido
																												// exista
		for (Partido partido : partidos) {
			if (nombre_equipo1 == partido.getEquipo1().getNombre()
					&& nombre_equipo2 == partido.getEquipo2().getNombre()) {
				return partido;
			}
		}
		return null;

	}
}
