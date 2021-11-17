package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameAlerta {
	String direction;
	JFrame frame; 
	JPanel panel;
	public FrameAlerta ()
	{
		 frame= new JFrame();
		 panel= new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		JLabel instruccionId= new JLabel ("Este producto no se encuentra disponible.");
		instruccionId.setBounds(10,20,80,25);
		panel.add(instruccionId);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Alerta");
				frame.pack();
				frame.setVisible(true);

	}

}
