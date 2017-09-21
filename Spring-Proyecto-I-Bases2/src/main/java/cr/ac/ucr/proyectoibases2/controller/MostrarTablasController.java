package cr.ac.ucr.proyectoibases2.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    HashMap<String, String> HashNombres = archivosdata.mapaNombres;
    HashMap<String, String[]> HashColumnas = archivosdata.mapaColumnas;
    HashMap<String, String[][]> HashDatos = archivosdata.mapaDatos;

    @RequestMapping(value = { "/MostrarTablas" }, method = RequestMethod.GET)
    public String mostrarTablas(Model model) {
        mostrar(columnasTabla());
        //leerHashMaps(HashNombres, HashColumnas, HashDatos);
        return "MostrarTablas";
    }

    public void leerHashMaps(HashMap<String, String> nombre, HashMap<String, String[]> columna,
            HashMap<String, String[][]> dato) {
        String nombres = "";
        String columnas = "";
        String datos = "";
        Iterator<Entry<String, String>> it = nombre.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            nombres += entry.getValue();
        }
        System.out.println("nombre de las tablas :" + nombres);
        Iterator<Entry<String, String[]>> it1 = columna.entrySet().iterator();
        while (it1.hasNext()) {
            Entry<String, String[]> entry1 = it1.next();
            columnas += entry1.getValue();
        }
        System.out.println("columnas de la tabla :" + columnas);
        Iterator<Entry<String, String[][]>> it2 = dato.entrySet().iterator();
        while (it2.hasNext()) {
            Entry<String, String[][]> entry2 = it2.next();
            datos += entry2.getValue();
        }
        System.out.println("datos de la tabla :" + datos);
    }

    public String[] columnasTabla() {
        String[] aux = new String[0];
        Iterator<Entry<String, String[]>> it = HashColumnas.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String[]> entry = it.next();
            String[] auxRes = entry.getValue();
            aux = auxRes;
        }
        return aux;
    }

    public void mostrar(String[] consulta) {
        for (String recorre : consulta) {
            System.out.println(recorre + "holi");
        }
    }

}
