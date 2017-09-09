package cr.ac.ucr.proyectoibases2.data;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cr.ac.ucr.proyectoibases2.domain.Farmaco;
@Repository
public class FarmacoData {
    public List<Farmaco> GetAllFarmacos(){
        LinkedList<Farmaco> farmacoTable= new LinkedList<Farmaco>();
        
        for(int i=0;i<=5;i++) {
            Farmaco f= new Farmaco(i,"Farmaco" + i, "Desarrollador" + i, "Indicaciones" + i);
            farmacoTable.add(f);
        }
        
        return farmacoTable;
    }
}
