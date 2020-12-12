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

	}

	public void subMenuInsertarVehiculo() {

	}

	public void subMenuRepararVehiculo() {

	}

	public void subMenuListarVehiculos() {
		String strOpcion = "";
		do {
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
			    System.out.println("Opción no válida.");
				br();
				break;
			}

		} while (strOpcion != "4");

	}

	public void menuEntregarVehiculo() {

	}

	public void cambiarEscape() {
		String mtrMoto;
		String marcaEscape;

		taller.listarMotocicletas();
		System.out.println("\nSeleccione una motocicleta (inserte su matrícula): ");

		do {
			mtrMoto = sc.nextLine();
			if (mtrMoto.isBlank())
				System.out.println("Introduzca una matrícula, por favor.");
		} while (mtrMoto.isBlank());

		do {
			marcaEscape = sc.nextLine();
			if (marcaEscape.isBlank())
				System.out.println("Introduzca una matrícula, por favor.");
		} while (marcaEscape.isBlank());

		taller.cambiarExcape(mtrMoto, marcaEscape);
	}

	// MÉTODOS

	/**
	 * Método que pedira al usuario la matrícula de un Vehículo.
	 * 
	 * @return
	 */
	public String pedirVehiculo() {
		return "";
	}
}
