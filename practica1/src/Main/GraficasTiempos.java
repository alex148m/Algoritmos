package Main;

import Clases.*;
import fundamentos.*;
public class GraficasTiempos {

	public static void main (String[] args) {

		QuickSort<Object> q = new QuickSort<Object>();
		InsertionSort<Object> i = new InsertionSort<Object>();


		int e = 0;
		int[] numElem = {500};
		int iteraciones = numElem[e];


		Grafica g = new Grafica ("Tiempos Medios De Ejecuci�n","iteraciones","tiempo");
		g.ponColor(Grafica.azul);
		g.ponTitulo("n�");
		for (int n=0; n<iteraciones;n++) {
			g.inserta(n, Math.pow(n, 2));
		}

		g.otraGrafica();
		g.ponColor(Grafica.rojo);
		g.ponTitulo("n(log(n))");
		for (int n=0; n<iteraciones;n++) {
			g.inserta(n, n* Math.log(n) / Math.log(2));
		}

		g.otraGrafica();
		g.ponColor(Grafica.rosa);
		g.ponTitulo("QuickSort");
		for (int n=0; n<iteraciones;n++) {
			int quickSort = q.tMedSort(iteraciones, 500);
			g.inserta(n,quickSort);
		}

		g.otraGrafica();
		g.ponColor(Grafica.negro);
		g.ponTitulo("InsertionSort");
		for (int n=0; n<iteraciones;n++) {
			int insertionSort = i.tMedSort(iteraciones, 500);
			g.inserta(n,insertionSort);
		}

		g.pinta();

		System.exit(0);
		}
	}
