package models;

public class Ciclomotor extends Vehiculo{
	
	public Ciclomotor(String color, String matricula, String marca, String modelo, double velocidadActual,
			double velocidadMaxima, int telefonoDueño) {
		super(color, matricula, marca, modelo, velocidadActual, velocidadMaxima, telefonoDueño);
		
	}
	

	@Override
	public String toString() {
		return "Ciclomotor [color=" + color + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", velocidadActual=" + velocidadActual+ "Km/h" + ", velocidadMaxima=" + velocidadMaxima+ "Km/h" + ", telefonoDueño="
				+ telefonoDueño + "]";
	}
	
	

}
