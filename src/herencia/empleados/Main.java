package herencia.empleados;

import javax.swing.JOptionPane;

public class Main {
    private static GestionEmpleados empresa = new GestionEmpleados();

    public static void main(String[] args) {
        String menuPrincipal = """
                SISTEMA DE GESTIÓN DE EMPLEADOS
                =================================
                1. Contratar empleado nuevo
                2. Despedir empleado
                3. Ver plantilla completa
                4. Calcular nómina total
                5. Salir
                """;

        int opcion;
        do {
            String entrada = JOptionPane.showInputDialog(null, menuPrincipal, "Menú Principal", JOptionPane.PLAIN_MESSAGE);
            if (entrada == null) break;
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> contratar();
                case 2 -> despedir();
                case 3 -> verPlantilla();
                case 4 -> calcularNomina();
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void contratar() {
        String[] tipos = {"Tiempo Completo", "Por Horas"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione tipo de empleado:", "Nuevo Empleado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

        if (tipo == JOptionPane.CLOSED_OPTION) return;

        String nombre = JOptionPane.showInputDialog("Nombre del empleado:");
        if (nombre == null || nombre.isBlank()) return;

        try {
            if (tipo == 0) { // Tiempo Completo
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario base mensual:"));
                empresa.contratar(new EmpleadoTiempoCompleto(nombre, salario));
            } else { // Por Horas
                double tarifa = Double.parseDouble(JOptionPane.showInputDialog("Tarifa por hora:"));
                int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas trabajadas:"));
                empresa.contratar(new EmpleadoPorHoras(nombre, tarifa, horas));
            }
            JOptionPane.showMessageDialog(null, "Empleado contratado exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: valor numérico no válido. No se pudo contratar.");
        }
    }

    private static void despedir() {
        if (!empresa.hayEmpleados()) {
            JOptionPane.showMessageDialog(null, "No hay empleados en la plantilla.");
            return;
        }
        String lista = empresa.listarEmpleados();
        String nombre = JOptionPane.showInputDialog(null, lista + "\nIngrese el nombre del empleado a despedir:", "Despedir Empleado", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null) return;
        if (empresa.despedir(nombre.trim())) {
            JOptionPane.showMessageDialog(null, "Empleado \"" + nombre + "\" despedido.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un empleado con ese nombre.");
        }
    }

    private static void verPlantilla() {
        JOptionPane.showMessageDialog(null, empresa.listarEmpleados(), "Plantilla de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void calcularNomina() {
        double total = empresa.calcularNominaTotal();
        String mensaje = "NÓMINA TOTAL: $" + total;
        JOptionPane.showMessageDialog(null, mensaje, "Nómina", JOptionPane.INFORMATION_MESSAGE);
    }
}