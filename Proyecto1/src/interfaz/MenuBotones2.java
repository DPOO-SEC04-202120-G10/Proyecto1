package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuBotones2 implements ActionListener{
	JFrame frame; 
	JPanel panel; 
	JButton boton1; 
	JButton boton2;

	public MenuBotones2() {
	frame = new JFrame ();
	panel= new JPanel();
	boton1= new JButton("Ingresar Prodcuto"); 
	boton1.addActionListener(this);
	boton2 = new JButton("Finalizar Compra"); 
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
		
		
		
	}
		else if (e.getSource()==boton2) {
			new FrameRegistrar();
		}
}
}
