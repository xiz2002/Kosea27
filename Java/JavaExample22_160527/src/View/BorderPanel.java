package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;

//외곽선이 있는 패널
public class BorderPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public BorderPanel() {
	}
	public BorderPanel(int width, int height) {
		setSize(width, height);
	}
//	private static final Insets insets = new Insets(1,1,1,1);
//	public Insets getInsets() {return insets;}
	@Override
	public void paint(Graphics g) {
		Dimension size = getSize();
		// g.setColor(getBackground());
		g.setColor(Color.red);
		g.drawRect(0, 0, size.width - 1, size.height - 1);
//		g.draw3DRect( 5,5,size.width-6, size.height-6, true);
//		g.draw3DRect( 0,0,size.width-1, size.height-1, true);
	}
}