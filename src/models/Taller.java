package models;

import java.util.ArrayList;
import java.util.List;

public class Taller {
	
	private ArrayList<Vehiculo> listaV;
	private List<Vehiculo> listaV_Averiados;
	private List<Vehiculo> listaV_Reparados;	
	
	public void insertarVAveriado(Vehiculo v) {
		if(listaV_Averiados.contains(v))
			System.out.println("El veh�culo que se intenta insertar ya existe en la lista.");
		else
			listaV_Averiados.add(v);
	}
	
	public void listarVAveriados() {
		System.out.println(listaV_Averiados);
	}
	
	public void listarVReparados() {
		// TODO a�adir el tel�fono de los clientes
		System.out.println(listaV_Reparados);
	}
	
	public void listarMotocicletas() {	
		System.out.println("Motocicletas averiadas:");
		for (Object object : listaV_Averiados) {
			if(object instanceof Object)
				System.out.println(object);
		}
		
		System.out.println("\nMotocicletas reparadas:");
		for (Object object : listaV_Reparados) {
			if(object instanceof Object)
				System.out.println(object);
		}
	}
	
	public void cambiarExcape(String matricula, String nueva) {
<<<<<<< HEAD
		for (Object object : listaV_Averiados) {
			if(object == matricula) {
				
			}
			
		}
=======
		// TODO Usar el m�todo cambiar escape de motocicleta
		listarMotocicletas();
>>>>>>> 93880ebe85ffb88a9d161b6ff7d113d4c113ebdb
	}
	
}
