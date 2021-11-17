package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import modelo.ControladorInventario;


@SuppressWarnings("serial")
public class InterfazInventario extends JFrame
{
	private PanelBotonesInventario panelBotones;
	private FrameCargamento frameCargamento;
	private FrameLote frameConsultarLote;
	private FrameProducto frameConsultarProd;
	private FrameImagen frameImagen;
	private ControladorInventario elContI;
	
	public InterfazInventario(ControladorInventario elContI)
    {
		this.elContI = elContI;
        setTitle( "Sistema Inventario" );
        setSize( 580, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

        // Panel de botones
        panelBotones = new PanelBotonesInventario(  elContI, this );
        add( panelBotones, BorderLayout.CENTER );

        setResizable( false );
        setLocationRelativeTo( null );
        
        // Configurar ventana para llamar al metodo dispose() al cerrar la ventana
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        setVisible(true);
    }
	
	
	public void cargarCargamento(ControladorInventario elContI) {
		var frameCargamento = new FrameCargamento( elContI);
		
	}
	
	public void consultarLote(ControladorInventario elContI) {
		var frameConsultarLote = new FrameLote( elContI);
	}
	
	public void consultarProducto(ControladorInventario elContI) {
		var frameConsultarProducto = new FrameProducto( elContI);
	}
	
	public void cambiarImagen(ControladorInventario elContI) {
		var frameImagen= new FrameImagen( elContI);
	}
	
}
