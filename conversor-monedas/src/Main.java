import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = """
                ** Escriba el número de la opcion deseada **
                1 - Convertir de dólares a pesos argentinos
                2 - Convertir de pesos argentinos a dólares
                3 - Convertir de pesos colombianos a pesos argentinos
                4 - Convertir de pesos argentinos a pesos colombianos
                5 - Convertir de pesos chilenos a peso argentino
                6 - Convertir de pesos argentinos a peso chilenos
                7 - Salir
                """;

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        ConsultaConversion convertir = new ConsultaConversion();

        while (opcion != 7) {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la cantidad de dólares para convertir a pesos argentinos:");
                        double valorAConvertirUsdArs = teclado.nextDouble();
                        ValoresConvertidos valorConvertidoUsdArs = convertir.convertirValores("USD","ARS", valorAConvertirUsdArs);
                        System.out.println("Su cantidad convertida es:" + valorConvertidoUsdArs.conversion_result() + " ARS");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad de pesos argentinos para convertir a dólares:");
                        double valorAConvertirArsUsd = teclado.nextDouble();
                        ValoresConvertidos valorConvertidoArsUsd = convertir.convertirValores("ARS","USD", valorAConvertirArsUsd);
                        System.out.println("Su cantidad convertida es:" + valorConvertidoArsUsd.conversion_result() + " USD");
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad de pesos colombianos para convertir a pesos argentinos:");
                        double valorAConvertirEurArs = teclado.nextDouble();
                        ValoresConvertidos valorConvertidoEurArs = convertir.convertirValores("COP","ARS", valorAConvertirEurArs);
                        System.out.println("Su cantidad convertida es:" + valorConvertidoEurArs.conversion_result() + " ARS");
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad de pesos argentinos para convertir a pesos colombianos:");
                        double valorAConvertirArsEur = teclado.nextDouble();
                        ValoresConvertidos valorConvertidoArsEur = convertir.convertirValores("ARS","COP", valorAConvertirArsEur);
                        System.out.println("Su cantidad convertida es:" + valorConvertidoArsEur.conversion_result() + " COP");
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad de pesos chilenos para convertir a pesos argentinos:");
                        double valorAConvertirYenArs = teclado.nextDouble();
                        ValoresConvertidos valorConvertidoYenArs = convertir.convertirValores("CLP","ARS", valorAConvertirYenArs);
                        System.out.println("Su cantidad convertida es:" + valorConvertidoYenArs.conversion_result() + " ARS");
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad de pesos argentinos para convertir a pesos chilenos:");
                        double valorAConvertirArsYen = teclado.nextDouble();
                        ValoresConvertidos valorConvertidoArsYen = convertir.convertirValores("ARS","CLP", valorAConvertirArsYen);
                        System.out.println("Su cantidad convertida es:" + valorConvertidoArsYen.conversion_result() + " CLP");
                        break;
                    case 7:
                        System.out.println("Gracias por usar nuestro conversor!");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Se ingresó una opción errónea, se procedera a cerrrar la aplicación. Por favor, reinicie el programa.");
                break;
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Se cerrará la aplicación. Por favor, reporte el problema.");
                break;
            }
        }
    }
}