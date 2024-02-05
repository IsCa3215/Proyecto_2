public class LineaTelefono {
    private String titular;
    private String numeroTelefono;
    private String nif;
    private String password;
    private int limite;
    private int añoPermanencia;
    private int mesPermanencia;
    private Llamada[] arr = new Llamada[50];


    private TarifaTelefonica tarifa;

    // private TarifaTelefonica tarifa;

    /* Constructor con parametros */

    /**
     * @see LineaTelefono() Constructor el cual crea una nueva línea de teléfono
     * @param titular        STRING titular de la linea
     * @param nif            STRING NIF, NIE, CIF del titular de la línea
     * @param password       STRING Contraseña para acceder a los servicios de la línea
     * @param limite         INT Importe máximo que puede gastar en un mes
     * @param numeroTelefono STRING Numero de teléfono asignado a la línea
     * @param tarifa         TarifaFunct Que tarifa tiene contratada la linea telefónica
     */

    public LineaTelefono(String titular, String nif, String password, int limite, String numeroTelefono, TarifaTelefonica tarifa) {
        // COMPROBACIONES
        if (!verificarTitular(titular)) {
            throw new IllegalArgumentException("\u001B[31m"+"No se han cumplido los requisitos del campo titular"+ "\u001B[0m");
        }
        if (!verificarNif(nif)) {
            throw new IllegalArgumentException("\u001B[31m"+"No se ha introducido un NIF válido"+ "\u001B[0m");
        }
        if (!verificarPasswd(password)) {
            throw new IllegalArgumentException("\u001B[31m"+"La contraseña no cumple los requisitos del campo"+ "\u001B[0m");
        }
        if (!verificarLimite(limite)) {
            throw new IllegalArgumentException("\u001B[31m"+"El limite de la tarifa no cumple."+ "\u001B[0m");
        }
        if (!verificarNumero(numeroTelefono)) {
            throw new IllegalArgumentException("\u001B[31m"+"El número no es válido"+ "\u001B[0m");
        }

        
          //Tarifa pendiente
          if (!verificarTarifa(tarifa)) {
            throw new IllegalArgumentException("\u001B[31m"+"No cumple con una tarifa válida"+ "\u001B[0m");
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
            throw new IllegalArgumentException("\u001B[31m"+"El número introducido no es válido"+ "\u001B[0m");
        }
        if (duracion <= 0) {
            throw new IllegalArgumentException("\u001B[31m"+"La duración de la llamada no es válida"+ "\u001B[0m");
        }
        // FUNCTION calcularCosteLlamada()
        return true;
    }

    // VERIFICACIONES

    @Override
    public String toString() {
        return "LineaTelefono [titular=" + titular + ", numeroTelefono=" + numeroTelefono + ", nif=" + nif
                + ", password=" + password + ", limite=" + limite + ", añoPermanencia=" + añoPermanencia
                + ", mesPermanencia=" + mesPermanencia + ", tarifa=" + tarifa + "]";
    }

    /**
     * @see veridicarPasswd() verifica que la contraseña cumpla todos los requisitos
     * @param passwd Contraseña a comprobar
     * @return true or false dependiendo si cumple o no los requisitos
     */

    public static boolean comprobarNumeroTelefono(String numero){

        return true;
    }

    public static TipoTelefono TipoTelefono(String numero){

        return TipoTelefono.FIJO;
    }
    // public static double calcularCosteLlamada(TarifaTelefonica tarifa,
    // TipoTelefono tipo, int duracion){
    // return 7;
    // }
    private boolean verificarPasswd(String passwd) {
        // Añadir comprobación de PASSWD
        return passwd.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    }

    private boolean verificarTitular(String titular) {
        // Añadir comprobación de Titular

        return titular.matches("^.{15,80}$");
    }

    private boolean verificarNif(String NIF) {
        // Añadir comprobación de NIF

        return true;
    }

    private boolean verificarLimite(int limite) {
        // Añadir comprobación de limite
        boolean value = false;
        if (limite > 10 && limite < 5000) {
            value = true;
        } 
        return value;
    }

    private boolean verificarNumero(String numero) {
        // Añadir comprobación de número tlf
        return true;
    }
    private boolean verificarTarifa(TarifaTelefonica tarifa){
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