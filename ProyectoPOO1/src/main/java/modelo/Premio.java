package modelo;
public class Premio{
  private String lugarPremio;
  private String descripcion;
  private Auspiciante auspiciante;

  public Premio(String lugarPremio,String descripcion){
    this.lugarPremio=lugarPremio;
    this.descripcion=descripcion;
  }

  public Premio(String lugarPremio,String descripcion, Auspiciante auspiciante){
    this.lugarPremio=lugarPremio;
    this.descripcion=descripcion;
    this.auspiciante=auspiciante;
  }

  public String getLugarPremio(){
    return lugarPremio;
  }

  public void setLugarPremio(String lugarPremio){
    this.lugarPremio=lugarPremio;
  }
  
  public String getDescripcion(){
    return descripcion;
  }

  public void setDescripcion(String descripcion){
    this.descripcion=descripcion;
  }

   public Auspiciante getAuspiciante(){
    return auspiciante;
  }

  public void setAuspiciante(Auspiciante auspiciante){
    this.auspiciante=auspiciante;
  }

}