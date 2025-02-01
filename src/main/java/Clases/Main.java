package Clases;

import java.io.IOException;
import java.util.Scanner;

/*
    Hacer un menu que abra las siguientes aplicaciones Steam, Google Chrome, Visual Studio Code y Discord.
    Emilio hará Discord y Visual Studio Code y Antonio hará Steam y Google Chrome
Rutas:

* Discord: C:\Users\emili\AppData\Local\Discord\Update.exe --processStart Discord.exe
* Steam: C:\Program Files (x86)\Steam\Steam.exe
* Chrome: C:\Program Files\Google\Chrome\Application\chrome.exe
* Visual studio: C:\Users\emili\AppData\Local\Programs\Microsoft VS Code\Code.exe */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Obtener el nombre del usuario automáticamente
        String nombreUsuario = System.getProperty("user.name");
        System.out.println("¡Hola, " + nombreUsuario + "! Bienvenido al menú de aplicaciones.");

        String opcion = "";
        Main main = new Main();
        while (!opcion.equals("0")) {
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opción introducida no es válida.");
                    break;
            }
        }
        sc.close();
    }

    private void abrirDiscord(String usuario) {
        try {
            Runtime.getRuntime().exec("C:\\Users\\" + usuario + "\\AppData\\Local\\Discord\\Update.exe --processStart Discord.exe");
        } catch (IOException e) {
            System.out.println("Error al abrir Discord: " + e.getMessage());
        }
    }

    private void abrirVisualStudioCode() {
        try {
            Runtime.getRuntime().exec("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");
        } catch (IOException e) {
            System.out.println("Error al abrir Visual Studio Code: " + e.getMessage());
        }
    }

    private void abrirGoogleChrome() {
        try {
            Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        } catch (IOException e) {
            System.out.println("Error al abrir Google Chrome: " + e.getMessage());
        }
    }

    private void abrirSteam() {
        try {
            Runtime.getRuntime().exec("C:\\Program Files (x86)\\Steam\\Steam.exe");
        } catch (IOException e) {
            System.out.println("Error al abrir Steam: " + e.getMessage());
        }
    }
}