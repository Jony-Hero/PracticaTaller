package utils;

import java.util.Scanner;

public class VarUtils {
	private static Scanner sc = new Scanner (System.in);
	
	public static int pedirInt(String titulo) {
		String aux = "";
		boolean esDouble = false;
		int num = 0;
		do {
			System.out.print(titulo + ": ");
			aux = sc.nextLine();
			try {
				num = Integer.parseInt(aux);
				esDouble = true;
			} catch (Exception e) {
				System.out.println("Debes introducir un valor numérico.");
			}
		} while (!esDouble);

		return num;
	}
	
	public static String pedirString(String titulo) {
		String aux = "";
		do {
			System.out.print(titulo + ": ");
			aux = sc.nextLine();
			if(aux.isBlank())
				System.out.println("No has introducido nada, vuelve a intentarlo.");
		} while (aux.isBlank());

		return aux;
	}
	
	public static Double pedirDouble(String titulo) {
		String aux = "";
		boolean esDouble = false;
		double num = 0;
		do {
			System.out.print(titulo + ": ");
			aux = sc.nextLine();
			try {
				num = Double.parseDouble(aux);
				esDouble = true;
			} catch (Exception e) {
				System.out.println("Debes introducir un valor numérico.");
			}
		} while (!esDouble);

		return num;
	}

}
