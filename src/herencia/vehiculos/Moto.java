package herencia.vehiculos;

public class Moto extends Vehiculo {
    private String tipo;

    public Moto(String marca, String modelo, String tipo) {
        super(marca, modelo); // llama al constructor del padre
        this.tipo = tipo;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // reutiliza lo del padre
        System.out.println("Tipo: " + tipo);
    }
}
