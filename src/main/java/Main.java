import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// 
		
		String archivo_pronostico = new File ("src\\main\\resources\\pronostico.csv").getAbsolutePath();
		String archivo_resultados = new File ("src\\main\\resources\\resultados.csv").getAbsolutePath();
		
		ArrayList<Partido> partidos = new ArrayList();
		ArrayList<Pronostico> pronosticos = new ArrayList();
		
		Ronda ronda = new Ronda(1,partidos);
		int indice_partidos = 0;
		int puntos_totales = 0;
		String resultado_pronostico = "";
		String resultado_partido = "";
		
		
		for(String linea : Files.readAllLines(Paths.get(archivo_resultados))) {
			//leo cada linea del archivo y le doy los valores correspondistes y despues agrego partido a una lista de partidos
			
			 String[] campos_linea = linea.split(","); 
			 String nombre_equipo1 = campos_linea[0];
			 String goles_equipo1 = campos_linea[1];
			 String goles_equipo2 = campos_linea[2];
			 String nombre_equipo2 = campos_linea[3];
			 
			 Equipo equipo1 = new Equipo(nombre_equipo1);
			 Equipo equipo2 = new Equipo(nombre_equipo2);
			 int goles_equipo1_int = Integer.parseInt(goles_equipo1);
			 int goles_equipo2_int = Integer.parseInt(goles_equipo2);
			 
			 Partido partido = new Partido(equipo1,equipo2,goles_equipo1_int,goles_equipo2_int);
			 
			 partidos.add(partido);
			 
		}	 
		
		for(String linea : Files.readAllLines(Paths.get(archivo_pronostico))) {
			
			 String[] campos_linea = linea.split(","); 
			 String nombre_equipo1 = campos_linea[0];
			 int gana1 = Integer.parseInt(campos_linea[1]);
			 int empata = Integer.parseInt(campos_linea[2]);
			 int gana2 = Integer.parseInt(campos_linea[3]);
			 String nombre_equipo2 = campos_linea[4];
			 
			if (gana1 == 1){
				resultado_pronostico = "ganador";
			} 
			if (empata == 1){
				resultado_pronostico = "empate";
			} 
			if (gana2 == 1) {
				resultado_pronostico = "perdedor";
			}

			 Equipo equipo1 = new Equipo(nombre_equipo1);
			 
			 Pronostico pronostico = new Pronostico(partidos.get(indice_partidos),equipo1,resultado_pronostico);
			 pronosticos.add(pronostico);
			 indice_partidos++;
			 
		}	 
		
		
		for(Pronostico pronostico : pronosticos) {
			
			resultado_partido = pronostico.getPartido().resultado(pronostico.getEquipo());
		
			if(resultado_partido == pronostico.getResultado()) {
				puntos_totales = puntos_totales + pronostico.puntos();
			}
			
		}
			
		System.out.println(puntos_totales);		
			 
	}
}
