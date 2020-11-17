package Main;

import Clases.*;
import fundamentos.*;
public class GraficasTiempos {

	public static void main (String[] args) {

		QuickSort<Object> q = new QuickSort<Object>();
		InsertionSort<Object> i = new InsertionSort<Object>();
		final int NUM_ITERACIONES = 500;


		int e = 0;
		int[] numElem = {NUM_ITERACIONES};
		int iteraciones = numElem[e];


		Grafica g = new Grafica ("Tiempos Medios De Ejecución","iteraciones","tiempo");
		g.ponColor(Grafica.azul);
		g.ponTitulo("n²");
		for (int n=1; n<iteraciones;n++) {
			g.inserta(n, Math.pow(n, 2));
		}

		g.otraGrafica();
		g.ponColor(Grafica.rojo);
		g.ponTitulo("n(log(n))");
		for (int n=1; n<iteraciones;n++) {
			g.inserta(n, n* Math.log(n) / Math.log(2));
		}

		g.otraGrafica();
		g.ponColor(Grafica.rosa);
		g.ponTitulo("QuickSort");
		for (int n=1; n<iteraciones;n++) {
			int quickSort = q.tMedSort(n, NUM_ITERACIONES);
			g.inserta(n,quickSort);
		}

		g.otraGrafica();
		g.ponColor(Grafica.negro);
		g.ponTitulo("InsertionSort");
		for (int n=1; n<iteraciones;n++) {
			int insertionSort = i.tMedSort(n, NUM_ITERACIONES);
			g.inserta(n,insertionSort);
		}

		g.pinta();

		System.exit(0);
		}
	}
