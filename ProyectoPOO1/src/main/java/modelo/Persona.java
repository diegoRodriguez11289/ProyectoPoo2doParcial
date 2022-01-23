package modelo;

import java.io.Serializable;

public  class Persona implements Serializable{
  public String nombre;
  public String direccion;
  public String telefono;
  public Ciudad ciudad;
  public String email;


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    public Ciudad getCiudad(){
        return ciudad;
    
    }

 public Persona(){}

  public Persona(String n,String d,String t, Ciudad c,String e){
    nombre=n;
    direccion=d;
    telefono=t;
    ciudad=c;
    email=e;
  }


  

  public void  setNombre(String nom){
    nombre=nom;
    
  }

  public void setDireccion(String dir){
    direccion=dir;

  }

  public void setTelefono(String tel){
    telefono=tel;
  }

  public void setEmail(String em){
    email=em;
  }

  public void setCiudad(Ciudad ciu){
    ciudad=ciu;
  }

  @Override
  public String toString(){
    return nombre;
  }

  


 
  
}