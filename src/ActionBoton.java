import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas. De alguna
 * manera tendrá que poder acceder a la ventana principal. Se puede lograr
 * pasando en el constructor la referencia a la ventana. Recuerda que desde la
 * ventana, se puede acceder a la variable de tipo ControlJuego
 * 
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener {

	private VentanaPrincipal vPrincipal;
	private int i;
	private int j;

	public ActionBoton() {

	}

	public ActionBoton(VentanaPrincipal vPrincipal, int i, int j) {
		this.vPrincipal = vPrincipal;
		this.i = i;
		this.j = j;
	}

	/**
	 * Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO
		if(vPrincipal.juego.abrirCasilla(i, j)){
			vPrincipal.mostrarNumMinasAlrededor(i, j);
			vPrincipal.actualizarPuntuacion();
		} else {
			if(vPrincipal.juego.getPuntuacion() == 80){
				vPrincipal.mostrarFinJuego(false);
			} else {
				vPrincipal.mostrarFinJuego(true);
			}
		}
		vPrincipal.refrescarPantalla();
	}
}