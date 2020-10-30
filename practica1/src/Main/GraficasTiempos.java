package Main;

import fundamentos.*;
public class GraficasTiempos {

	public static void main (String[] args) {

		Grafica g = new Grafica ("Tiempos Medios De Ejecución","iteraciones","tiempo");
		int n1= 25;
		double x;

		// El primer grafico
		g.ponColor(Grafica.azul);
		g.ponTitulo("Seno");
		for (int i=0; i<=n1; i++) {
			x = i/10.0;
			g.inserta(x,Math.sin(x));
		}

		// El segundo grafico
		g.otraGrafica();
		g.ponColor(Grafica.rojo);
		g.ponTitulo("Coseno");
		for (int i=0; i<=n1; i++) {
			x = i/10.0;
			g.inserta(x,Math.cos(x));
		}
		g.pinta();

		System.exit(0);
	}
}
