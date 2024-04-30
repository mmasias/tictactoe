package v000;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;

    private final Intervalo LIMITES;

    public Coordenada(){
        LIMITES = new Intervalo(1, 3);
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

}
