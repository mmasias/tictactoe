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

    private boolean estaCompleto(char color){
        int fila = this.getFila(color);
        int conteoFichas = 0;
        for (int i=0; i<fichas[fila].length; i++){
            conteoFichas++;
        }
        return conteoFichas == DIMENSION;
    }

    public boolean estaCompleto(Jugador jugador) {
        return this.estaCompleto(jugador.color());
    }    

    public boolean ocupado(Coordenada coordenada) {
        return this.ocupado(coordenada, 'o') || this.ocupado(coordenada, 'x');
    }

    private boolean ocupado(Coordenada coordenada, char color) {
        int fila = this.getFila(color);
        for (int i = 0; i < fichas[fila].length; i++) {
            if (fichas[fila][i]!=null && fichas[fila][i].igual(coordenada)){
                return true;
            }
        }
        return false;
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
