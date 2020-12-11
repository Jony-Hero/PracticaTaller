package main;
import models.Vehiculo;
import models.Ciclomotor;
import models.Motocicleta;
public class MainApp {
	public  static  void  main ( String [] args ) { 
		Vehiculo lo = new Ciclomotor("Azul", "AZK123", "LOG", "AZKY", 25, 123, 12345678);
		System.out.println(lo);
		
//		Motocicleta kol = new Motocicleta("azul", "ahwu83h","Amarillo" , "ARC", 12, 250, 123451239, "Full HD");
//		System.out.println(kol);
//		System.out.println(" ");
//		kol.cambiarEscape("ihpfih");
//		System.out.println(kol);
		
	}



}
