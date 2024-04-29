package v000;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;

    public void recoger() {
        boolean error = false;
        do  {
            System.out.println("> Fila? [1..3]");
            this.fila = new Scanner(System.in).nextInt();
            System.out.println("> Columna? [1..3]");
            this.columna = new Scanner(System.in).nextInt();
            error = !this.esValida();
            if (error) {
                System.out.println("ERROR > Coordenada inválida!");
            }
        } while (error);
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
