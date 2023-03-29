
public enum ResultadoEnum {

	GANADOR("ganador"),
	EMPATE("empate"),
	PERDEDOR("perdedor");
	
	private final String resultado;

	private ResultadoEnum(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}
}

