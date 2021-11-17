package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Cliente;
import modelo.ControladorCliente;
import modelo.ControladorInventario;
import modelo.ControladorPedido;
import modelo.Pedido;

public class MenuBotones2 implements ActionListener{
	JFrame frame; 
	JPanel panel; 
	JButton boton1; 
	JButton boton2;
	Pedido pedido;
	ControladorPedido elContP;
	Cliente elCliente;
	ControladorCliente  elContC;
	ControladorInventario elContI;
	int idPedido;
	String fecha;

	public MenuBotones2(Pedido Pedido, ControladorPedido ContP, Cliente Cliente, ControladorInventario ContI, ControladorCliente contC) {
		elContI=ContI;
		pedido= Pedido;
		elContP=ContP;
		elCliente=Cliente;
	frame = new JFrame ();
	panel= new JPanel();
	boton1= new JButton("Ingresar Producto"); 
	boton1.addActionListener(this);
	boton2 = new JButton("Finalizar Compra"); 
	boton2.addActionListener(this);

	frame.setLocationRelativeTo(null);
	
	panel.add(boton1);
	panel.add(boton2);

	

	frame.add(panel, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Opciones");
	frame.pack();
	frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==boton1) {
		new FrameProductoNuevo(pedido,elContP, elCliente, elContI);
		

		
		
		
	}
		else if (e.getSource()==boton2) {
			elCliente.anadirPedido(pedido);
			elContP.anadiraHistorial(pedido);
			new Factura(pedido,elCliente,elContP);
		}
}
}
