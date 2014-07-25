package epk.sam.ebooks.corejava9.v2.ch06;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * This renderer renders a color value as a panel with the given color.
 */
public class ColorTableCellRenderer extends JPanel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6547736595377164017L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setBackground((Color) value);
		if (hasFocus)
			setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		else
			setBorder(null);
		return this;
	}
}