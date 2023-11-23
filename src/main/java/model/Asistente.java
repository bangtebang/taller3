package model;

public class Usuario {
    private String nombre;
    private int edad;
    private String rut;
    public Usuario(String nombre, int edad, String rut) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
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
