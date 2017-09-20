package cr.ac.ucr.proyectoibases2.business;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import cr.ac.ucr.proyectoibases2.data.ArchivosData;

public class ArchivosBusiness {
    @Autowired
    private ArchivosData archivosData;
    
    public void crearArchivo(String nombre) {
        archivosData.crearArchivo(nombre);
                
    }
    public String leerArchivo(String nombre) throws IOException {
       return archivosData.leerArchivo(nombre);
    }
    
   public String nombreTabla (String archivo) throws FileNotFoundException, IOException {
       return archivosData.nombreTabla(archivo);
   }
   public String [] nombreColumna(String archivo) throws FileNotFoundException, IOException {
       return archivosData.nombreColumna(archivo);
   }
   public String[][] datosTabla(String nombre) throws FileNotFoundException, IOException{
       return archivosData.datosTabla(nombre);
   }
}
