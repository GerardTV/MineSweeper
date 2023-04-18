package src.test;

import src.model.GeneradorTableros;

import static org.junit.jupiter.api.Assertions.*;

class GeneradorTablerosTest {

    GeneradorTableros generadorTableros;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        generadorTableros = new GeneradorTableros(5,5);
    }

    @org.junit.jupiter.api.Test
    void generarTableroConMinas_TresMinas() {
        int minas = 3;
        String[][] tablero = generadorTableros.generarTableroConMinas(minas);
        int minasEncontradas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j].equals(" * ")){
                    minasEncontradas++;
                }
            }
        }
        assertEquals(minas,minasEncontradas);
    }

    @org.junit.jupiter.api.Test
    void generarTableroVacio_de_5_columnas() {
        generadorTableros = new GeneradorTableros(5,5);
        String[][] tablero = generadorTableros.generarTableroConMinas(4);
        assertEquals(5,tablero.length);
    }

    @org.junit.jupiter.api.Test
    void generarTableroVacio_de_5_filas_por_columna() {
        generadorTableros = new GeneradorTableros(5,5);
        String[][] tablero = generadorTableros.generarTableroConMinas(4);
        assertEquals(5,tablero.length);
        assertEquals(5,tablero[0].length);
        assertEquals(5,tablero[1].length);
        assertEquals(5,tablero[2].length);
        assertEquals(5,tablero[3].length);
        assertEquals(5,tablero[4].length);
    }
}