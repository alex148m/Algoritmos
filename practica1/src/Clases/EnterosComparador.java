package Clases;

/**
 * Implementa la comparacion entre enteros a traves de la interfaz Comparator
 */
import java.util.*;
public class EnterosComparador implements Comparator<Integer>
{
	public int compare(Integer n, Integer m)
	{
		if(n < m) {
			return 1;
		}else if(n > m) {
			return -1;
		}else{
			return 0;
		}
	}
}
