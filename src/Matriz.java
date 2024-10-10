import java.util.Scanner;

public class Matriz {
    static Scanner l = new Scanner(System.in);

    double[][] matriz;
    double[] arrSumas;
    double[][] array;


    /*----------------------------------------------------------------------------------------------------*/
    //Defino y lleno matriz por el usuario. (1)
    public Matriz() { //crea y llena
        int m;
        int n;
        do {
            System.out.println("");
            System.out.println("¡¡¡CREANDO UNA MATRIZ!!!");
            System.out.print("Indique el número de filas (mínimo 3): ");
            m = l.nextInt();
            System.out.print("Indique el número de columnas (mínimo 2): ");
            n = l.nextInt();
            if (m < 3 || n < 2) {
                System.out.println("Error: El tamaño mínimo de la matriz debe ser 3x2. Inténtalo nuevamente.");
            }
        } while (m < 3 || n < 2);
        matriz = new double[m][n];
        System.out.println("Ingrese los valores de la Matriz colocando n° con coma: ");
        for (int i = 0; i < m; i++) {      //filas
            for (int j = 0; j < n; j++) {  //col
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = l.nextDouble();

            }
        }


    }

    //Muestro (2)
    public void mostrar() {
        System.out.println("Los n° de la Matriz son: ");
        for (int i = 0; i < matriz.length; i++) {      //filas
            for (int j = 0; j < matriz[i].length; j++) {  //col
                System.out.print("[" + matriz[i][j] + "]" + " ");
            }
            System.out.println();
        }
        //l.close();

    }

    //Sumo las filas y las muestro (3 y 4)
    public void sumaDeFilas() {
        arrSumas = new double[matriz.length];
        double sumaFila = 0;
        for (int i = 0; i < matriz.length; i++) {
            sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }

            arrSumas[i] = sumaFila;
        }
        // Imprimir la matriz resultante como una columna
        System.out.println("Matriz resultante (suma de filas en una columna):");
        for (int i = 0; i < arrSumas.length; i++) {
            System.out.printf("%.2f\n", arrSumas[i]);
        }
    }

    //Genero matriz con sumas, la ordeno y muestro(5 y 6)
    public void sumarYordenar() {
        if (arrSumas == null) {
            sumaDeFilas();
        }

        this.array = new double[matriz.length][2];
        int N = arrSumas.length;
        double[][] array = new double[N][2];

        // Inicializar la matriz ordenada con las sumas y los índices originales
        for (int i = 0; i < N; i++) {
            array[i][0] = arrSumas[i]; // Columna 0: suma
            array[i][1] = i;             // Columna 1: índice original
        }

        // Algoritmo de ordenamiento burbuja para ordenar de mayor a menor basado en las sumas
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (array[j][0] < array[j + 1][0]) {
                    // Intercambiar las filas completas (suma e índice)
                    double[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Imprimir la nueva matriz ordenada (suma y su índice original) (6)
        System.out.println("Suma  | Índice Original");
        for (int i = 0; i < N; i++) {
            System.out.printf("%.2f  | %.0f\n", array[i][0], array[i][1]);
        }
    }

    //Muestro solo la columna de las sumas ordenadas (7)
    public void sumaTotal() {
        if (arrSumas == null) {
            sumaDeFilas();
        }
        int n = arrSumas.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrSumas[j] < arrSumas[j + 1]) { // Comparar elementos adyacentes
                    // Intercambiar los elementos
                    double temp = arrSumas[j];
                    arrSumas[j] = arrSumas[j + 1];
                    arrSumas[j + 1] = temp;
                }
            }
        }

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo ordenado de mayor a menor:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\n", arrSumas[i]);
        }

    }

}

