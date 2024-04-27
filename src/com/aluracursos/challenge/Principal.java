package src.com.aluracursos.challenge;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> historial = new ArrayList<>();
        String message = """
                *************************************
                1) Dólar           → Peso Argentino
                2) Peso Argentino  → Dólar
                3) Dólar           → Real Brasileño
                4) Real Brasileño  → Dólar
                5) Dólar           → Peso Colombiano
                6) Peso Colombiano → Dólar
                7) Ver el historial
                8) Salir
                Elija una opción valida, un numero
                del 1 al 7.
                *************************************
                """;
        try {
            while (true) {
                System.out.println(message);
                int option = input.nextInt();

                if (option > 8 || option < 1) {
                    System.out.println("Error: debe pasar un numero entre 1 y 8");
                    continue;
                }

                if (option == 8) {
                    System.out.println("Que tenga un buen dia.");
                    break;
                }

                if (option == 7) {
                    if (!historial.isEmpty()) {
                        System.out.println("Historial:");
                        for (String item : historial) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("El historial esta vacío.");
                    }
                    continue;
                }

                System.out.println("Ingrese un valor que quiera convertir");
                var money = input.nextDouble();

                if (option == 1) {
                    convertir("USD", "ARS", historial, money);
                }
                if (option == 2) {
                    convertir("ARS", "USD", historial, money);
                }
                if (option == 3) {
                    convertir("USD", "BRL", historial, money);
                }
                if (option == 4) {
                    convertir("BRL", "USD", historial, money);
                }
                if (option == 5) {
                    convertir("USD", "COP", historial, money);
                }
                if (option == 6) {
                    convertir("COP", "USD", historial, money);
                }
            }
        } catch (InputMismatchException err) {
            System.out.println("Error: El valor debe ser numérico");
        }
        catch (RuntimeException err){
            System.out.println(err.getMessage());
        }
    }
    private static void convertir(String fromCurrency, String toCurrency, List<String> historial, double money) {
        String result = BuscarCambio
                .cambio(fromCurrency, toCurrency)
                .calculateChange(money);
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm | ");
        String formattedDateTime = time.format(formatter);
        historial.add(formattedDateTime + result);
        System.out.println(result);
    }
}
