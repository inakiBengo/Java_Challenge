package src.com.aluracursos.challenge.principal;

import src.com.aluracursos.challenge.hooks.BuscarCambio;
import src.com.aluracursos.challenge.records.Change;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String message = """
                *************************************
                1) Dólar           → Peso Argentino
                2) Peso Argentino  → Dólar
                3) Dólar           → Real Brasileño
                4) Real Brasileño  → Dólar
                5) Dólar           → Peso Colombiano
                6) Peso Colombiano → Dólar
                7) Salir
                Elija una opción valida, un numero
                del 1 al 7.
                *************************************
                """;
        try {
            while (true) {
                System.out.println(message);
                int option = input.nextInt();

                if (option > 7 || option < 1) {
                    System.out.println("Error: debe pasar un numero entre 1 y 7");
                    return;
                }

                if (option == 7) {
                    System.out.println("Que tenga un buen dia.");
                    break;
                }

                System.out.println("Ingrese un valor que quiera convertir");
                int money = input.nextInt();

                if (option == 1) {
                    Change result = BuscarCambio.cambio("USD", "ARS");
                    System.out.println(result.calculateChange(money));
                }
                if (option == 2) {
                    Change result = BuscarCambio.cambio("ARS", "USD");
                    System.out.println(result.calculateChange(money));
                }
                if (option == 3) {
                    Change result = BuscarCambio.cambio("USD", "BRL");
                    System.out.println(result.calculateChange(money));
                }
                if (option == 4) {
                    Change result = BuscarCambio.cambio("BRL", "USD");
                    System.out.println(result.calculateChange(money));
                }
                if (option == 5) {
                    Change result = BuscarCambio.cambio("USD", "COP");
                    System.out.println(result.calculateChange(money));
                }
                if (option == 6) {
                    Change result = BuscarCambio.cambio("COP", "USD");
                    System.out.println(result.calculateChange(money));
                }
            }
        } catch (InputMismatchException err) {
            System.out.println("Error: El valor debe ser numérico");
        }
        catch (RuntimeException err){
            System.out.println(err.getMessage());
        }
    }
}
