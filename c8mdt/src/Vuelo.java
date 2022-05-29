import java.util.Date;

public class Vuelo {
    private Date fechaDeSalida;
    private Date fechaDeRegreso;
    private String origen;
    private String destino;

    public Vuelo(Date fechaDeSalida, Date fechaDeRegreso, String origen, String destino) {
        this.fechaDeSalida = fechaDeSalida;
        this.fechaDeRegreso = fechaDeRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public Date getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(Date fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public Date getFechaDeRegreso() {
        return fechaDeRegreso;
    }

    public void setFechaDeRegreso(Date fechaDeRegreso) {
        this.fechaDeRegreso = fechaDeRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
