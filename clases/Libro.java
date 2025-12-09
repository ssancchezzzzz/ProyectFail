package clases;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int añoPublicacion, int ejemplaresTotales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresTotales;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean estaDisponible() {
        return ejemplaresDisponibles > 0;
    }

    public void prestarEjemplar() {
        if (ejemplaresDisponibles > 0)
            ejemplaresDisponibles--;
    }

    public void devolver() {
        if (ejemplaresDisponibles < ejemplaresTotales)
            ejemplaresDisponibles++;
    }
}