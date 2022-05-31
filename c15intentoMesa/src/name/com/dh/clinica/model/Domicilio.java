package name.com.dh.clinica.model;

public class Domicilio {
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String previo;

    public Domicilio(Long id, String calle, String numero, String localidad, String previo) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.previo = previo;
    }

    public Domicilio(String calle, String numero, String localidad, String previo) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.previo = previo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPrevio() {
        return previo;
    }

    public void setPrevio(String previo) {
        this.previo = previo;
    }
}