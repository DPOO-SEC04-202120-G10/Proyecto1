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
import modelo.ControladorCliente;
import modelo.ControladorInventario;
import modelo.ControladorPedido;

public class MenuPOS1 implements ActionListener{
JFrame frame; 
JPanel panel; 
JButton boton1; 
JButton boton2;
ControladorCliente  elContC;
ControladorInventario elContI;
int idPedido;
String fecha;
ControladorPedido elContP;
public MenuPOS1(ControladorCliente  ContC, ControladorInventario contI, int idpedido, String fech,ControladorPedido ContP) 
{	elContC=ContC;
	elContI=contI;
	idPedido=idpedido;
	fecha=fech;
	elContP=ContP;

	
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
		new FrameIngresar(elContC,elContI,idPedido, fecha,elContP);
		frame.setVisible(false);
		
		
		
	}
		else if (e.getSource()==boton2) {
			new FrameRegistrar(elContC,elContI,idPedido, fecha,elContP);
			frame.setVisible(false);
		}
}

}