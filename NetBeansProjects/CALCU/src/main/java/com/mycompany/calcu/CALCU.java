/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calcu;

/**
 *
 * @author Ivam
 */
import java.util.Scanner;

public class CALCU {
    private Scanner sc;

    // Constructor
    public CALCU() {
        sc = new Scanner(System.in);
    }

    // Método principal de la calculadora
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n===== CALCULADORA BÁSICA =====");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> suma();
                case 2 -> resta();
                case 3 -> multiplicacion();
                case 4 -> division();
                case 5 -> System.out.println("👋 Gracias por usar la calculadora.");
                default -> System.out.println("⚠ Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Métodos de operaciones
    private void suma() {
        System.out.print("Ingresa el primer número: ");
        double a = sc.nextDouble();
        System.out.print("Ingresa el segundo número: ");
        double b = sc.nextDouble();
        System.out.println("Resultado = " + (a + b));
    }

    private void resta() {
        System.out.print("Ingresa el primer número: ");
        double a = sc.nextDouble();
        System.out.print("Ingresa el segundo número: ");
        double b = sc.nextDouble();
        System.out.println("Resultado = " + (a - b));
    }

    private void multiplicacion() {
        System.out.print("Ingresa el primer número: ");
        double a = sc.nextDouble();
        System.out.print("Ingresa el segundo número: ");
        double b = sc.nextDouble();
        System.out.println("Resultado = " + (a * b));
    }

    private void division() {
        System.out.print("Ingresa el dividendo: ");
        double a = sc.nextDouble();
        System.out.print("Ingresa el divisor: ");
        double b = sc.nextDouble();
        if (b != 0) {
            System.out.println("Resultado = " + (a / b));
        } else {
            System.out.println("⚠ Error: No se puede dividir entre 0");
        }
    }

    // 🚀 Punto de entrada
    public static void main(String[] args) {
        CALCU programa = new CALCU();
        programa.iniciar();
    }
}