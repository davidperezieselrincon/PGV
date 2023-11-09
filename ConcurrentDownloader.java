/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.concurrentdownloader;

/**
 *
 * @author DavidPerez
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConcurrentDownloader {

    public static void main(String[] args) {
        String[] urls = {/* lista de URLs a descargar */"https://www.nature.com/documents/aj-artworkguidelines.pdf", "https://img.freepik.com/vector-gratis/fachada-casa_23-2147512107.jpg?w=740&t=st=1699535858~exp=1699536458~hmac=a5182b78cb13441556a17ffa920a5d45ed4cdf3b893599abcfe3ae7b096f0809"};

        for (String url : urls) {
            ProcessBuilder processBuilder = new ProcessBuilder("curl", "-O", url);
            processBuilder.redirectErrorStream(true);
            /*Este programa utiliza curl para descargar archivos, que es una herramienta común 
            de línea de comandos para transferir datos con URL. Asegúrate de que curl esté instalado 
            en tu sistema para que este código funcione.*/

            try {
                Process process = processBuilder.start();

                // Leer y mostrar la salida del comando
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                /* Con este código la ejecución no sería concurrente
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Descarga completada para: " + url);
                } else {
                    System.err.println("Error al descargar el archivo: " + url);
                }*/


            } catch (IOException e) {
                System.err.println("Error al descargar el archivo: " + url);
                e.printStackTrace();
            }
        }
    }
}

