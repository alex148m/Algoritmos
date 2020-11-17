/*
 * @AUTHOR: ALEJANDRO MARTÍNEZ FLORANES
 * @DATE: 17/11/2020
 * @Práctica 2: Torres de Hanoi, Analisis de eficiencia
 * */

package practica2;

public class Hanoi {
	
	//Variabel global que cuenta el numero de movimientos
	int movimientos=0;
	
	//Constructor Hanoi
	public Hanoi() {}

	//Método Torres de Hanoi Recursivo
	public int Hanoi(int n, int origen,  int auxiliar, int destino){
		if(n==1) {
			System.out.println("mover disco de " + origen + " a " + destino);
		}else{
			movimientos++;
			Hanoi(n-1, origen, destino, auxiliar);
			System.out.println("mover disco de "+ origen + " a " + destino);
			Hanoi(n-1, auxiliar, origen, destino);
		}
		return movimientos;
	}
}