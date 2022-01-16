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
import java.util.Objects;
import javafx.scene.control.Alert;

public class DueñoDeMascota  extends Persona implements Serializable{
  private String apellidos;
  private String ci;

    public String getApellidos() {
        return apellidos;
    }

    public String getCi() {
        return ci;
    }
    
    

  public DueñoDeMascota(String n,String d,String t, Ciudad c,String e,String a,String ci){
    super(n,d,t,c,e);
    apellidos=a;
    this.ci=ci;
  }
  
  public DueñoDeMascota(String n,String d,String t, Ciudad c,String e,String a){
    super(n,d,t,c,e);
    apellidos=a;
    
  }
  
  
  
  
  

  public String getNombresApellidos(){
    return nombre +" "+ apellidos;
  }


  
  

  public void setApellidos(String ap){
    apellidos=ap;

  }
  
      public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.ci);
        return hash;
    }
  
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
        final DueñoDeMascota other = (DueñoDeMascota) obj;
        if (!Objects.equals(this.ci, other.ci)) {
            return false;
        }
        return true;
    }
  
  
  
  

  public String toString(){
    return super.toString()+", apellidos: "+apellidos+", cedula: "+ ci;

  }

      public static ArrayList<DueñoDeMascota> cargarDuenos(String ruta) {
        ArrayList<DueñoDeMascota> dueños = new ArrayList<>();
        
       
        try(InputStream input = DueñoDeMascota.class.getClassLoader().getResourceAsStream(ruta);
                BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String linea = null;
            
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                Ciudad c= new Ciudad(info[5]);
                dueños.add(new DueñoDeMascota(info[2],info[3],info[4],c,info[6],info[1],info[0]));
                        
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutDuenos))){
            out.writeObject(dueños);
            out.flush();


       
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
        
        
        
       return dueños;
    }

      
       public static ArrayList<DueñoDeMascota> cargarDuenos2(String ruta) {
        ArrayList<DueñoDeMascota> dueños = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            dueños = (ArrayList<DueñoDeMascota>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return dueños;
    }   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
  public String generarCodigo(String nom, String tel, String em, String a) {
        String n1 = nom.substring(0, 2);
        String t1 = tel.substring(4, 6);
        String em1 = em.substring(0, 2);
        String a1 = em.substring(0, 2);
        
        
        ci=n1 + em1 +a1 + t1;
        return ci;
    }
      
      
      
      
      
      
      
      
}