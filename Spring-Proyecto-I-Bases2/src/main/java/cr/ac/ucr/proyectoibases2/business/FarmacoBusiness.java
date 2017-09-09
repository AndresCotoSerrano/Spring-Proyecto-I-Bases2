package cr.ac.ucr.proyectoibases2.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cr.ac.ucr.proyectoibases2.data.FarmacoData;
import cr.ac.ucr.proyectoibases2.domain.Farmaco;

@Service
public class FarmacoBusiness {

    @Autowired
    private FarmacoData farmacoData;
    
    public List<Farmaco> GetAllFarmacos(){
        return farmacoData.GetAllFarmacos();
    }
}
