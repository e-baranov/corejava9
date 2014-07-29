package epk.sam.ebooks.corejava9.v2.ch10;

import javax.swing.*;

/**
 * @version 1.00 2007-11-02
 * @author Cay Horstmann
 */
public abstract class ButtonFrame2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7621987965929526656L;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	protected JPanel panel;
	protected JButton yellowButton;
	protected JButton blueButton;
	protected JButton redButton;

	protected abstract void addEventHandlers();

	public ButtonFrame2() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		panel = new JPanel();
		add(panel);

		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");

		panel.add(yellowButton);
		panel.add(blueButton);
		panel.add(redButton);

		addEventHandlers();
	}
}
