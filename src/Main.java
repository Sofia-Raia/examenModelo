import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matriz m = new Matriz();
        boolean continuar = true;


        do {
            System.out.println("@@@ MENÚ DE OPERACIONES CON MATRIZ @@@");
            System.out.println("Ingrese una obcion del 1 al 5");
            System.out.println("1 MOSTRAR MATRIZ");
            System.out.println("2 SUMAR SUS FILAS");
            System.out.println("3 MOSTRAR SUMAS ORDENADAS Y SUS INDICES");
            System.out.println("4 FILA DE SUMAS ORDENADAS");
            System.out.println("5 SALIR");
            System.out.println("----------------------------------------------");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    m.mostrar();
                    break;
                case 2:
                    m.sumaDeFilas();
                    break;
                case 3:
                    m.sumarYordenar();
                    break;
                case 4:
                    m.sumaTotal();
                    break;
                case 5:
                    System.out.println("Usted salió del sistema!!");
                    continuar=false;
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (continuar);

    }
}