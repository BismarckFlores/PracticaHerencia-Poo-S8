package herencia.vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Vehiculo> lista = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE VEHICULOS ===");
            System.out.println("1. Registrar carro");
            System.out.println("2. Registrar moto");
            System.out.println("3. Ver todos los vehiculos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Marca: ");
                    String marcaCarro = entrada.nextLine();

                    System.out.print("Modelo: ");
                    String modeloCarro = entrada.nextLine();

                    System.out.print("Numero de puertas: ");
                    int numeroPuertas = entrada.nextInt();
                    entrada.nextLine();

                    Carro carro = new Carro(marcaCarro, modeloCarro, numeroPuertas);
                    lista.add(carro);

                    System.out.println("Carro registrado.");
                    break;

                case 2:
                    System.out.print("Marca: ");
                    String marcaMoto = entrada.nextLine();

                    System.out.print("Modelo: ");
                    String modeloMoto = entrada.nextLine();

                    System.out.print("Tipo: ");
                    String tipoMoto = entrada.nextLine();

                    Moto moto = new Moto(marcaMoto, modeloMoto, tipoMoto);
                    lista.add(moto);

                    System.out.println("Moto registrada.");
                    break;

                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("No hay vehiculos registrados.");
                    } else {
                        System.out.println("\n=== LISTA DE VEHICULOS ===");
                        for (Vehiculo v : lista) {
                            v.mostrarInfo();
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 4);

        entrada.close();
    }
}