package epk.sam.ebooks.corejava9.v2.ch06;

import javax.swing.*;

/**
 * A model that dynamically generates n-letter words.
 */
public class WordListModel extends AbstractListModel<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8070712171925065286L;
	private int length;
	public static final char FIRST = 'a';
	public static final char LAST = 'z';

	/**
	 * Constructs the model.
	 * 
	 * @param n
	 *            the word length
	 */
	public WordListModel(int n) {
		length = n;
	}

	public int getSize() {
		return (int) Math.pow(LAST - FIRST + 1, length);
	}

	public String getElementAt(int n) {
		StringBuilder r = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char c = (char) (FIRST + n % (LAST - FIRST + 1));
			r.insert(0, c);
			n = n / (LAST - FIRST + 1);
		}
		return r.toString();
	}
}
