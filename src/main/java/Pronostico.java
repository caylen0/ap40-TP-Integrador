
public class Pronostico {
	public Partido partido;
	public Equipo equipo;
	public ResultadoEnum resultado;
	

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}	
	
	public int puntos () {
		return 1;
	}
	
	

}
