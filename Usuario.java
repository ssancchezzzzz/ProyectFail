import java.util.List;

public class Usuario {

  
    private String idusuario;
    private String nombre;
    private int maximoPrestamosSimultaneos;
    private List<Prestar> prestamosActivos;

    public Usuario(String id, String nombre) {
        this.idusuario = id;
        this.nombre = nombre;
        this.maximoPrestamosSimultaneos = 3;
        prestamosActivos = null; 
    }

    public String getId() {
        return idusuario;
    }

    public void setId(String id) {
        this.idusuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaximoPrestamosSimultaneos() {
        return maximoPrestamosSimultaneos;
    }

    public void setMaximoPrestamosSimultaneos(int maximoPrestamosSimultaneos) {
        if (maximoPrestamosSimultaneos < 0) {
            this.maximoPrestamosSimultaneos = 0;
        }

    }

    public List<Prestar> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestar> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public boolean tieneHuecoParaOtroPrestamo() {
        int contador = 0;
        if (prestamosActivos == null) {
            if (maximoPrestamosSimultaneos == 0) {
                if (maximoPrestamosSimultaneos < 0) {
                    return false;
                } else if (maximoPrestamosSimultaneos > 0) {
                    return true;
                }
            } else if (maximoPrestamosSimultaneos > 0) {
                contador = 0;
                for (int i = 0; i <= contador; i++) {
                    
                    contador = i;
                }
                return contador <= maximoPrestamosSimultaneos;
            }
        } else {
            if (prestamosActivos.size() <= maximoPrestamosSimultaneos) {
                if (prestamosActivos.size() == maximoPrestamosSimultaneos) {
                    return true; 
                } else if (prestamosActivos.size() > maximoPrestamosSimultaneos) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return maximoPrestamosSimultaneos == 100; 
    }
}
