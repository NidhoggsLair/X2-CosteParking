/* 
 * Copyright 2020 Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static final Random RND = new Random();

    public static void main(String[] args) {
//        Constantes y Variables
        int horaE, minE;
        int horaRndm, minRndm;
//        23 * 60 + 59 son las 23:59 traducida a minutos
        final int MAX = 1439;
        final double COSTE = 0.15;

        try {
            System.out.println("Párking Morverdre");
            System.out.println("=================");

//          Scan hora de entrada
            System.out.print("Hora de Entrada ......: ");
            horaE = SCN.nextInt();
            System.out.print("Minuto Entrada .......: ");
            minE = SCN.nextInt();

            int te = horaE * 60 + minE;
            
//          Random hora de salida
            int horaRnd = RND.nextInt(MAX - te + 1) + te;

//          Calculos
            int horaT = horaRnd / 60;
            int minT = horaRnd % 60;
            
            int tt = horaRnd - te;
            int horaD = tt / 60;
            int minD = tt % 60;
            
            double costeTotal = tt * COSTE;

//          Salida por pantalla
            System.out.println("---");
            System.out.printf("Momento entrada ......: %02d:%02d - Manual %n",
                    horaE, minE);
            System.out.printf("Momento salida .......: %02d:%02d - Aleatorio %n",
                    horaT, minT);
            System.out.println("---");
            System.out.printf(Locale.ENGLISH, "Tarifa ...............: %.2f "
                    + "€/min %n", COSTE);
            System.out.printf("Tiempo facturado .....: %d minutos (%dh + %dm) "
                    + "%n", tt, horaD, minD);
            System.out.printf(Locale.ENGLISH, "Importe ..............: %.2f€ %n",
                    costeTotal);

//           Excepcion
        } catch (Exception e) {
            System.out.println("ERROR. Entrada Incorrecta.");
//            Limpiar buffer
        } finally {
            SCN.nextLine();
        }
    }

}
