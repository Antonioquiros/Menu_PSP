package Clases;

/*
    Hacer un menu que abra las siguientes aplicaciones Steam, Google Chrome, Visual Studio Code y Discord.
    Emilio hará Discord y Visual Studio Code y Antonio hará Steam y Google Chrome

Rutas:

* Discord: C:\Users\emili\AppData\Local\Discord\Update.exe --processStart Discord.exe
* Steam: C:\Program Files (x86)\Steam\Steam.exe
* Chrome: C:\Program Files\Google\Chrome\Application\chrome.exe
* Visual studio: C:\Users\emili\AppData\Local\Programs\Microsoft VS Code\Code.exe */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Obtener el nombre del usuario automáticamente
        String nombreUsuario = System.getProperty("user.name");
        System.out.println("¡Hola, " + nombreUsuario + "! Bienvenido al menú de aplicaciones.");

        String opcion;
        Main main = new Main();

        do {
            System.out.println("---------------------------------");
            System.out.println("Menú de aplicaciones");
            System.out.println("1. Discord");
            System.out.println("2. Visual Studio Code");
            System.out.println("3. Google Chrome");
            System.out.println("4. Steam");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");
            System.out.print(nombreUsuario + ", elige una aplicación: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    main.abrirDiscord(nombreUsuario);
                    System.out.println("Abriendo Discord...");
                    break;
                case "2":
                    main.abrirVisualStudioCode();
                    System.out.println("Abriendo Visual Studio Code...");
                    break;
                case "3":
                    main.abrirGoogleChrome();
                    System.out.println("Abriendo Google Chrome...");
                    break;
                case "4":
                    main.abrirSteam();
                    System.out.println("Abriendo Steam...");
                    break;
                case "0":
                    System.out.println("Saliendo del programa... ¡Hasta luego, " + nombreUsuario + "!");
                    break;
                default:
                    System.out.println("La opción introducida no es válida.");
                    break;
            }
        } while (!opcion.equals("0"));

        sc.close();
    }

    private void abrirDiscord(String usuario) {
        ejecutarProceso("C:\\Users\\" + usuario + "\\AppData\\Local\\Discord\\Update.exe", "--processStart", "Discord.exe");
    }

    private void abrirVisualStudioCode() {
        ejecutarProceso("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");
    }

    private void abrirGoogleChrome() {
        ejecutarProceso("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    }

    private void abrirSteam() {
        ejecutarProceso("C:\\Program Files (x86)\\Steam\\Steam.exe");
    }

    private void ejecutarProceso(String... comando) {
        try {
            new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al abrir la aplicación: " + e.getMessage());
        }
    }
}