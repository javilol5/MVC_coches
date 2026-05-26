// Importación de ArrayList para almacenar los coches
import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos.
 * Forma parte del modelo dentro del patrón MVC.
 */
public class Model {

    // Lista que almacena todos los coches creados
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo añade al parking.
     *
     * @param modelo Modelo del coche
     * @param matricula Identificador único del coche
     * @return El coche creado
     */
    public Coche crearCoche(String modelo, String matricula){

        // Crea un nuevo objeto Coche
        Coche aux = new Coche(modelo, matricula);

        // Añade el coche al parking
        parking.add(aux);

        // Devuelve el coche creado
        return aux;
    }

    /**
     * Busca un coche según su matrícula.
     *
     * @param matricula Matrícula a buscar
     * @return El coche encontrado o null si no existe
     */
    public Coche getCoche(String matricula){

        // Variable auxiliar para guardar el coche encontrado
        Coche aux = null;

        // Recorre la lista de coches
        for (Coche e : parking) {

            // Comprueba si la matrícula coincide
            if (e.matricula.equals(matricula)) {

                aux = e;
            }
        }

        // Devuelve el coche encontrado
        return aux;
    }

    /**
     * Devuelve la gasolina de un coche.
     *
     * @param matricula Matrícula del coche
     * @return Cantidad de gasolina
     */
    public Object getGasolina(String matricula) {

        return getCoche(matricula).gasolina;
    }

    /**
     * Cambia la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @param v Nueva velocidad
     * @return Velocidad modificada
     */
    public int cambiarVelocidad(String matricula, Integer v) {

        // Busca el coche y cambia la velocidad
        getCoche(matricula).velocidad = v;

        // Mensaje de comprobación
        System.out.println(" LOG esta haciendose");

        // Devuelve la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Devuelve la velocidad de un coche según su matrícula.
     *
     * @param matricula Matrícula del coche
     * @return Velocidad actual
     */
    public int getVelocidad(String matricula) {

        return getCoche(matricula).velocidad;
    }

    /**
     * Cambia la cantidad de gasolina de un coche.
     *
     * @param matricula Matrícula del coche
     * @param gasolina Nueva cantidad de gasolina
     * @return Gasolina actualizada o -1 si no existe el coche
     */
    public double cambiarGasolina(String matricula, double gasolina) {

        // Busca el coche
        Coche c = getCoche(matricula);

        // Comprueba si existe
        if (c == null) {

            return -1;
        }

        // Cambia la gasolina
        c.gasolina = gasolina;

        // Devuelve la gasolina actual
        return c.gasolina;
    }

    /**
     * Hace avanzar un coche una cantidad de metros.
     *
     * @param matricula Matrícula del coche
     * @param metros Metros a recorrer
     * @return Recorrido total,
     *         -1 si no existe el coche,
     *         -2 si no hay suficiente gasolina
     */
    public int avanzar(String matricula, int metros) {

        // Busca el coche
        Coche c = getCoche(matricula);

        // Comprueba si existe
        if (c == null) {

            return -1;
        }

        // Calcula la gasolina necesaria
        double litrosNecesarios = metros / 1570.0;

        // Comprueba si tiene suficiente gasolina
        if (c.gasolina < litrosNecesarios) {

            return -2;
        }

        // Descuenta la gasolina utilizada
        c.gasolina -= litrosNecesarios;

        // Incrementa el recorrido
        c.recorrido += metros;

        // Devuelve el recorrido total
        return c.recorrido;
    }
}