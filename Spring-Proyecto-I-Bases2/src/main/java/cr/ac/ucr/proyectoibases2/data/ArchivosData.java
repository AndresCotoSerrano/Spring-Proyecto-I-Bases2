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
    private final String NOMBRE = ".../.../Archivos";;
    public String ruta;
    public static final String SEPARADOR = ";";
    public static final String SLASH = "\"";
    
    

    public void crearArchivo(String nombre) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ruta + nombre));
            this.nombre = nombre;
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public void leerArchivo() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(ruta + nombre));
            String line = br.readLine();
            while (null != line) {
                String[] celdas = line.split(SEPARADOR);
                System.out.println(Arrays.toString(celdas));

                celdas = eliminaCampos(celdas);
                System.out.println(Arrays.toString(celdas));

                line = br.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != br) {
                br.close();
            }
        }
    }

    public String[] eliminaCampos(String[] campos) {
        String result[] = new String[campos.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = campos[i].replaceAll("^" + SLASH, "").replaceAll(SLASH + "$", "");
        }
        return result;
    }
}
