public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("20-78996525-7", "Grupo 4");
        Empleado e1 = new Empleado("Lucila", "Arjona", "7897", 855.00);
        Empleado e2 = new Empleado("Lucila", "Arjona", "7897", 855.00);
        Empleado e3 = new Empleado("Lucila", "Arjona", "7897", 855.00);
        Empleado e4 = new Empleado("Lucila", "Arjona", "7897", 855.00);

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);
        empresa.agregarEmpleado(e4);
    }
}
