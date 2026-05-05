package herencia.empleados;

public class EmpleadoTiempoCompleto extends Empleado {
    public EmpleadoTiempoCompleto(String nombre, double salarioMensual) {
        super(nombre, salarioMensual);
    }

    @Override
    public double calcularSalario() {
        return this.salario;
    }
}
