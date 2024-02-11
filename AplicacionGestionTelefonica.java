import java.util.Scanner;
//7 PENDING CHANGES

public class AplicacionGestionTelefonica {
    public static void main(String[] args) {
        boolean exit = false;
        boolean volver = false;
        System.out.println("Bienvenido a la gestión telefonica de edx");
        Scanner leer = new Scanner(System.in);
        String nombre = leer.next();
        LineaTelefono linea1 = null;
        
        System.out.println(LineaTelefono.comprobarNumeroTelefono("901323232"));
        
        linea1 = new LineaTelefono("wdwadwdadwdwadwd", "77559057K", "IsCa3215@", 12, "958323232", TarifaTelefonica.NORMAL);
        // a.Llamar(10.00, "958323212");
        linea1.Llamar(12, "958323232");
        
        Llamada llamar = new Llamada(10, "958323212");
        linea1.getLlamadas_arr();
        System.out.println(linea1);
        System.out.println("Gestión telefónica EDX, Bievenid@ " + nombre);
        while (!exit) {
            int case_1 = Funciones.leerIntValue("1. Crear nueva línea de teléfono" + "\n"
                    + "2. Eliminar línea de teléfono" + "\n"
                    + "3. Gestionar línea de teléfono" + "\n"
                    + "4. Consultar gastos totales" + "\n"
                    + "5. Salir del programa",
                    1, 5);
            switch (case_1) {
                case 1:
                    String titular = Funciones.leerString("Introduzca el nombre del titular");
                    String NIF = Funciones.leerString("Introduzca el NIF del titular");
                    String passwd = Funciones.leerString("Introduzca la contraseña del titular");
                    int limite = Funciones.leerInt("Introduzca el limite máximo de gasto para la tarifa");
                    String numero_tlf = Funciones.leerString("Introduzca el número de teléfono");
                    int tarifaselect = Funciones.leerIntValue("Que tarifa deseas?" + "\n" +
                            "1.Basica" + "\n" +
                            "2.Normal" + "\n" +
                            "3.Premium", 1, 3);
                    TarifaTelefonica tarifaSelect2 = TarifaTelefonica.NORMAL;
                    if (tarifaselect == 1) {
                        tarifaSelect2 = TarifaTelefonica.BASICA;
                    } else if (tarifaselect == 2) {
                        tarifaSelect2 = TarifaTelefonica.NORMAL;
                    } else {
                        tarifaSelect2 = TarifaTelefonica.PREMIUM;
                    }

                    linea1 = new LineaTelefono(titular, NIF, passwd, limite, numero_tlf, tarifaSelect2);
                    System.out.println(linea1);
                    break;
                case 2:

                case 3:
                    while (!volver) {
                        int case_3 = Funciones.leerIntValue("1. Mostrar el número de teléfono completo." + "\n"
                                + "2. Mostrar el nombre del titular de la línea." + "\n"
                                + "3. Mostrar la fecha de permanencia" + "\n"
                                + "4. Modificar la contraseña" + "\n"
                                + "5. Realizar una llamada" + "\n"
                                + "6. Consultar llamadas" + "\n"
                                + "7. Consultar gasto total" + "\n"
                                + "8. Volver al menú principal",
                                1, 8);
                        switch (case_3) {
                            case 1:
                                System.out.println("Tu número de teléfono es: "+linea1.getNumeroTelefono());
                                break;
                            case 2:
                                System.out.println("El nombre del titular es: "+linea1.getTitular());
                                break;
                            case 3:
                                System.out.println("Tu fecha de permanencia es de: "+linea1.getAñoPermanencia());
                                break;
                            case 4:
                                String passwd_c = Funciones.leerString("Introduzca la nueva contraseña");
                                linea1.setPassword(passwd_c);
                                break;
                            case 5:
                                String destino = Funciones.leerString("¿A quién deseas llamar?");
                                linea1.Llamar(12, destino);
                                break;
                            case 6:
                                
                                break;
                            case 7:
                                System.out.println(linea1.calcularCosteLlamada(linea1.getTarifa(), linea1.comprobarNumeroTelefono(linea1.getNumeroTelefono()), 12)); 
                                break;
                            case 8:
                                volver = true;
                                break;
                            default:
                                break;
                        }
                    }

                    break;
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