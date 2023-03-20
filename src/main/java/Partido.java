public class Partido {

	public Equipo equipo1;
	public Equipo equipo2;
	public int goles_equipo1;
	public Partido(Equipo equipo1, Equipo equipo2, int goles_equipo1, int goles_equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.goles_equipo1 = goles_equipo1;
		this.goles_equipo2 = goles_equipo2;
	}

	public int goles_equipo2;


	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGoles_equipo1() {
		return goles_equipo1;
	}

	public void setGoles_equipo1(int goles_equipo1) {
		this.goles_equipo1 = goles_equipo1;
	}

	public int getGoles_equipo2() {
		return goles_equipo2;
	}

	public void setGoles_equipo2(int goles_equipo2) {
		this.goles_equipo2 = goles_equipo2;
	}
	
	public String resultado(Equipo equipo) {
		
		if (this.getGoles_equipo1() > this.getGoles_equipo2()) {
			return "ganador";
		}
		else if (this.getGoles_equipo1() < this.getGoles_equipo2()) {
			return "perdedor";
		}
		return "empate";
	}
	
}
