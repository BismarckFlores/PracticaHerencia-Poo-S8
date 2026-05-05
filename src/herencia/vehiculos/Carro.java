package herencia.vehiculos;

public class Carro extends Vehiculo {
    private int numeroPuertas;

    public Carro(String marca, String modelo, int numeroPuertas) {
        super(marca, modelo); // llama al constructor de Vehiculo
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // muestra marca y modelo
        System.out.println("Numero de puertas: " + numeroPuertas);
    }
}