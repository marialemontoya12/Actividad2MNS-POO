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

public class Jugador {
    private static int contador = 0; // Variable estática para generar IDs automáticamente
    private int id; // ID único del jugador
    private String nombre; // Nombre del jugador
    private String posicion; // Posición del jugador
    private int edad; // Edad del jugador

    // Constructor de la clase Jugador
    public Jugador(String nombre, String posicion, int edad) {
        this.id = ++contador; // Asigna un ID único incrementando el contador
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }

    // Métodos getter y setter para acceder y modificar los atributos del jugador
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método para convertir el objeto Jugador a una cadena de texto legible
    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", edad=" + edad +
                '}';
    }
}
