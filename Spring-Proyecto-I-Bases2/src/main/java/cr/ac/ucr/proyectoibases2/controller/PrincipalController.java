package cr.ac.ucr.proyectoibases2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrincipalController {
    @RequestMapping(value = { "/Principal" }, method = RequestMethod.GET)
    public String Principal(Model model) {
        return "Principal";
    }

    @RequestMapping(value = "/Principal", method = RequestMethod.POST)
    public String recibeQuery(@RequestParam("query") String query) {
        String[] auxSelect = query.split("select");
        String aux = converToString(auxSelect);
        String[] auxFrom = aux.split("from");
        String aux1 = converToString(auxFrom);
        String[] auxWhere = aux1.split("where");
        String aux2 = converToString(auxWhere);
        String[] consulta = aux2.split(",");
        String auxConsulta = converToString(consulta);
        String[] result = auxConsulta.split(" ");
        mostrar(result);
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
            result += s + "\n";
        }
        return result.trim();
    }

}
