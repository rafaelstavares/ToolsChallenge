package br.com.ToolsChallenge.util;

import java.util.Random;

public class Utilitaria {

	public static Long numeroAleatorio() {
		Long numeroSorteado;
		Random numeroAle = new Random();

		numeroSorteado = (long) numeroAle.nextInt(99999999);
		if (numeroSorteado < 0) {
			numeroSorteado = numeroSorteado * -1;
			return	numeroSorteado = 100000000 +numeroSorteado;
		}else {
			return numeroSorteado = 100000000 +numeroSorteado;
		}

		 
	}

}
