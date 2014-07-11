package epk.sam.ebooks.corejava9.v1.ch02;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import javax.swing.*;

/**
 * A program for viewing images.
 * 
 * @version 1.22 2007-05-21
 * @author Cay Horstmann
 */
public class ImageViewer {

	// @SuppressWarnings("unused")
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ImageViewerFrame();
				frame.setTitle("ImageViewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * A frame with a label to show an image.
 */
class ImageViewerFrame extends JFrame {
	/**
	 * 
	 */
	URL url;
	private static final long serialVersionUID = 4400694309412551371L;
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;

	public ImageViewerFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// use a label to display the images
		label = new JLabel();
		add(label);

		// set up the file chooser
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));

		// set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		url = classLoader
				.getResource("epk/sam/ebooks/corejava9/v1/ch02/Cay.gif");
		// поставим ресурс автоматом, далее выбираем вручную
		label.setIcon(new ImageIcon(url));
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// show file chooser dialog
				int result = chooser.showOpenDialog(null);

				// if file selected, set it as icon of the label
				if (result == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
				}
			}
		});

		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}
}
