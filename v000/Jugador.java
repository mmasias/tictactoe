package v000;

class Jugador {

    private char color;

    public Jugador(char color) {
        this.color = color;
    }

    public char color() {
        return color;
    }

    public void celebrar() {
        System.out.println(color + " han ganado!!!!");
    }

    public void ponerFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.recoger();
        } while (!coordenada.esValida() || tablero.ocupado(coordenada));
        tablero.ponerFicha(coordenada, color);
    }

    public void moverFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.recoger();
        } while (!coordenada.esValida() || tablero.vacio(coordenada));
        tablero.sacarFicha(coordenada);
        this.ponerFicha(tablero);
    }
}
