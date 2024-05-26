import java.util.ArrayList;
import java.util.Scanner;

public class CRUDJugador {
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CRUDJugador crud = new CRUDJugador();
        crud.menu();
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("1. Ingresar un nuevo jugador");
            System.out.println("2. Elimina un jugador");
            System.out.println("3. Busca un jugador");
            System.out.println("4. Edita la informacion de un jugador");
            System.out.println("5. Ver listado de jugadores");
            System.out.println("6. Quieres Salir?");
            System.out.print("Seleccione la opción que necesita: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarJugador();
                    break;
                case 2:
                    eliminarJugador();
                    break;
                case 3:
                    buscarJugador();
                    break;
                case 4:
                    editarJugador();
                    break;
                case 5:
                    listarJugadores();
                    break;
                case 6:
                    System.out.println("Finalizando ejecución del programa...");
                    break;
                default:
                    System.out.println("Opcion seleccionada no válida.");
            }
        } while (opcion != 6);
    }

    private void agregarJugador() {
        System.out.print("Por favor, ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Por favor, ingrese posición: ");
        String posicion = scanner.nextLine();
        System.out.print("Por favor, ingrese edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Jugador jugador = new Jugador(nombre, posicion, edad);
        jugadores.add(jugador);
        System.out.println("El jugador fue agregado exitosamente.");
        listarJugadores();
    }

    private void eliminarJugador() {
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.print("¿Confirma que desea eliminar al jugador? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                jugadores.remove(jugador);
                System.out.println("El Jugador fue eliminado exitosamente.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
        listarJugadores();
    }

    private void buscarJugador() {
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.println(jugador);
        } else {
            System.out.println("EL Jugador no fue encontrado.");
        }
    }

    private void editarJugador() {
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.print("Ingrese nuevo nombre (deje en blanco para no modificar): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                jugador.setNombre(nombre);
            }

            System.out.print("Ingrese nueva posición (deja en blanco para no modificar): ");
            String posicion = scanner.nextLine();
            if (!posicion.isEmpty()) {
                jugador.setPosicion(posicion);
            }

            System.out.print("Ingrese nueva edad (0 para no modificar): ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            if (edad != 0) {
                jugador.setEdad(edad);
            }

            System.out.println("el Jugador fue editado exitosamente.");
        } else {
            System.out.println("El Jugador no fue encontrado.");
        }
        listarJugadores();
    }

    private void listarJugadores() {
        System.out.println("Listado de jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    private Jugador buscarJugadorPorId(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }
}

