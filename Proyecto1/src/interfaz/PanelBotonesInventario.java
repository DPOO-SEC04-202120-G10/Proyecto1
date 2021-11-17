package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ControladorInventario;


public class PanelBotonesInventario extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Opci�n registrar.
     */
    public final static String N_CARG = "NUEVO_CARGAMENTO";

    /**
     * Opci�n anular.
     */
    public final static String C_PROD = "CONSULTAR_PRODUCTO";

    /**
     * Opci�n buscar.
     */
    public final static String C_LOT = "CONSULTAR_LOTE";

    /**
     * Opci�n porcentaje de ocupaci�n.
     */
    public final static String C_IMAGEN = "CONSULTAR_IMAGEN";

    /**
     * Opci�n cambiar de App
     */
    private final static String CAMBIAR_APP = "CAMBIAR_APP";

    private ControladorInventario elContI;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Registro de nuevo pasajero.
     */
    private JButton bNCarg;

    /**
     * Bot�n Anular.
     */
    private JButton bCProd;

    /**
     * Bot�n de b�squeda.
     */
    private JButton bCLote;

    /**
     * Bot�n porcentaje de ocupaci�n.
     */
    private JButton bCImag;

    /**
     * Bot�n de cambio de App.
     */
    private JButton botonCambiarApp;


    /**
     * Interfaz principal.
     */
    private InterfazInventario ventana;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones. <br>
     * <b>post: </b> Se crean y alistan los botones de la interfaz.
     * @param pVentana Ventana o frame padre. pVentana != null.
     */
    public PanelBotonesInventario(ControladorInventario elContI,InterfazInventario pVentana)
    {
    	this.elContI = elContI;
        // Guarda la referencia a la ventana padre
        ventana = pVentana;

        // Configura propiedades visuales
        setLayout( new GridLayout( 2, 2, 8, 30 ) );
        //setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Bot�n registrar
       	bNCarg = new JButton( "Nuevo Cargamento" );
        bNCarg.setActionCommand( N_CARG );
        bNCarg.addActionListener( this );
        bNCarg.setPreferredSize( new Dimension( 40, 10 ) );
        add( bNCarg );

        // Bot�n anular registro
        bCProd = new JButton( "Consultar Producto" );
        bCProd.setActionCommand( C_PROD );
        bCProd.addActionListener( this );
        add( bCProd );

        // Bot�n buscar pasajero
        bCLote = new JButton( "Consultar Lote" );
        bCLote.setActionCommand( C_LOT );
        bCLote.addActionListener( this );
        add( bCLote );

        // Bot�n porcentaje de ocupaci�n
        bCImag = new JButton( "Cambiar Imagen" );
        bCImag.setActionCommand( C_IMAGEN );
        bCImag.addActionListener( this );
        add( bCImag );

        

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Acciones de respuesta a los eventos de la interfaz.
     * @param pEvento Evento generado por un elemento de la interfaz.
      */

    public void actionPerformed( ActionEvent pEvento )
    {
        String comand = pEvento.getActionCommand( );

        if( comand.equals( N_CARG ) )
        {
            ventana.cargarCargamento(  elContI);
        }
        else if( comand.equals( C_PROD ) )
        {
            ventana.consultarProducto(  elContI);
        }
        else if( comand.equals( C_LOT ) )
        {
            ventana.consultarLote(elContI );
        }
        else if( comand.equals( C_IMAGEN ) )
        {
            ventana.cambiarImagen(elContI );
        }
       
    }
   
}

