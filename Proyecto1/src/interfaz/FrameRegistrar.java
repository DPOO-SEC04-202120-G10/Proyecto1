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

import modelo.Cliente;
import modelo.ControladorCliente;
import modelo.ControladorInventario;
import modelo.ControladorPedido;

public class FrameRegistrar {
	String direction;
	JFrame frame; 
	JPanel panel;
	ControladorCliente  elContC;
	ControladorInventario contI;
	int idPedido;
	String fech;
	ControladorPedido elContP;
	public FrameRegistrar(ControladorCliente  elContC, ControladorInventario contI, int idPedido, String fecha,ControladorPedido elContP)
	{
		 frame= new JFrame();
		 panel= new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		JLabel instruccionCedula= new JLabel ("Cedula");
		instruccionCedula.setBounds(10,20,80,25);
		panel.add(instruccionCedula);
		JTextField cedula= new JTextField(10); 
		cedula.setBounds(100, 20, 165, 25);
		Action action = new AbstractAction()
				{ @Override
		    public void actionPerformed(ActionEvent e)
			    {
					direction=cedula.getText();
			        System.out.println(direction);
			        frame.setVisible(false);
			        
			        
			    }
			};

		cedula.addActionListener(action);
		
		panel.add(cedula);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Registrar");
				frame.pack();
				frame.setVisible(true);

	}
	public int getcedula()
	{int cedulaa= Integer.parseInt(direction);
		return cedulaa;
	}
	}

