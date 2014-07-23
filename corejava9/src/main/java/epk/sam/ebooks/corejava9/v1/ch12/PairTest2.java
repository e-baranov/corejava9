package epk.sam.ebooks.corejava9.v1.ch12;

import java.util.*;

/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class PairTest2 {
	public static void main(String[] args) {
		GregorianCalendar[] birthdays = {
				new GregorianCalendar(1906, Calendar.DECEMBER, 9), // G. Hopper
				new GregorianCalendar(1815, Calendar.DECEMBER, 10), // A.
																	// Lovelace
				new GregorianCalendar(1903, Calendar.DECEMBER, 3), // J. von
																	// Neumann
				new GregorianCalendar(1910, Calendar.JUNE, 22), // K. Zuse
		};
		Pair2<GregorianCalendar> mm = ArrayAlg2.minmax(birthdays);
		System.out.println("min = " + mm.getFirst().getTime());
		System.out.println("max = " + mm.getSecond().getTime());
	}
}

class ArrayAlg2 {
	/**
	 * Gets the minimum and maximum of an array of objects of type T.
	 * 
	 * @param a
	 *            an array of objects of type T
	 * @return a pair with the min and max value, or null if a is null or empty
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable> Pair2<T> minmax(T[] a) {
		if (a == null || a.length == 0)
			return null;
		T min = a[0];
		T max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) > 0)
				min = a[i];
			if (max.compareTo(a[i]) < 0)
				max = a[i];
		}
		return new Pair2<>(min, max);
	}
}
