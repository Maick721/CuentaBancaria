package com.alan.cuentabancaria;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = null;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta Corriente");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Ver Extracto Mensual");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("Gracias por usar el sistema bancario.");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese saldo inicial: ");
                    float saldoAhorros = scanner.nextFloat();
                    System.out.print("Ingrese tasa de interés anual: ");
                    float tasaAhorros = scanner.nextFloat();
                    cuenta = new CuentaAhorros(saldoAhorros, tasaAhorros);
                    System.out.println("Cuenta de Ahorros creada.");
                    break;
                case 2:
                    System.out.print("Ingrese saldo inicial: ");
                    float saldoCorriente = scanner.nextFloat();
                    System.out.print("Ingrese tasa de interés anual: ");
                    float tasaCorriente = scanner.nextFloat();
                    cuenta = new CuentaCorriente(saldoCorriente, tasaCorriente);
                    System.out.println("Cuenta Corriente creada.");
                    break;
                case 3:
                    if (cuenta != null) {
                        System.out.print("Ingrese cantidad a depositar: ");
                        float deposito = scanner.nextFloat();
                        cuenta.depositar(deposito);
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Debe crear una cuenta primero.");
                    }
                    break;
                case 4:
                    if (cuenta != null) {
                        System.out.print("Ingrese cantidad a retirar: ");
                        float retiro = scanner.nextFloat();
                        cuenta.retirar(retiro);
                        System.out.println("Retiro realizado.");
                    } else {
                        System.out.println("Debe crear una cuenta primero.");
                    }
                    break;
                case 5:
                    if (cuenta != null) {
                        cuenta.extractoMensual();
                        System.out.println("\n=== EXTRACTO MENSUAL ===");
                        System.out.println("Saldo actual: $" + cuenta.saldo);
                        System.out.println("Comisión mensual: $" + cuenta.comisionMensual);
                    } else {
                        System.out.println("Debe crear una cuenta primero.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
