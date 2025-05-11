package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int code1 = 0;
        int code2 = 0;
        double mount = 1.0;
        double result = 0;
        String baseCurrency = "";
        String targetCurrency = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n*** Elija la moneda de origen: ***");
                currencyMenu();
                code1 = scanner.nextInt();
                if (code1 == 7) { break; }

                System.out.println("\n*** Ingrese el monto: ***");
                mount = scanner.nextDouble();

                System.out.println("\n*** Elija la moneda de destino ***");
                currencyMenu();
                code2 = scanner.nextInt();
                if (code2 == 7) { break; }

                baseCurrency = convertCurrencyCodeToString(code1);
                targetCurrency = convertCurrencyCodeToString(code2);

                Search search = new Search();
                Conversion conversion = search.search(baseCurrency, targetCurrency);
                result = mount * conversion.conversion_rate();
                System.out.println("\n" + mount + " " + baseCurrency + " equivalen " + result + " " + targetCurrency);

            } catch (Exception e) {
                System.out.println("Error:\n"
                        + e.getMessage());;
            }
        }
        scanner.close();
        System.out.println("\n*** Programa finalizado. ***");
    }

    public static void currencyMenu() {
        System.out.println("""
                1. ARS - Peso argentino
                2. BOB - Boliviano boliviano
                3. BRL - Real brasileño
                4. CLP - Peso chileno
                5. COP - Peso colombiano
                6. USD - Dólar estadounidense
                7. Salir
                """);
    }

    public static String convertCurrencyCodeToString(int choice) {
        return switch (choice) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> throw new RuntimeException("Elección no válida");
        };
    }
}
