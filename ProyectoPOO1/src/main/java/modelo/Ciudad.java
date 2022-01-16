package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Ciudad implements Serializable{
  private String nombre;
  private String provincia;

  public Ciudad(String n, String p){
    nombre=n;
    provincia=p;
  }
    public Ciudad(String n){
    nombre=n;
    
  }

  public String getNomCiudad(){
    return nombre;
  }

  public String getNomProvincia(){
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
                ciudades.add(new Ciudad(info[1],info[2]));
                        
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        return ciudades;
   
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
