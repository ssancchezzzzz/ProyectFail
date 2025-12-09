package clases;

import java.util.ArrayList;
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
        this.prestamosActivos = new ArrayList<>();
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaximoPrestamosSimultaneos(int maximoPrestamosSimultaneos) {
        this.maximoPrestamosSimultaneos = maximoPrestamosSimultaneos;
    }

    public List<Prestar> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestar> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public String getId() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaximoPrestamosSimultaneos() {
        return maximoPrestamosSimultaneos;
    }

    public boolean tieneHuecoParaOtroPrestamo() {
        return prestamosActivos.size() < maximoPrestamosSimultaneos;
    }
}