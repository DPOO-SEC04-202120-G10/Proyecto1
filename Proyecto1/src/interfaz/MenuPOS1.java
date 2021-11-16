package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Cliente;

public class MenuPOS1 implements ActionListener{
JFrame frame; 
JPanel panel; 
JButton boton1; 
JButton boton2;

public MenuPOS1() 
{
	frame = new JFrame ();
	panel= new JPanel();
	boton1= new JButton("Ingresar Cliente"); 
	boton1.addActionListener(this);
	boton2 = new JButton("Registrar Cliente"); 
	boton2.addActionListener(this);

	
	
	panel.add(boton1);
	panel.add(boton2);

	

	frame.add(panel, BorderLayout.CENTER);
;		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Opciones");
	frame.pack();
	frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==boton1) {
		new FrameIngresar();
		frame.setVisible(false);
		
		
		
	}
		else if (e.getSource()==boton2) {
			new FrameRegistrar();
			frame.setVisible(false);
		}
}

}