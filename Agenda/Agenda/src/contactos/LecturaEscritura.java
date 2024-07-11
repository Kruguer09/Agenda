/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.HeadlessException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
/**
 *
 * @author Conti
 */
public class LecturaEscritura {
     /*
    clase en la que definiremos los metodos
    de lectura y escritura del programa
    */
    
    /**
     * Clase para poder pasar por parametro la ruta del archivo
     * que deseemos guardar
     * @param ruta
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardarComo(String ruta) throws FileNotFoundException, IOException{
        String fichero=ruta;
        File f= new File(fichero);
        
        if (f.exists()){
            FileOutputStream foos=new FileOutputStream(fichero);
            ObjectOutputStream oos=new ObjectOutputStream(foos);
            for (Contactos c:Contactos.listaContactos){
                oos.writeObject(c);
            }
            
            if (oos != null){
                oos.close();
                foos.close();
            }
        }else{
            if (f.createNewFile()){
                FileOutputStream foos2=new FileOutputStream(fichero);
                ObjectOutputStream oos2=new ObjectOutputStream (foos2);
                
                for (Contactos c2:Contactos.listaContactos){
                    oos2.writeObject(c2);
                }
                
                if (oos2!=null){
                    oos2.close();
                    foos2.close();
                }
            }
        }
    }
    
    /**
     * Clase void que usaremos para leer la informacion del fichero de datos que guardemos
     * y posteriormente será mostrado en un componente JList
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    
    /****   ESTA NO SE PONE **************/
    
    public void leeFichero() throws IOException, ClassNotFoundException {
        String archivo="fichero.dat";
        File f = null;
        FileInputStream fe = null;
        ObjectInputStream ois = null;
        try {
         
            f = new File(archivo);
            if (f.exists()) {
                fe = new FileInputStream(f);
                ois = new ObjectInputStream(fe);
                while (true) {
                    Contactos c2 = null;
                    c2 = (Contactos) ois.readObject();
                    Contactos.getContactos().add(c2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: El fichero no existe.D:/fichero.dat (El sistema no puede encontrar el archivo especificado)", null, ERROR_MESSAGE);
            }
        } catch (EOFException eof) {
        } catch (FileNotFoundException fnf) {
        } catch (IOException | HeadlessException e) {
        } finally {
            if (ois
                    != null) {
                ois.close();
                fe.close();
            }
        }
    }
    
    /**
     * Clase para poder abrir un fichero cuya ruta sea introducida por parametro
     * @param ruta
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void abrirFichero(String ruta) throws IOException, ClassNotFoundException {
        File f = null;
        FileInputStream fe = null;
        ObjectInputStream ois = null;
        try {
            //c.getContactos();
            f = new File(ruta);
            if (f.exists()) {
                fe = new FileInputStream(f);
                ois = new ObjectInputStream(fe);
                while (true) {
                    Contactos c2 = null;
                    c2 = (Contactos) ois.readObject();
                    Contactos.getContactos().add(c2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: El fichero no existe.D:/fichero.dat (El sistema no puede encontrar el archivo especificado)", null, ERROR_MESSAGE);
            }
        } catch (EOFException eof) {
        } catch (FileNotFoundException fnf) {
        } catch (IOException | HeadlessException e) {
        } finally {
            if (ois
                    != null) {
                ois.close();
                fe.close();
            }
        }
    }
}