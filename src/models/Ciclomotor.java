package models;

public class Ciclomotor extends Vehiculo {

	public Ciclomotor(String color, String matricula, String marca, String modelo, double velocidadMaxima,
			String telefonoOwner) {
		super(color, matricula, marca, modelo, velocidadMaxima, telefonoOwner);

	}

	@Override
	public String toString() {
		return "Ciclomotor[Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color
				+ ", Velocidad Actual: " + velocidadActual + "km/h" + ", Velocidad M�xima: " + velocidadMaxima + "Km/h"
				+ ", Telefono Due�o: " + telefonoOwner + "]";
	}

//	@Override
//	public String toString() {
//		return "====== Ciclomotor ======\nMatricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nColor: " + color + "\nVelocidad Actual: " + velocidadActual
//				+ "km/h" + "\nVelocidad M�xima: " + velocidadMaxima + "Km/h" + "\nTelefono Due�o: " + telefonoDue�o;
//	}
}
