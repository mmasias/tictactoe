package v000;

import java.util.Scanner;

class Intervalo {

    private double inferior;
    private double superior;

    public Intervalo(double inferior, double superior) {
        this.inferior = inferior;
        this.superior = superior;
    }

    public Intervalo(double superior) {
        this(0, superior);
    }

    public Intervalo(Intervalo intervalo) {
        this(intervalo.inferior, intervalo.superior);
    }

    public Intervalo() {
        this(0, 0);
    }

    public Intervalo clone() {
        return new Intervalo(this);
    }

    public double longitud() {
        return superior - inferior;
    }

    public void desplazar(double desplazamiento) {
        inferior += desplazamiento;
        superior += desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento) {
        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }

    public boolean incluye(double valor) {
        return inferior <= valor && valor <= superior;
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior) &&
                this.incluye(intervalo.superior);
    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return inferior == intervalo.inferior &&
                superior == intervalo.superior;
    }

    public Intervalo interseccion(Intervalo intervalo) {
        assert this.intersecta(intervalo);
        if (this.incluye(intervalo)) {
            return intervalo.clone();
        } else if (intervalo.incluye(this)) {
            return this.clone();
        } else if (this.incluye(intervalo.inferior)) {
            return new Intervalo(intervalo.inferior, superior);
        } else {
            return new Intervalo(inferior, intervalo.superior);
        }
    }

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior) ||
                this.incluye(intervalo.superior) ||
                intervalo.incluye(this);
    }

    public void oponer() {
        double inferiorInicial = inferior;
        double superiorInicial = superior;
        inferior = -superiorInicial;
        superior = -inferiorInicial;
    }

    public void doblar() {
        double longitudInicial = this.longitud();
        inferior -= longitudInicial / 2;
        superior += longitudInicial / 2;
    }

    public void recoger() {

        System.out.println("Inferior?");
        inferior = new Scanner(System.in).nextDouble();
        System.out.println("Superior?");
        superior = new Scanner(System.in).nextDouble();
    }

    public void mostrar() {
        System.out.println("[" + inferior + "," + superior + "]");
    }

    public static void main(String[] args) {
        Intervalo intervalo = new Intervalo();
        intervalo.recoger();
        intervalo.mostrar();
        System.out.println("Longitud: " + intervalo.longitud());
    }

}
