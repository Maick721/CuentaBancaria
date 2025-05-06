package com.maiccol
    .cuentabancaria;

public class CuentaAhorros extends CuentaBancaria {
    //Declaramos una variable de tipo booleano
    private boolean activa;

    /*Creamos el constructor*/
    public CuentaAhorros(float saldo, float tasa){
        super(saldo,tasa);

        if(saldo<50)
        {
            //Se activa o desactiva la cuenta
            activa = false;
        }else {
            activa = true;
        }
    }
    //Implementa un metodo para depositar
    public void depositar(float cantidad){
        //VErificamos la cuenta este activa
        if(activa){
            super .depositar(cantidad);
        }
    }
    public void retirar(float cantidad){
        if (activa){
            super.retirar(cantidad);
        } else {
            System.out.println("No se puede retirar: la cuenta de ahorros esta inactiva");
        }
    }
    public void extractoMensual() {
        if (numeroRetiro > 4) {
            int retirosAdicionales = numeroRetiro - 4;
            comisionMensual = retirosAdicionales * 10;
        }

        super.extractoMensual();
        activa = saldo >= 50;

        System.out.println("=== Extracto Mensual Cuenta Ahorros ===");
        System.out.println("Estado de la cuenta: " + (activa ? "ACTIVA" : "INACTIVA"));
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Número de transacciones: " + (numeroConsignacion + numeroRetiro));
    }

    public boolean estaActiva() {
        return activa;
    }
}

