package main;

public class testAdri {
	public static void main(String[] args) {
		String randomColor = "";
		String[] randomColors = new String[21];
		randomColors[0] = "Absenta";
		randomColors[1] = "Alabastro";
		randomColors[2] = "Almendra";
		randomColors[3] = "Amaranto";
		randomColors[4] = "Amarillo"; 
		randomColors[5] = "Verde";
		randomColors[6] = "Negro";
		randomColors[7] = "Naranja";
		randomColors[8] = "Magenta"; 
		randomColors[9] = "Rosa";
		randomColors[10] = "Lima"; 
		randomColors[11] = "Rojo";
		randomColors[12] = "Ámbar";
		randomColors[13] = "Amatista";
		randomColors[14] = "Azul";
		randomColors[15] = "Azul cobalto";
		randomColors[16] = "Azul marino";
		randomColors[17] = "Carmesí";
		randomColors[18] = "Cian";
		randomColors[19] = "Escarlata";
		randomColors[20] = "Esmeralda";
		System.out.println(randomColors.length);
		return randomColor[((int) Math.random()*randomColors.length)];
	}
}
