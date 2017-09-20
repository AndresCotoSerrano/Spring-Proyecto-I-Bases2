package cr.ac.ucr.proyectoibases2.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ArchivosData {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String nombre;
    public final String RUTA = ".../.../Archivos";

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
        bf.close();
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
        bf.close();
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

    public String[][] datosTabla(String nombre) throws FileNotFoundException, IOException {
        String[][] datos = null;
        String linea = null;
        String[] dato = null;
        String sCadena = null;
        int cont = 1;
        int contador = 1;
        int cuenta = 1;

        BufferedReader bf = new BufferedReader(new FileReader(RUTA + nombre));

        while ((sCadena = bf.readLine()) != null) {
            if (contador >= 5 && !sCadena.equals("")) {
                ++cont;
                dato = sCadena.split(",");
            }
            ++contador;
        }
        bf.close();
        int columnas = dato.length;
        boolean bandera = false;
        int numDatos = 0;
        BufferedReader bfs = new BufferedReader(new FileReader(RUTA + nombre));
        datos = new String[cont][columnas];
        while ((linea = bfs.readLine()) != null) {
            bandera = false;
            dato = linea.split(",");
            if (cuenta >= 5 && dato.length == columnas) {
                for (int i = 0; i < cont; i++) {
                    if (i == numDatos && bandera == false) {
                        for (int j = 0; j < columnas; j++) {
                            datos[i][j] = dato[j];
                        }
                        bandera = true;
                    }
                }
                numDatos++;
            }
            cuenta++;
        }
        bfs.close();
        return datos;
    }

}
