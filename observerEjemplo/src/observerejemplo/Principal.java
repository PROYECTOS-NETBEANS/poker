package observerejemplo;


/**
 * Clase principal del aplicativo, se establecen las instancias
 * entre las clases y el patron observer
 * @author chenao
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ClaseObservador observador=new ClaseObservador();
		VentanaOpciones miVentanaOpciones=new VentanaOpciones(observador);
		VentanaColor miVentanaColor=new VentanaColor(observador);
		VentanaSeleccion miVentanaSeleccion=new VentanaSeleccion(observador);
	
		/*Aqui se Agregan los observadores*/
		observador.addObserver(miVentanaColor);
		observador.addObserver(miVentanaSeleccion);
		observador.addObserver(miVentanaOpciones);
	}
}
<<<<<<< f1cd274cd7b95db64491f937350ef72574e57d15
//Este es un ejemplomodificado en el servidro
// modificacion en el cliente de para el mergue
>>>>>>> cec7c1b618b7881f23c3884003acde9535df6131
