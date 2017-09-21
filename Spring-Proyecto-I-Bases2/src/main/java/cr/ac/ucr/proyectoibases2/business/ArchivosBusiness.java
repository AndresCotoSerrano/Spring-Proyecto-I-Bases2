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
    
   public void nombreTabla (String archivo) throws FileNotFoundException, IOException {
      archivosData.llenaHashNombreTabla(archivo);
   }
   public void nombreColumna(String archivo) throws FileNotFoundException, IOException {
      archivosData.llenaHashNombreColumna(archivo);
   }
   public void datosTabla(String nombre) throws FileNotFoundException, IOException{
      archivosData.llenaHashDatosTabla(nombre);
   }
}
