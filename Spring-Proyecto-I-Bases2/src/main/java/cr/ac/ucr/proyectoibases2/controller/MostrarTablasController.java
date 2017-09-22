package cr.ac.ucr.proyectoibases2.controller;

import java.util.ArrayList;
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

    @RequestMapping(value = { "/MostrarTablas" }, method = RequestMethod.GET)
    public String mostrarTablas(Model model) {
        String archivo = CargarArchivoController.NOMBRE_ARCHIVO;
        model.addAttribute("nombreTabla",archivosdata.cargarArrayNombreTabla(archivo));
       model.addAttribute("columnaTabla",archivosdata.cargarArrayColumnaTabla(archivo));
       model.addAttribute("datoTabla",archivosdata.cargarArrayDatoTabla(archivo));

        return "MostrarTablas";
    }

    public void recorreArrayNombre(ArrayList<java.lang.String> nombre) {
        if (nombre.isEmpty()) {
            System.out.println("vacio");
        } else {
            for (String n : nombre) {
                System.out.println(n);
            }
        }
    }

    public void recorreArrayColumna(ArrayList<java.lang.String> columna) {
        for (String c : columna) {
            System.out.println(c);
        }
    }

    public void recorreArrayDato(ArrayList<java.lang.String> dato) {
        for (String d : dato) {
            System.out.println(d);
        }
    }
}
