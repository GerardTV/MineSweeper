package src.model;

public class Buscaminas {
  public String[][] tableroSolucion;
  public String[][] tableroJuego;
  private String desconocido = " ? ";
  private String mina = " * ";
  private String vacio = "   ";
  public Boolean seTermino = false;
  public Boolean haGanado = false;

  public Buscaminas(GeneradorTableros generadorTableros, int minas) {
    tableroSolucion = generadorTableros.generarTableroConMinas(minas);
    tableroJuego = generadorTableros.generarTableroVacio();
  }


  public static void imprimirTablero(String[][] str) {
    for (int x = 1; x < str.length - 1; x++) {
      for (int y = 0; y < str[0].length; y++) {
        //Formats row.
        if (y > 0 && y < str[0].length)
          System.out.print("|");
        else
          System.out.println("");

        System.out.print(str[x][y]); //muestra el contenido de una casilla
      }
    }
  }

  public void mostrarSolucion() {
    System.out.println("_______Solucion______");
    imprimirTablero(tableroSolucion);
    System.out.println("\n_____________________");
  }

  public void actualizar() {
    imprimirTablero(tableroJuego);
    System.out.println("");
  }


  //cuenta el número de minas vacias alrededor de la casilla seleccionada
  public void detectarMinas() {
    for (int x = 1; x < tableroJuego.length - 2; x++) {
      for (int y = 1; y < tableroJuego.length - 2; y++) {
        if (tableroSolucion[x][y].equals(vacio) == true) {
          int nums = 0;
          for (int i = (x - 1); i <= (x + 1); i++) {
            for (int j = (y - 1); j <= (y + 1); j++) {
              if (tableroSolucion[i][j].equals(mina) == true)
                nums++;
            }
          }
          tableroJuego[x][y] = " " + nums + " ";
        }
      }
    }
  }

  public int detectarMinas(int x, int y) {
    int nums = -1;
    if (tableroSolucion[x][y].equals(vacio) == true) {
      nums = 0;
      for (int i = (x - 1); i <= (x + 1); i++) {
        for (int j = (y - 1); j <= (y + 1); j++) {
          if (tableroSolucion[i][j].equals(mina) == true)
            nums++;
        }
      }
      tableroJuego[x][y] = " " + nums + " ";
    }
    return nums;
  }



  public boolean seleccionaCasilla(int x, int y){
    if(tableroSolucion[x][y].equals(desconocido) == true){ //Si no havía sido seleccionada previamente, se dejavacia
      seTermino = false;
      tableroJuego[x][y] = vacio;
      tableroSolucion[x][y] = vacio;
    }else if(tableroSolucion[x][y].equals(mina) == true){  //Se ha seleccionado una mina
      seTermino = true;
      haGanado = false;
    }else if(tableroJuego[x][y].equals(vacio) == true && tableroSolucion[x][y].equals(vacio)){
      seTermino = false;
      return false;
    }
    return true;
  }
  
  public void hayGanador(){
    int casillasPorSeleccionar = 0;
    for(int i = 0; i < tableroSolucion.length; i++){
      for(int j = 0; j < tableroSolucion[0].length; j++){
        if(tableroSolucion[i][j].equals(desconocido) == true)
          casillasPorSeleccionar++;
      }
    }
    if(casillasPorSeleccionar != 0)
      haGanado = false;
    else{
      haGanado = true;
      seTermino = true;
    }
  }

  public Boolean esFinalizado(){
    return seTermino;
  }
  
  public Boolean terminadoConVictoria(){
    return haGanado;
  }
  
}
