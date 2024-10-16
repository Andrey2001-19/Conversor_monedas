package com.aluracursos.conversormodenas.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ObtencionConversionMoneda respuesta = new ObtencionConversionMoneda();

        while (true) {
            try {
                System.out.println("\n");
                System.out.println("***************************************");
                System.out.println("Bienvenido/a al Conversor de Monedas...");
                System.out.println("1) Dólar [USD] => Peso Mexicano [MXN]\n" +
                        "2) Peso Mexicano [MXN] => Dólar [USD]\n" +
                        "3) Dólar [USD] => Peso Argentino [ARS]\n" +
                        "4) Peso Argentino [ARS] => Dólar [USD]\n" +
                        "5) Dólar [USD] => Real Brasileño [BRL]\n" +
                        "6) Real Brasileño [BRL] => Dólar [USD]\n" +
                        "7) Salir");
                System.out.println("***************************************");
                System.out.println("Eliga la conversión que desea realizar:");
                var opcion = Integer.parseInt(lectura.nextLine());
                if (opcion == 7) {
                    break;
                } else if (opcion > 0 && opcion < 7) {
                    System.out.println("Ingrese el valor que deseas convertir:");
                    var valor = Double.valueOf(lectura.nextLine());
                    switch (opcion) {
                        case 1:
                            respuesta.resultado("USD", "MXN", valor);
                            break;
                        case 2:
                            respuesta.resultado("MXN", "USD", valor);
                            break;
                        case 3:
                            respuesta.resultado("USD", "ARS", valor);
                            break;
                        case 4:
                            respuesta.resultado("ARS", "USD", valor);
                            break;
                        case 5:
                            respuesta.resultado("USD", "BRL", valor);
                            break;
                        case 6:
                            respuesta.resultado("BRL", "USD", valor);
                            break;
                    }
                } else {
                    System.out.println("Opcion Invalida...");
                }
            }catch (NumberFormatException e){
                System.out.println("Opcion Invalida...");
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Cerrando Conversor.");
            }
        }
        System.out.println("Cerrando Conversor....");
    }
}