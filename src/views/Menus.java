package views;

import java.util.Scanner;

import models.Ciclomotor;
import models.Coche;
import models.Motocicleta;
import models.Taller;
import utils.RandomGenerator;
import utils.VarUtils;

public class Menus {

	private static Scanner sc = new Scanner(System.in);
	private static RandomGenerator rg = new RandomGenerator();
	private Taller taller;

	public Menus(Taller taller) {
		this.taller = taller;
	}

	public void br() {
		System.out.println();
	}	

	/**
	 * 
	 */
	public void menuPrincipal() {
		String strOpcion = "";
		do {
			System.out.println(
					"------------- Inicio -------------\n"
			+ "1. A�adir veh�culo averiado.\n" 
		    + "2. Reparar veh�culo.\n"
		    + "3. Cambiar escape de motocicleta.\n"
	    	+ "4. Listar veh�culos.\n" 
		    + "5. Entregar veh�culo.\n" 
	    	+ "6. Terminar la jornada.");
			br();
			System.out.print("Opci�n: ");
			strOpcion = sc.nextLine();
			switch (strOpcion) {
			case "1":
				br();
				subMenuInsertarVehiculo();
				br();
				break;
			case "2":
				br();
				subMenuRepararVehiculo();
				br();
				break;
			case "3":
				br();
				subMenuCambiarEscape();
				br();
				break;
			case "4":
				br();
				subMenuListarVehiculos();
				br();
				break;
			case "5":
				br();
				subMenuEntregarVehiculo();
				br();
				break;
			case "6":
				System.out.print("\n"
					+ "================================\n"
					+ "|     �Hasta la pr�xima!       |\n"
					+ "================================\n");
				break;
		    default:
				System.out.println("Opci�n no valida.");
			}
		} while (!strOpcion.equals("6"));
	}

	/**
	 * M�todo que muestra un men� para seleccionar el tipo de veh�culo a insertar
	 * adem�s de obtener sus atributos.
	 * 
	 * Esta informaci�n se la pasar� al taller para que este inserte un veh�culo en
	 * su lista de veh�culos averiados.
	 */
	public void subMenuInsertarVehiculo() {
		
		System.out.println("�Que tipo de veh�culo es?\n"
				+ "1. Coche.\n"
				+ "2. Motocicleta.\n"
				+ "3. Ciclomotor.");
		
		String op = "";
		do {
			
			System.out.print("Opcion: ");
			op = sc.nextLine();
			br();			
			if(!op.equals("1") && !op.equals("2") && !op.equals("3"))
					System.out.println("Opci�n no v�lida.");
			
		} while (!op.equals("1") && !op.equals("2") && !op.equals("3"));
		
		System.out.println("Introduzca los datos del su veh�culo: (Escribir \"auto\" para valores aleatorios)");
		
		String matricula;
		boolean esUnica = false;
		do {
			
			matricula = VarUtils.pedirString("Matr�cula");
			esUnica = taller.mtrIsUnica(matricula);
			
			if(!esUnica)
				System.out.println("La matr�cula introducida ya existe, introduza otra, por favor.");
			
		} while(!esUnica);
		
		if(matricula.contentEquals("auto")) { // Matricula aleatoria
			do {
				matricula = rg.strR_Matricula();
				esUnica = taller.mtrIsUnica(matricula);
			} while(!esUnica);
		}
		
		String marca = VarUtils.pedirString("Marca");
		String modelo = VarUtils.pedirString("Modelo");
		String color = VarUtils.pedirString("Color");
		
		if(color.contentEquals("auto")) // Color aleatorio
			color = rg.strR_Color();
		
		double velocidadMaxima = VarUtils.pedirDouble("Velocidad M�xima (0 para valor aleatorio)");	
		if(velocidadMaxima == 0)
			velocidadMaxima = rg.doubleR_VMax();
		String telefonoOwner = Integer.toString(VarUtils.pedirInt("Telefono del Due�o (0 para valor aleatorio)"));
		
		if(telefonoOwner.contentEquals("0"))
			telefonoOwner = rg.strR_Tlfmovil(); // Tlf aleatorio
		
		if (op.equals("1")) { // Si es un coche
			
			if(marca.contentEquals("auto")) // Marca aleatoria de coche
				marca = rg.strR_MarcaCoche();
			if(modelo.contentEquals("auto")) // Modelo aleatorio de coche
				modelo = rg.strR_CocheModel();
			
			taller.insertarVAveriado(new Coche(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner));
			System.out.println("Veh�culo a�adido: " + taller.getUltimoVehiculoAveriadoInsertado());
			
		} else if (op.equals("2")) { // Si es una motocicleta
			
			if(marca.contentEquals("auto")) // Marca aleatoria de motocicleta
				marca = rg.strR_MarcaMotocicleta();
			if(modelo.contentEquals("auto")) // Modelo aleatorio de motocicleta
				modelo = rg.strR_MotocicletaModel();
			
			String marcaEscape = VarUtils.pedirString("Marca de Escape");
			taller.insertarVAveriado(
					new Motocicleta(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner, marcaEscape));
			System.out.println("Veh�culo a�adido: " + taller.getUltimoVehiculoAveriadoInsertado());
			
		} else { // Si es un ciclomotor
			if(marca.contentEquals("auto")) // Marca aleatoria de ciclomotor
				marca = rg.strR_MarcaCiclomotor();
			if(modelo.contentEquals("auto")) // Modelo aleatorio de ciclomotor
				modelo = rg.strR_CiclomotorModel();
			
			// Se pasa el nuevo veh�culo al taller
			taller.insertarVAveriado(new Ciclomotor(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner));
			System.out.println("Veh�culo a�adido: " + taller.getUltimoVehiculoAveriadoInsertado());
		}
		br();
	}
	
	/**
	 * M�todo que muestra la lista de veh�culos averiados y, posteriormente, pide
	 * una matr�cula.
	 * 
	 * Esta matricula se la pasar� al taller para que empiece el proceso de
	 * reparaci�n del veh�culo.
	 */
	public void subMenuRepararVehiculo() {
		
		String matricula="";

		if(taller.checkVehiculos()) {
			
			taller.listarVAveriados();
			br();
			
			System.out.print("Por favor escriba su matr�cula: ");
			
			do {
				matricula = sc.nextLine(); // Obtiene la matr�cula
				if (matricula.isBlank())
					System.out.println("No has introducido nada, vuelve a intentarlo.");
			} while (matricula.isBlank());
			
			taller.reparaVehiculo(matricula); // Se pasa la matr�cula la taller
		} else
			System.out.println("No hay vehiculos en el taller.");
	}

	/**
	 * M�todo que permite mostrar los veh�culos del taller utilizando
	 * tres m�todos diferentes.
	 *  - Mostrar todos los veh�culos.
	 *  - Mostrar solo los reparados.
	 *  - Mostrar solo los averiados.
	 */
	public void subMenuListarVehiculos() {
		
		String strOpcion = "";
		if(taller.checkVehiculos()) {
			do {
				System.out.println("Las opciones que tenemos son:\n"
						+ "1. Lista de Veh�culos.\n"
						+ "2. Lista de Veh�culos averiados.\n"
						+ "3. Lista de Veh�culos reparados.\n"
						+ "4. Volver al Menu.");
				br();
				
				System.out.print("Opci�n elegida: ");
				strOpcion = sc.nextLine();
				
				switch (strOpcion) {
				case "1":
					br();
					taller.listarVehiculos();
					br();
					break;
				case "2":
					br();
					taller.listarVAveriados();
					br();
					break;
				case "3":
					br();
					taller.listarVReparados();
					br();
					break;
				case "4": // Case necesario para que simplemente contin�e
					break;
				default:
					br();
					System.out.println("Opci�n no v�lida.");
					br();
					break;
				}
			} while (!strOpcion.equals("4"));
		} else
			System.out.println("No hay veh�culos en el taller.");
		
	}

	/**
	 * M�todo que muestra todos los veh�culos del taller y, posteriormente, pide una
	 * matr�cula.
	 * 
	 * Esta matricula se la pasar� al taller para que empiece el proceso de entrega
	 * del veh�culo.
	 */
	public void subMenuEntregarVehiculo() {
		
		String matricula = "";
		if(taller.checkVehiculos()) {
			
			taller.listarVehiculos();
			br();
			
			System.out.print("Por favor escriba su matr�cula: ");
			
			do {
			 matricula = sc.nextLine();
			 if(matricula.isBlank()) 
			   System.out.println("No has introducido nada, vuelve a intentarlo.");
			}while(matricula.isBlank());
			
			taller.entregarVehiculo(matricula);
			
		} else
			System.out.println("No hay veh�culos en el taller.");
	}
	
	/**
	 * M�todo que muestra todas las motocicletas del taller y, posteriormente, pide
	 * una matr�cula y la nueva marca del escape.
	 * 
	 * Esta matricula se la pasar� al taller para que empiece el proceso de cambio
	 * de escape de la motocicleta.
	 */
	public void subMenuCambiarEscape() {

		String mtrMoto;
		String marcaEscape;

		if(taller.checkMotocicletas()) { // Solo si hay motocicletas procede
			
			taller.listarMotocicletas();
			System.out.println("\nSeleccione una motocicleta (inserte su matr�cula): ");
			
			do { // Pide la matr�cula
				mtrMoto = sc.nextLine();
				if (mtrMoto.isBlank())
					if (mtrMoto.isBlank())
						System.out.println("Introduzca una matr�cula, por favor.");
			} while (mtrMoto.isBlank());
			
			do { // Pide la nueva marca de escape
				marcaEscape = sc.nextLine();
				if (marcaEscape.isBlank())
					System.out.println("Introduzca una marca de escape, por favor.");
			} while (marcaEscape.isBlank());
			
			taller.cambiarExcape(mtrMoto, marcaEscape); // Pasa estos datos al taller
			
		} else // Si no hay motocicletas lo notifica
			System.out.println("No hay motocicletas en el taller.");
		
	}
}
