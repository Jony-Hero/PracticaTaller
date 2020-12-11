package models;

public class Ciclomotor extends Vehiculo{
	
	public Ciclomotor(String color, String matricula, String marca, String modelo, double velocidadActual,
			double velocidadMaxima, int telefonoDue�o) {
		super(color, matricula, marca, modelo, velocidadActual, velocidadMaxima, telefonoDue�o);
		
	}
	

	@Override
	public String toString() {
		return "Ciclomotor [color=" + color + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", velocidadActual=" + velocidadActual+ "Km/h" + ", velocidadMaxima=" + velocidadMaxima+ "Km/h" + ", telefonoDue�o="
				+ telefonoDue�o + "]";
	}
	
	

}
