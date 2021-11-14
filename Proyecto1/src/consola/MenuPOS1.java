package consola;

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

public class MenuPOS1 implements ActionListener{
JFrame frame; 
JPanel panel; 
JButton boton1; 
JButton boton2;
String direction;
public MenuPOS1() 
{
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
	frame.setTitle("Ventana de Inicio");
	frame.pack();
	frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==boton1) {
		
		
		
	}
		else if (e.getSource()==boton2) {
			
		}
}
public Cliente Registrar()
{
	JFrame f= new JFrame();
	JPanel p= new JPanel();
	f.add(p, BorderLayout.CENTER);
	f.setLayout(new GridBagLayout());
	GridBagConstraints c= new GridBagConstraints();
	JLabel lab= new JLabel ("Cedula");
	lab.setBounds(10,20,80,25);
	p.add(lab);
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
	
	p.add(cedula);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("Registrar");
			f.pack();
			f.setVisible(true);

}
}