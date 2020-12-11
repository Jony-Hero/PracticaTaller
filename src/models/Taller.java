package models;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Clase que simula el funcionamiento de un taller.
 * 
 * Como taller, lleva la cuenta de los vehículos que son reparados y los
 * vehículos que están averiados (pendientes de reparar).
 * 
 * El comportamiento de esta clase permite: - Insertar nuevos vehículos
 * averiados. - Listar los vehículos almacenados. - TODO Completar
 * 
 * @author AdriGB
 * @author TODO Jonhy pon tu nombre aquí *
 *
 */
public class Taller {

	private ArrayList<Vehiculo> listaV_Averiados;
	private ArrayList<Vehiculo> listaV_Reparados;

	/**
	 * Constructor de la clase, reserva memoria para los ArrayList.
	 */
	public Taller() {
		listaV_Averiados = new ArrayList<Vehiculo>();
		listaV_Reparados = new ArrayList<Vehiculo>();
	}

	/**
	 * Método que lista todos los vehículos. Lista todos los tipos sin tener en
	 * cuenta si están o no averiados.
	 */
	public void listarVehiculos() {
		int cont = 1;
		for (Vehiculo vehiculo : listaV_Averiados) {
			System.out.println(cont++ + ". " + vehiculo);
		}
	}

	/**
	 * Método que inserta un vehículo ingresado como parámetro en la lista de
	 * vehículos averiados.
	 * 
	 * @param vehiculo Vehículo que será insertado.
	 */
	public void insertarVAveriado(Vehiculo vehiculo) {
		if (listaV_Averiados.contains(vehiculo))
			System.out.println("El vehículo que se intenta insertar ya existe en la lista.");
		else
			listaV_Averiados.add(vehiculo);
	}

	/**
	 * Método que lista los vehículos que siguen averiados.
	 */
	public void listarVAveriados() {
		int cont = 1;
		for (Vehiculo vehiculo : listaV_Averiados) {
			System.out.println(cont++ + ". " + vehiculo);
		}
	}

	/**
	 * Método que lista los vehículos que han sido reparados.
	 */
	public void listarVReparados() {
		int cont = 1;
		for (Vehiculo vehiculo : listaV_Reparados) {
			System.out.println(cont++ + ". " + vehiculo);
		}
	}

	/**
	 * Método que lista todas las motocicletas, tanto reparadas como averiadas.
	 */
	public void listarMotocicletas() {
		int cont = 1;

		System.out.println("Motocicletas averiadas:");
		for (Vehiculo moto : listaV_Averiados) {
			if (moto instanceof Motocicleta)

				System.out.println(cont++ + ". " + moto);
		}

		System.out.println("\nMotocicletas reparadas:");
		for (Vehiculo moto : listaV_Reparados) {
			if (moto instanceof Motocicleta)
				System.out.println(cont++ + ". " + moto);
		}
	}

	/**
	 * Método de testeo. TODO Borrar antes de entregar.
	 * 
	 * @returns String Matrícula de una Motocicleta.
	 * @returns null Si no hay motocicletas.
	 */
	public String getMatriculaMotocicleta() {
		for (Vehiculo vehiculo : listaV_Averiados) {
			if (vehiculo instanceof Motocicleta) {
				return vehiculo.matricula;
			}
		}
		return null;
	}

	/**
	 * Método que cambia el escape de una Motocicleta.
	 * 
	 * Son ingresados la matrícula del vehículo y la marca del nuevo escape. Si la
	 * matrícula pertenece a una motocicleta proceda, en caso contrario indica que
	 * el vehículo indicado no es una motocicleta.
	 * 
	 * @param matricula   Matrícula del vehículo a 1.reparar
	 * @param nuevoEscape Marca del nuevo escape.
	 */
	public void cambiarExcape(String matricula, String nuevoEscape) {
		boolean existe = false; // Controla si el vehículo buscado existe o no
		for (Vehiculo motocicleta : listaV_Averiados) {
			if (motocicleta.getMatricula() == matricula) { // Si existe procede
				existe = true;
				if (motocicleta instanceof Motocicleta) { // Comprueba si es una motocicleta
					((Motocicleta) motocicleta).cambiarEscape(nuevoEscape);

					System.out.println("El escape desechado es: " + ((Motocicleta) motocicleta).getMarcaEscape()
							+ "El nuevo escape es: " + nuevoEscape);

					listaV_Reparados.add(motocicleta);
					listaV_Averiados.remove(motocicleta);
					// Al eliminar el vehículo de la lista, no es posible seguir recorriendo el
					// ArrayList
					// Lanzaría una ConcurrentModificationException.
					break;
				} else {
					System.out.println("El vehículo seleccionado no es una Motocicleta.");
				}
			}

		}
		if (!existe) { // Si no existe lo indica
			System.out.println("El vehiculo elegido no existe.");
		}
	}

	/**
	 * Método que pasa un coche averiado a la lista de reparados sin hacer ningún
	 * cambio en él.
	 * 
	 * @param vehiculo Vehículo averiado que será puesto en vehículos reparados.
	 */
	public void marcarVehiculoReparado(Vehiculo vehiculo) {
		if (this.listaV_Averiados.contains(vehiculo)) {
			listaV_Reparados.add(vehiculo);
			listaV_Averiados.remove(vehiculo);
		} else {
			System.out.println("El vehículo indicado no se encuentra en la lista de vehículos averiados.");
		}
	}

	/**
	 * Método que entrega un vehículo reparado a su cliente. En caso de no estar
	 * reparado, le indica que vuelva al día siguiente. En caso de no existir, lo
	 * echa de la tienda..
	 * 
	 * @param matricula
	 */
	public void entregarVehiculo(String matricula) {

		boolean existe = false; // Controla si el vehículo buscado existe o no

		for (Vehiculo vehiculo : listaV_Averiados) {
			if (vehiculo.getMatricula() == matricula) { // Si existe procede en Averiados
				existe = true;
				System.out.println("Su vehículo no está reparado, vuelva mañana por favor.");
			}
		}

		for (Vehiculo vehiculo : listaV_Reparados) {
			if (vehiculo.getMatricula() == matricula) { // Si existe procede en Reparados
				existe = true;
				System.out.println("Muchas gracias por confiar ReparaTox :)");
				listaV_Reparados.remove(vehiculo);
			}
		}

		if (!existe) { // Si no existe lo indica
			System.out.println("¡FUERA DE AQUI!");
		}
	}

}
