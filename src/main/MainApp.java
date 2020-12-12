package main;

import models.Taller;
import views.Menus;

public class MainApp {
	public static void main(String[] args) {
		
		Taller taller = new Taller();
		Menus menu = new Menus(taller);
		
		System.out.println(
				  "==================================\n"
				+ "|    ¡BIENVENIDO A ReparaTox!    |\n"
				+ "==================================\n");
		
		menu.menuPrincipal();
		
	}

}
