package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EventoMusical {
    private ArrayList<Artista> artistas= new ArrayList<>();
    private ArrayList<Asistente> asistentes= new ArrayList<>();
    private String nombre;
    private int edad;
    private String rut;
    public EventoMusical(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
