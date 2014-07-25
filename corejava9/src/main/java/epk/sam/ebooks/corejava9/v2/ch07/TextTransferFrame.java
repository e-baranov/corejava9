package epk.sam.ebooks.corejava9.v2.ch07;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * This frame has a text area and buttons for copying and pasting text.
 */
public class TextTransferFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4558687087356443727L;
	private JTextArea textArea;
	private static final int TEXT_ROWS = 20;
	private static final int TEXT_COLUMNS = 60;

	public TextTransferFrame() {
		textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		JPanel panel = new JPanel();

		JButton copyButton = new JButton("Copy");
		panel.add(copyButton);
		copyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				copy();
			}
		});

		JButton pasteButton = new JButton("Paste");
		panel.add(pasteButton);
		pasteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				paste();
			}
		});

		add(panel, BorderLayout.SOUTH);
		pack();
	}

	/**
	 * Copies the selected text to the system clipboard.
	 */
	private void copy() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String text = textArea.getSelectedText();
		if (text == null)
			text = textArea.getText();
		StringSelection selection = new StringSelection(text);
		clipboard.setContents(selection, null);
	}

	/**
	 * Pastes the text from the system clipboard into the text area.
	 */
	private void paste() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		DataFlavor flavor = DataFlavor.stringFlavor;
		if (clipboard.isDataFlavorAvailable(flavor)) {
			try {
				String text = (String) clipboard.getData(flavor);
				textArea.replaceSelection(text);
			} catch (UnsupportedFlavorException e) {
				JOptionPane.showMessageDialog(this, e);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e);
			}
		}
	}
}
