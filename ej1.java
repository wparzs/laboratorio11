//        // Validaciones:
// Las notas son de 0 a 20
// Los alumnos deben tener al menos nombre y apellido

// PASO 1: INGRESA LA CANTIDAD DE ESTUDIANTES
// PASO 2: INGRESA LAS NOTAS DEL ESTUDIANTE
// PASO 3: CALCULA EL PROMEDIO DEL ESTUDIANTE
// PASO 3: CALCULA LA NOTA MAS ALTA
// PASO 3: CALCULA LA NOTA MAS BAJA
// PASO 3: CALCULA LA MEDIA
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa numero de estudiantes: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        
        String[] nombres = new String[cantidad];
        int[] notas = new int[cantidad * 4]; 

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingresa nombre del estudiante: ");
            String nombre = scanner.nextLine();
            nombres[i] = nombre;

            for (int j = 0; j < 4; j++) {
                System.out.print("inngresa nota del estudiante" + (j + 1) + ": ");
                int nota = scanner.nextInt();
                while (!verifnota(nota)) {
                    System.out.print("NIngresa una nota de 0 a 20: ");
                    nota = scanner.nextInt();
                }
                notas[i * 4 + j] = nota; 
            }
            scanner.nextLine();
        }

        for (int i = 0; i < cantidad; i++){
            double promedio = prom(notas, i);
            int mayo = n_alta(notas, i);
            int men = n_baja(notas, i);

            System.out.println("alumno:" + nombres[i]);
            System.out.println("promedio: " + promedio);
            System.out.println("NOTTA MAS ALTA: " + mayo);
            System.out.println("nota MAS BAJA: " + men);
            System.out.println();
        }
        scanner.close();
    }
    public static boolean verifnota(int nota) {
        return nota >= 0 && nota <= 20;
    }
    public static double prom(int[] notas, int i){
        double suma = 0;
        for (int j= 0; j < 4; j++) {
            suma += notas[i* 4 + j];
        }
        return suma/4; 
    }

    public static int n_alta(int[] notas, int i){
        int mayo = notas[i *4];
        for (int j= 1; j <4; j++) {
            if (notas[i *4 + j] > mayo) {
                mayo= notas[i* 4 + j];
            }
        }
        return mayo;
    }
public static int n_baja(int[] notas, int i){
    int menor = notas[i * 4];
    for (int j = 1; j < 4;j++) {
        if (notas[i * 4 +j] < menor) {
            menor = notas[i * 4 + j];
        }
    }
    return menor;
}
}
