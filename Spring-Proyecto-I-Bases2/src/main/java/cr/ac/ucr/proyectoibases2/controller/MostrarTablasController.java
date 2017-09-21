package cr.ac.ucr.proyectoibases2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MostrarTablasController {
   // @Autowired
    //private FarmacoBusiness farmacoBusiness;
    //private List<Farmaco> farmacoList;
   @RequestMapping(value = { "/MostrarTablas" }, method = RequestMethod.GET)
    public String mostrarTablas(Model model) {
      //  farmacoList = farmacoBusiness.GetAllFarmacos();
      //  Farmaco f = new Farmaco();
      //  model.addAttribute("farmaco", farmacoList);
      //  model.addAttribute("name", f.getClass().getSimpleName());
      return "MostrarTablas";
   }
}
