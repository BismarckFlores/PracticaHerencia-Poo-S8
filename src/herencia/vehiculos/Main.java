package herencia.vehiculos;

public class Main {
    public static void main(String[] args) {

        // Crear objetos
        Carro carro1 = new Carro("Toyota", "Corolla", 4);
        Moto moto1 = new Moto("Yamaha", "R1", "Deportiva");

        // Mostrar informacion
        System.out.println(" Carro ");
        carro1.mostrarInfo();

        System.out.println("\n Moto");
        moto1.mostrarInfo();
    }
}