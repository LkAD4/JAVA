package com.mycompany.nequix;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

/**
 *
 * @author Ivam
 */
// Clase Persona
class Usuario extends Persona {
    private double saldo;

    public Usuario(String nombre, int edad, double dinero) {
        super(nombre, edad, dinero);
        if (edad < 18) {
            throw new IllegalArgumentException("Debes ser mayor de edad para crear una cuenta Nequi.");
        }
        this.saldo = dinero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto, Banco banco, ArrayList<String> operaciones) {
        double iva = banco.getIva();
        double montoFinal = monto - (monto * iva); // se descuenta el IVA
        saldo += montoFinal;
        operaciones.add("Depósito en " + banco.getNombre() + ": +" + montoFinal + " (IVA aplicado: " + (iva * 100) + "%)");
    }

   public void retirar(double monto, Banco banco, ArrayList<String> operaciones) {
    double iva = banco.getIva();
    double montoConIva = monto + (monto * iva); // al retirar, se descuenta el monto + IVA

    if (montoConIva > saldo) {
        System.out.println("Fondos insuficientes. Necesitas al menos " + montoConIva + " para retirar " + monto);
        return;
    }

    saldo -= montoConIva;
    operaciones.add("Retiro en " + banco.getNombre() + ": -" + monto + 
                    " (IVA cobrado: " + (iva * 100) + "%)");
    }
}
