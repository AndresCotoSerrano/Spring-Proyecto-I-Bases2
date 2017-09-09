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
    @RequestMapping(value = {"/Principal"}, method = RequestMethod.GET)
    public String Principal(Model model) {

        return "Principal";
    }


}
