
package modelo;
import java.util.ArrayList;

public class Administrar{
  public static ArrayList<Concurso> concursos;
  public static ArrayList<DueñoDeMascota> dueños;
  public static ArrayList<Mascota> mascotas;
  public static ArrayList<Mascota> eliminadas;

public static void mostrarConcursos(){
  for (int i = 0; i<concursos.size(); i++) {
      System.out.println(concursos.get(i).getNombre()+" "+concursos.get(i).getFecha()+" "+concursos.get(i).getHora()+" "+concursos.get(i).getFechaInicio()+" "+concursos.get(i).getFechaCierre()+" "+concursos.get(i).getCiudad()+" "+concursos.get(i).getAuspiciante()+" "+concursos.get(i).getDirigidoA()+" "+concursos.get(i).getCodigoC()+"\n");
    }
}
  public static void mostrarMascotas(){
    for (int i = 0; i<mascotas.size(); i++) {
      System.out.println(mascotas.get(i).getNombre()+" "+mascotas.get(i).getTipo()+" "+mascotas.get(i).getRaza()+" "+" "+mascotas.get(i).getNacimiento()+" "+mascotas.get(i).getCodigo());

    }
  } 

  public static void mostrarDueños(){
    for (int i = 0; i<dueños.size(); i++) {
      System.out.println(dueños.get(i).toString()+"\n");

    }
  } 


public static void crearConcurso(){
    Ciudad Guayaquil= new Ciudad("Guayaquil","Guayas");
    Ciudad Cuenca= new Ciudad("Cuenca","Azogues");
    Ciudad Quito= new Ciudad("Quito","Pichincha");
    ArrayList<Auspiciante> auspiciantes= new ArrayList<>();
    Auspiciante auspiciante1=new Auspiciante("Diego Adriel","Los olivos","0994047722",Guayaquil,"diadrodr@espol.edu.ec","www.diegoflores.com");
    Auspiciante auspiciante2=new Auspiciante("Pedro Carlos","Mi casa","0993038157",Cuenca,"carlos2@gmail.com","www.pedrocarlos.com");
    Auspiciante auspiciante3=new Auspiciante("Rodrigo Andres","Sauces 5 mz109 s10","0994047722",Quito,"Rodrigo7@espol.edu.ec","www.rodrigoandres.com");
    auspiciantes.add(auspiciante1);
    auspiciantes.add(auspiciante2);
    auspiciantes.add(auspiciante3);

   concursos= new ArrayList<>();
   ArrayList<Premio> premios=new ArrayList<>();
   Premio p1 = new Premio("Primer Lugar", "$200 y productos Pronaca");
   premios.add(p1);
   Premio p2 = new Premio("Segundo Lugar", "100 y productos Pronaca");
   premios.add(p2);
   Premio p3 = new Premio("Tercer Lugar", "50 y productos Pronaca");
   premios.add(p3);
 
   Concurso concurso1= new Concurso("Concurso1","30/11/2021","12:00","25/11/2021","30/11/2021",Guayaquil,"La Roca",premios,auspiciante1,DirigidoAnimal.PERROS,"C3123GPoLa");

    DueñoDeMascota dueño1=new DueñoDeMascota("Diego Adriel","Los olivos","0994047722",Guayaquil,"diadrodr@espol.edu.ec","Rodriguez Flores","0924781081");
    DueñoDeMascota dueño2=new DueñoDeMascota("Pedro Carlos","Mi casa","0993038157",Guayaquil,"carlos2@gmail.com","Rodriguez Serra","0945308110");
    DueñoDeMascota dueño3=new DueñoDeMascota("Rodrigo Andres","Sauces 5 mz109 s10","0994047722",Guayaquil,"Rodrigo7@espol.edu.ec","Torres Valladares","0724788456");
    DueñoDeMascota dueño4=new DueñoDeMascota("Josue Cesar","Sauces 5 mz109 s11","0981234568",Guayaquil,"Josue8@espol.edu.ec","Alcivar Velasquez","0427676123");
    DueñoDeMascota dueño5=new DueñoDeMascota("John Piero","Barrio aniñado de Quito","0994047722",Quito,"jlopez1@espol.edu.ec","Lopez Sorroza","0169781276");
    Mascota mascota1 = new Mascota("Pelusa",TipoAnimal.PERRO,"French Puddle","2001", dueño1, "PePERROFr2001");
     Mascota mascota2 = new Mascota("Manchas",TipoAnimal.GATO,"Mestizo","2003",dueño2, "MaGATOMe2003");
     Mascota mascota3 = new Mascota("Pipo",TipoAnimal.PERRO,"Husky","2004",dueño3, "PiPERROHu2004");
     Mascota mascota4 = new Mascota("Misifu",TipoAnimal.GATO,"Persa","2002",dueño4, "MiGATOPe2002");
     Mascota mascota5 = new Mascota("Ladrador",TipoAnimal.PERRO,"Labrador","2005",dueño5, "LaPerroLa2005");

    

     Concurso concurso2= new Concurso("Concurso2","12/12/2021","12:00","05/11/2021","30/12/2021",Guayaquil,"La Perla",premios,auspiciante2,DirigidoAnimal.GATOS,"C11053GPoLa");
     
     concursos.add(concurso1);
     concursos.add(concurso2);
}

 public static ArrayList<DueñoDeMascota> crearListaDueños(){
    Ciudad Guayaquil= new Ciudad("Guayaquil","Guayas");
    Ciudad Cuenca= new Ciudad("Cuenca","Azuay");
    Ciudad Quito= new Ciudad("Quito","Pichincha");
    ArrayList<DueñoDeMascota> dueños= new ArrayList<>();
    DueñoDeMascota dueño1=new DueñoDeMascota("Diego Adriel","Los olivos","0994047722",Guayaquil,"diadrodr@espol.edu.ec","Rodriguez Flores","0924781081");
    DueñoDeMascota dueño2=new DueñoDeMascota("Pedro Carlos","Mi casa","0993038157",Guayaquil,"carlos2@gmail.com","Rodriguez Serra","0945308110");
    DueñoDeMascota dueño3=new DueñoDeMascota("Rodrigo Andres","Sauces 5 mz109 s10","0994047722",Guayaquil,"Rodrigo7@espol.edu.ec","Torres Valladares","0724788456");
    DueñoDeMascota dueño4=new DueñoDeMascota("Josue Cesar","Sauces 5 mz109 s11","0981234568",Guayaquil,"Josue8@espol.edu.ec","Alcivar Velasquez","0427676123");
    DueñoDeMascota dueño5=new DueñoDeMascota("John Piero","Barrio aniñado de Quito","0994047722",Quito,"jlopez1@espol.edu.ec","Lopez Sorroza","0169781276");
    DueñoDeMascota dueño6=new DueñoDeMascota("Carlos Andres","Barrio podre de Cuenca","0982345671",Cuenca,"Cflor34@espol.edu.ec","Flores Moncayo","0871235678");
    DueñoDeMascota dueño7=new DueñoDeMascota("David Jesus","Sauces 5 mz109 s13","0999876543",Guayaquil,"david17@espol.edu.ec","Vasques Almeida","1023457126");
    DueñoDeMascota dueño8=new DueñoDeMascota("Piero Harry","Samanes 3 mz123 s10","0993346689",Guayaquil,"Ppotter68@espol.edu.ec","Hincapie Potter","0341236987");
    DueñoDeMascota dueño9=new DueñoDeMascota("Antonio Walter","Preguntale a mi mama ","0988977724",Quito,"AV25@hotmail.com","Valencia Espinoza","0724788456");
    DueñoDeMascota dueño10=new DueñoDeMascota("Adolf Alejandro","Alborada 3ra etapa maz30 S27","0992431974",Guayaquil,"AdolfH@gmail.com","Quizhpe Guartanga","0913456782");

    
    dueños.add(dueño1);
    dueños.add(dueño2);
    dueños.add(dueño3);
    dueños.add(dueño4);
    dueños.add(dueño5);
    dueños.add(dueño6);
    dueños.add(dueño7);
    dueños.add(dueño8);
    dueños.add(dueño9);
    dueños.add(dueño10);
    return dueños;
  }


   public static void crearMascotas(){
     Ciudad Guayaquil= new Ciudad("Guayaquil","Guayas");
     Ciudad Cuenca= new Ciudad("Cuenca","Azogues");
     Ciudad Quito= new Ciudad("Quito","Pichincha");
     
     mascotas= new ArrayList<>();
     eliminadas= new ArrayList<>();
    DueñoDeMascota dueño1=new DueñoDeMascota("Diego Adriel","Los olivos","0994047722",Guayaquil,"diadrodr@espol.edu.ec","Rodriguez Flores","0924781081");
    DueñoDeMascota dueño2=new DueñoDeMascota("Pedro Carlos","Mi casa","0993038157",Guayaquil,"carlos2@gmail.com","Rodriguez Serra","0945308110");
    DueñoDeMascota dueño3=new DueñoDeMascota("Rodrigo Andres","Sauces 5 mz109 s10","0994047722",Guayaquil,"Rodrigo7@espol.edu.ec","Torres Valladares","0724788456");
    DueñoDeMascota dueño4=new DueñoDeMascota("Josue Cesar","Sauces 5 mz109 s11","0981234568",Guayaquil,"Josue8@espol.edu.ec","Alcivar Velasquez","0427676123");
    DueñoDeMascota dueño5=new DueñoDeMascota("John Piero","Barrio aniñado de Quito","0994047722",Quito,"jlopez1@espol.edu.ec","Lopez Sorroza","0169781276");
    DueñoDeMascota dueño6=new DueñoDeMascota("Carlos Andres","Barrio podre de Cuenca","0982345671",Cuenca,"Cflor34@espol.edu.ec","Flores Moncayo","0871235678");
    DueñoDeMascota dueño7=new DueñoDeMascota("David Jesus","Sauces 5 mz109 s13","0999876543",Guayaquil,"david17@espol.edu.ec","Vasques Almeida","1023457126");
    DueñoDeMascota dueño8=new DueñoDeMascota("Piero Harry","Samanes 3 mz123 s10","0993346689",Guayaquil,"Ppotter68@espol.edu.ec","Hincapie Potter","0341236987");
    DueñoDeMascota dueño9=new DueñoDeMascota("Antonio Walter","Preguntale a mi mama ","0988977724",Quito,"AV25@hotmail.com","Valencia Espinoza","0724788456");
    DueñoDeMascota dueño10=new DueñoDeMascota("Adolf Alejandro","Alborada 3ra etapa maz30 S27","0992431974",Guayaquil,"AdolfH@gmail.com","Quizhpe Guartanga","0913456782");


     Mascota mascota1 = new Mascota("Pelusa",TipoAnimal.PERRO,"French Puddle","2001", dueño1, "PePERROFr2001");
     Mascota mascota2 = new Mascota("Manchas",TipoAnimal.GATO,"Mestizo","2003",dueño2, "MaGATOMe2003");
     Mascota mascota3 = new Mascota("Pipo",TipoAnimal.PERRO,"Husky","2004",dueño3, "PiPERROHu2004");
     Mascota mascota4 = new Mascota("Misifu",TipoAnimal.GATO,"Persa","2002",dueño4, "MiGATOPe2002");
     Mascota mascota5 = new Mascota("Ladrador",TipoAnimal.PERRO,"Labrador","2005",dueño5, "LaPerroLa2005");
     Mascota mascota6 = new Mascota("Nena",TipoAnimal.GATO,"Persa","2010",dueño6,"NeGATOPe2010");
     Mascota mascota7 = new Mascota("Pilita",TipoAnimal.PERRO,"Labrador","2020", dueño7,"PiPERROLa2020");
     Mascota mascota8 = new Mascota("Michu",TipoAnimal.GATO,"Bengali","2015",dueño8,"MiGATOBe2015");
     Mascota mascota9 = new Mascota("Goofy",TipoAnimal.PERRO,"Chihuahua","2017",dueño9,"GoPERROCh2017");
     Mascota mascota10 = new Mascota("Miau",TipoAnimal.GATO,"Esfinge","2012",dueño10,"MiGATOEs2012");

     mascotas.add(mascota1);
     mascotas.add(mascota2);
     mascotas.add(mascota3);
     mascotas.add(mascota4);
     mascotas.add(mascota5);
     mascotas.add(mascota6);
     mascotas.add(mascota7);
     mascotas.add(mascota8);
     mascotas.add(mascota9);
     mascotas.add(mascota10);
  
  } 

}


