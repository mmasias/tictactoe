package v000;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;

    private static final Intervalo LIMITES = new Intervalo(1, 3);;

    public Coordenada() {
    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        assert this.esValida();
    }

    public void recoger() {
        boolean error = false;
        do {
            System.out.println("> Fila? [1..3]");
            this.fila = new Scanner(System.in).nextInt();
            System.out.println("> Columna? [1..3]");
            this.columna = new Scanner(System.in).nextInt();
            error = !this.esValida();
            if (error)
                System.out.println("ERROR > Coordenada inválida!");
        } while (error);
    }

    public boolean esValida() {
        return (LIMITES.incluye(fila) && LIMITES.incluye(columna));
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean igual(Coordenada coordenada) {
        return this.fila == coordenada.fila && this.columna == coordenada.columna;
    }

    public static void main(String[] args) {
        Coordenada coordenada = new Coordenada(0, 0);
    }

    public int direcion(Coordenada coordenada) {
        if (fila == coordenada.fila) {
            return 0;
        }
        if (columna == coordenada.columna) {
            return 1;
        }
        if (fila - columna == 0 && coordenada.fila - coordenada.columna == 0) {
            return 2;
        }
        if (fila + columna == 4 && coordenada.fila + coordenada.columna == 4) {
            return 3;
        }
        return -1;
    }

}
