package main;
import models.Ciclomotor;
import models.Motocicleta;
import models.Taller;
import models.Vehiculo;

public class MainApp {
	public  static  void  main ( String [] args ) { 
		Taller taller = new Taller();
		Vehiculo lo = new Ciclomotor("Azul", "AZK123", "LOG", "AZKY", 25, 123, 12345678);
//		System.out.println(lo);
		
		Motocicleta kol = new Motocicleta("azul", "ahwu83h","Amarillo" , "ARC", 12, 250, 123451239, "Full HD");
		Motocicleta kkol = new Motocicleta("rojo", "ahwu83h","Amarillo" , "ARC", 12, 250, 123451239, "Full HD");
		Motocicleta kkoll = new Motocicleta("amarillo", "ahwu83h","Amarillo" , "ARC", 12, 250, 123451239, "Full HD");
		taller.insertarVAveriado(kol);
		taller.insertarVAveriado(kkol);
		
		taller.insertarVAveriado(lo);
		taller.listaV_Reparados.add(kkoll);
//		System.out.println(kol);
//		System.out.println(" ");
//		kol.cambiarEscape("ihpfih");
//		System.out.println(kol);
		
		taller.listarMotocicletas();
		
//		taller.cambiarExcape("ahwu83h","ABCDE");
//		
//		taller.listarVReparados();
//		taller.listarVAveriados();
		
	}


}
