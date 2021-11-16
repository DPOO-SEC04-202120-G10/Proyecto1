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
import modelo.ControladorInventario;
import modelo.ControladorPedido;
import modelo.Pedido;

public class FrameProductoNuevo {
	String direction;
	JFrame frame; 
	JPanel panel;
	Pedido pedido;
	ControladorPedido contp;
	Cliente cliente;
	ControladorInventario elContI;
	public FrameProductoNuevo(Pedido pedido, ControladorPedido contp, Cliente cliente, ControladorInventario elContI)
	{
		 frame= new JFrame();
		 panel= new JPanel();
		frame.add(panel, BorderLayout.CENTER);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		JLabel instruccionId= new JLabel ("Id del Producto");
		instruccionId.setBounds(10,20,80,25);
		panel.add(instruccionId);
		JTextField id= new JTextField(10); 
		id.setBounds(100, 20, 165, 25);
		Action action = new AbstractAction()
				{ @Override
		    public void actionPerformed(ActionEvent e)
			    {
					direction=id.getText();
			        System.out.println(direction);
			        frame.setVisible(false);
			        contp.anadirProducto(pedido, getid(), elContI);
			        //new FrameImagen ();
			        
			        
			    }
			};

		id.addActionListener(action);
		
		panel.add(id);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Ingresar Nuevo Producto");
				frame.pack();
				frame.setVisible(true);

	}
	public int getid()
	{int cedulaa= Integer.parseInt(direction);
		return cedulaa;
	}
	
}
