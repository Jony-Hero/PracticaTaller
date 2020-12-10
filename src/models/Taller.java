package models;

import java.util.ArrayList;
import java.util.List;

public class Taller {
	ArrayList<Object> listaV;
	List<Object> listaV_Averiados;
	List<Object> listaV_Reparados;
	
	
	public void insertarVAveriado(Object v) {
		if(listaV_Averiados.contains(v))
			System.out.println("El vehículo que se intenta insertar ya existe en la lista.");
		else
			listaV_Averiados.add(v);
	}
	
	public void listarVAveriados() {
		System.out.println(listaV_Averiados);
	}
	
	public void listarVReparados() {
		// TODO añadir el teléfono de los clientes
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
		lista
	}
	
}
