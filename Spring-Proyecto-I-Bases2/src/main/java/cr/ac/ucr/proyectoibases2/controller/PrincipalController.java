package cr.ac.ucr.proyectoibases2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.proyectoibases2.business.FarmacoBusiness;
import cr.ac.ucr.proyectoibases2.domain.Farmaco;

@Controller
public class PrincipalController {
    @Autowired
    private FarmacoBusiness farmacoBusiness;
    private List<Farmaco> farmacoList;
    @RequestMapping(value = {"/Principal"}, method = RequestMethod.GET)
    public String Principal(Model model) {
        farmacoList = farmacoBusiness.GetAllFarmacos();
        model.addAttribute("farmaco", farmacoList);
        return "Principal";
    }

    public int recorreID() {
        int id = 0;
        farmacoList = farmacoBusiness.GetAllFarmacos();
        for (Farmaco f : farmacoList) {
            id = f.getId();
        }
        return id;
    }

    public String recorreNombre() {
        String nombre = "";
        farmacoList = farmacoBusiness.GetAllFarmacos();
        for (Farmaco f : farmacoList) {
            nombre = f.getNombre();
        }
        return nombre;
    }

    public String recorreDesarrollador() {
        String desarrollador = "";
        farmacoList = farmacoBusiness.GetAllFarmacos();
        for (Farmaco f : farmacoList) {
            desarrollador = f.getDesarrollador();
        }
        return desarrollador;
    }

    public String recorreIndicaciones() {
        String indicaciones = "";
        farmacoList = farmacoBusiness.GetAllFarmacos();
        for (Farmaco f : farmacoList) {
            indicaciones = f.getIndicaciones();
        }
        return indicaciones;
    }

}
