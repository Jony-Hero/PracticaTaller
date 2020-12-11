package tests;

import utils.RandomGenerator;

public class TestUtils {
	public static void main(String[] args) {

		testRandomGenerator();
	}

	public static void testRandomGenerator() {
		RandomGenerator rg = new RandomGenerator();

		for (int i = 0; i < 15; i++) {
			System.out.println(rg.strR_Color());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++) {
			System.out.println(rg.strR_CiclomotorModel());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++) {
			System.out.println(rg.strR_CocheModel());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++) {
			System.out.println(rg.strR_MarcaEscape());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++) {
			System.out.println(rg.strR_Matricula());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++) {
			System.out.println(rg.strR_MotocicletaModel());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++ ) {
			System.out.println(rg.strR_Tlfmovil());
		} System.out.println("\n");
		for (int i = 0; i < 15; i++) {
			System.out.println(rg.doubleR_VMax());
		} System.out.println("\n");
	}
}
