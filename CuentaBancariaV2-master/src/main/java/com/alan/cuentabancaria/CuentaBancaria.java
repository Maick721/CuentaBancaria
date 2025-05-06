package com.alan.cuentabancaria;
/*Desarrollador:Maiccol Zurita
* fecha:05/05/2025
* descripcion: Clase padre de nombre CuentaBancaria
 * donde se van a crear metodos de deposito y retiro*/


public class CuentaBancaria {
    /*declaramos una atributo de tipo flotante para el saldo*/
    protected float saldo;
    /*atributo de tipo int con nombre numeroConsignaciones con inicio de 0*/
    protected int numeroConsignacion = 0;
    /*Numero de retiros de tipo int inicializado en 0*/
    protected int numeroRetiro = 0;
    /*Tasa anual de interes (Porcentaje), tipo Float*/
    protected float tasaAnual;
    /*comision mensual tipo flotante inicializa en 0*/
    protected float comisionMensual = 0;

    /*metodo constructor que recibe en este caso una cantidad de dinero
     * @Param saldo parametro que define el saldo de la cuenta
     * @Param tasaAnual que define la tasa anual de intereses*/
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    /*metodo para recibir una cantidad de dinero a depositar y actualiza el saldo
     * @Param cantidad, que define la cantidad de dinero que se deposita*/
    public void depositar(float cantidad) {
        saldo = saldo + cantidad;
        /*Se actualiza el numero de consignaciones*/
        numeroConsignacion = numeroConsignacion + 1;
    }

    /*metodo para retirar dinero
     * @Param cantidad: variable que retira el dinero*/
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;
        /*Verificar que el nuevo saldo sea positivo*/
        if (nuevoSaldo >= 0) {
            saldo = saldo - cantidad;
            numeroRetiro = numeroRetiro + 1;
        } else {
            System.out.println("No se puede retirar el dinero");
        }
    }

    public void interesMensual() {
        float tasaMensual = tasaAnual / 12;
        float interesRecibido = saldo * (tasaMensual / 100);
        saldo = saldo + interesRecibido;
    }

    public void extractoMensual() {
        /*Actualizamos el saldo restandole la comision mensual*/
        saldo -= comisionMensual;

        // Invocamos al metodo interés mensual
        interesMensual();
    }

    /*metodo para imprimir los datos de la cuenta*/
    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Número de consignaciones: " + numeroConsignacion);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: $" + comisionMensual);
    }
}

