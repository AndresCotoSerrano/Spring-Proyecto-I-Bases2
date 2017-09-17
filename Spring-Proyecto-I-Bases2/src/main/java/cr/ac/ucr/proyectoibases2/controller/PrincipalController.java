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
        //aca funciona perfectamente enviar la parte del from
        String auxWhere = where(auxQuery);
        String[] auxSplitWhere = auxWhere.split("where");
        String where = converToString(auxSplitWhere);
        System.out.println(where);
        //aca funciona perfectamente enviar la parte del where
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
}
