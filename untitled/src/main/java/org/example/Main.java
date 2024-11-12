package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int intro_equipo = 1;
        int[] equipo1 = new int[7];
        int[] equipo2 = new int[7];

        do {        //al ser un do while s'executa almenys una volta

            System.out.println("Equipo " + intro_equipo);

            System.out.println("Introduce potencia de los samurais: ");
            String entrada_equipo = teclado.nextLine();
            String equipo[] = entrada_equipo.split(" ");   // per a llevar els espais

            int potencia = 0;

            if (equipo.length == 7) { // si la longitud és = a 7 farà el següent

                int equipo_int[] = new int[equipo.length];

                for (int i = 0; i < equipo.length; i++) {

                    equipo_int[i] = Integer.parseInt(equipo[i]);
                    potencia += equipo_int[i];

                }

                if (potencia != 30) {   // si la suma dels 7 numeros no és 30
                    System.out.println("ERROR. La potencia total no suma 30.");
                    continue;
                } else {
                    if (intro_equipo == 1) {   //si açó està bé, seguirà amb el programa
                        intro_equipo = 2;
                        equipo1 = equipo_int.clone();  //per clonar el equipo1
                    } else {
                        equipo2 = equipo_int.clone();
                        intro_equipo = 3;
                    }

                }

            } else {
                System.out.println("ERROR. No hay 7 samuráis.");
                System.out.println(Arrays.toString(equipo));
            }

        } while (intro_equipo <= 2);

        Random random = new Random(); //per a que ens diga el nº random on comença

        int turno = random.nextInt(7); // per a que ens diga un nº del 0 al 6

        int bajasEquipo1 = 0;
        int bajasEquipo2 = 0;  // creem les dos variables per comptar les baixes

        System.out.println("¡Empieza la batalla!");

        while (bajasEquipo1 <= 3 && bajasEquipo2 <= 3) { //mentre aquestes dos condicions es complisquen es seguira executant el codi
            System.out.println("Samurai" + (turno + 1) + ". Potencia Equipo 1: " + equipo1[turno] + " vs Potencia Equipo 2: " + equipo2[turno]);


            if (equipo1[turno] > equipo2[turno]) { //comencem a comparar samurais
                System.out.println("Gana equipo 1.");
                equipo2[turno] = 0;
                bajasEquipo2++; // sumem una baixa a l'equip 2
            } else if (equipo2[turno] > equipo1[turno]) {
                System.out.println("Gana equipo 2.");
                equipo1[turno] = 0;
                bajasEquipo1++; //sumem una baixa a l'equip 1
            } else {
                System.out.println("Empate, ambos samuráis pierden.");
                equipo1[turno] = 0;
                equipo2[turno] = 0;
                bajasEquipo1++;
                bajasEquipo2++;
            }

            turno++; //per aque seguixca compant el turno

            if (turno == 7) { // si el turno fora 7
                turno = 0; // reinciar des de la posicio 0
            }
        }
        if (bajasEquipo1 > 3) { // si les baixes de l'equip1 és major a 3
            System.out.println("¡Equipo 2 gana! Equipo 1 ha tenido " + bajasEquipo1 + " bajas.");
        } else{
            System.out.println("¡Equipo 1 GANA! Equipo 1 ha tenido " + bajasEquipo2 + " bajas.");
        }
    }
}