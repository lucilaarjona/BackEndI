import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private String cuit;
    private String razonSocial;
    private List<Empleado> listaEmpleados;

    public Empresa(String cuit, String razonSocial, List<Empleado> listaEmpleados) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.listaEmpleados = new ArrayList<>();
    }

    public Empresa(String cuit, String razonSocial) {
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public void agregarEmpleado(Empleado e){
        listaEmpleados.add(e);
    }
    public void eliminarEmpleado(Empleado e){
        this.listaEmpleados.remove(e);
    }
}
