package modelo;
public class Mascota{
    private String nombre;
    private TipoAnimal tipo;
    private String raza;
    private String foto;
    private String nacimiento;
    private String codigo;
    private DueñoDeMascota dueno;

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

    public String getCodigo() {
        return codigo;
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
}
