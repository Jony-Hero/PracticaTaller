package models;

public class Ciclomotor extends Vehiculo {

	public Ciclomotor(String color, String matricula, String marca, String modelo, double velocidadMaxima,
			String telefonoDueño) {
		super(color, matricula, marca, modelo, velocidadMaxima, telefonoDueño);

	}

	@Override
	public String toString() {
		return "Ciclomotor[Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color
				+ ", Velocidad Actual: " + velocidadActual + "km/h" + ", Velocidad Máxima: " + velocidadMaxima + "Km/h"
				+ ", Telefono Dueño: " + telefonoDueño + "]";
	}

//	@Override
//	public String toString() {
//		return "====== Ciclomotor ======\nMatricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nColor: " + color + "\nVelocidad Actual: " + velocidadActual
//				+ "km/h" + "\nVelocidad Máxima: " + velocidadMaxima + "Km/h" + "\nTelefono Dueño: " + telefonoDueño;
//	}
}
