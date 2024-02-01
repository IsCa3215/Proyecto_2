
public class LineaTelefono {
    private String titular;
    private String numeroTelefono;
    private String nif;
    private String password;
    private int limite;
    private int añoPermanencia;
    private int mesPermanencia;
    private Llamada[] arr = new Llamada[50];


    private TarifaFunct tarifa;

    // private TarifaTelefonica tarifa;

    /* Constructor con parametros */

    /**
     * @see LineaTelefono() Constructor el cual crea una nueva línea de teléfono
     * @param titular        titular de la linea
     * @param nif            NIF, NIE, CIF del titular de la línea
     * @param password       Contraseña para acceder a los servicios de la línea
     * @param limite         Importe máximo que puede gastar en un mes
     * @param numeroTelefono Numero de teléfono asignado a la línea
     * @param tarifa         Que tarifa tiene contratada la linea telefónica
     */

    public LineaTelefono(String titular, String nif, String password, int limite, String numeroTelefono, TarifaFunct tarifa) {
        // COMPROBACIONES
        if (!verificarTitular(titular)) {
            throw new IllegalArgumentException("No se han cumplido los requisitos del campo");
        }
        if (!verificarNif(nif)) {
            throw new IllegalArgumentException("No se ha introducido un NIF válido");
        }
        if (!verificarPasswd(password)) {
            throw new IllegalArgumentException("La contraseña no cumple los requisitos del campo");
        }
        if (!verificarLimite(limite)) {
            throw new IllegalArgumentException("El limite de la tarifa no cumple.");
        }
        if (!verificarNumero(numeroTelefono)) {
            throw new IllegalArgumentException("El número no es válido");
        }

        
          //Tarifa pendiente
          if (!verificarTarifa(tarifa)) {
            throw new IllegalArgumentException("No cumple con una tarifa válida");
          }
         
        //FIN COMPROBACIONES

        this.titular = titular;
        this.nif = nif;
        this.password = password;
        this.limite = limite;
        this.numeroTelefono = numeroTelefono;
        this.tarifa = tarifa;

    }

    public LineaTelefono(LineaTelefono lt) {
        this.titular = lt.titular;
        this.nif = lt.nif;
        this.password = lt.password;
        this.limite = lt.limite;
        this.numeroTelefono = lt.numeroTelefono;
        this.tarifa = lt.tarifa;
    }

    /**
     * 
     * @param duracion duración de la llamada en formato minutos:segundos (mm:ss)
     * @param destino  Teléfono al que se realiza la llamada
     * @return true or false si se ha podido realizar la llamada
     */
    public boolean Llamar(double duracion, String destino) {
        if (!verificarNumero(destino)) {
            throw new IllegalArgumentException("El número introducido no es válido");
        }
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración de la llamada no es válida");
        }
        // FUNCTION calcularCosteLlamada()
        return true;
    }

    // VERIFICACIONES

    /**
     * @see veridicarPasswd() verifica que la contraseña cumpla todos los requisitos
     * @param passwd Contraseña a comprobar
     * @return true or false dependiendo si cumple o no los requisitos
     */

    public static boolean comprobarNumeroTelefono(String numero){

        
        int i = numero.charAt(0);
        switch (i) {
            case 1:

        
            default:
                break;
        }
        return true;
    }

    // public static double calcularCosteLlamada(TarifaTelefonica tarifa,
    // TipoTelefono tipo, int duracion){
    // return 7;
    // }
    private boolean verificarPasswd(String passwd) {
        // Añadir comprobación de PASSWD
        return true;
    }

    private boolean verificarTitular(String titular) {
        // Añadir comprobación de Titular
        return true;
    }

    private boolean verificarNif(String NIF) {
        // Añadir comprobación de NIF
        return true;
    }

    private boolean verificarLimite(int limite) {
        // Añadir comprobación de limite
        return true;
    }

    private boolean verificarNumero(String numero) {
        // Añadir comprobación de número tlf
        return true;
    }
    private boolean verificarTarifa(TarifaFunct tarifa){
    //Añadir comprobación de Tarifa
    return true;
    }
    // FIN VERIFICACIONES

    // GETTERS
    public String getTitular() {
        return titular;
    }

    public int getLimite() {
        return limite;
    }

    public String getNif() {
        return nif;
    }

    public String getPassword() {
        return password;
    }

    // public String getAñoPermanencia() {
    // return Año;
    // }
    // public String getmesPermanencia() {
    // return mes;
    // }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    // Fin GETTERS

    // SETTERS
    public void setPassword(String password) {
        this.password = password;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    // public void setTarifa(int tarifa) {
    // this.tarifa = tarifa;
    // }
}