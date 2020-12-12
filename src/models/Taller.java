package models;

import java.util.ArrayList;
import java.util.Scanner;

import utils.VarUtils;

/**
 * Clase que simula el funcionamiento de un taller.
 * 
 * Como taller, lleva la cuenta de los vehículos que son reparados y los
 * vehículos que están averiados (pendientes de reparar).
 * 
 * El comportamiento de esta clase permite:
 *  - Insertar nuevos vehículos averiados.
 *  - Listar los vehículos almacenados.
 *  
 * 
 * @author AdriGB
 * @author TODO Jonhy pon tu nombre aquí
 *
 */
public class Taller {

	// Scanner utilizado en los métodos.
	private static Scanner sc = new Scanner(System.in);
	
	// Atributos
	private ArrayList<Vehiculo> listaV_Averiados;
	private ArrayList<Vehiculo> listaV_Reparados;

	/**
	 * Constructor de la clase, simplemente reserva memoria para los ArrayList.
	 */
	public Taller() {
		listaV_Averiados = new ArrayList<Vehiculo>();
		listaV_Reparados = new ArrayList<Vehiculo>();
	}
	
	public void br() {
		System.out.println();
	}
	
	/**
	 * Método que comprueba si la matrícula recibida es única (no existe ningún
	 * vehículo registrado con esa matrícula.
	 * 
	 * @param matricula Matrícula a verificar.
	 * @returns false Si existe un vehículo con dicha matrícula.
	 * @returns true Si no existe un vehículo con dicha matrícula.
	 */
	public boolean mtrIsUnica(String matricula) {
		
		boolean esUnica = true;
		
		for (Vehiculo vehiculo : listaV_Averiados) {
			if(vehiculo.getMatricula().equals(matricula))
				esUnica = false;
		}
		
		for (Vehiculo vehiculo : listaV_Reparados) {
			if(vehiculo.getMatricula().equals(matricula))
				esUnica = false;
		}
		
		return esUnica;
	}
	
	/**
	 * Método que lista todos los vehículos, lo hace sin tener en
	 * cuenta si están o no averiados y sin tener en cuenta el tipo de vehículo.
	 */
	public void listarVehiculos() {
		int cont = 1;
		if (!this.listaV_Averiados.isEmpty() || !this.listaV_Reparados.isEmpty()) {
			
			for (Vehiculo vehiculo : listaV_Averiados) {
				System.out.println(cont++ + ". " + vehiculo);
			}
			
			for (Vehiculo vehiculo : listaV_Reparados) {
				System.out.println(cont++ + ". " + vehiculo);
			}
			
		} else
			System.out.println("No hay vehículos actualmente.");
	}
	
	/**
	 * Método que devuleve el último vehículo añadido a la lista de vehículos
	 * averiados.
	 * 
	 * @return Vehiculo
	 */
	public Vehiculo getUltimoVehiculoAveriadoInsertado() {
		return this.listaV_Averiados.get(listaV_Averiados.size()-1);
	}
	
	/**
	 * Método que devuleve el último vehículo añadido a la lista de vehículos
	 * reparados.
	 * 
	 * @return Vehiculo
	 */
	public Vehiculo getUltimoVehiculoReparadoInsertado() {
		return this.listaV_Reparados.get(listaV_Reparados.size()-1);
	}
	
	/**
	 * Método que comprueba si hay motocicletas en el taller.
	 * 
	 * @returns true Si hay motocicletas.
	 * @returns false Si no hay motocicletas.
	 */
	public boolean checkMotocicletas() {
		
		boolean hayMotos = false;

		for (Vehiculo moto : listaV_Averiados) {
			if (moto instanceof Motocicleta) {
				hayMotos = true;
			}
		}

		for (Vehiculo moto : listaV_Reparados) {
			if (moto instanceof Motocicleta) {
				hayMotos = true;
			}
		}
		
		return hayMotos;
	}
	
	/**
	 * Método que comprueba si hay vehículos en el taller.
	 * 
	 * @returns true Si hay vehículos.
	 * @returns false Si no hay vehículos.
	 */
	public boolean checkVehiculos() {
		
		boolean hayVehiculos = false;

		if(!this.listaV_Averiados.isEmpty())
			hayVehiculos = true;
		if(!this.listaV_Reparados.isEmpty())
			hayVehiculos = true;
		
		return hayVehiculos;
	}

	/**
	 * Método que inserta un vehículo ingresado como Objeto de tipo vehículo en la lista de
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
	 * Método que lista los vehículos que están averiados.
	 */
	public void listarVAveriados() {
		int cont = 1;
		if(!this.listaV_Averiados.isEmpty()) 
			for (Vehiculo vehiculo : listaV_Averiados) {
				System.out.println(cont++ + ". " + vehiculo);	
			}
		else
			System.out.println("No hay vehículos averiados.");
	}

	/**
	 * Método que lista los vehículos que han sido reparados.
	 */
	public void listarVReparados() {
		int cont = 1;
		if(!this.listaV_Reparados.isEmpty()) {
			for (Vehiculo vehiculo : listaV_Reparados) {
			System.out.println(cont++ + ". " + vehiculo);
			}
		}else {
			System.out.println("No hay vehículos reparados.");
		}
	}

	/**
	 * Método que lista todas las motocicletas, tanto reparadas como averiadas.
	 */
	public void listarMotocicletas() {
		
		int cont = 1;
		boolean hayMotos = false;
		
		System.out.println("Motocicletas averiadas:");

		for (Vehiculo moto : listaV_Averiados) {
			if (moto instanceof Motocicleta) {
				System.out.println(cont++ + ". " + moto);
				hayMotos = true;
			}
		}
		
		if (!hayMotos)
			System.out.println("Noy hay motos averiadas actualmente.");
		
		System.out.println("\nMotocicletas reparadas:");
		
		for (Vehiculo moto : listaV_Reparados) {
			if (moto instanceof Motocicleta) {
				System.out.println(cont++ + ". " + moto);
				hayMotos = true;
			}
		}
		
		if (!hayMotos || this.listaV_Reparados.isEmpty()) {
			System.out.println("Noy hay motos reparadas actualmente.");
		}
	}

	/**
	 * Método que cambia el escape de una Motocicleta.
	 * 
	 * Son ingresados la matrícula del vehículo y la marca del nuevo escape. Si la
	 * matrícula pertenece a una motocicleta procede, en caso contrario, indica que
	 * el vehículo indicado no es una motocicleta.
	 * 
	 * <h3>DETALLE RELEVANTE:<h3>
	 * 		Al recorrer la lista y marcar la motocicleta como reparada, se modifica la lista, es decir,
	 * 		la motocicleta pasa de la lista de <strong>Averiados<strong> a la lista de <strong>Reparados<strong>.
	 * 		Por esto, no es posible seguir recorriendo el ArrayList pues lanzaría una ConcurrentModificationException.
	 * 
	 * @param matricula   Matrícula del vehículo a reparar.
	 * @param nuevoEscape Marca del nuevo escape.
	 */
	public void cambiarExcape(String matricula, String nuevoEscape) {
		
		boolean existe = false; // Boolean que controla si el vehículo buscado existe o no
		
		for (Vehiculo motocicleta : listaV_Averiados) { // Analiza la lista de Averiados
			
			if (motocicleta.getMatricula().equals(matricula)) { // Si existe en listaV_Averiados procede
				
				existe = true;
				
				if (motocicleta instanceof Motocicleta) { // Comprueba si es una motocicleta
				
					System.out.println(
							  "El escape desechado es: " + ((Motocicleta) motocicleta).getMarcaEscape()
							+ "\nEl nuevo escape es: " + nuevoEscape);
					
					((Motocicleta) motocicleta).cambiarEscape(nuevoEscape);

					listaV_Reparados.add(motocicleta);
					listaV_Averiados.remove(motocicleta);
					
					break;
				} else
					System.out.println("El vehículo seleccionado no es una motocicleta.");
			}
		}
		
		for (Vehiculo motocicleta : listaV_Reparados) { // Analiza la lista de Reparados
			
			if (motocicleta.getMatricula().equals(matricula)) { // Si existe en listaV_Reparados notifica
				existe = true;
				if (motocicleta instanceof Motocicleta) { // Ofrece la opción de marcar el vehículo como averiado
					System.out.println("La motocicleta que buscas ya está reparada, ¿desea marcarla como averiada para poder cambiar el escape?\n"
							+ "1. Sí.\n"
							+ "2. No.");
					String strOption = "";
					br();
					
					do { 
						System.out.print("Opcion: ");
						strOption = sc.nextLine();
						if(!strOption.equals("1") && !strOption.equals("2"))
							System.out.println("Opción no válida, vuelve a intentarlo.");
					} while(!strOption.equals("1") && !strOption.equals("2"));
					
					if(strOption.equals("1")) // Si la respuesta es positiva, se marca como averiada
						this.marcarVehiculoAveriado(motocicleta);
					
				} else // en caso de que motocicleta no sea una instancia de Motocicleta
					System.out.println("El vehículo seleccionado no es una motocicleta.");
			}
		}
		
		if (!existe) { // Si no existe lo indica
			System.out.println("El vehiculo elegido no está registrado en el taller.");
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
			System.out.println("El vehículo ha sido marcado como reparado.");
			
		} else
			System.out.println("El vehículo indicado ya está marcado como reparado.");
	}
	
	/**
	 * Método que marca un vehículo como averiado, es decir, lo pasa de Reparados a Averiados.
	 * Este método cobra sentido cuando el usuario intenta cambiar el escape o reparar un vehículo
	 * y este ya se encuentra reparado.
	 * @param vehiculo
	 */
	public void marcarVehiculoAveriado(Vehiculo vehiculo) {
		
		if(this.listaV_Reparados.contains(vehiculo)) {
			
			this.listaV_Averiados.add(vehiculo);
			this.listaV_Reparados.remove(vehiculo);
			System.out.println("El vehículo ha sido marcado como averiado.");
			
		} else
			System.out.println("El vehículo indicado ya está marcado como averiado.");
	}

	/**
	 * Método que entrega un vehículo reparado a su cliente. En caso de no estar
	 * reparado, le indica que vuelva al día siguiente. En caso de no existir, lo
	 * echa de la tienda..
	 * 
	 * @param matricula
	 */
	public void entregarVehiculo(String matricula) {
		
		String opc = "";
		boolean existe = false; // Controla si el vehículo buscado está registrado o no

		for (Vehiculo vehiculo : listaV_Averiados) {
			if (vehiculo.getMatricula().equals(matricula)) { // Si está registrado en Averiados, notifica
				existe = true;
				System.out.println("Su vehículo no está reparado, vuelva mañana por favor.");
				System.out.println("Detalles del vehículo:\n" + vehiculo);
			}
		}

		for (Vehiculo vehiculo : listaV_Reparados) {
			if (vehiculo.getMatricula().equals(matricula)) { // Si está registrado en Reparados, procede
				
				existe = true;
				System.out.println("Detalles del vehículo:\n" + vehiculo);
				System.out.println("¿Desea recoger el vehículo?:\n"
						+ "1. Si.\n"
						+ "2. No ");
				
				do {
					System.out.print("Opción: ");
					opc = sc.nextLine();
				} while (!opc.equals("1") && !opc.equals("2")); // Si no es "1" ni "2"
				
				if (opc.equals("1")) {
					System.out.println("Muchas gracias por confiar ReparaTox :)");
					listaV_Reparados.remove(vehiculo);
				}
			}
		}

		if (!existe) { // Si no existe lo indica
			System.out.println("¡FUERA DE AQUI!");
		}
	}

	/**
	 * Método que recibe una matrícula.
	 * En caso de que esta matrícula pertenezca un vehículo comprobará de qué tipo es.
	 * 
	 * Para cada tipo de vehículo se ha hecho un menú de repacarión diferente.
	 * 
	 * @param matricula
	 */
	public void reparaVehiculo(String matricula) {
		
		boolean existe = false;
		String opcion = "";
		br();		

		for (Vehiculo vehiculo : listaV_Averiados) {
			if (vehiculo.getMatricula().equals(matricula)) { // En caso de que existe y esté averiado
				existe = true;

				System.out.println("Vehículo seleccionado: \n" + vehiculo);
				br();

				if (vehiculo instanceof Motocicleta) { // En caso de ser una Motocicleta
					do {
						System.out.println("Opciones disponibles:\n" 
					            + "1. Acelerar.\n" 
								+ "2. Frenar.\n"
								+ "3. Cambiar escape.\n"
								+ "4. Frenar hasta parar.\n" 
								+ "5. Marcar como reparado.\n"
								+ "6. Detener proceso de reparación sin haber terminado.\n");						
						System.out.print("Opciones: ");
						opcion = sc.nextLine();
						br();

						switch (opcion) {
						case "1":
							double acelera = VarUtils.pedirDouble("Velocidad a acelerar");
							vehiculo.acelerar(acelera);

							break;
						case "2":
							double frena = VarUtils.pedirDouble("Velocidad a frenar");
							vehiculo.frenar(frena);

							break;
						case "3":
							String nuevaMarca = VarUtils.pedirString("Nombre de la nueva marca del escape");
							((Motocicleta) vehiculo).cambiarEscape(nuevaMarca);

							break;
						case "4":
							vehiculo.frenarHastaParar();
							break;
						case "5":
							this.marcarVehiculoReparado(vehiculo);
							System.out.println("El vehículo ha sido reparado.");
							br();
							// No uso break, ya que si ya ha sido reparado, no volvería a reparar
							// Además, obligo que salga del menú
							opcion = "6";
						case "6":
							System.out.println("Sesión de reparación finalizada.");
							break;
						default:
							System.out.println("Opcion no válida.");							
						}
					} while (!opcion.equals("6"));
					
				} else if (vehiculo instanceof Coche) { // En caso de ser un Coche
					do {
						System.out.println("Opciones disponibles:\n"
					      + "1. Acelerar.\n"
						  + "2. Frenar.\n"
						  + "3. Frenar hasta parar.\n"
						  + "4. Subir ventanillas.\n" 
					      + "5. Bajar ventanillas.\n" 
						  + "6. Marcar como reparado.\n"
						  + "7. Detener proceso de reparación sin haber terminado.\n");
						System.out.print("Opción: ");
						opcion = sc.nextLine();
						br();

						switch (opcion) {
						case "1":
							double acelera = VarUtils.pedirDouble("Velocidad a acelerar (km/h)");
							vehiculo.acelerar(acelera);

							break;
						case "2":
							double frena = VarUtils.pedirDouble("Velocidad a frenar (km/h)");
							vehiculo.frenar(frena);

							break;
						case "3":
							vehiculo.frenarHastaParar();
							break;
						case "4":
							((Coche) vehiculo).subirVentanillas();

							break;
						case "5":
							((Coche) vehiculo).bajarVentanillas();

							break;
						case "6":
							this.marcarVehiculoReparado(vehiculo);
							System.out.println("El vehículo ha sido reparado.");
							br();
							// No uso break, ya que si ya ha sido reparado, no volvería a reparar
							// Además, obligo que salga del menú
							opcion = "7";
						case "7":
							System.out.println("Sesión de reparación finalizada.");
							break;
						default:
							System.out.println("Opcion no válida.");
						}
					} while (!opcion.equals("7"));
						
				} else { // En caso de ser un Ciclomotor
					
					do {						
						System.out.println("Opciones disponibles:\n"
								+ "1. Acelerar.\n"
								+ "2. Frenar.\n"
								+ "3. Frenar hasta parar.\n"
								+ "4. Marcar como reparado.\n"
								+ "5. Detener proceso de reparación sin haber terminado.\n");						
						System.out.print("Opciones: ");
						opcion = sc.nextLine();
						br();

						switch (opcion) {
						case "1":
							double acelera = VarUtils.pedirDouble("Velocidad a acelerar");
							vehiculo.acelerar(acelera);

							break;
						case "2":
							double frena = VarUtils.pedirDouble("Velocidad a frenar");
							vehiculo.frenar(frena);

							break;
						case "3":
							vehiculo.frenarHastaParar();
							break;
						case "4":
							this.marcarVehiculoReparado(vehiculo);
							System.out.println("El vehículo ha sido reparado.");
							br();
							// No uso break, ya que si ya ha sido reparado, no volvería a reparar
							// Además, obligo que salga del menú
							opcion = "5";
						case "5":
							System.out.println("Sesión de reparación finalizada.");
							break;
						default:
							System.out.println("Opcion no válida.");	
						}
						
					} while(opcion.equals("5"));
				}

			} // Fin caso existe averiado
		} // Fin listaV_Averiados
		
		for (Vehiculo vehiculoo : listaV_Reparados) {
			if (vehiculoo.getMatricula().equals(matricula)) { // En caso de que exista y esté reparado 
				existe = true;
				System.out.println("Su vehículo ya esta reparado.");
			}
		}
		
		if (!existe) { // En caso de que no exista
			System.out.println("Su vehículo no se encuentra aquí lo sentimos.");
		}
	}

}
