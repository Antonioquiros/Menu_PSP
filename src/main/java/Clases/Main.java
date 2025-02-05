package Clases;

/*
    Hacer un menu que abra las siguientes aplicaciones Steam, Google Chrome, Visual Studio Code y Discord.
    Emilio hará Discord y Visual Studio Code y Antonio hará Steam y Google Chrome

Rutas:

* Discord: C:\Users\%usuario%\AppData\Local\Discord\Update.exe --processStart Discord.exe
* Steam: C:\Program Files (x86)\Steam\Steam.exe
* Chrome: C:\Program Files\Google\Chrome\Application\chrome.exe
* Visual studio: C:\Users\%usuario%\AppData\Local\Programs\Microsoft VS Code\Code.exe */

import java.awt.*;
import java.io.IOException;
import java.net.URI;
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
            System.out.println("5. Paint");
            System.out.println("6. Spotify");
            System.out.println("7. Calculadora");
            System.out.println("8. Bloc de notas");
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
                case "5":
                    main.abrirPaint();
                    System.out.println("Abriendo Paint...");
                    break;
                case "6":
                    main.abrirSpoty();
                    System.out.println("Abriendo Spotify...");
                    break;
                case "7":
                    main.abrirCalculadora();
                    System.out.println("Abriendo calculadora...");
                    break;
                case "8":
                    main.blocDeNotas();
                    System.out.println("Abriendo bloc de notas...");
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

    private void abrirPaint(){
            ejecutarProceso("mspaint");
    }
    private void abrirSpoty(){
        ejecutarProceso("spotify.exe");
    }
    private void abrirCalculadora(){
        ejecutarProceso("calc");
    }
    private void blocDeNotas(){
       ejecutarProceso("notepad.exe");
    }

    private void ejecutarProceso(String... comando) {
        try {
            new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al abrir la aplicación: " + e.getMessage());
        }
    }


    private void abrirEnNavegador(String url) {
        try {
            // Crear un objeto URI con la URL proporcionada
            URI uri = new URI(url);

            // Verificar si Desktop es soportado en el sistema
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);  // Abrir la URL en el navegador predeterminado
            } else {
                System.out.println("No se puede abrir el navegador.");
            }
        } catch (Exception e) {
            System.out.println("Error al abrir la URL: " + e.getMessage());
            e.printStackTrace();
        }
    }

}