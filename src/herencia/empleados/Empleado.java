package herencia.empleados;

public abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nSalario calculado: $" + calcularSalario();
    }

    public String getNombre() {
        return nombre;
    }
}