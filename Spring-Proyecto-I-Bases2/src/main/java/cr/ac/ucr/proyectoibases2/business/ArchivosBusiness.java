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
    public void leerArchivo() throws IOException {
        archivosData.leerArchivo();
    }
    public String[] eliminaCampos(String [] campos) {
        return archivosData.eliminaCampos(campos);
    }
}
