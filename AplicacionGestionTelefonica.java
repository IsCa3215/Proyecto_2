import java.util.Scanner;

public class AplicacionGestionTelefonica {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la gestión telefonica de edx");
        System.out.println("Introduzca su nombre:");
        Scanner leer = new Scanner(System.in);
        String nombre = leer.next();
        Llamada lamar = new Llamada(23, "a");
        System.out.println(lamar);
        }
    
}