package models;
import Interfaces.Arrancable;
import Interfaces.Movible;

public abstract class Vehiculo implements Movible,Arrancable {
	//Son los atributos que debe tener un Vehiculo.
	protected String color; 
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected double velocidadActual;
	protected double velocidadMaxima;
	protected int telefonoDueño;
	//Es el constructor de los atributos de Vehiculo.
	public Vehiculo(String color, String matricula, String marca, String modelo, double velocidadActual,
			double velocidadMaxima, int telefonoDueño) {
		super();
		this.color = color;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadActual = velocidadActual;
		this.velocidadMaxima = velocidadMaxima;
		this.telefonoDueño = telefonoDueño;
	}
// Estos son los setter y getter de los atributos de Vehiculo.
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(double velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public int getTelefonoDueño() {
		return telefonoDueño;
	}

	public void setTelefonoDueño(int telefonoDueño) {
		this.telefonoDueño = telefonoDueño;
	}
	// Estos de aquí son los metodos que implementamos de las interfaces
	@Override
	public void Arrancar() {
		System.out.println("El Vehículo esta arrancado");
	}
	@Override
	public void Parar() {
			System.out.println("El Vehículo esta parado");
		}
	@Override
	public void Acelerar(double v) {
		this.velocidadActual += v;
		System.out.println("La velocidad Actual es de " +velocidadActual);
	}
	
	@Override
	public void Frenar(double v) {
		this.velocidadActual -= v;
		System.out.println("La velocidad Actual es de " +velocidadActual);
	}

}
