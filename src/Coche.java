/**
 * Clase que representa un coche.
 * Guarda información básica como la matrícula,
 * el modelo, la velocidad, la gasolina y el recorrido.
 */
public class Coche {

    // Matrícula del coche
    String matricula;

    // Modelo del coche
    String modelo;

    // Velocidad actual del coche
    Integer velocidad;

    // Cantidad de gasolina disponible
    double gasolina;

    // Kilómetros recorridos por el coche
    Integer recorrido;

    /**
     * Constructor de la clase Coche.
     * Inicializa el modelo y la matrícula del coche.
     * La velocidad, gasolina y recorrido empiezan en 0.
     *
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     */
    public Coche(String modelo, String matricula) {

        // Asigna el modelo recibido
        this.modelo = modelo;

        // Asigna la matrícula recibida
        this.matricula = matricula;

        // Inicializa la velocidad a 0
        this.velocidad = 0;

        // Inicializa la gasolina a 0
        this.gasolina = 0;

        // Inicializa el recorrido a 0
        this.recorrido = 0;
    }
}