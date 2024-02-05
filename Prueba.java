import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prueba {
    public static void main(String[] args) {
        Pattern patron = Pattern.compile("[01]+");
        Matcher m = patron.matcher("00000101");
        if (m.matches()) {
            System.out.println("Es binario");
        } else {
            System.out.println("No es binario");
        }

        Pattern dni = Pattern.compile("([XY]?)([0-9]{1-9})");
        
    }
    
}
