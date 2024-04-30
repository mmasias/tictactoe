package v000;

class Tablero {

    private Coordenada[][] fichas;

    private final int DIMENSION = 3;
    private final char VACIA = '_';

    public Tablero() {
        fichas = new Coordenada[2][3];
    }

    public void mostrar() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.println(this.getColor(new Coordenada(i,j)) + " ");    
            }
            System.out.println();
        }
    }

    private String getColor(Coordenada coordenada) {
        if (this.ocupada(coordenada, 'o')){ return 'o'; }
        if (this.ocupada(coordenada, 'x')){ return 'x'; }
        return VACIA;
    }

    public boolean estaCompleto(Jugador jugador) {
        int conteoFichas = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (casillas[i][j] == jugador.color()) {
                    conteoFichas++;
                }
            }
        }
        return conteoFichas == 3;
    }

    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        int[] filas = new int[DIMENSION];
        int[] columnas = new int[DIMENSION];
        int diagonal = 0;
        int secundaria = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (color == casillas[i][j]) {
                    filas[i]++;
                    columnas[j]++;
                    diagonal = diagonal + ((i == j) ? 1 : 0);
                    secundaria = secundaria + ((i + j == 2) ? 1 : 0);

                    if (filas[i] == DIMENSION || columnas[j] == DIMENSION || diagonal == DIMENSION || secundaria == DIMENSION) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ocupado(Coordenada coordenada) {
        return casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] != VACIA;
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = color;
    }

    public boolean vacio(Coordenada coordenada) {
        return !ocupado(coordenada);
    }

    public void sacarFicha(Coordenada coordenada) {
        casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = VACIA;
    }
}
