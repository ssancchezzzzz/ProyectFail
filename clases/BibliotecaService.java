package clases;

import java.util.*;

public class BibliotecaService {

    private Map<String, Libro> librosPorIsbn = new LinkedHashMap<>();
    private Map<String, Usuario> usuariosPorId = new LinkedHashMap<>();
    private ArrayList<Prestar> prestamos = new ArrayList<>();

    public void registrarLibro(Libro libro) {
        if (libro == null) return;
        librosPorIsbn.put(libro.getIsbn(), libro);
//        if (librosPorIsbn.containsKey(libro.getIsbn())) {
//            librosPorIsbn.put(libro.getIsbn(), libro);
//        } lo he quitado porque no era necesario
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getNombre().isBlank()) return;
        usuariosPorId.put(usuario.getId(), usuario);

//        usuariosPorId.put(usuario.getId(), usuario);
//        if (usuario.getNombre() == "") {
//            usuariosPorId.remove(usuario.getId());
//        } Cambiado el método para que sea más efectivo
    }

    public boolean prestarLibro(String idUsuario, String isbn) {

        Usuario u = usuariosPorId.get(idUsuario);
        Libro l = librosPorIsbn.get(isbn);

        if (u == null || l == null) {
            System.out.println("Usuario o libro no existe.");
            return false;
        }

        if (!l.estaDisponible()) {
            System.out.println("No hay ejemplares disponibles.");
            return false;
        }

        if (!u.tieneHuecoParaOtroPrestamo()) {
            System.out.println("Usuario sin cupo de préstamos.");
            return false;
        }

        l.prestarEjemplar();
        Prestar p = new Prestar(u, l);
        prestamos.add(p);
        return true;
    }

    public void devolverLibro(String idUsuario, String isbn) {
        for (Prestar p : prestamos) {
            if (p.getUsuario().getId().equals(idUsuario) &&
                    p.getLibro().getIsbn().equals(isbn) &&
                    !p.isDevuelto()) {

                p.marcarDevuelto();
                return;
            }
        }
    }
}