package cr.ac.ucr.proyectoibases2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.proyectoibases2.data.ArchivosData;

@Controller
public class PrincipalController {

    ArchivosData archivosdata = new ArchivosData();

    @RequestMapping(value = { "/Principal" }, method = RequestMethod.GET)
    public String Principal(Model model) {
        return "Principal";
    }

    @RequestMapping(value = "/Principal", method = RequestMethod.POST)
    public String recibeQuery(@RequestParam("query") String query, Model model) {

        String[] auxQuery = query.split(" ");
        String auxSelect = select(auxQuery);
        String[] auxSplitSelect = auxSelect.split("select");
        String select = converToString(auxSplitSelect);
        // System.out.println(select);
        // aca funciona perfectamente enviar la parte del select
        String auxFrom = from(auxQuery);
        String[] auxSplitFrom = auxFrom.split("from");
        String from = converToString(auxSplitFrom);
        // System.out.println(from);
        // aca funciona perfectamente enviar la parte del from
        String auxWhere = where(auxQuery);
        String[] auxSplitWhere = auxWhere.split("where");
        String where = converToString(auxSplitWhere);
        // System.out.println(where);
        // aca funciona perfectamente enviar la parte del where
        // mostrar(archivosdata.cargarArrayNombre(from));
        // mostrar(archivosdata.cargarArrayColumna(from));
        // mostrar(archivosdata.cargarArrayDato(from));
        // model.addAttribute("query",query(select,from,where));
        model.addAttribute("listQuery", mostrarMatriz(query(select, from, where)));
        System.out.println(matrizToArray(query(select, from, where)));
        return "Principal";
    }

    public String mostrarMatriz(String[][] m) {
        String result="";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {

                 result+= m[i][j];
            }
        }
        return result;
    }

    public void mostrar(ArrayList<java.lang.String> consulta) {
        for (String recorre : consulta) {
            System.out.println(recorre);
        }
    }

    public String converToString(String[] consulta) {
        String result = "";
        for (String s : consulta) {
            result += s;
        }
        return result;
    }

    public String select(String[] consulta) {
        String result = "";
        for (String select : consulta) {
            if (select.equalsIgnoreCase("select")) {
                continue;
            } else if (select.equalsIgnoreCase("from")) {
                break;
            }

            result += select;
        }

        return result;
    }

    public String from(String[] consulta) {
        String result = "";
        for (String from : consulta) {
            if (from.equalsIgnoreCase("where")) {
                break;
            }
            result += from;
        }
        int inicio = result.indexOf("from");
        String substring = result.substring(inicio);
        return substring;
    }

    public String where(String[] consulta) {
        String result = "";
        for (String where : consulta) {
            result += where;
        }
        int inicio = result.indexOf("where");
        String substring = result.substring(inicio);
        return substring;
    }

    public String[][] ejecutarSelect(String consulta, String[] tabla, String[][] datos){
    	 
        String[] tamanoConsulta = consulta.split(",");
        int cantidadVariables = 0;
        String[][] respuesta = new String[datos.length][tamanoConsulta.length];
        String[] aux = new String[tabla.length];
        
        cantidadVariables = tamanoConsulta.length;
        if(cantidadVariables == 1){
            aux = selectUnico(consulta, datos, tabla);
            for (int i = 0; i < aux.length; i++) {
                respuesta[i][0] = aux[i];
            }
        }else{
            String[][] auxMatriz = selectMultiple(consulta, tabla, datos);
            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < auxMatriz[i].length; j++) {
                    respuesta[i][j] = auxMatriz[i][j];
                }
            }
        }
        return respuesta;
    }
    
    public String[] selectUnico(String consulta, String[][] datos, String[] columnas){
        int posicion = 0;
        String[] result = new String[datos.length];
        
        
        for (int i = 0; i < columnas.length; i++) {
           if(consulta.equalsIgnoreCase(columnas[i])){
               posicion = i;
           }
        }
        
        for (int i = 0; i < datos.length; i++) {
            result[i] = datos[i][posicion];
        }
        return result;
    }

    public String[][] selectMultiple(String consulta, String[] tabla, String[][] datos){
        
        String[] tamanoConsulta = consulta.split(",");
        String[][] respuesta = new String[datos.length][tamanoConsulta.length];
        
        for (int i = 0; i < tamanoConsulta.length; i++) {
            String[] aux = selectUnico(tamanoConsulta[i], datos, tabla);
            
            for (int j = 0; j < datos.length; j++) {
                respuesta[j][i] = aux[j];
            }   
        }
        return respuesta;
    }

    public String[][] query(String select, String from, String where) {

        String[][] res = new String[0][0];
        String[][] datos = new String[0][0];
        String[] cantidadTablas = from.split(";");
        String[] cantidadVariables = select.split(";");
        ArrayList<String> columnas = new ArrayList<>();
        ArrayList<String> datosTemp;
        String data = "";
        String[] columnasFrom;

        if (cantidadTablas.length <= 1) {
        	columnas = archivosdata.cargarArrayColumna(from);
        	columnasFrom = ArrayListToArray(columnas);
        	datosTemp = archivosdata.cargarArrayDato(from);
        	data = generarDatos(datosTemp); 
        	datos = crearMatrizDatos(columnasFrom, data);
        	
        	res = ejecutarSelect(select, columnasFrom, datos);
        }

        return res;
    }

    public String[][] crearMatrizDatos(String[] columnas, String datos) {

        String[] aux = datos.split(",");
        String[][] res = new String[aux.length / columnas.length][columnas.length];
        int contador = 0;
        for (int i = 0; i < aux.length / columnas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                res[i][j] = aux[contador];
                contador++;
            }

        }
        return res;
    }

    public String generarDatos(ArrayList<String> datosTemp) {
        String resp = "";
        for (String res : datosTemp) {
            resp += res;
        }
        return resp;
    }

    public ArrayList<String> matrizToArray(String[][] datos) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[0].length; j++) {
                res.add(datos[i][j]);
            }
        }
        return res;
    }
    
    public String[] ArrayListToArray(ArrayList<String> prueba){
        
        String aux = "";
        for (String res : prueba) {
            aux += res;
        }
        String[] respuesta = aux.split(",");
        return respuesta;
    }
    
}
