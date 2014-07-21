package epk.sam.ebooks.corejava9.v1.ch09;

import javax.swing.*;

/**
 * A frame with a color chooser panel
 */
public class ColorChooserFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7954700957009046687L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public ColorChooserFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// add color chooser panel to frame

		ColorChooserPanel panel = new ColorChooserPanel();
		add(panel);
	}
}