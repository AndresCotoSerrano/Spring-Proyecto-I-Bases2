package cr.ac.ucr.proyectoibases2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PrincipalController {

    @RequestMapping(value = {"/","Welcome","/badSQL","/Principal"}, method = RequestMethod.GET)
    public String Principal(Model model) {
        return "Principal";
    }
}




