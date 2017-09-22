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
    public HashMap<String, String> mapaNombres;
    public HashMap<String, String[]> mapaColumnas;
    public HashMap<String, String[][]> mapaDatos;

    public void crearArchivo(String nombre) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(RUTA + nombre));
            this.nombre = nombre;
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HashMap<String,String> llenaHashNombreTabla(String archivo) throws FileNotFoundException, IOException {
        mapaNombres = new HashMap<String, String>();
        String nombre = "";
        String sCadena = "";
        int contador = 1;
        BufferedReader bf = new BufferedReader(new FileReader(RUTA+archivo));
        while ((sCadena = bf.readLine()) != null) {
            if (contador == 1) {
                nombre = sCadena;
                ++contador;
                break;
            }
        }
        bf.close();
        mapaNombres.put(archivo, nombre);
       return mapaNombres;

    }

    public HashMap<String,String[]> llenaHashNombreColumna(String archivo) throws FileNotFoundException, IOException {
        mapaColumnas = new HashMap<String, String[]>();
        String[] columnas = new String[0];
        String sCadena = "";
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
        return mapaColumnas;
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

    public HashMap <String,String[][]> llenaHashDatosTabla(String archivo) throws FileNotFoundException, IOException {
        mapaDatos = new HashMap<String, String[][]>();
        String[][] datos;
        String linea = "";
        String[] dato = new String[0];
        String sCadena = "";
        int cont = 1;
        int contador = 1;
        int cuenta = 1;

        BufferedReader bf = new BufferedReader(new FileReader(RUTA + archivo));

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
        BufferedReader bfs = new BufferedReader(new FileReader(RUTA+archivo));
        datos = new String[(cont/2)+1][columnas];
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
        return mapaDatos;

    }

}
