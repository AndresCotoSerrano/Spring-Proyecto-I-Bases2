package cr.ac.ucr.proyectoibases2.controller;

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

CargarArchivoController cargararchivo;
    @RequestMapping(value = { "/Principal" }, method = RequestMethod.GET)
    public String Principal(Model model) {
        return "Principal";
    }

    @RequestMapping(value = "/Principal", method = RequestMethod.POST)
    public String recibeQuery(@RequestParam("query") String query) {

        String[] auxQuery = query.split(" ");
        String auxSelect = select(auxQuery);
        String[] auxSplitSelect = auxSelect.split("select");
        String select = converToString(auxSplitSelect);
        System.out.println(select);
        // aca funciona perfectamente enviar la parte del select
        String auxFrom = from(auxQuery);
        String[] auxSplitFrom = auxFrom.split("from");
        String from = converToString(auxSplitFrom);
        System.out.println(from);
        // aca funciona perfectamente enviar la parte del from
        String auxWhere = where(auxQuery);
        String[] auxSplitWhere = auxWhere.split("where");
        String where = converToString(auxSplitWhere);
        System.out.println(where);
        // aca funciona perfectamente enviar la parte del where
        return "Principal";
    }


    public void mostrar(String[] consulta) {
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

    public String[][] ejecutarSelect(String consulta, String[] tabla, String[][] datos) {

        String[] tamanoConsulta = consulta.split(",");
        int cantidadVariables = 0;
        String[][] respuesta = new String[datos.length][tamanoConsulta.length];
        String[] aux = new String[tabla.length];

        cantidadVariables = tamanoConsulta.length;
        if (cantidadVariables == 1) {
            aux = selectUnico(consulta, datos, tabla);
            for (int i = 0; i < aux.length; i++) {
                respuesta[i][0] = aux[i];
            }
        } else {
            String[][] auxMatriz = selectMultiple(consulta, tabla, datos);
            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < auxMatriz[i].length; j++) {
                    respuesta[i][j] = auxMatriz[i][j];
                }
            }
        }
        return respuesta;
    }

    public String[] selectUnico(String consulta, String[][] datos, String[] columnas) {
        int posicion = 0;
        String[] result = new String[datos.length];

        for (int i = 0; i < columnas.length; i++) {
            if (consulta.equalsIgnoreCase(columnas[i])) {
                posicion = i;
            }
        }

        for (int i = 0; i < datos.length; i++) {
            result[i] = datos[i][posicion];
        }
        return result;
    }

    public String[][] selectMultiple(String consulta, String[] tabla, String[][] datos) {

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

}
