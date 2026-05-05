package herencia.empleados;

import java.util.ArrayList;

public class GestionEmpleados {
    private ArrayList<Empleado> plantilla;

    public GestionEmpleados() {
        plantilla = new ArrayList<>();
    }

    public void contratar(Empleado e) {
        plantilla.add(e);
    }

    public boolean despedir(String nombre) {
        return plantilla.removeIf(emp -> emp.getNombre().equalsIgnoreCase(nombre));
    }

    public String listarEmpleados() {
        if (plantilla.isEmpty()) {
            return "No hay empleados contratados.";
        }
        StringBuilder sb = new StringBuilder("--- PLANTILLA DE EMPLEADOS ---\n");
        for (int i = 0; i < plantilla.size(); i++) {
            sb.append("\n[").append(i + 1).append("] ").append(plantilla.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public double calcularNominaTotal() {
        double total = 0;
        for (Empleado e : plantilla) {
            total += e.calcularSalario();
        }
        return total;
    }

    public boolean hayEmpleados() {
        return !plantilla.isEmpty();
    }

    public ArrayList<Empleado> getPlantilla() {
        return plantilla;
    }
}