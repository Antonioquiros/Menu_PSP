package Clases;

/* Hacer un menú que abra las siguientes aplicaciones: Steam, Google Chrome, Visual Studio Code y Discord.
   Emilio abrirá las 4 aplicaciones y Antonio abrirá las 4 páginas web. */

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
            System.out.println("5. Diario Marca");
            System.out.println("6. Diario As");
            System.out.println("7. Diario El Pais");
            System.out.println("8. Diario Mundo Deportivo");
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
                    // Si elige "5", abrir la página de Marca
                    main.abrirMarca();
                    System.out.println("Ya vas a ver al leon");
                    break;
                case "6":
                    // Si elige "6", abrir la página de As
                    main.abrirAs();
                    System.out.println("Ya vas a ver al as");
                    break;
                case "7":
                    // Si elige "7", abrir la página de El País
                    main.abrirElPais();
                    System.out.println("Ya vas a ver al el pais");
                    break;
                case "8":
                    // Si elige "8", abrir la página de Mundo Deportivo
                    main.abrirMundoDeportivo();
                    System.out.println("Ya vas a ver al mundo deportivo");
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

    // Método para abrir Discord
    private void abrirDiscord(String usuario) {
        // Abrir Discord como una aplicación
        ejecutarProceso("C:\\Users\\" + usuario + "\\AppData\\Local\\Discord\\Update.exe", "--processStart", "Discord.exe");
    }

    // Método para abrir Visual Studio Code
    private void abrirVisualStudioCode() {
        // Abrir Visual Studio Code como una aplicación
        ejecutarProceso("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe");
    }

    // Método para abrir Google Chrome
    private void abrirGoogleChrome() {
        // Abrir Google Chrome como una aplicación
        ejecutarProceso("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    }

    // Método para abrir Steam
    private void abrirSteam() {
        // Abrir Steam como una aplicación
        ejecutarProceso("C:\\Program Files (x86)\\Steam\\Steam.exe");
    }

    // Método para abrir la página web de Marca en un navegador
    private void abrirMarca() {
        // Crear un nuevo proceso para abrir la página web de Marca
        abrirEnNavegador("https://www.marca.com/");
    }

    // Método para abrir la página web de As en un navegador
    private void abrirAs() {
        // Crear un nuevo proceso para abrir la página web de As
        abrirEnNavegador("https://www.as.com/");
    }

    // Método para abrir la página web de El País en un navegador
    private void abrirElPais() {
        // Crear un nuevo proceso para abrir la página web de El País
        abrirEnNavegador("https://www.elpais.com/");
    }

    // Método para abrir la página web de Mundo Deportivo en un navegador
    private void abrirMundoDeportivo() {
        // Crear un nuevo proceso para abrir la página web de Mundo Deportivo
        abrirEnNavegador("https://www.mundodeportivo.com/");
    }

    // Método para ejecutar cualquier proceso (como abrir una aplicación)
    private void ejecutarProceso(String... comando) {
        try {
            // Crear un nuevo proceso con los parámetros proporcionados
            new ProcessBuilder(comando).start();
        } catch (IOException e) {
            // Si ocurre un error al ejecutar el proceso, mostrar un mensaje de error
            System.out.println("Error al abrir la aplicación: " + e.getMessage());
        }
    }

    // Método para abrir una URL en un navegador utilizando un proceso separado
    private void abrirEnNavegador(String url) {
        try {
            // Crear un objeto URI con la URL proporcionada
            URI uri = new URI(url);

            // Verificar si el sistema soporta la funcionalidad de abrir el navegador
            if (Desktop.isDesktopSupported()) {
                // Usar un nuevo proceso para abrir la URL en el navegador
                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", uri.toString());
                processBuilder.start();  // Ejecutar el proceso para abrir el navegador
            } else {
                System.out.println("No se puede abrir el navegador.");
            }
        } catch (Exception e) {
            // Si ocurre un error al abrir la URL, mostrar un mensaje de error
            System.out.println("Error al abrir la URL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}