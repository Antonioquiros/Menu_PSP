package Clases;

import java.util.Scanner;

/*
    Hacer un menu que abra las siguientes aplicaciones Steam, Google Chrome, Visual Studio Code y Spotify.
    Emilio hará Discord y Visual Studio Code y Antonio hará Steam y Google Chrome

Rutas:

* Discord: C:\Users\emili\AppData\Local\Discord\Update.exe --processStart Discord.exe
* Steam: C:\Program Files (x86)\Steam\Steam.exe
* Chrome: C:\Program Files\Google\Chrome\Application\chrome.exe
* Visual studio: C:\Users\emili\AppData\Local\Programs\Microsoft VS Code\Code.exe */
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("---------------------------------");
            System.out.println("Menu de aplicaciones");
            System.out.println("1. Spotify");
            System.out.println("2. Visual Studio Code");
            System.out.println("3. Google Chrome");
            System.out.println("4. Steam");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");
            System.out.println("Elige una aplicacion: ");
             opcion = sc.nextInt();
        }while (opcion != 0);
    }
}