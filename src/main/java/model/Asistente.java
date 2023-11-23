package model;

public class Asistente {
    private String nombre;
    private int edad;
    private String rut;
    private EventoMusical evento;
    public Asistente(String nombre, int edad, String rut, EventoMusical evento) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
        this.evento = evento;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }
    public String getRut() {
        return this.rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }

}
