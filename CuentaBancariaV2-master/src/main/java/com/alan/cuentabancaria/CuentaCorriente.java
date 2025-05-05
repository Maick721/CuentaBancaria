package com.alan.cuentabancaria;

public class CuentaCorriente extends CuentaBancaria {

    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
    }

    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            sobregiro += cantidad - saldo;
            saldo = 0;
        } else {
            saldo -= cantidad;
        }
        numeroRetiro++;
    }

    public void depositar(float cantidad) {
        if (sobregiro > 0) {
            float pagoSobregiro = Math.min(cantidad, sobregiro);
            sobregiro -= pagoSobregiro;
            cantidad -= pagoSobregiro;
        }
        if (cantidad > 0) {
            super.depositar(cantidad);
        }
    }

    public void extractoMensual() {
        super.extractoMensual();
    }
    // d. Método para imprimir información de la cuenta
    public void imprimir() {
        System.out.println("----- ESTADO DE CUENTA CORRIENTE -----");
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Transacciones totales: " + (numeroConsignacion + numeroRetiro));
        System.out.println("Valor de sobregiro: $" + sobregiro);
    }
}

