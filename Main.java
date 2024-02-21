import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductosLocales = new ArrayList<>();
        ArrayList<Producto> listaProductosForáneos = new ArrayList<>();

        boolean seguirEnMenu = true;
        Scanner input = new Scanner(System.in);

        while(seguirEnMenu){
            System.out.print(
                    "\n\nSelecciona el número correspondiente a la opción que deseas:\n" +
                            "1 - Registrar artículos locales\n" +
                            "2 - Registrar artículos importados\n" +
                            "3 - Mostrar artículos locales\n" +
                            "4 - Mostrar artículos importados\n" +
                            "5 - Buscar artículo local\n" +
                            "6 - Buscar artículo importado" +
                            "\nIndica tu opción:\t"
            );
            int opción = input.nextInt();
            input.nextLine();

            if (opción == 1){
                System.out.println("Introduce el nombre del artículo:\t");
                String nombre = input.nextLine();

                System.out.println("Ingresa el número identificador del artículo:\t");
                int identificador = input.nextInt();
                input.nextLine();

                System.out.println("Escribe el código DIAN (Dirección de Impuestos y Aduanas Nacionales):\t");
                String códigoDIAN = input.nextLine();
                listaProductosLocales.add(new Nacional(nombre, identificador, códigoDIAN));
            }


            else if (opción == 2) {
                System.out.println("Ingresa el nombre del artículo:\t");
                String nombre = input.nextLine();

                System.out.println("Indica el número identificador del artículo:\t");
                int identificador = input.nextInt();
                input.nextLine();

                System.out.println("Escribe el permiso de importación:\t");
                String permiso = input.nextLine();
                listaProductosLocales.add(new Nacional(nombre, identificador, permiso));

            }


            else if (opción == 3) {
                ImpresoraLista.mostrarLista(listaProductosLocales);
                if(listaProductosForáneos.size() == 0){
                    System.out.println("No hay artículos en la lista de productos locales");
                }
            }

            else if (opción == 4) {
                ImpresoraLista.mostrarLista((listaProductosForáneos));
                if(listaProductosForáneos.size() == 0){
                    System.out.println("No hay artículos en esta lista de productos importados");
                }
            }



            else if (opción == 5){
                System.out.println("Ingresa el nombre del artículo local que quieres buscar:\t");
                String nombreABuscar = input.nextLine();
                boolean encontrado = false;
                for (Producto producto: listaProductosLocales){
                    if (Objects.equals(producto.nombre, nombreABuscar)){
                        System.out.printf("Sí, el artículo %s está en la lista.", nombreABuscar);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado){
                    System.out.printf("No, el artículo %s no está en la lista.", nombreABuscar);
                }
            }

            else if (opción == 6){
                System.out.println("Ingresa el nombre del artículo importado que deseas buscar:\t");
                String nombreABuscar = input.nextLine();
                boolean encontrado = false;
                for (Producto producto: listaProductosForáneos){
                    if (Objects.equals(producto.nombre, nombreABuscar)){
                        System.out.printf("Sí, el artículo %s está en la lista.", nombreABuscar);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado){
                    System.out.printf("No, el artículo %s no está en la lista.", nombreABuscar);
                }
            }

            validarSalida(seguirEnMenu);
        }
    }


    public static void validarSalida(boolean seguirEnMenu){
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nProceso finalizado. Presiona 0 para salir o enter para continuar\t");
        String respuesta = entrada.nextLine();
        if (Objects.equals(respuesta, "0")){
            seguirEnMenu = false;
        }
    }
}

