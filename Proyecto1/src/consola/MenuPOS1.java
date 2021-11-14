package consola;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	frame.setTitle("Ventana de Inicio");
	frame.pack();
	frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==boton1) {
		
		
		
	}
		else if (e.getSource()==boton2) {
			new MenuPOS1();
		}
}
}
