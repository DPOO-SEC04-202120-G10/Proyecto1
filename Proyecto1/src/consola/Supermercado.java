package consola;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Supermercado implements ActionListener {
JFrame frame;
JButton boton1;
JButton boton2;
JPanel panel;
String fecha;
public Supermercado() {
	frame = new JFrame ();
	panel= new JPanel();
	boton1= new JButton("Sistema de Inventario"); 
	boton1.addActionListener(this);
	boton2 = new JButton("Sistema POS"); 
	boton2.addActionListener(this);
	JLabel header = new JLabel ("Supermercado");
	header.setHorizontalAlignment(JLabel.CENTER);
    header.setVerticalAlignment(JLabel.CENTER);
	Font font = new Font("Courier", Font.BOLD,18);
	header.setFont(font);
	
	panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
	panel.setLayout(new GridBagLayout());
	GridBagConstraints c= new GridBagConstraints();
	c.gridy=0;
	panel.add(header,c);
	JLabel lab= new JLabel ("Ingrese la fecha");
	lab.setBounds(10,20,80,25);
	c.gridy=1;
	c.gridx=0;
	panel.add(lab,c);
	JTextField fechahoy= new JTextField(10); 
	fechahoy.setBounds(100, 20, 165, 25);
	Action action = new AbstractAction()
			{ @Override
	    public void actionPerformed(ActionEvent e)
		    {
				fecha=fechahoy.getText();
		        System.out.println("some action");
		        System.out.println(fecha);
		        
		        
		    }
		};

	fechahoy.addActionListener(action);
	c.gridx=1;
	c.gridy=1;
	panel.add(fechahoy,c);
	// se crea para organizar componentes
	//c.insets= new Insets (5,5,5,5);
	
	
	// se crea para espacios entre componentes 
	
	c.gridx=0;
	c.gridy=5;
	// coordenadas de los componentes 
	
	
	panel.add(boton1,c);
	
	
	c.gridx=1;
	c.gridy=5;
	panel.add(boton2,c);

	

	frame.add(panel, BorderLayout.CENTER);
;		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Ventana de Inicio");
	frame.pack();
	frame.setVisible(true);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Supermercado();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
					if (e.getSource()==boton1) {
					
					
					
				}
					else if (e.getSource()==boton2) {
						new MenuPOS1();
						
					}
					frame.setVisible(false);
	}

}
