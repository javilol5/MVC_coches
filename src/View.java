// Importación de la clase Scanner para leer datos del teclado
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario.
 * Forma parte de la vista dentro del patrón MVC.
 */
public class View {

    /**
     * Método que muestra el menú principal
     * y gestiona las opciones elegidas por el usuario.
     */
    public void menu() {

        // Crea una instancia del controlador
        Controller c = new Controller();

        // Variable para guardar la opción seleccionada
        int opcion = 0;

        // Bucle principal del menú
        do {

            // Muestra las opciones disponibles
            System.out.println("\n--- XESTOR COCHES ---");
            System.out.println("1. Engadir Coche");
            System.out.println("2. Cambiar velocidad");
            System.out.println("3. Rellenar gasolina");
            System.out.println("4. Avanzar");
            System.out.println("9. Salir");
            System.out.print("Selecciona unha opción: ");

            // Lee la opción introducida por el usuario
            opcion = new Scanner(System.in).nextInt();

            // Ejecuta una acción dependiendo de la opción elegida
            switch (opcion) {

                /**
                 * Opción 1:
                 * Añadir un nuevo coche
                 */
                case 1 -> {

                    // Solicita el modelo
                    System.out.println("Modelo: ");
                    String modelo = new Scanner(System.in).next();

                    // Solicita la matrícula
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();

                    // Llama al controlador para añadir el coche
                    boolean a = c.añadirCoche(modelo, matricula);

                    // Comprueba el resultado
                    if (a == true) {

                        System.out.println("Se ha añadido correctamente");

                    } else {

                        System.out.println("Algo ha fallado");
                    }
                }

                /**
                 * Opción 2:
                 * Cambiar la velocidad de un coche
                 */
                case 2 -> {

                    // Solicita la matrícula
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();

                    // Solicita la nueva velocidad
                    System.out.println("Nueva velocidad: ");
                    int velocidad = new Scanner(System.in).nextInt();

                    // Llama al controlador
                    boolean a = c.newVelocidad(matricula, velocidad);

                    // Comprueba el resultado
                    if (a == true) {

                        System.out.println("Se ha cambiado correctamente");

                    } else {

                        System.out.println("Algo ha fallado");
                    }
                }

                /**
                 * Opción 3:
                 * Añadir gasolina a un coche
                 */
                case 3 -> {

                    // Solicita la matrícula
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();

                    // Solicita la gasolina a añadir
                    System.out.println("Gasolina a rellenar: ");
                    double gasolina = new Scanner(System.in).nextInt();

                    // Llama al controlador
                    boolean a = c.newGasolina(matricula, gasolina);

                    // Comprueba el resultado
                    if (a == true) {

                        System.out.println("Se ha rellenado correctamente");

                    } else {

                        System.out.println("Algo ha fallado");
                    }
                }

                /**
                 * Opción 4:
                 * Avanzar una cantidad de metros
                 */
                case 4 -> {

                    // Solicita la matrícula
                    System.out.println("Matricula: ");
                    String matricula = new Scanner(System.in).next();

                    // Solicita los metros a avanzar
                    System.out.println("Metros a avanzar: ");
                    int metros = new Scanner(System.in).nextInt();

                    // Llama al controlador
                    boolean a = c.avanzarCoche(matricula, metros);

                    // Comprueba el resultado
                    if (a) {

                        System.out.println("Movimiento realizado");

                    } else {

                        System.out.println("Algo ha fallado");
                    }
                }

                /**
                 * Opción 9:
                 * Salir del programa
                 */
                case 9 -> {

                    System.out.println("Chao hasta luego....");
                }
            }

            // El menú se repite hasta que el usuario elija salir
        } while (opcion != 9);
    }

    /**
     * Muestra la velocidad de un coche.
     *
     * @param matricula Matrícula del coche
     * @param v Velocidad actual
     * @return true si se mostró correctamente
     */
    public boolean muestraVelocidad(String matricula, Integer v){

        System.out.println(matricula + ": " + v + "km/hr");

        return true;
    }

    /**
     * Muestra la cantidad de gasolina de un coche.
     *
     * @param matricula Matrícula del coche
     * @param gasolina Cantidad de gasolina
     * @return true si se mostró correctamente
     */
    public boolean muestraGasolina(String matricula, Object gasolina) {

        System.out.println(matricula + ": " + gasolina + " litros");

        return true;
    }
}