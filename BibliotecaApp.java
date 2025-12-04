
import juego.clases.MyScanner;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private Libro libro;
    private ArrayList<Libro> libros;
    private BibliotecaService getServicio;
    private static final MyScanner scanner = new MyScanner(System.in);
    private static BibliotecaService servicio;

    public void BibliotecaApp() {
        servicio = new BibliotecaService();
    }

    public static void main(String[] argumentos) {
        BibliotecaService app = new BibliotecaService();
        ejecutarMenu();
    }

    private static void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;
        while (opcion != 0) {
            imprimirMenu();
            opcion = scanner.nextInt();

            if (opcion == 1) {
                registrarLibroDesdeConsola(scanner);
            } else if (opcion == 2) {
                registrarUsuarioDesdeConsola(scanner);
            } else if (opcion == 3) {
                prestarLibroDesdeConsola(scanner);
            } else if (opcion == 4) {
                devolverLibroDesdeConsola(scanner);
            } else if (opcion == 0) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion no valida");
            }
        }

        scanner.close();
    }

    private static void imprimirMenu() {
        System.out.println("=== GESTIÓN BIBLIOTECA ===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    private static void registrarLibroDesdeConsola(Scanner scanner) {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.next();
        System.out.print("Año publicación: ");
        int anio = scanner.nextInt();
        System.out.print("Ejemplares totales: ");
        int totales = scanner.nextInt();

        Libro libro = new Libro(isbn, titulo, autor, anio, totales);
        servicio.registrarLibro(libro);
    }

    private static void registrarUsuarioDesdeConsola(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.next();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre);
        servicio.registrarUsuario(usuario);
    }

    private static void prestarLibroDesdeConsola(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.next();
        System.out.print("ISBN libro: ");
        String isbn = scanner.next();

        servicio.prestarLibro(id, isbn);
    }

    private static void devolverLibroDesdeConsola(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.next();
        System.out.print("ISBN libro: ");
        String isbn = scanner.next();

        servicio.devolverLibro(id, isbn);
    }
}
