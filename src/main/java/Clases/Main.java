package Clases;

import java.util.Scanner;

import static java.lang.System.exit;

/*
    Hacer un menu que abra las siguientes aplicacones Steam, Google Chrome, Visual Studio Code y Spotify.
    Emilio hará Spotify y Visual Studio Code y Antonio hará Steam y Google Chrome
 */
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        Main main = new Main();
        while (opcion != "0")
        {
            System.out.println("---------------------------------");
            System.out.println("Menu de aplicaciones");
            System.out.println("1. Spotify");
            System.out.println("2. Visual Studio Code");
            System.out.println("3. Google Chrome");
            System.out.println("4. Steam");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");
            System.out.println("Elige una aplicacion: ");
             opcion = sc.nextLine();


             switch (opcion){

                 case "1":
                     main.abrirSpotify();
                     System.out.println("Abriendo spotify");
                     break;
                 case "2":
                     main.abrirVisualStudioCode();
                     break;
                 case "3":
                     main.abrirGoogleChrome();
                     break;
                 case "4":
                     main.abrirSteam();
                     break;
                 case "0":
                     System.out.println("Saliendo del programa...");
                     System.exit(0);
                     break;
                 default:
                     System.out.println("La opcion introducida no es valida");
                     break;
             }
        }
    }
    private void abrirSpotify(){}
    private void abrirSteam(){}
    private void abrirGoogleChrome(){}
    private void abrirVisualStudioCode(){}
}