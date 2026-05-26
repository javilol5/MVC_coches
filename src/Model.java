import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    public Object getGasolina(String matricula) {
         return getCoche(matricula).gasolina;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        System.out.println(" LOG esta haciendose");
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    public double cambiarGasolina(String matricula, double gasolina) {

        Coche c = getCoche(matricula);
        if (c == null) {
            return -1;
        }

        c.gasolina = gasolina;
        return c.gasolina;
    }

    public int avanzar(String matricula, int metros) {

        Coche c = getCoche(matricula);

        if (c == null) {
            return -1;
        }

        // gasolina necesaria
        double litrosNecesarios = metros / 1570.0;

        // comprobar gasolina
        if (c.gasolina < litrosNecesarios) {

            return -2;
        }

        // descontar gasolina
        c.gasolina -= litrosNecesarios;

        // avanzar
        c.recorrido += metros;

        return c.recorrido;
    }

}
