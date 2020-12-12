package tests;

import models.Taller;
import models.Vehiculo;
import utils.RandomGenerator;
import views.Menus;
public class TestTaller {
	public static void main(String[] args) {
		
		Taller taller = new Taller();
		Menus pop = new Menus(taller);
		RandomGenerator rg = new RandomGenerator();
		Vehiculo coche = rg.cocheR();
		taller.insertarVAveriado(coche);
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.ciclomotorR());
		taller.insertarVAveriado(rg.motocicletaR());
		taller.insertarVAveriado(rg.motocicletaR());
		taller.insertarVAveriado(rg.motocicletaR());
		taller.insertarVAveriado(rg.motocicletaR());
		pop.menuEntregarVehiculo();
//		taller.marcarVehiculoReparado(coche);
//		taller.listarVehiculos();
//		taller.listarVReparados();
//		
//		taller.cambiarExcape(taller.getMatriculaMotocicleta(), "PIPO");
//		
//		taller.listarVReparados();
	}
}
