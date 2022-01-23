package modelo;

import com.mycompany.proyectopoo.App;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mascota{
    private String nombre;
    private TipoAnimal tipo;
    private String raza;
    private String foto;
    private String nacimiento;
    private String codigo;
    private DueñoDeMascota dueno;
    private String duenoNombre;
    
    public Mascota(String n, TipoAnimal t, String r, String na) {
        nombre = n;
        tipo = t;
        raza = r;
        nacimiento = na;    }

    public Mascota(String n, TipoAnimal t, String r, String na, DueñoDeMascota d, String cod) {
        nombre = n;
        tipo = t;
        raza = r;
        dueno = d;
        nacimiento = na;
        codigo = cod;
    }
    
     public Mascota(String cod, String n ,TipoAnimal t, String dn) {
        nombre = n;
        tipo = t;
        duenoNombre = dn;
        codigo = cod;
    }

    public String getCodigo() {
        return codigo;
    }
    
     public String getDuenoNombre() {
        return duenoNombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public String getFoto() {
        return foto;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setTipo(TipoAnimal t) {
        tipo = t;
    }

    public void setRaza(String r) {
        raza = r;
    }

    public void setFoto(String f) {
        foto = f;
    }

    public void setNacimiento(String na) {
        nacimiento = na;
    }

    public DueñoDeMascota getDueno() {
        return dueno;
    }

    public void setDueno(DueñoDeMascota d) {
        dueno = d;
    }


    public String generarCodigo(String n, TipoAnimal t, String r, String na) {
        String n1 = n.substring(0, 2);
        String r1 = r.substring(0, 2);
        codigo=n1 + t + r1 + na;
        return codigo;
    }
    
       public static ArrayList<Mascota> cargarMascotas(String ruta1) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        ArrayList<DueñoDeMascota> dueno = new ArrayList<>(DueñoDeMascota.cargarDuenos(App.rutDuenoscsv));



        try (InputStream input = Mascota.class.getClassLoader().getResourceAsStream(ruta1);
                BufferedReader br1 = new BufferedReader(new InputStreamReader(input))) {
                String linea = null;
                br1.readLine();
                while ((linea = br1.readLine()) != null) //iterar mientras haya lineas
                {
                    String[] info = linea.split(";");//separar los datos por coma
                    //crear objeto y agregar a la lista
                    String mayus = info[2].trim().toUpperCase();
                    TipoAnimal tip = TipoAnimal.valueOf(mayus);
                    int i =0;
                    for (DueñoDeMascota d: dueno){
                        if (info[6].equals(d.getCi())){
                            mascotas.add(new Mascota(info[0].trim(), info[1].trim(), tip, d.getNombresApellidos()));
                        }
                    } 

                    
               
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutMascotas))){
            out.writeObject(mascotas);
            out.flush();


       
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
        


        return mascotas;
    }
    
        public static ArrayList<Mascota> cargarMascotas2(String ruta) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            mascotas = (ArrayList<Mascota>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return mascotas;
    }   
      
      
    
}
