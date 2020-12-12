package views;

import java.util.Scanner;

import models.Ciclomotor;
import models.Coche;
import models.Motocicleta;
import models.Taller;
import utils.VarUtils;

public class Menus {

	private static Scanner sc = new Scanner(System.in);
	private Taller taller;

	public Menus(Taller taller) {
		this.taller = taller;
	}

	public void br() {
		System.out.println();
	}

	

	// MENUS
	public void menuPrincipal() {
		String strOpcion = "";
		do {
			System.out.println(
					"------------- Inicio -------------\n"
			+ "1. A�adir veh�culo averiado.\n" 
		    + "2. Reparar veh�culo.\n"
	    	+ "3. Listar veh�culos.\n" 
		    + "4. Entregar veh�culo.\n" 
	    	+ "5. Terminar la jornada.");
			br();
			System.out.print("Opci�n: ");
			strOpcion = sc.nextLine();
			switch (strOpcion) {
			case "1":
				subMenuInsertarVehiculo();
				break;
			case "2":
				subMenuRepararVehiculo();
				break;
			case "3":
				subMenuListarVehiculos();
				break;
			case "4":
				menuEntregarVehiculo();
				break;
			case "5":
				System.out.print("\n" + "================================\n" + "|     �Hasta la pr�xima!       |\n"
						+ "================================\n");
				break;
		    default:
				System.out.println("Opci�n no valida.");
			}
		} while (!strOpcion.equals("5"));
		
	}

	public void subMenuInsertarVehiculo() {
		System.out.println("�Que tipo de veh�culo es?\n" + "1. Coche.\n" + "2. Motocicleta.\n" + "3. Ciclomotor.");
		String op = "";
		do {
			System.out.print("Opcion: ");
			op = sc.nextLine();
			br();
		} while (!op.equals("1") && !op.equals("2") && !op.equals("3"));
		System.out.println("Introduzca los datos del su veh�culo:");
		String matricula = VarUtils.pedirString("Matr�cula");
		String marca = VarUtils.pedirString("Marca");
		String modelo = VarUtils.pedirString("Modelo");
		String color = VarUtils.pedirString("Color");
		double velocidadMaxima = VarUtils.pedirDouble("Velocidad M�xima");
		String telefonoOwner = VarUtils.pedirString("Telefono del Due�o ");
		if (op.equals("1")) {
			taller.insertarVAveriado(new Coche(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner));
		} else if (op.equals("2")) {
			String marcaEscape = VarUtils.pedirString("Marca de Escape");
			taller.insertarVAveriado(
					new Motocicleta(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner, marcaEscape));
		} else {
			taller.insertarVAveriado(new Ciclomotor(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner));
		}
		br();
	}

	public void subMenuRepararVehiculo() {
		String matricula="";
		taller.listarVAveriados();
		br();
		System.out.print("Por favor escriba su matr�cula: ");
		do {
			matricula = sc.nextLine();
			if (matricula.isBlank())
				System.out.println("No has introducido nada, vuelve a intentarlo.");
		} while (matricula.isBlank());
		taller.reparaVehiculo(matricula);
	}

	public void subMenuListarVehiculos() {
		String strOpcion = "";
		
		
		do {
			System.out.println("Las opciones que tenemos son:\n"
					+ "1. Lista de Veh�culos.\n"
					+ "2. Lista de Veh�culos averiados.\n"
					+ "3. Lista de Veh�culos reparados.\n"
					+ "4. Volver al Menu.");
			br();
			System.out.print("Opci�n elegida:");
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
			case "4":
				break;
			default:
				br();
				System.out.println("Opci�n no v�lida.");
				br();
				break;
			}

		} while (!strOpcion.equals("4"));

	}

	public void menuEntregarVehiculo() {
		
		String matricula = "";
		taller.listarVehiculos();
		br();
		System.out.print("Por favor escriba su matr�cula: ");
		do {
		 matricula = sc.nextLine();
		 if(matricula.isBlank()) 
		   System.out.println("No has introducido nada, vuelve a intentarlo.");
		}while(matricula.isBlank());
		taller.entregarVehiculo(matricula);
	}


	

	
	public void cambiarEscape() {
		String mtrMoto;
		String marcaEscape;

		taller.listarMotocicletas();
		System.out.println("\nSeleccione una motocicleta (inserte su matr�cula): ");

		do {
			mtrMoto = sc.nextLine();
			if (mtrMoto.isBlank())
				if (mtrMoto.isBlank())
					System.out.println("Introduzca una matr�cula, por favor.");
		} while (mtrMoto.isBlank());

		do {
			marcaEscape = sc.nextLine();
			if (marcaEscape.isBlank())
				System.out.println("Introduzca una matr�cula, por favor.");
		} while (marcaEscape.isBlank());

		taller.cambiarExcape(mtrMoto, marcaEscape);
	}

	// M�TODOS

	/**
	 * M�todo que pedira al usuario la matr�cula de un Veh�culo.
	 * 
	 * @return
	 */
	public String pedirVehiculo() {
		return "";
	}
}
