package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.ControladorInventario;

public class FrameCargamento extends JFrame implements ActionListener {
	private JPanel panel;
	private String direccion;
	private JTextField fieldDireccion;
	private ControladorInventario elContI;
	
	public FrameCargamento(ControladorInventario elContIi) {
		this.elContI = elContIi;
		setSize( 580, 700 );
		this.panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		JLabel lab= new JLabel ("Direccion Archivo");
		lab.setBounds(10,20,80,25);
		panel.add(lab);
		this.fieldDireccion= new JTextField(10); 
		fieldDireccion.setBounds(100, 20, 165, 25);
		
		Action action = new AbstractAction()
		{ @Override
		    public void actionPerformed(ActionEvent ee)
			    {
					direccion=fieldDireccion.getText();
			        System.out.println("Direccion Archivo");
			        System.out.println(direccion);
			        try {
						elContI.cargarNuevoLote(direccion);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			        setVisible(false);
			        
			        
			    }
			};
			fieldDireccion.addActionListener(action);
			panel.add(fieldDireccion);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Nuevo Cargamento");
			pack();
			setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
