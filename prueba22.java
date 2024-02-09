public class prueba22 {
    LineaTelefono a = new LineaTelefono("wdwadwdadwdwadwd", "77559057K", "IsCa3215@", 12, "958323232",TarifaTelefonica.NORMAL);

    public static TipoTelefono comprobarNumeroTelefono(String numero) {
        TipoTelefono retorno = null;
        if (numero.matches("[89][1-8][0-9]{7}")) {
            retorno = TipoTelefono.FIJO;
        } else if (numero.matches("[6][0-9]\\d{7}|[7][1234]\\d{7}")) {
            retorno = TipoTelefono.MOVIL;
        } else if (numero.matches("[89][0][0]{6}")){
            retorno = TipoTelefono.GRATUITO;
        } else if (numero.matches("112[0]{2}")){
            retorno = TipoTelefono.GRATUITO_ESPECIAL;
        } else if (numero.matches("[89][0][57]{6}")){
            retorno = TipoTelefono.COSTE_ADICIONAL;
        } else if (numero.matches("[9][0][12]{6}")) {
            retorno = TipoTelefono.COSTE_COMPARTIDO;
        }
        if (retorno == null) {
            throw new IllegalArgumentException("El número no es válido");
        }
        return retorno;
    }
    
}
    
