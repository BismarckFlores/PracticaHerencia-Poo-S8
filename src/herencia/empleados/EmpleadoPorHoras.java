package herencia.empleados;

public class EmpleadoPorHoras extends Empleado{
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double salario, int horasTrabajadas) {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return this.salario * this.horasTrabajadas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHoras trabajadas: " + horasTrabajadas;
    }
}
