/*
 * @AUTHOR: ALEJANDRO MARTÍNEZ FLORANES
 * @DATE: 17/11/2020
 * @Práctica 2: Torres de Hanoi, Analisis de eficiencia
 * */

package practica2;
import fundamentos.*;

public class GráficaHanoi {

	public static void main(String[] args) {

		final int NUM_ITERACIONES = 20;
		Hanoi h = new Hanoi();
		
		
		int e = 0;
		int[] numElem = {NUM_ITERACIONES};
		int iteraciones = numElem[e];


		Grafica g = new Grafica ("Tiempos Medios De Ejecución","iteraciones","tiempo");
		g.ponColor(Grafica.azul);
		g.ponTitulo("2^n - 1");
		for (int n=1; n<iteraciones;n++) {
			g.inserta(n, Math.pow(2,n) - 1);
		}
		
		g.otraGrafica();
		g.ponColor(Grafica.rojo);
		g.ponTitulo("Hanoi");
		for (int n=1; n<iteraciones;n++) {
			g.inserta(n, h.Hanoi(n, 1, 2, 3));
		}
		
		g.pinta();

		System.exit(0);
	}

}
