package views;

import java.util.Scanner;

import models.Taller;

public class Menus {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void cambiarEscape(Taller taller) {
		
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
}
