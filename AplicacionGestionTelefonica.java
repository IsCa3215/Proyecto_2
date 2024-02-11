import java.util.Scanner;

public class AplicacionGestionTelefonica {
    public static void main(String[] args) {
        boolean exit = false;
        boolean volver = false;
        System.out.println("Bienvenido a la gestión telefónica de EDX");
        Scanner leer = new Scanner(System.in);
        System.out.print("Por favor, ingrese su nombre: ");
        String nombre = leer.next();
        LineaTelefono linea1 = null;
        LineaTelefono[] lineasTelefonicas = new LineaTelefono[10];
        int contadorLineas = 0;

       
        linea1 = new LineaTelefono("wdwadwdadwdwadwd", "77559057K", "IsCa3215@", 12, "958323232",
                TarifaTelefonica.NORMAL);
                lineasTelefonicas[contadorLineas++] = linea1;
       
        linea1 = new LineaTelefono("adsadweq2rwqrwq", "77559058K", "IsCa3215@", 20, "652346412",
        TarifaTelefonica.PREMIUM);
        lineasTelefonicas[contadorLineas++] = linea1;

        linea1 = new LineaTelefono("adsadwew3423432", "77559059K", "IsCa3215@", 15, "652346424",
        TarifaTelefonica.NORMAL);
        lineasTelefonicas[contadorLineas++] = linea1;
        Llamada llamar = new Llamada(10, "958323212");

        

       
        System.out.println("Gestión telefónica EDX, Bienvenid@ " + nombre);
        while (!exit) {
            int case_1 = Funciones.leerIntValue("1. Crear nueva línea de teléfono" + "\n"
                    + "2. Eliminar línea de teléfono" + "\n" + "3. Gestionar línea de teléfono" + "\n"
                    + "4. Consultar gastos totales" + "\n" + "5. Salir del programa", 1, 5);
            switch (case_1) {
                case 1:
                    do {
                        String titular = Funciones.leerString("Introduzca el nombre del titular");
                        String NIF = Funciones.leerString("Introduzca el NIF del titular");
                        String passwd = Funciones.leerString("Introduzca la contraseña del titular");
                        int limite = Funciones.leerInt("Introduzca el límite máximo de gasto para la tarifa");
                        String numero_tlf = Funciones.leerString("Introduzca el número de teléfono");
                        int tarifaselect = Funciones.leerIntValue("¿Qué tarifa deseas?" + "\n" + "1. Básica" + "\n"
                                + "2. Normal" + "\n" + "3. Premium", 1, 3);
                        TarifaTelefonica tarifaSelect2;
                        switch (tarifaselect) {
                            case 1:
                                tarifaSelect2 = TarifaTelefonica.BASICA;
                                break;
                            case 2:
                                tarifaSelect2 = TarifaTelefonica.NORMAL;
                                break;
                            case 3:
                                tarifaSelect2 = TarifaTelefonica.PREMIUM;
                                break;
                            default:
                                tarifaSelect2 = TarifaTelefonica.NORMAL; 
                                break;
                        }

                        LineaTelefono nuevaLinea = new LineaTelefono(titular, NIF, passwd, limite, numero_tlf, tarifaSelect2);
                        lineasTelefonicas[contadorLineas++] = nuevaLinea;
                        System.out.println(nuevaLinea);

                        
                        String respuesta = Funciones.leerString("¿Desea agregar otra línea telefónica? (S/N)");
                        if (!respuesta.equalsIgnoreCase("S")) {
                            break; 
                        }
                    } while (contadorLineas < lineasTelefonicas.length);
                    break;
                case 2:
                    String nifEliminar = Funciones.leerString("Introduzca el NIF de la línea de teléfono que desea eliminar:");
                    LineaTelefono.eliminarLineaTelefono(lineasTelefonicas, nifEliminar);
                    break;
                case 3:
                    while (!volver) {
                        int case_3 = Funciones.leerIntValue(
                                "1. Mostrar el número de teléfono completo." + "\n"
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
                                System.out.println("Tu número de teléfono es: " + linea1.getNumeroTelefono());
                                break;
                            case 2:
                                System.out.println("El nombre del titular es: " + linea1.getTitular());
                                break;
                            case 3:
                                System.out.println("Tu fecha de permanencia es de: " + linea1.getAñoPermanencia());
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
                                System.out.println("Llamadas realizadas en la línea:");
                                System.out.println(linea1.consultarLlamadas());
                                break;
                               
                            case 7:
                            double gastoTotal = 0;
                            for (Llamada llamada : linea1.getLlamadas_arr()) {
                                if (llamada != null) {
                                    TipoTelefono tipoTelefonoDestino = LineaTelefono.comprobarNumeroTelefono(llamada.getDestino());
                                    gastoTotal += linea1.calcularCosteLlamada(linea1.getTarifa(), tipoTelefonoDestino, llamada.getDuracion());
                                }
                            }
                            System.out.println("El gasto total de la línea es: " + gastoTotal);
                            
                            case 8:
                                volver = true;
                                break;
                            default:
                                break;
                        }
                    }
                    volver = false; 
                    break;
                case 4:
                    double gastoTotalGeneral = 0;
                    for (LineaTelefono linea : lineasTelefonicas) {
                        if (linea != null) {
                            for (Llamada llamada : linea.getLlamadas_arr()) {
                                if (llamada != null) {
                                    TipoTelefono tipoTelefonoDestino = LineaTelefono.comprobarNumeroTelefono(llamada.getDestino());
                                    gastoTotalGeneral += linea.calcularCosteLlamada(linea.getTarifa(), tipoTelefonoDestino, llamada.getDuracion());
                                }
                            }
                        }
                    }
                System.out.println("El gasto total de todas las líneas es: " + gastoTotalGeneral);
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
