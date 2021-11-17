package interfaz;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FrameInfoLote extends JFrame{
	
	public FrameInfoLote(String informacion) {
		JPanel panel = new JPanel();
		getContentPane();
		JLabel label = new JLabel(informacion);
		Dimension size = label.getPreferredSize();
		label.setBounds(150, 100, size.width, size.height);
		panel.setLayout(null);
		panel.add(label);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(panel);
		setSize(500, 300);
		setVisible(true);
	}
 
}