package cr.ac.ucr.proyectoibases2.business;

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
    public String[] eliminaCampos(String [] campos) {
        return archivosData.eliminaCampos(campos);
    }
}
