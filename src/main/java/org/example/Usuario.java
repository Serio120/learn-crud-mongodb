package org.example;

public class Usuario {
    private String id;
    private String nombre;
    private int edad;

    public Usuario(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
}

