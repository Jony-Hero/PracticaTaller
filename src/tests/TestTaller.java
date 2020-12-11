package tests;

import models.Taller;
import utils.RandomGenerator;

public class TestTaller {
	public static void main(String[] args) {
		
		Taller taller = new Taller();
		RandomGenerator rg = new RandomGenerator();
		
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.motocicletaR());
		taller.insertarVAveriado(rg.motocicletaR());
		taller.insertarVAveriado(rg.motocicletaR());
		taller.insertarVAveriado(rg.motocicletaR());
		
		taller.listarVReparados();
		
		taller.cambiarExcape(taller.getMatriculaMotocicleta(), "PIPO");
		
		taller.listarVReparados();
	}
}
