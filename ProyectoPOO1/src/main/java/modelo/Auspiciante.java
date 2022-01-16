package modelo;
public class Auspiciante extends Persona{  
  private String webpage;
  private String codigo;

  public Auspiciante(){
    super();
  }
 

  public Auspiciante(String n,String d,String t, Ciudad c,String e, String w){
    super(n,d,t,c,e);
    webpage=w;
    
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


}