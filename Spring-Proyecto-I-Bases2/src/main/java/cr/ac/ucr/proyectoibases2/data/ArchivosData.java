package cr.ac.ucr.proyectoibases2.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArchivosData {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String nombre;
    public final String RUTA = "src/main/resources/static/files/";
    public ArrayList<java.lang.String> LeerArchivo(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo;

        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    datos.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public ArrayList<java.lang.String> cargarArrayNombre(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo + ".csv";
        int contador = 0;
        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    if (contador == 0) {
                        datos.add(line);
                        contador++;
                    } else {
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public ArrayList<java.lang.String> cargarArrayNombreTabla(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo;
        int contador = 0;
        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    if (contador == 0) {
                        datos.add(line);
                        contador++;
                    } else {
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public ArrayList<java.lang.String> cargarArrayColumna(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo + ".csv";
        int contador = 0;
        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    if (contador == 1) {
                        datos.add(line);
                        contador++;
                    }
                    if (contador == 2) {
                        break;
                    }
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public ArrayList<java.lang.String> cargarArrayColumnaTabla(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo;
        int contador = 0;
        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    if (contador == 1) {
                        datos.add(line);
                        contador++;
                    }
                    if (contador == 2) {
                        break;
                    }
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public ArrayList<java.lang.String> cargarArrayDato(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo + ".csv";
        int contador = 0;
        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {

                    if (contador == 2 || contador > 2) {
                        datos.add(line);
                    }
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public ArrayList<java.lang.String> cargarArrayDatoTabla(String archivo) {

        BufferedReader br = null;
        String line = "";
        ArrayList<String> datos = new ArrayList<>();
        String file = "src/main/resources/static/files/" + archivo;
        int contador = 0;
        try {
            File f = new File(file);
            if (f.exists()) {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {

                    if (contador == 2 || contador > 2) {
                        datos.add(line);
                    }
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

}
