package Clases;

/*
Hacer un menú que abra las siguientes aplicaciones:

    - Steam

    - Google Chrome

    - Visual Studio Code

    - Discord.

    - Bloc de notas

    - Calculadora

    - Spotify

    - Paint.

Emilio abrirá las 4 primeras aplicaciones y Antonio abrirá las 4 siguientes. */

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para capturar la entrada del usuario.
        Scanner sc = new Scanner(System.in);

        // Obtener el nombre del usuario automáticamente a través del sistema operativo
        String nombreUsuario = System.getProperty("user.name");
        System.out.println("¡Hola, " + nombreUsuario + "! Bienvenido al menú de aplicaciones.");

        // Variable para almacenar la opción seleccionada por el usuario
        String opcion;
        // Crear una instancia de la clase Main
        Main main = new Main();

        // Ciclo do-while que mantendrá el menú activo hasta que el usuario elija salir
        do {
            // Mostrar el menú con las opciones disponibles
            System.out.println("---------------------------------");
            System.out.println("Menú de aplicaciones");
            System.out.println("1. Discord");
            System.out.println("2. Visual Studio Code");
            System.out.println("3. Google Chrome");
            System.out.println("4. Steam");
            System.out.println("5. Bloc de notas");
            System.out.println("6. Calculadora");
            System.out.println("7. Spotify");
            System.out.println("8. Paint");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");
            // Solicitar al usuario que elija una opción
            System.out.print(nombreUsuario + ", elige una aplicación: ");
            opcion = sc.nextLine();  // Leer la opción introducida por el usuario

            // Evaluar la opción introducida por el usuario
            switch (opcion) {
                case "1":
                    // Si elige "1", abrir Discord
                    main.abrirDiscord(nombreUsuario);
                    System.out.println("Abriendo Discord...");
                    break;
                case "2":
                    // Si elige "2", abrir Visual Studio Code
                    main.abrirVisualStudioCode();
                    System.out.println("Abriendo Visual Studio Code...");
                    break;
                case "3":
                    // Si elige "3", abrir Google Chrome
                    main.abrirGoogleChrome();
                    System.out.println("Abriendo Google Chrome...");
                    break;
                case "4":
                    // Si elige "4", abrir Steam
                    main.abrirSteam();
                    System.out.println("Abriendo Steam...");
                    break;
                case "5":
                    // Si elige "5", abrir el bloc de notas
                    main.abrirBloc();
                    System.out.println("Abriendo el bloc de notas...");
                    break;
                case "6":
                    // Si elige "6", abrir la calculadora
                    main.abrirCalc();
                    System.out.println("Abriendo la calculadora...");
                    break;
                case "7":
                    // Si elige "7", abrir Spotify
                    main.abrirSpotify();
                    System.out.println("Abriendo Spotify...");
                    break;
                case "8":
                    // Si elige "8", abrir Paint
                    main.abrirPaint();
                    System.out.println("Abriendo Paint...");
                    break;
                case "0":
                    // Si elige "0", salir del programa
                    System.out.println("Saliendo del programa... ¡Hasta luego, " + nombreUsuario + "!");
                    break;
                default:
                    // Si la opción no es válida, mostrar un mensaje de error
                    System.out.println("La opción introducida no es válida.");
                    break;
            }
        } while (!opcion.equals("0"));  // El ciclo continuará hasta que el usuario elija salir (opción 0)

        // Cerrar el objeto Scanner
        sc.close();
    }

    // Metodo para abrir Discord
    private void abrirDiscord(String usuario) {
        // Abrir Discord como una aplicación
        ejecutarProceso("C:\\Users\\" + usuario + "\\AppData\\Local\\Discord\\Update.exe", "--processStart", "Discord.exe");
    }

    // Metodo para abrir Visual Studio Code
    private void abrirVisualStudioCode() {
        // Abrir Visual Studio Code como una aplicación
        ejecutarProceso("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");
    }

    // Metodo para abrir Google Chrome
    private void abrirGoogleChrome() {
        // Abrir Google Chrome como una aplicación
        ejecutarProceso("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    }

    // Metodo para abrir Steam
    private void abrirSteam() {
        // Abrir Steam como una aplicación
        ejecutarProceso("C:\\Program Files (x86)\\Steam\\Steam.exe");
    }

    // Metodo para abrir bloc de notas
    private void abrirBloc() {
        // Crear un nuevo proceso para abrir el bloc de notas
        ejecutarProceso("notepad");
    }

    // Metodo para abrir la calculadora
    private void abrirCalc() {
        // Crear un nuevo proceso para abrir la calculadora
        ejecutarProceso("calc");
    }

    // Metodo para abrir Spotify
    private void abrirSpotify() {
        // Crear un nuevo proceso para abrir Spotify
        ejecutarProceso("spotify.exe");
    }

    // Metodo para abrir Paint
    private void abrirPaint() {
        // Crear un nuevo proceso para abrir Paint
        ejecutarProceso("mspaint");
    }

    // Metodo para ejecutar cualquier proceso (como abrir una aplicación)
    private void ejecutarProceso(String... comando) {
        try {
            // Crear un nuevo proceso con los parámetros proporcionados
            new ProcessBuilder(comando).start();
        } catch (IOException e) {
            // Si ocurre un error al ejecutar el proceso, mostrar un mensaje de error
            System.out.println("Error al abrir la aplicación: " + e.getMessage());
        }
    }

}