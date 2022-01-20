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

public class Auspiciante extends Persona implements Serializable{  
  private String webpage;
  private String codigo;

  public Auspiciante(){
    super();
  }
 

  public Auspiciante(String n,String d,String t, Ciudad c,String e, String w){
    super(n,d,t,c,e);
    webpage=w;
    
  }
  
    public Auspiciante(String n,String d,String t, Ciudad c,String e, String w,String cod){
    super(n,d,t,c,e);
    webpage=w;
    codigo= cod;
    
  }
  
  
  
  public String getWebpage(){
    return webpage;

  }

  public String getCodigo(){
    return codigo;
  }

  public void setWebpage(String webp){
    webpage=webp;

  }

  public String toString(){
    return super.toString()+" webpage:"+webpage;
  }

  
        public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final Auspiciante other = (Auspiciante) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
      
      public static ArrayList<Auspiciante> cargarAuspiciantes(String ruta) {
        ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
        
       
        try(InputStream input = Auspiciante.class.getClassLoader().getResourceAsStream(ruta);
                BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String linea = null;
            
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(";");//separar los datos por coma
                //crear objeto y agregar a la lista
                Ciudad c= new Ciudad(info[4]);
                auspiciantes.add(new Auspiciante(info[1],info[2],info[3],c,info[4],info[6],info[0]));
                        
            }
        }  catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }  catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } 
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.rutAuspiciantes))){
            out.writeObject(auspiciantes);
            out.flush();


       
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
        
        
        
       return auspiciantes;
    }

      
       public static ArrayList<Auspiciante> cargarAuspiciantes2(String ruta) {
        ArrayList<Auspiciante> auspiciantes = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            auspiciantes = (ArrayList<Auspiciante>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return auspiciantes;
    }   
      
      
      
      
  
  public String generarCodigo(String nom, String tel, String em, String w) {
        String n1 = nom.substring(0, 2);
        String t1 = tel.substring(4, 6);
        String em1 = em.substring(0, 2);
        String a1 = w.substring(0, 2);
        
        
        codigo=n1 + em1 +a1 + t1;
        return codigo;
    }
  
  
  
  
  
  
  
  
  
  
  
  

}