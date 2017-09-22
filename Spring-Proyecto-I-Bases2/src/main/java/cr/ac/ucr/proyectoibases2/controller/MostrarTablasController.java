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
    CargarArchivoController cac = new CargarArchivoController();
    HashMap<String, String> HashNombres = cac.HashNombres;
    HashMap<String, String[]> HashColumnas = cac.HashColumnas;
    HashMap<String, String[][]> HashDatos = cac.HashDatos;

    @RequestMapping(value = { "/MostrarTablas" }, method = RequestMethod.GET)
    public String mostrarTablas(Model model) {
        leerHashMaps(HashNombres, HashColumnas, HashDatos);
        return "MostrarTablas";
    }

    public void leerHashMaps(HashMap<String, String> nombre, HashMap<String, String[]> columna,
            HashMap<String, String[][]> dato) {
        String nombres = "";
        String columnas = "";
        String datos = "";
        if (nombre.isEmpty()) {
            System.out.println("esta vacio" + nombre.entrySet());
        } else {
            Iterator it = nombre.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                System.out.println("Nombre tablas: " + e.getKey() + " " + e.getValue());
            }
        }
        if (columna.isEmpty()) {
            System.out.println("esta vacio" + columna.entrySet());
        } else {
            Iterator it1 = columna.entrySet().iterator();
            while (it1.hasNext()) {
                Map.Entry c = (Map.Entry) it1.next();
                System.out.println("Nombres Columna: " + c.getKey() + " " + c.getValue());
            }
        }
        if (dato.isEmpty()) {
            System.out.println("esta vacio" + dato.entrySet());
        } else {

            Iterator it2 = dato.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry d = (Map.Entry) it2.next();
                System.out.println("Todos datos" + d.getKey() + " " + d.getValue());
            }
        }
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
