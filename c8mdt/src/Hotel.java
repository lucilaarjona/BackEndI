import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private localDate fechaDeEntrada;
    private localDate fechaDeSalida;
    private String ciudad;

    public Hotel(localDate fechaDeEntrada, localDate fechaDeSalida, String ciudad) {
        this.fechaDeEntrada = fechaDeEntrada;
        this.fechaDeSalida = fechaDeSalida;
        this.ciudad = ciudad;
    }

    public Date getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(Date fechaDeEntrada) {
        this.fechaDeEntrada = fechaDeEntrada;
    }

    public Date getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(Date fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
