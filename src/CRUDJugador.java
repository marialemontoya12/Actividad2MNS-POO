/*
 * Este código fue desarrollado por [nombre del equipo] como parte de la actividad [número de actividad].
 * Declaramos que todo el código fuente es original y no fue copiado de ninguna fuente externa.
 *
 * Se utilizó ChatGPT de OpenAI para obtener orientación sobre la estructura y la implementación de ciertas partes del código.
 * Específicamente, ChatGPT nos asistió en:
 * - Proveer una estructura básica para la clase CRUDJugador y sugerir métodos necesarios.
 * - Proveer ejemplos sobre cómo implementar las operaciones CRUD (Agregar, Eliminar, Buscar, Editar, Listar).
 * - Proveer ejemplos de manejo de entradas y salidas usando la clase Scanner para interactuar con el usuario.
 *
 * No copiamos ni mandamos a realizar ninguna parte de este proyecto. Todo el código fue implementado por nosotros basándonos en la orientación recibida.
 */

import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas
import java.util.Scanner; // Importa la clase Scanner para la entrada de datos

// Clase que maneja las operaciones CRUD para jugadores
public class CRUDJugador {
    private ArrayList<Jugador> jugadores = new ArrayList<>(); // Lista para almacenar jugadores
    private Scanner scanner = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario

    // Método principal que inicia el programa
    public static void main(String[] args) {
        CRUDJugador crud = new CRUDJugador(); // Crea una instancia de CRUDJugador
        crud.menu(); // Llama al método menu para mostrar el menú principal
    }

    // Método que muestra el menú principal y gestiona la interacción del usuario
    public void menu() {
        int opcion = 0; // Variable para almacenar la opción seleccionada por el usuario
        do {
            // Muestra las opciones del menú
            System.out.println("1. Agregar jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Buscar jugador");
            System.out.println("4. Editar jugador");
            System.out.println("5. Listar todos los jugadores");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); // Lee la opción seleccionada por el usuario
            scanner.nextLine(); // Limpiar el buffer

            // Ejecuta la acción correspondiente a la opción seleccionada
            switch (opcion) {
                case 1:
                    agregarJugador(); // Llama al método para agregar un jugador
                    break;
                case 2:
                    eliminarJugador(); // Llama al método para eliminar un jugador
                    break;
                case 3:
                    buscarJugador(); // Llama al método para buscar un jugador
                    break;
                case 4:
                    editarJugador(); // Llama al método para editar un jugador
                    break;
                case 5:
                    listarJugadores(); // Llama al método para listar todos los jugadores
                    break;
                case 6:
                    System.out.println("Saliendo del programa..."); // Muestra un mensaje de salida
                    break;
                default:
                    System.out.println("Opción no válida."); // Muestra un mensaje de error si la opción no es válida
            }
        } while (opcion != 6); // Repite el menú hasta que el usuario seleccione salir
    }

    // Método para agregar un nuevo jugador
    private void agregarJugador() {
        // Solicita al usuario los datos del jugador
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese posición: ");
        String posicion = scanner.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Crea un nuevo objeto Jugador con los datos ingresados
        Jugador jugador = new Jugador(nombre, posicion, edad);
        jugadores.add(jugador); // Agrega el nuevo jugador a la lista
        System.out.println("Jugador agregado exitosamente.");
        listarJugadores(); // Muestra la lista actualizada de jugadores
    }

    // Método para eliminar un jugador
    private void eliminarJugador() {
        // Solicita al usuario el ID del jugador a eliminar
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Busca el jugador por ID
        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            // Confirma la eliminación del jugador
            System.out.print("¿Confirma que desea eliminar al jugador? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                jugadores.remove(jugador); // Elimina el jugador de la lista
                System.out.println("Jugador eliminado exitosamente.");
            }
        } else {
            System.out.println("Jugador no encontrado."); // Muestra un mensaje si el jugador no existe
        }
        listarJugadores(); // Muestra la lista actualizada de jugadores
    }

    // Método para buscar un jugador por ID
    private void buscarJugador() {
        // Solicita al usuario el ID del jugador a buscar
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Busca el jugador por ID
        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.println(jugador); // Muestra los datos del jugador si lo encuentra
        } else {
            System.out.println("Jugador no encontrado."); // Muestra un mensaje si el jugador no existe
        }
    }

    // Método para editar los datos de un jugador
    private void editarJugador() {
        // Solicita al usuario el ID del jugador a editar
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Busca el jugador por ID
        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            // Solicita los nuevos datos del jugador (deja en blanco para no modificar)
            System.out.print("Ingrese nuevo nombre (dejar en blanco para no modificar): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                jugador.setNombre(nombre); // Modifica el nombre del jugador si se ingresó uno nuevo
            }

            System.out.print("Ingrese nueva posición (dejar en blanco para no modificar): ");
            String posicion = scanner.nextLine();
            if (!posicion.isEmpty()) {
                jugador.setPosicion(posicion); // Modifica la posición del jugador si se ingresó una nueva
            }

            System.out.print("Ingrese nueva edad (0 para no modificar): ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            if (edad != 0) {
                jugador.setEdad(edad); // Modifica la edad del jugador si se ingresó una nueva
            }

            System.out.println("Jugador editado exitosamente.");
        } else {
            System.out.println("Jugador no encontrado."); // Muestra un mensaje si el jugador no existe
        }
        listarJugadores(); // Muestra la lista actualizada de jugadores
    }

    // Método para listar todos los jugadores
    private void listarJugadores() {
        System.out.println("Lista de jugadores:"); // Muestra un encabezado para la lista de jugadores
        for (Jugador jugador : jugadores) {
            System.out.println(jugador); // Muestra los datos de cada jugador en la lista
        }
    }

    // Método auxiliar para buscar un jugador por ID
    private Jugador buscarJugadorPorId(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador; // Retorna el jugador si encuentra uno con el ID especificado
            }
        }
        return null; // Retorna null si no encuentra ningún jugador con el ID especificado
    }
}
