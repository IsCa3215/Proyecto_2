import java.util.Scanner;
import java.util.logging.Level;

public class AplicacionGestionTelefonica {
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Bienvenido a la gestión telefonica de edx");
        System.out.println("Introduzca su nombre:");
        Scanner leer = new Scanner(System.in);
        String nombre = leer.next();
        Llamada llamar = new Llamada(10,"a");
        System.out.println(llamar);
        System.out.println("Gestión telefónica EDX, Bievenid@ " + nombre);
        while (!exit) {
            int Prog_1 = Funciones.leerIntValue("1. Crear nueva línea de teléfono" + "\n"
                    + "2. Eliminar línea de teléfono" + "\n"
                    + "3. Gestionar línea de teléfono" + "\n"
                    + "4. Consultar gastos totales" + "\n"
                    + "5. Salir del programa",
                    1, 5);
            switch (Prog_1) {
                case 1:
                    String titular = Funciones.leerString("Introduzca el nombre del titular");
                    String NIF = Funciones.leerString("Introduzca el NIF del titular");
                    String passwd = Funciones.leerString("Introduzca la contraseña del titular");
                    int limite = Funciones.leerInt("Introduzca el limite máximo de gasto para la tarifa");
                    String numero_tlf = Funciones.leerString("Introduzca el número de teléfono");
                    int tarifaselect = Funciones.leerIntValue("Que tarifa deseas?" + "\n" +
                            "1.Basica" + "\n" +
                            "2.Normal" +"\n" +
                            "3.Premium", 1, 3);
                    TarifaTelefonica tarifaSelect2 = TarifaTelefonica.NORMAL;
                    if (tarifaselect == 1) {
                        tarifaSelect2 = TarifaTelefonica.BASICA;
                    } else if (tarifaselect == 2) {
                        tarifaSelect2 = TarifaTelefonica.NORMAL;
                    } else {
                        tarifaSelect2 = TarifaTelefonica.PREMIUM;
                    }

                    LineaTelefono linea1 = new LineaTelefono(titular, NIF, passwd, limite, numero_tlf, tarifaSelect2);
                    System.out.println(linea1);
                    break;
                case 2:

                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Ha ocurrido un error en la lógica de selección");
                    break;
            }

        }

    }
}