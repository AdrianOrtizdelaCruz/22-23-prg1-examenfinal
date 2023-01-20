import java.util.Scanner;

public class Pacman_V3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int[][] posicionesFrutas = { { 10, 1 }, { 10, 20 }, { 1, 1 }, { 1, 20 } };
        int puntos = 0;
        int turnosInvencible = 0;
        boolean invencible = false;

        do {
            // Contador de puntos
            System.out.println("PUNTOS:" + puntos);
            // Implementación de las pastillas de invencibilidad
            if ((posicionPersonaje[0] == posicionesFrutas[0][0] && posicionPersonaje[1] == posicionesFrutas[0][1])
                    || (posicionPersonaje[0] == posicionesFrutas[1][0]
                            && posicionPersonaje[1] == posicionesFrutas[1][1])
                    || (posicionPersonaje[0] == posicionesFrutas[2][0]
                            && posicionPersonaje[1] == posicionesFrutas[2][1])
                    || (posicionPersonaje[0] == posicionesFrutas[3][0]
                            && posicionPersonaje[1] == posicionesFrutas[3][1])) {
                puntos = puntos + 6;
                invencible = true;
                turnosInvencible = turnosInvencible + 15;
            }
            if (turnosInvencible <= 0) {
                invencible = false;
            }
            if (invencible) {
                System.out.println("TURNOS DE INVENCIBILIDAD: " + turnosInvencible);
                turnosInvencible = turnosInvencible - 1;
            }
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    // Comer las pastillas cuando el jugador pasa por encima de ellas
                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna
                            && unaMatriz[laFila][laColumna] == 0) {
                        unaMatriz[laFila][laColumna] = 2;
                        // Añadir puntos al comer la pastilla
                        puntos = puntos + 3;
                    }
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                        // Aparición de las Frutas en el mapa
                    } else if (laFila == posicionesFrutas[0][0] && laColumna == posicionesFrutas[0][1]) {
                        System.out.print("X");
                    } else if (laFila == posicionesFrutas[1][0] && laColumna == posicionesFrutas[1][1]) {
                        System.out.print("X");
                    } else if (laFila == posicionesFrutas[2][0] && laColumna == posicionesFrutas[2][1]) {
                        System.out.print("X");
                    } else if (laFila == posicionesFrutas[3][0] && laColumna == posicionesFrutas[3][1]) {
                        System.out.print("X");
                    } else {
                        if (unaMatriz[laFila][laColumna] == 0) {
                            System.out.print(".");
                        } else if (unaMatriz[laFila][laColumna] == 1) {
                            System.out.print("#");
                        } else if (unaMatriz[laFila][laColumna] == 2) {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S', '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'w', 'W', '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case 'a', 'A', '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case 'd', 'D', '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'f', 'F':
                    terminar = true;
            }
        } while (!terminar);
    }

    public static void interaccionesConElJugador(int[] posicionPersonaje, int[][] posicionesFrutas,
            int[] posicionFantasma, int puntos, int turnosInvencible, boolean invencible) {
        if ((posicionPersonaje[0] == posicionesFrutas[0][0] && posicionPersonaje[1] == posicionesFrutas[0][1])
                || (posicionPersonaje[0] == posicionesFrutas[1][0] && posicionPersonaje[1] == posicionesFrutas[1][1])
                || (posicionPersonaje[0] == posicionesFrutas[2][0] && posicionPersonaje[1] == posicionesFrutas[2][1])
                || (posicionPersonaje[0] == posicionesFrutas[3][0] && posicionPersonaje[1] == posicionesFrutas[3][1])) {
            puntos = puntos + 6;
            invencible = true;
            turnosInvencible = turnosInvencible + 15;
        }
        if (turnosInvencible == 0) {
            invencible = false;
        }

    }

}