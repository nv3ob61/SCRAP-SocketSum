/*
 * Copyright 2019 mon_mo
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
package scrap.socketsuma.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon_m
 */
public final class UtilesEntrada {

    // Scanner + Codificación Windows
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    // Locale Spanish
    public static final Locale LCL = new Locale("es", "ES");

    
    // Consola >> Texto
    public static final String leerTexto(String msgUsr) {
        System.out.print(msgUsr);
        return SCN.nextLine();
    }

    // Pausa + MSG >> INTRO
    public static final void hacerPausa(String msgUsr) {
        System.out.println("---");
        System.out.println(msgUsr);
        hacerPausa();
    }

    // Pausa >> INTRO
    public static final void hacerPausa() {
        System.out.println("---");
        System.out.print("Pulse INTRO para continuar ...");
        SCN.nextLine();
        System.out.println("---");
    }

    // Confirmación S/N + Defecto > Boolean
    public static final boolean confirmarProceso(String msgUsr, boolean defectoOK) {
        // Semáforo
        boolean confirmacionOK = defectoOK;

        // Consola > Caracter
        String entrada = leerTexto(msgUsr);

        // Analisis Entrada
        if (entrada.length() > 0) {
            // Entrada > Caracter 1
            char c = entrada.charAt(0);

            // Caracter [Ss | Nn] > Boolean
            confirmacionOK = "Ss".contains(c + "");
        }

        // Devolución Confirmación
        return confirmacionOK;
    }
}
