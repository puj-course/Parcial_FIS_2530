package com.example.usuaario;

public class Usuario {
    public String name;
    public String apellido;
    public int cc;
    public String correo;
    public int telefono;
    public String tipo;

    public Usuario(String name, String apellido, int cc, String correo, int telefono, String tipo) {
        this.name = name;
        this.apellido = apellido;
        this.cc = cc;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }
    public void solicitarPrestamo(Libro libro){
        //funcion encargada de solicitar un prestamo
    }
}
