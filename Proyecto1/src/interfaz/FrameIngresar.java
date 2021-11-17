package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class FrameIngresar implements ActionListener {
	String direction;
	String edadd; 
	String sexoo;
	String eCivil;
	String slab;
	JFrame frame; 
	JPanel panel;
	JButton boton; 
	JTextField cedula;
	JTextField edad;
	JTextField sexo;
	JTextField estadoCivil;
	JTextField situacionLab;
	ControladorCliente  elContC;
	ControladorInventario elContI;
	int idPedido;
	String fecha;
	ControladorPedido elContP;
	Cliente elCliente;
	Pedido pedido;
		public  FrameIngresar(ControladorCliente  ContC, ControladorInventario contI, int idpedido, String fech,ControladorPedido ContP)
		{
			elContC=ContC;
			elContI=contI;
			idPedido=idpedido;
			fecha=fech;
			elContP=ContP;
			 frame= new JFrame();
			frame.setLocationRelativeTo(null);
			 panel= new JPanel();
			frame.add(panel, BorderLayout.CENTER);
			frame.setLayout(new GridLayout());
			GridBagConstraints c= new GridBagConstraints();
			JLabel instruccionCedula= new JLabel ("Cedula");
			instruccionCedula.setBounds(10,20,80,25);
			c.gridy=0;
			c.gridx=0;
			panel.add(instruccionCedula,c);
			cedula= new JTextField(10); 
			cedula.setBounds(100, 20, 165, 25);
			c.gridx=1;
			c.gridy=0;
			panel.add(cedula,c);
			
			JLabel instruccionEdad= new JLabel ("edad");
			instruccionEdad.setBounds(10,20,80,25);
			c.gridy=1;
			c.gridx=0;
			panel.add(instruccionEdad,c);
			edad= new JTextField(10); 
			c.gridx=1;
			c.gridy=1;
			edad.setBounds(100, 20, 165, 25);
			panel.add(edad,c);
			
			JLabel instruccionsexo= new JLabel ("Sexo");
			instruccionsexo.setBounds(10,20,80,25);
			c.gridy=2;
			c.gridx=0;
			panel.add(instruccionsexo,c);
			sexo= new JTextField(10); 
			c.gridx=1;
			c.gridy=2;
			sexo.setBounds(100, 20, 165, 25);
			panel.add(sexo,c);
		
			
			JLabel instruccioneCivil= new JLabel ("Estado civil");
			instruccioneCivil.setBounds(10,20,80,25);
			c.gridy=3;
			c.gridx=0;
			panel.add(instruccioneCivil,c);
			estadoCivil= new JTextField(10); 
			c.gridx=1;
			c.gridy=3;
			estadoCivil.setBounds(100, 20, 165, 25);
			panel.add(estadoCivil,c);
			
			JLabel instruccionsLab= new JLabel ("situacion laboral");
			instruccionsLab.setBounds(10,20,80,25);
			c.gridy=4;
			c.gridx=0;
			panel.add(instruccionsLab,c);
			situacionLab= new JTextField(10); 
			c.gridx=1;
			c.gridy=4;
			situacionLab.setBounds(100, 20, 165, 25);
			panel.add(situacionLab,c);
			boton= new JButton ("Enter"); 
			boton.addActionListener(this);
			panel.add(boton);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setTitle("Ingresar");
					frame.pack();
					frame.setVisible(true);

		}
		private int getcedula()
		{
			int cedulaa= Integer.parseInt(direction);
			return cedulaa;
		}
		
		private Cliente newClienter(int edad,String estadoCivil,String sexo,String situacionLaboral)
		{
			elContC.registrarNuevoCliente(getcedula(),edad,estadoCivil,sexo,situacionLaboral);
			Cliente elCliente = elContC.buscarCliente(getcedula());
			return elCliente;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			direction=cedula.getText();
			edadd=edad.getText();
			int eddad=Integer.parseInt(edadd);
			sexoo=sexo.getText();
			slab=situacionLab.getText();
			eCivil=estadoCivil.getText();
	        System.out.println(direction);
	        System.out.println("Si logro");
	        elCliente= newClienter(eddad,eCivil,sexoo,slab);
	        Pedido pedido = elContP.nuevoPedido(idPedido,fecha); 
	        new MenuBotones2(pedido,elContP, elCliente, elContI, elContC);
	        frame.setVisible(false);
	        
	        
	        
		}
}
