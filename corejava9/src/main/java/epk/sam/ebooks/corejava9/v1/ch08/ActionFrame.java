package epk.sam.ebooks.corejava9.v1.ch08;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * A frame with a panel that demonstrates color change actions.
 */
public class ActionFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 421487609418715750L;
private JPanel buttonPanel;
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   public ActionFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      buttonPanel = new JPanel();

      // define actions
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		java.net.URL url = classLoader.getResource("epk/sam/ebooks/corejava9/v1/ch08/yellow-ball.gif");
      
      Action yellowAction = new ColorAction("Yellow", new ImageIcon(url), Color.YELLOW);
      url = classLoader.getResource("epk/sam/ebooks/corejava9/v1/ch08/blue-ball.gif");
      Action blueAction = new ColorAction("Blue", new ImageIcon(url), Color.BLUE);
      url = classLoader.getResource("epk/sam/ebooks/corejava9/v1/ch08/red-ball.gif");
      Action redAction = new ColorAction("Red", new ImageIcon(url), Color.RED);

      // add buttons for these actions
      buttonPanel.add(new JButton(yellowAction));
      buttonPanel.add(new JButton(blueAction));
      buttonPanel.add(new JButton(redAction));

      // add panel to frame
      add(buttonPanel);

      // associate the Y, B, and R keys with names
      InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
      imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
      imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
      imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

      // associate the names with actions
      ActionMap amap = buttonPanel.getActionMap();
      amap.put("panel.yellow", yellowAction);
      amap.put("panel.blue", blueAction);
      amap.put("panel.red", redAction);
   }
   
public class ColorAction extends AbstractAction
   {
      /**
	 * 
	 */
	private static final long serialVersionUID = 935226159660200459L;

	/**
       * Constructs a color action.
       * @param name the name to show on the button
       * @param icon the icon to display on the button
       * @param c the background color
       */
      public ColorAction(String name, Icon icon, Color c)
      {
         putValue(Action.NAME, name);
         putValue(Action.SMALL_ICON, icon);
         putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
         putValue("color", c);
      }

      public void actionPerformed(ActionEvent event)
      {
         Color c = (Color) getValue("color");
         buttonPanel.setBackground(c);
      }
   }
}
