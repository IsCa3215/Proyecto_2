import java.util.Scanner;
public class Funciones {
    

    public static int leerInt(String mensaje) {
        Scanner leer = new Scanner(System.in);
        System.out.println(mensaje);
        while (!leer.hasNextInt()) {
            leer.nextLine();
            System.out.println("\u001B[31m" + "No se ha introducido un valor válido, Inténtalo de nuevo" + "\u001B[0m");

        }
        int valor2;
        valor2 = leer.nextInt();
        return valor2;
    }

    public static int leerIntValue(String mensaje, int min, int max) {
        int comprobar = leerInt(mensaje);
        Scanner leer = new Scanner(System.in);

        while (comprobar > max || comprobar < min) {
            System.out.println("\u001B[31m" + "No se ha introducido un valor válido" + "\u001B[0m");
            comprobar = leer.nextInt();
        }


        return comprobar;

    }
    public static String leerString(String mensaje){
        Scanner leer = new Scanner(System.in);
        System.out.println(mensaje);
        String res = leer.next();
        return res;
    }
}
