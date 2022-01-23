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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ciudad implements Serializable{
  private String nombre;
  private String provincia;
  private String codigo;

  public Ciudad(String n, String p){
    nombre=n;
    provincia=p;
  }
    public Ciudad(String n){
    nombre=n;
    
  }
    public Ciudad(String n,String p,String cod){
    nombre=n;
    codigo=cod;
    provincia=p;
    
  }

    public String getNombre() {
        return nombre;
    }
  

    

    public String getCodigo() {
        return codigo;
    }

    public String getProvincia() {
        return provincia;
    }
  
  

  

   public void setNombre(String n) {
        nombre = n;
    }

    public void setProvincia(String p) {
        provincia = p;
    }
  @Override
   public String toString(){
       return nombre;
   
   }
   
   
  @Override
       public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
   
   
   
   
   
   
  @Override
   public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ciudad other = (Ciudad) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

  /*public String toString(){
    return ", ciudad: "+nombre+", Provincia: "+provincia;
  }
*/

    public static ArrayList<Ciudad> cargarCiudades(String ruta) {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        
       
        try(InputStream input = Ciudad.class.getClassLoader().getResourceAsStream(ruta);
                BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String linea = null;
            
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                ciudades.add(new Ciudad(info[1],info[2],info[0]));
                        
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutciudades))){
            out.writeObject(ciudades);
            out.flush();


       
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
        
        return ciudades;
   
    }
   
   
     public String generarCodigo(String nom,  String prov) {
        String n1 = nom.substring(0, 2);
        String em1 = prov.substring(0, 2);
        String a1 = prov.substring(0, 2);
        
        
        codigo=n1 + em1 +a1 ;
        return codigo;
    }
   
   public static ArrayList<Ciudad> cargarCiudades2(String ruta) {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de personas del archivo serSializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            ciudades = (ArrayList<Ciudad>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return ciudades;
    } 
   
   
       public static ArrayList<String> cargarProvincias(String ruta) {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        ArrayList<String> provincias = new ArrayList<>();
       
        try(InputStream input = Ciudad.class.getClassLoader().getResourceAsStream(ruta);
                BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String linea = null;
            
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                ciudades.add(new Ciudad(info[1],info[2],info[0]));
                provincias.add(info[2]);
                        
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return provincias;
       }
   
   public static ArrayList<String> cargarProvincias2(String ruta) {
       ArrayList<Ciudad> ciudades = Ciudad.cargarCiudades2(App.rutciudades);
       ArrayList<String> provincias = new ArrayList<>();
       for (int x = 0; x < ciudades.size(); x++) {
           
             provincias.add(ciudades.get(x).getProvincia());
           

       }
     Set<String> set = new HashSet<>(provincias);
     provincias.clear();
     provincias.addAll(set);
     return provincias;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
