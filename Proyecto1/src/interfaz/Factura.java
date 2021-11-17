package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Pedido;

public class Factura {
		JFrame frame; 
		JPanel panel;
		String factura;
		Pedido pedido;
		public Factura (Pedido Pedidoo)
		{pedido=Pedidoo;
		
		frame= new JFrame();
			panel= new JPanel();
			 factura="Hola";
			frame.add(panel, BorderLayout.CENTER);
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c= new GridBagConstraints();
			JLabel instruccionId= new JLabel (factura);
			instruccionId.setBounds(10,20,80,25);
			panel.add(instruccionId);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setTitle("Factura de Compra");
					frame.pack();
					frame.setVisible(true);

		}

	}

