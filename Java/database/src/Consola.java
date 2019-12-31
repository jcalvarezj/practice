/*
 * Basic JDBC example. Not using packages best practice for making it quick
 *
 * @author J. Alvarez
 */

/**
 * Model class of the Consola entity
 */
public class Consola {

	private int consolaId;
	private String nombre;
	private String firmware;

	/**
	 * Creates a new Consola instance from an id, a name, and a firmware
	 * @param consolaId The id of the Consola
	 * @param nombre The nombre of the Consola
	 * @param firmware The firmware of the Consola
	 */
	public Consola(int consolaId, String nombre, String firmware) {
		this.consolaId = consolaId;
		this.nombre = nombre;
		this.firmware = firmware;
	}

	/**
	 * @return The Consola's id
	 */
	public int getConsolaId() {
		return consolaId;
	}

	/**
	 * Sets the Consola's id
	 * @param consolaId The new id
	 */
	public void setConsolaId(int consolaId) {
		this.consolaId = consolaId;
	}

	/**
	 * @return The Consola's id
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the Consola's name
	 * @param nombre The new name
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return The Consola's id
	 */
	public String getFirmware() {
		return firmware;
	}

	/**
	 * Sets the Consola's firmware
	 * @param firmware The new firmware
	 */
	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	/**
	 * Returns a String with the Consola's id, name, and firmware
	 * @return String with the Consola's information
	 */
	@Override
	public String toString() {
		return "(" + consolaId + "): " + nombre + " - " + firmware;
	}
}

