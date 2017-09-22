package cr.ac.ucr.proyectoibases2.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.proyectoibases2.data.ArchivosData;

@Controller
public class MostrarTablasController {
    // @Autowired
    ArchivosData archivosdata = new ArchivosData();
   // HashMap<String, String> HashNombres = archivosdata.MAPA_NOMBRES;
   // HashMap<String, String[]> HashColumnas = archivosdata.MAPA_COLUMNAS;
   // HashMap<String, String[][]> HashDatos = archivosdata.MAPA_DATOS;

    @RequestMapping(value = { "/MostrarTablas" }, method = RequestMethod.GET)
    public String mostrarTablas(Model model) {
        //leerHashMaps(HashNombres, HashColumnas, HashDatos);
        return "MostrarTablas";
    }

    public void leerHashMaps(HashMap<String, String> nombre, HashMap<String, String[]> columna,
            HashMap<String, String[][]> dato) {
        if (!nombre.isEmpty()) {
            for (String n : nombre.values()) {
                System.out.println("nombres" + n);
            }
        } else {
            System.out.println("esta vacio");
        }
        if (!columna.isEmpty()) {
            for (String[] n : columna.values()) {
                System.out.println("columnas" + n);
            }
        } else {
            System.out.println("esta vacio");
        }
        if (!dato.isEmpty()) {
            for (String[][] n : dato.values()) {
                System.out.println("datos" + n);
            }
        } else {
            System.out.println("esta vacio");
        }

    }

    public void mostrar(String[] consulta) {
        for (String recorre : consulta) {
            System.out.println(recorre + "holi");
        }
    }

}
