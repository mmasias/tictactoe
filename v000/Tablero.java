package v000;

class Tablero {

    private char[][] casillas;

    public Tablero(){
        casillas = new char[3][3];

        for(int i=0; i<casillas.length; i++){
            for (int j=0; j<=casillas[i].length; j++){
                casillas[i][j] = '_';
            }
            System.out.println();
        }
    }    

    public void mostrar() {
        for(int i=0; i<casillas.length; i++){
            for (int j=0; j<=casillas[i].length; j++){
                System.out.print(" " + casillas[i][j]);
            }
            System.out.println();
        }
    }

    public boolean estaCompleto(Jugador jugador) {

    }

    public boolean hayTresEnRaya() {

    }

}
