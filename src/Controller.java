/**
 * Clase Controller.
 * Se encarga de conectar la vista (View)
 * con el modelo (Model) siguiendo el patrón MVC.
 */
public class Controller {

    // Instancia estática de la vista
    static View miView = new View();

    // Instancia del modelo
    Model miModel = new Model();

    /**
     * Método principal del programa.
     * Inicia el menú de la aplicación.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {

        // Muestra el menú principal
        miView.menu();

        /**
         * Código de pruebas comentado.
         * Sirve para probar manualmente la aplicación.
         *

         // Instanciamos la vista y el modelo

         // Crear tres coches
         miModel.crearCoche("LaFerrari", "SBC 1234");
         miModel.crearCoche("Alpine", "HYU 4567");
         miModel.crearCoche("Aston Martin", "FGH 3333");

         // Obtiene un coche concreto
         Coche ferrari = miModel.getCoche("SBC 1234");

         // Modifica la velocidad
         int nuevaVelocidad = miModel.cambiarVelocidad("SBC 1234", 30);

         // Recoge la velocidad y la muestra en la vista
         boolean hecho = miView.muestraVelocidad(
         "SBC 1234",
         miModel.getVelocidad("SBC 1234")
         );

         // Muestra un mensaje de comprobación
         if (hecho) {
         System.out.println("[LOG] Correcto");
         } else {
         System.out.println("[LOG] Error");
         }

         **/
    }

    /**
     * Añade un nuevo coche al modelo.
     *
     * @param modelo Modelo del coche
     * @param matricula Matrícula del coche
     * @return true si el coche fue añadido correctamente
     */
    public boolean añadirCoche(String modelo, String matricula){

        // Crea el coche
        Coche creado = miModel.crearCoche(modelo, matricula);

        // Comprueba si el coche existe en el modelo
        if (creado == miModel.getCoche(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cambia la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @param velocidad Nueva velocidad
     * @return true si la velocidad se mostró correctamente
     */
    public boolean newVelocidad(String matricula, int velocidad){

        // Cambia la velocidad en el modelo
        int nuevaVelocidad =
                miModel.cambiarVelocidad(matricula, velocidad);

        // Muestra la velocidad actual en la vista
        boolean hecho =
                miView.muestraVelocidad(
                        matricula,
                        miModel.getVelocidad(matricula)
                );

        return hecho;
    }

    /**
     * Cambia la cantidad de gasolina de un coche.
     *
     * @param matricula Matrícula del coche
     * @param gasolina Cantidad de gasolina a añadir
     * @return true si la operación fue correcta
     */
    public boolean newGasolina(String matricula, double gasolina){

        // Cambia la gasolina del coche
        double nuevaGasolina =
                miModel.cambiarGasolina(matricula, gasolina);

        // Comprueba si la matrícula existe
        if (nuevaGasolina == -1) {

            System.out.println("No existe esa matrícula");

            return false;
        }

        // Muestra la gasolina actual en la vista
        return miView.muestraGasolina(
                matricula,
                miModel.getGasolina(matricula)
        );
    }

    /**
     * Hace avanzar un coche una cantidad de metros.
     *
     * @param matricula Matrícula del coche
     * @param metros Metros a recorrer
     * @return true si el coche avanzó correctamente
     */
    public boolean avanzarCoche(String matricula, int metros) {

        // Avanza el coche en el modelo
        int total = miModel.avanzar(matricula, metros);

        // Comprueba si la matrícula existe
        if (total == -1) {

            System.out.println("No existe esa matrícula");

            return false;
        }

        // Comprueba si hay suficiente gasolina
        if (total == -2) {

            System.out.println("Gasolina insuficiente");

            return false;
        }

        // Muestra el recorrido realizado
        System.out.println(
                matricula + " ha recorrido " +
                        metros + " metros"
        );

        return true;
    }
}