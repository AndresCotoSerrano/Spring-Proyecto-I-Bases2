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
    private String ruta;
    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    

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
            br = new BufferedReader(new FileReader("files/Libro1.csv"));
            String line = br.readLine();
            while (null != line) {
                String[] celdas = line.split(SEPARADOR);
                System.out.println(Arrays.toString(celdas));

                celdas = removeTrailingQuotes(celdas);
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

    private static String[] removeTrailingQuotes(String[] fields) {
        String result[] = new String[fields.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }

}
