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

    private char getColor(Coordenada coordenada) {
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
        if (!this.estaCompleto(color)){
            return false;
        }
        int fila = this.getFila(color);
        int direccion = fichas[fila][0].direcion(fichas[fila][1]);
        if (direccion==-1) return false;
        return direccion == fichas[fila][1].direcion(fichas[fila][2]);
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
