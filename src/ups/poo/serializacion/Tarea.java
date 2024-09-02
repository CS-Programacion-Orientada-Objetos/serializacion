/**
 * Serialización
 * Autor: Rodrigo
 * Fecha: 2 sept 2024
 */
package ups.poo.serializacion;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 */
public class Tarea implements Serializable {
	// Versión de serialización
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String descripcion;
	private boolean completada;
	private LocalDate vencimiento;

	public Tarea(String nom, String des, LocalDate fecha) {
		this.nombre = nom;
		this.descripcion = des;
		this.vencimiento = fecha;
		this.completada = false;
	}

	// Métodos getter y setter
	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public LocalDate getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Tarea: " + nombre + " | Descripción: " + descripcion + " | Fecha de vencimiento: " + vencimiento
				+ " | Completada: " + (completada ? "Sí" : "No");
	}
}
