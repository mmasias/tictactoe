package v000;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;

    public void recoger() {
        do  {
            System.out.println("> Fila? [1..3]");
            this.fila = new Scanner(System.in).nextInt();
            System.out.println("> Columna? [1..3]");
            this.columna = new Scanner(System.in).nextInt();
        } while (!this.esValida());
    }

    public boolean esValida() {
        return (fila >= 1 && fila <= 3 && columna >= 1 && columna <= 3);
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

}
