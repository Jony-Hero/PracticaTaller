package models;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Clase que simula el funcionamiento de un taller.
 * 
 * Como taller, lleva la cuenta de los veh�culos que son reparados y los
 * veh�culos que est�n averiados (pendientes de reparar).
 * 
 * El comportamiento de esta clase permite: - Insertar nuevos veh�culos
 * averiados. - Listar los veh�culos almacenados. - TODO Completar
 * 
 * @author AdriGB
 * @author TODO Jonhy pon tu nombre aqu�
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
	 * M�todo que lista todos los veh�culos. Lista todos los tipos sin tener en
	 * cuenta si est�n o no averiados.
	 */
	public void listarVehiculos() {
		int cont = 1;
		for (Vehiculo vehiculo : listaV_Averiados) {
			System.out.println(cont++ + ". " + vehiculo);
		}
	}

	/**
	 * M�todo que inserta un veh�culo ingresado como par�metro en la lista de
	 * veh�culos averiados.
	 * 
	 * @param vehiculo Veh�culo que ser� insertado.
	 */
	public void insertarVAveriado(Vehiculo vehiculo) {
		if (listaV_Averiados.contains(vehiculo))
			System.out.println("El veh�culo que se intenta insertar ya existe en la lista.");
		else
			listaV_Averiados.add(vehiculo);
	}
	
	/**
	 * M�todo que lista los veh�culos que siguen averiados.
	 */
	public void listarVAveriados() {
		int cont = 1;
		for (Vehiculo vehiculo : listaV_Averiados) {
			System.out.println(cont++ + ". " + vehiculo);
		}
	}

	/**
	 * M�todo que lista los veh�culos que han sido reparados.
	 */
	public void listarVReparados() {
		int cont = 1;
		for (Vehiculo vehiculo : listaV_Reparados) {
			System.out.println(cont++ + ". " + vehiculo);
		}
	}

	/**
	 * M�todo que lista todas las motocicletas, tanto reparadas como averiadas.
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
	 * M�todo de testeo. TODO Borrar antes de entregar.
	 * 
	 * @returns String Matr�cula de una Motocicleta.
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
	 * M�todo que cambia el escape de una Motocicleta.
	 * 
	 * Son ingresados la matr�cula del veh�culo y la marca del nuevo escape. Si la
	 * matr�cula pertenece a una motocicleta proceda, en caso contrario indica que
	 * el veh�culo indicado no es una motocicleta.
	 * 
	 * @param matricula   Matr�cula del veh�culo a 1.reparar
	 * @param nuevoEscape Marca del nuevo escape.
	 */
	public void cambiarExcape(String matricula, String nuevoEscape) {
		boolean existe = false; // Controla si el veh�culo buscado existe o no
		for (Vehiculo motocicleta : listaV_Averiados) {
			if (motocicleta.getMatricula() == matricula) { // Si existe procede
				existe = true;
				if (motocicleta instanceof Motocicleta) { // Comprueba si es una motocicleta
					((Motocicleta) motocicleta).cambiarEscape(nuevoEscape);

					System.out.println("El escape desechado es: " + ((Motocicleta) motocicleta).getMarcaEscape()
							+ "El nuevo escape es: " + nuevoEscape);

					listaV_Reparados.add(motocicleta);
					listaV_Averiados.remove(motocicleta);
					// Al eliminar el veh�culo de la lista, no es posible seguir recorriendo el
					// ArrayList.
					// Lanzar�a una ConcurrentModificationException.
					break;
				} else {
					System.out.println("El veh�culo seleccionado no es una Motocicleta.");
				}
			}

		}
		if (!existe) { // Si no existe lo indica
			System.out.println("El vehiculo elegido no existe.");
		}
	}

	/**
	 * M�todo que pasa un coche averiado a la lista de reparados sin hacer ning�n
	 * cambio en �l.
	 * 
	 * @param vehiculo Veh�culo averiado que ser� puesto en veh�culos reparados.
	 */
	public void marcarVehiculoReparado(Vehiculo vehiculo) {
		if (this.listaV_Averiados.contains(vehiculo)) {
			listaV_Reparados.add(vehiculo);
			listaV_Averiados.remove(vehiculo);
		} else {
			System.out.println("El veh�culo indicado no se encuentra en la lista de veh�culos averiados.");
		}
	}

	/**
	 * M�todo que entrega un veh�culo reparado a su cliente. En caso de no estar
	 * reparado, le indica que vuelva al d�a siguiente. En caso de no existir, lo
	 * echa de la tienda..
	 * 
	 * @param matricula
	 */
	public void entregarVehiculo(String matricula) {

		boolean existe = false; // Controla si el veh�culo buscado existe o no

		for (Vehiculo vehiculo : listaV_Averiados) {
			if (vehiculo.getMatricula() == matricula) { // Si existe procede en Averiados
				existe = true;
				System.out.println("Su veh�culo no est� reparado, vuelva ma�ana por favor.");
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
			System.out.println("�FUERA DE AQUI!");
		}
	}

}
