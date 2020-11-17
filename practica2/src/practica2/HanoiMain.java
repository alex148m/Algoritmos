/*
 * @AUTHOR: ALEJANDRO MARTÍNEZ FLORANES
 * @DATE: 17/11/2020
 * @Práctica 2: Torres de Hanoi, Analisis de eficiencia
 * */

package practica2;

import java.util.Scanner;

public class HanoiMain {

	static Hanoi h = new Hanoi();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Numero de discos: ");
		n = sc.nextInt();
		h.Hanoi(n,1,2,3);  //1:origen  2:auxiliar 3:destino
		sc.close();
	}
}
