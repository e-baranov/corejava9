package epk.sam.ebooks.corejava9.v1.ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A sample modal dialog that displays a message and waits for the user to click
 * the OK button.
 */
public class AboutDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4922371582359092087L;

	public AboutDialog(JFrame owner) {
		super(owner, "About DialogTest", true);

		// add HTML label to center

		add(new JLabel(
				"<html><h1><i>Core Java</i></h1><hr>By Cay Horstmann and Gary Cornell</html>"),
				BorderLayout.CENTER);

		// OK button closes the dialog

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});

		// add OK button to southern border

		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);

		pack();
	}
}
