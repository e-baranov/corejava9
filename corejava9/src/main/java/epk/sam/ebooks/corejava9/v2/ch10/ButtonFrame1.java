package epk.sam.ebooks.corejava9.v2.ch10;

import javax.swing.*;

public class ButtonFrame1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2819373778451144430L;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	private JPanel panel;
	private JButton yellowButton;
	private JButton blueButton;
	private JButton redButton;

	public ButtonFrame1() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		panel = new JPanel();
		panel.setName("panel");
		add(panel);

		yellowButton = new JButton("Yellow");
		yellowButton.setName("yellowButton");
		blueButton = new JButton("Blue");
		blueButton.setName("blueButton");
		redButton = new JButton("Red");
		redButton.setName("redButton");

		panel.add(yellowButton);
		panel.add(blueButton);
		panel.add(redButton);
	}
}
