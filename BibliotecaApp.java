import clases.BibliotecaService;
import clases.Libro;
import clases.Usuario;

import java.util.Scanner;

public class BibliotecaApp {

//    private Libro libro;
//    private ArrayList<Libro> libros;
//    private BibliotecaService getServicio;
//    private static final MyScanner scanner = new MyScanner(System.in);
//    private static BibliotecaService servicio;
//    todo se elimina de aqui, y se inicializa en cada método en caso de ser utilizados salvo el BibliotecaService, que esta inicializado aqui abajo.

    private static BibliotecaService servicio = new BibliotecaService();

    public static void main(String[] args) {
        //BibliotecaService app = new BibliotecaService();
        //eliminado para que el main unicamente ejecute el metodo ejecutarMenu
        ejecutarMenu();
    }

    private static void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            imprimirMenu();

            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            //en vez de hacer un búcle de if y elif, utilizo un switch para llamar a todos los métodos y poder en el menú inicial inicializar cualquier metodo que elija el usuario

            switch (opcion) {
                case 1 -> registrarLibroDesdeConsola(scanner);
                case 2 -> registrarUsuarioDesdeConsola(scanner);
                case 3 -> prestarLibroDesdeConsola(scanner);
                case 4 -> devolverLibroDesdeConsola(scanner);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }

    //método no cambiado
    private static void imprimirMenu() {
        System.out.println("\n=== GESTIÓN BIBLIOTECA ===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("0. Salir");
    }

    private static void registrarLibroDesdeConsola(Scanner scanner) {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año publicación: ");
        int año = scanner.nextInt();
        System.out.print("Ejemplares totales: ");
        int totales = scanner.nextInt();
        scanner.nextLine();

        Libro libro = new Libro(isbn, titulo, autor, año, totales);
        servicio.registrarLibro(libro);
        System.out.println("Libro registrado.");
    }

    private static void registrarUsuarioDesdeConsola(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre);
        servicio.registrarUsuario(usuario);
        System.out.println("Usuario registrado.");
    }

    private static void prestarLibroDesdeConsola(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.nextLine();
        System.out.print("ISBN libro: ");
        String isbn = scanner.nextLine();

        boolean ok = servicio.prestarLibro(id, isbn);
        System.out.println(ok ? "Préstamo realizado." : "No se pudo prestar.");

        //método cambiado para que cuando se agregen los id e isbn, el usuario reciba una respuesta tanto validando la info correcta como denegando la continuación por datos incorrectos
    }

    private static void devolverLibroDesdeConsola(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.nextLine();
        System.out.print("ISBN libro: ");
        String isbn = scanner.nextLine();

        servicio.devolverLibro(id, isbn);
        System.out.println("Libro devuelto.");
    }
}