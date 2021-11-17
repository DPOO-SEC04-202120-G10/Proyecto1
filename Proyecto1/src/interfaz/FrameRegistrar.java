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
import modelo.Pedido;

public class FrameRegistrar implements ActionListener {
	String direction;
	JFrame frame; 
	JPanel panel;
	ControladorCliente  elContC;
	ControladorInventario elContI;
	int idPedido;
	String fecha;
	JButton boton;
	ControladorPedido elContP;
	JTextField cedula;
	Cliente elCliente;
	Pedido pedido;
	
	
	public FrameRegistrar(ControladorCliente  ContC, ControladorInventario contI, int idpedido, String fech,ControladorPedido ContP)
	{elContC=ContC;
	elContI=contI;
	idPedido=idpedido;
	fecha=fech;
	elContP=ContP;
	
		 frame= new JFrame();
		 panel= new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		JLabel instruccionCedula= new JLabel ("Cedula");
		instruccionCedula.setBounds(10,20,80,25);
		panel.add(instruccionCedula);
		cedula= new JTextField(10); 
		cedula.setBounds(100, 20, 165, 25);

		
		panel.add(cedula);
		boton= new JButton ("Enter"); 
		boton.addActionListener(this);
		panel.add(boton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Registrar");
				frame.pack();
				frame.setVisible(true);

	}
	public int getcedula()
	{int cedulaa= Integer.parseInt(direction);
		return cedulaa;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		direction=cedula.getText();
		elCliente= Clienter();
		pedido = elContP.nuevoPedido(idPedido,fecha); 
		new MenuBotones2(pedido,elContP, elCliente, elContI, elContC);
        frame.setVisible(false);
	}
	private Cliente Clienter()
	{
		Cliente elCliente = elContC.buscarCliente(getcedula());
		return elCliente;
	}
	}

