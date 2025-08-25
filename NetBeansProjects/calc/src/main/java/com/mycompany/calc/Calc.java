/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calc;

import java.util.Scanner;

public class Calc {
    private Scanner sc;

    // Constructor
    public Calc() {
        sc = new Scanner(System.in);
    }

    // Método que muestra el menú
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n===== CALCULADORA DE ÁREAS =====");
            System.out.println("1. Área del Triángulo");
            System.out.println("2. Área del Cuadrado");
            System.out.println("3. Área del Rectángulo");
            System.out.println("4. Área del Círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> areaTriangulo();
                case 2 -> areaCuadrado();
                case 3 -> areaRectangulo();
                case 4 -> areaCirculo();
                case 5 -> System.out.println("👋 Gracias por usar la calculadora.");
                default -> System.out.println("⚠ Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Métodos para calcular áreas
    private void areaTriangulo() {
        System.out.print("Ingresa la base: ");
        double base = sc.nextDouble();
        System.out.print("Ingresa la altura: ");
        double altura = sc.nextDouble();
        double area = (base * altura) / 2;
        System.out.println("Área del triángulo = " + area);
    }

    private void areaCuadrado() {
        System.out.print("Ingresa el lado: ");
        double lado = sc.nextDouble();
        double area = lado * lado;
        System.out.println("Área del cuadrado = " + area);
    }

    private void areaRectangulo() {
        System.out.print("Ingresa la base: ");
        double base = sc.nextDouble();
        System.out.print("Ingresa la altura: ");
        double altura = sc.nextDouble();
        double area = base * altura;
        System.out.println("Área del rectángulo = " + area);
    }

    private void areaCirculo() {
        System.out.print("Ingresa el radio: ");
        double radio = sc.nextDouble();
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Área del círculo = " + area);
    }

    // 🚀 Punto de entrada
    public static void main(String[] args) {
        Calc programa = new Calc();
        programa.iniciar();
    }
}
