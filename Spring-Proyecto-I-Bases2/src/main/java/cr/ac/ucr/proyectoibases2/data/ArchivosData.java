package cr.ac.ucr.proyectoibases2.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ArchivosData {
	
	private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String nombre;
    public final String RUTA =  ".../.../Archivos";
    
    

    public void crearArchivo(String nombre) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(RUTA + nombre));
            this.nombre = nombre;
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
    public String nombreTabla(String archivo) throws FileNotFoundException, IOException {
        String nombre = "";
        String sCadena = null;
        int contador = 1;
        BufferedReader bf = new BufferedReader(new FileReader(RUTA + archivo));
        while ((sCadena = bf.readLine()) != null) {
            if (contador == 1) {
                nombre = sCadena + "\n";
                ++contador;
                break;
            }
        }
        return nombre;
    }

    public String[] nombreColumna(String archivo) throws FileNotFoundException, IOException {
        String[] columnas = null;
        String sCadena = null;
        int contador = 1;
        BufferedReader bf = new BufferedReader(new FileReader(RUTA + archivo));
        while ((sCadena = bf.readLine()) != null) {
            if (contador == 3) {
                columnas = sCadena.split(",");
            }
            ++contador;
        }
        return columnas;
    }
    
    public String leerArchivo(String nombre) throws IOException {
        String result = "";

        String sCadena = null;
        BufferedReader bf = new BufferedReader(new FileReader(RUTA + nombre));
        while ((sCadena = bf.readLine()) != null) {
            result += sCadena + "\n";
        }
        bf.close();
        result.replaceAll(" ", "");
        return result;
    }
    
}
