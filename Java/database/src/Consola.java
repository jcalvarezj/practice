/*
 * Basic JDBC example. Not using packages best practice for making it quick
 */

/**
 * Model class of the Consola entity
 *
 * @author J. Alvarez
 */
public class Consola {

	private int consolaId;
	private String nombre;
	private String firmware;

	public Consola(int consolaId, String nombre, String firmware) {
		this.consolaId = consolaId;
		this.nombre = nombre;
		this.firmware = firmware;
	}

	public int getConsolaId() {
		return consolaId;
	}

	public void setConsolaId(int consolaId) {
		this.consolaId = consolaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}
}

