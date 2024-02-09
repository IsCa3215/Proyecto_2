import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Llamada {
    private int duracion;
    private String destino;
    private Calendar fecha = Calendar.getInstance();
    private SimpleDateFormat formater = new SimpleDateFormat("dd MMMMMMMMMMMMM yyyy HH:mm:ss");

    /**
     * @param duracion Duración de la Llamada
     * @param destino  Destino de la llamada (número de teléfono)
     * @throws IllegalArgumentException Se produce cuando la duración de llamada no
     *                                  es válida
     */
    public Llamada(int duracion, String destino) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración de la llamada no es válida");
        }
        
        this.duracion = duracion;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "[Llamada realizada]"+"\n"+
                "duracion: " + duracion +"\n"+ "destino: " + destino +"\n"+ ", fecha: "
                + formater.format(fecha.getTime());
    }
    //CONSTRUCTOR COPIA
    public Llamada(Llamada ll) {
        this.destino = ll.destino;
        this.duracion = ll.duracion;
        this.fecha = ll.fecha;

    }



    public String getDestino() {
        return destino;
    }

    public double getDuracion() {
        return duracion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}