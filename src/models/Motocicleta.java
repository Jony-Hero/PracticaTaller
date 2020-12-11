package models;

public class Motocicleta extends Vehiculo {

	private String marcaEscape;

	public Motocicleta(String color, String matricula, String marca, String modelo, double velocidadMaxima,
			String telefonoDueño, String marcaEscape) {
		super(color, matricula, marca, modelo, velocidadMaxima, telefonoDueño);
		this.marcaEscape = marcaEscape;
	}

	public String getMarcaEscape() {
		return marcaEscape;
	}

	public void cambiarEscape(String nuevaMarca) {
		marcaEscape = nuevaMarca;
	}

	@Override
	public String toString() {
		return "Motocicleta[Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Marca Escape: "
				+ marcaEscape + ", Color: " + color + ", Velocidad Actual: " + velocidadActual + "km/h"
				+ ", Velocidad Máxima: " + velocidadMaxima + "Km/h" + ", Telefono Dueño: " + telefonoDueño + "]";
	}

//	@Override
//	public String toString() {
//		return "====== Motocicleta ======\nMatricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nMarca Escape: " + marcaEscape + "\nColor: " + color + "\nVelocidad Actual: " + velocidadActual
//				+ "km/h" + "\nVelocidad Máxima: " + velocidadMaxima + "Km/h" + "\nTelefono Dueño: " + telefonoDueño;
//	}
}
