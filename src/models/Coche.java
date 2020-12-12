package models;

public class Coche extends Vehiculo {

	private String estadoVentanillas;

	public Coche(String color, String matricula, String marca, String modelo, double velocidadMaxima,
			String telefonoDueño) {
		super(color, matricula, marca, modelo, velocidadMaxima, telefonoDueño);
		this.estadoVentanillas = "Subidas";
	}

	public void subirVentanillas() {
		if (estadoVentanillas == "Subidas") {
			System.out.println("Las ventanillas ya estaban subidas.");
		} else {
			this.estadoVentanillas = "Subidas";
			System.out.println("Se han subido las ventanillas.");
		}
	}

	public void bajarVentanillas() {
		if (estadoVentanillas == "Bajadas") {
			System.out.println("Las ventanillas ya estaban bajadas.");
		} else {
			this.estadoVentanillas = "Bajadas";
			System.out.println("Se han bajado las ventanillas.");
		}
	}

	@Override
	public String toString() {
		return "Coche[Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Ventanillas: "
				+ estadoVentanillas + ", Color: " + color + ", Velocidad Actual: " + velocidadActual + "km/h"
				+ ", Velocidad Máxima: " + velocidadMaxima + "Km/h" + ", Telefono Dueño: " + telefonoDueño + "]";
	}

}
