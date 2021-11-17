package interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.ControladorInventario;

public class FrameImagen extends JFrame implements ActionListener {
	private JPanel panel;
	private String productoID;
	private JTextField fieldId;
	private ControladorInventario elContI;
	
	public FrameImagen(ControladorInventario elContIi) {
		setLocationRelativeTo(null);
		var elContI = elContIi;
		setSize( 580, 700 );
		var panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		
		JLabel lab= new JLabel ("Id Producto");
		lab.setBounds(10,20,80,25);
		panel.add(lab);
		
		JTextField fieldID= new JTextField(10); 
		fieldID.setBounds(100, 20, 165, 25);
		
		Action action = new AbstractAction()
		
		{ @Override
		    public void actionPerformed(ActionEvent e)
			    {
					productoID=fieldID.getText();
			        System.out.println("Id Producto");
			        System.out.println(productoID);
			        setVisible(false);
			        
			        
			    }
			};
		fieldID.addActionListener(action);
		panel.add(fieldID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Consultar Producto");
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}