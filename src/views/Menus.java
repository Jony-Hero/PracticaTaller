package views;

import java.util.Scanner;

import models.Taller;

public class Menus {
	
	private static Scanner sc = new Scanner(System.in);
	private Taller taller;
	
	public Menus(Taller taller) {
		this.taller = taller;
	}
	
	// MENUS
	public void menuPrincipal() {
		String strOpcion = "";
		do {
			System.out.println("------------- Inicio -------------\n"
					+ "1. Añadir vehículo averiado.\n"
					+ "2. Reparar vehículo.\n"
					+ "3. Listar vehículos.\n"
					+ "4. Entregar vehículo.\n"
					+ "5. Terminar la jornada.");
			
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
				System.out.print("\n" 
						+ "================================\n"
						+ "|     ¡Hasta la próxima!       |\n"
						+ "================================\n");
			}
		} while (strOpcion != "5");
		
	}
	
	public void subMenuInsertarVehiculo() {
		
	}
	
	public void subMenuRepararVehiculo() {
		
	}
	
	public void subMenuListarVehiculos() {
		
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
			if(mtrMoto.isBlank())
				System.out.println("Introduzca una matrícula, por favor.");
		} while(mtrMoto.isBlank());
		
		do {
			marcaEscape = sc.nextLine();
			if(marcaEscape.isBlank())
				System.out.println("Introduzca una matrícula, por favor.");
		} while(marcaEscape.isBlank());
		
		taller.cambiarExcape(mtrMoto, marcaEscape);
	}
	
	// MÉTODOS
	
	/**
	 * Método que pedira al usuario la matrícula de un Vehículo.
	 * @return
	 */
	public String pedirVehiculo() {
		return "";
	}
}
