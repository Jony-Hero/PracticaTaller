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
	protected int telefonoDue�o;
	//Es el constructor de los atributos de Vehiculo.
	public Vehiculo(String color, String matricula, String marca, String modelo, 
			double velocidadMaxima, int telefonoDue�o) {
		super();
		this.color = color;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadActual = 0;
		this.velocidadMaxima = velocidadMaxima;
		this.telefonoDue�o = telefonoDue�o;
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

	public int getTelefonoDue�o() {
		return telefonoDue�o;
	}

	public void setTelefonoDue�o(int telefonoDue�o) {
		this.telefonoDue�o = telefonoDue�o;
	}
	// Estos de aqu� son los metodos que implementamos de las interfaces
	@Override
	public void arrancar() {
		System.out.println("El Veh�culo esta arrancado");
	}
	@Override
	public void parar() {
			System.out.println("El Veh�culo esta parado");
		}
	@Override
	public void acelerar(double v) {
		this.velocidadActual += v;
		System.out.println("La velocidad Actual es de " +velocidadActual);
	}
	
	@Override
	public void frenar(double v) {
		this.velocidadActual -= v;
		System.out.println("La velocidad Actual es de " +velocidadActual);
	}
	@Override
	public void frenarHastaParar() {
		this.velocidadActual = 0;
		System.out.println("El veh�culo a frenado hasta pararse ");
	}
}
