/**
 * Serialización
 * Autor: Rodrigo
 * Fecha: 2 sept 2024
 */
package ups.poo.serializacion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
	// Nombre del archivo de serialización
	private static final String FILE_NAME = "tareas.ser"; 

	public static void main(String[] args) {
		// Lista de tareas
		List<Tarea> tasks = new ArrayList<>();

		// Añadir algunas tareas a la lista con fechas de vencimiento
		tasks.add(new Tarea("Comprar leche", "Comprar leche en el supermercado", LocalDate.of(2024, 9, 2)));
		tasks.add(new Tarea("Estudiar Java", "Revisar los conceptos de serialización", LocalDate.of(2024, 9, 10)));
		tasks.add(new Tarea("Limpiar la casa", "Hacer una limpieza general de la casa", LocalDate.of(2024, 9, 5)));

		// Serializar la lista de tareas en un archivo
		serializarTareas(tasks);

		// Deserializar la lista de tareas desde el archivo
		List<Tarea> tareasDeserializadas = deserializarTareas();

		// Mostrar las tareas deserializadas
		if (tareasDeserializadas != null) {
			// CAmbiar el estado de una tarea
			tareasDeserializadas.get(1).setCompletada(true);
			System.out.println("Tareas deserializadas desde el archivo:");
			for (Tarea t : tareasDeserializadas) {
				System.out.println(t);
			}
		}
	}

	// Método para serializar una lista de tareas
	private static void serializarTareas(List<Tarea> tasks) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(tasks);
			System.out.println("Lista de tareas serializada en el archivo '" + FILE_NAME + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para deserializar una lista de tareas
	private static List<Tarea> deserializarTareas() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			List<Tarea> tasks = (List<Tarea>) ois.readObject();
			return tasks;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}