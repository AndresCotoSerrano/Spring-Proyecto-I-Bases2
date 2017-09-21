package cr.ac.ucr.proyectoibases2.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class ArchivosData {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String nombre;
    public final String RUTA = "src/main/resources/static/files/";
    public HashMap<String, String> mapaNombres =new HashMap<String, String>();
    public HashMap<String, String []> mapaColumnas = new HashMap<String, String[]>();
    public HashMap<String, String [][]> mapaDatos = new HashMap<String, String[][]>();


    public void crearArchivo(String nombre) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(RUTA + nombre));
            this.nombre = nombre;
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void llenaHashNombreTabla(String archivo) throws FileNotFoundException, IOException {
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
        mapaNombres.put(archivo, nombre);
    }

    public void llenaHashNombreColumna(String archivo) throws FileNotFoundException, IOException {
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
        mapaColumnas.put(archivo, columnas);
    }

    public String leerArchivo(String nombre) throws IOException {
        String result = "";

        String sCadena = null;
        BufferedReader bf = new BufferedReader(new FileReader(RUTA + nombre));
        while ((sCadena = bf.readLine()) != null) {
            result += sCadena + "\n";
        }
        result.replaceAll(" ", "");
         bf.close();
         return result;
    }

    public void llenaHashDatosTabla(String nombre) throws FileNotFoundException, IOException {
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
        mapaDatos.put(nombre, datos);
    }

}
