package models;

public class Motocicleta extends Vehiculo{
	
	public String marcaEscape;
	

	public Motocicleta(String color, String matricula, String marca, String modelo, double velocidadActual,
			double velocidadMaxima, int telefonoDue�o, String marcaEscape) {
		super(color, matricula, marca, modelo, velocidadMaxima, telefonoDue�o);
		this.marcaEscape = marcaEscape;
	}


	public String getMarcaEscape() {
		return marcaEscape;
	}


	public void setMarcaEscape(String marcaEscape) {
		this.marcaEscape = marcaEscape;
	}
	
	public void cambiarEscape(String nuevaMarca){
	         marcaEscape = nuevaMarca;
}

	@Override
	public String toString() {
		return "Motocicleta [marcaEscape=" + marcaEscape + ", color=" + color + ", matricula=" + matricula + ", marca="
				+ marca + ", modelo=" + modelo + ", velocidadActual=" + velocidadActual + ", velocidadMaxima="
				+ velocidadMaxima + ", telefonoDue�o=" + telefonoDue�o + "]";
	}


	
	

}
