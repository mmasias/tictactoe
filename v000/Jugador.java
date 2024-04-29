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
        boolean error = false;
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.recoger();
            boolean valida = coordenada.esValida();
            boolean ocupado = tablero.ocupado(coordenada);
            error = !valida || ocupado;
            if (ocupado)
                System.out.println("La posición está ocupada!");
        } while (error);
        tablero.ponerFicha(coordenada, color);
    }

    public void moverFicha(Tablero tablero) {
        boolean error = false;
        Coordenada coordenada = new Coordenada();
        do {
            coordenada.recoger();
            boolean valida = coordenada.esValida();
            boolean vacio = tablero.vacio(coordenada);
            error = !valida || vacio;
            if (vacio)
                System.out.println("No hay ficha en la posición indicada");
        } while (error);
        tablero.sacarFicha(coordenada);
        this.ponerFicha(tablero);
    }
}
