import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas. De alguna
 * manera tendrá que poder acceder a la ventana principal. Se puede lograr
 * pasando en el constructor la referencia a la ventana. Recuerda que desde la
 * ventana, se puede acceder a la variable de tipo ControlJuego
 * 
 * @author Ana Sánchez Miguel
 **
 */
public class ActionBoton implements ActionListener {

	final static int PUNTACION = 80;

	private VentanaPrincipal vPrincipal;
	private int i;
	private int j;

	public ActionBoton() {

	}

	/**
	 * @param vPrincipal Es un objeto de ventana principal.
	 * @param i          Posición horizontal del boton que estamos pulsando.
	 * @param j          Posición vertical del boton del que estamos pulsando.
	 */
	public ActionBoton(VentanaPrincipal vPrincipal, int i, int j) {
		this.vPrincipal = vPrincipal;
		this.i = i;
		this.j = j;
	}

	/**
	 * Acción que ocurrirá cuando pulsamos uno de los botones. Si abrimos una
	 * casilla, mostramos las minas de alrededor y actualizamos la puntuación. Si la
	 * puntuacion llega al valor de la constante, es decir, 80. Te saltará el
	 * mensaje de que has ganado, sino, te mostrara que has perdido.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (vPrincipal.juego.abrirCasilla(i, j)) {
			vPrincipal.mostrarNumMinasAlrededor(i, j);
			vPrincipal.actualizarPuntuacion();
		} else {
			if (vPrincipal.juego.getPuntuacion() == PUNTACION) {
				vPrincipal.mostrarFinJuego(false);
			} else {
				vPrincipal.mostrarFinJuego(true);
			}
		}
		vPrincipal.refrescarPantalla();
	}
}