/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Conti
 */
public class Contactos implements Serializable{
    
    /*
     *  Clase en la que configuraremos la informacion de 
     *  los contactos
     */
    
    String nombre;
    String apellidos;
    String dni;
    int edad;
    public static ArrayList<Contactos> listaContactos= new ArrayList<>();//ArrayList en el que amacenaremos la informacion de los diferentes contactos
    
    /*
    getters y setters
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setContactos(ArrayList <Contactos> c){
        this.listaContactos=c;
    }
    
    public static ArrayList<Contactos> getContactos(){
        return listaContactos;
    }
    
    /*
    Constructor vacio
    */
    public Contactos(){
        
    }
   
    /**
     * contructor de la clase contactos
     * @param nombre 
     * @param apellidos
     * @param edad
     * @param dni 
     */
    public Contactos(String nombre, String apellidos, int edad, String dni){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.edad=edad;
        listaContactos.add(this);
    }
    
    /**
     * metodo para modificcar los contactos
     * @param modNombre nombre a modificar
     * @param modApellidos apellidos a modificar
     * @param modDni dni a modificar
     * @param modEdad edad a modificar
     */
    public void modContactos(String modNombre, String modApellidos, String modDni, int modEdad){
        this.apellidos = modApellidos;
        this.nombre=modNombre;
        this.dni=modDni;
        this.edad=modEdad;
    }

    /**
     * metodo toString para poder mostrar todos los datos
     * de nuestro arrayList
     * @return retorna los valores del ArrayList
     */
    public String toString() {
        return "Contacto:" + dni+" -- "+nombre+" -- "+apellidos+" -- "+edad;
    }
    
    public void borrarArrayList(){
        Contactos.getContactos().clear();
    }
    
     
    
    
}
