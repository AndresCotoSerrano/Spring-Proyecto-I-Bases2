package cr.ac.ucr.proyectoibases2.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cr.ac.ucr.proyectoibases2.data.ArchivosData;

@Controller
public class CargarArchivoController {
    private String url = "src/main/resources/static/files";
    ArchivosData archivosdata;

    @RequestMapping(value = { "/CargarArchivo" }, method = RequestMethod.GET)
    public String Principal(Model model) {
        return "CargarArchivo";
    }

    // Metodo asincrono con ajax
    @RequestMapping(value = "/cargarArchivo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> cargarArchivo(@RequestParam("cargararchivo") MultipartFile cargararchivo) {
        System.out.println("Cargando...");
        try {
            // Path y nombre original del archivo
            String filename = cargararchivo.getOriginalFilename();
            String filepath = Paths.get(url, filename).toString();

            // guarda el archivo en la carpeta static
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(cargararchivo.getBytes());
            stream.close();
            System.out.println("Successfull");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    } // metodo uploadFile

    @RequestMapping(value = "/cargarArchivo")
    @ResponseBody
    public void cargaArchivo(@RequestParam("cargararchivo") MultipartFile cargararchivo) {
            try {
                archivosdata.llenaHashNombreColumna(cargararchivo.getOriginalFilename());
                archivosdata.llenaHashNombreColumna(cargararchivo.getOriginalFilename());
                archivosdata.llenaHashDatosTabla(cargararchivo.getOriginalFilename());
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
               System.out.println(cargararchivo.getOriginalFilename());
            }

    }
}
