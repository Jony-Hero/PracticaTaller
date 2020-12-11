package models;

import java.util.ArrayList;
import java.util.List;

public class Taller {
	
	
	private ArrayList<Vehiculo> listaV_Averiados;
	public ArrayList<Vehiculo> listaV_Reparados;
	
	public Taller(){
		listaV_Averiados = new ArrayList<Vehiculo>();
		listaV_Reparados = new ArrayList<Vehiculo>();
	};
	
	public void insertarVAveriado(Vehiculo v) {
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
		System.out.println("Vehículos reparados :" );
	}
	
	public void listarMotocicletas() {
		int cont = 1;
		
		System.out.println("Motocicletas averiadas:");
		for (Vehiculo moto : listaV_Averiados) {
			if(moto instanceof Motocicleta)
				
				System.out.println(cont++ + ". " + moto);
		}
		
		System.out.println("\nMotocicletas reparadas:");
		for (Vehiculo moto : listaV_Reparados) {
			if(moto instanceof Motocicleta)
				System.out.println(cont++ + ". " + moto);
		}
	}

	/**
	 * Lo primero que hace sera recorrer un sublista de vehiculos averiados ,luego
	 * comprobara quien tiene la misma matricula que la ingresada en el metodo ,se
	 * continuara diciendo que moto es una Motocicleta y luego se aplica el metodo
	 * de cambiar escape por el nuevo ingresado .
	 * 
	 * @param matricula
	 * @param nuevaEsc
	 */
	public void cambiarExcape(String matricula, String nuevaEsc) {
		boolean existe = false;
		for (Vehiculo moto : listaV_Averiados) {
			if (moto.matricula == matricula) {
				existe = true;
				if (moto instanceof Motocicleta) {
					((Motocicleta) moto).cambiarEscape(nuevaEsc);
					
					listaV_Reparados.add(moto);
					listaV_Averiados.remove(moto);

				} else {
					System.out.println("El vehículo seleccionado, no es una Motocicleta.");
				}
			} 
			
		}
		if(!existe) {
			System.out.println("El vehiculo elegido no existe.");
		}
	}
	
	
	
	
	

}
	

