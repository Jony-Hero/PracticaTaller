package views;

import java.util.Scanner;

import models.Taller;

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
					"------------- Inicio -------------\n" + "1. A�adir veh�culo averiado.\n" + "2. Reparar veh�culo.\n"
							+ "3. Listar veh�culos.\n" + "4. Entregar veh�culo.\n" + "5. Terminar la jornada.");

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
			}
		} while (strOpcion != "5");

	}

	public void subMenuInsertarVehiculo() {

	}

	public void subMenuRepararVehiculo() {

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
			System.out.println("Opci�n elegida:");
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
