package com.mycompany.nequix;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Ivam
 */
public class NequiX {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Paso 1: Crear usuario
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();

        System.out.print("Ingresa tu dinero inicial: ");
        double dinero = sc.nextDouble();

        Usuario usuario;
        try {
            usuario = new Usuario(nombre, edad, dinero);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // termina el programa si es menor de edad
        }

        // Paso 2: Crear bancos
        ArrayList<Banco> bancos = new ArrayList<>();
        bancos.add(new Banco("Banco de Occidente", 0.05));  // 5% IVA
        bancos.add(new Banco("Bancolombia", 0.03));         // 3% IVA
        bancos.add(new Banco("Banco Popular", 0.02));       // 2% IVA

        // Lista de operaciones realizadas
        ArrayList<String> operaciones = new ArrayList<>();

        // Paso 3: Menú
        int opcion;
        do {
            System.out.println("\n--- Menú Nequi ---");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Ver historial de operaciones");
            System.out.println("4. Ver saldo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Monto a depositar: ");
                    double montoDeposito = sc.nextDouble();
                    Banco bancoDeposito = elegirBanco(bancos, sc);
                    usuario.depositar(montoDeposito, bancoDeposito, operaciones);
                }
                case 2 -> {
                    System.out.print("Monto a retirar: ");
                    double montoRetiro = sc.nextDouble();
                    Banco bancoRetiro = elegirBanco(bancos, sc);
                    usuario.retirar(montoRetiro, bancoRetiro, operaciones);
                }
                case 3 -> {
                    System.out.println("\n--- Historial ---");
                    for (String op : operaciones) {
                        System.out.println(op);
                    }
                }
                case 4 -> System.out.println("Saldo actual: " + usuario.getSaldo());
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    // Método para elegir banco
    private static Banco elegirBanco(ArrayList<Banco> bancos, Scanner sc) {
        System.out.println("\nElige un banco:");
        for (int i = 0; i < bancos.size(); i++) {
            System.out.println((i + 1) + ". " + bancos.get(i).getNombre() + " (IVA: " + (bancos.get(i).getIva() * 100) + "%)");
        }
        int eleccion = sc.nextInt();
        return bancos.get(eleccion - 1);
    }
}