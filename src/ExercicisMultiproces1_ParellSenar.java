import java.util.Scanner;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix un nombre: ");
        int nombre = scanner.nextInt();

        if (nombre % 2 == 0) {
            System.out.println("Parell");
        } else {
            System.out.println("Senar");
        }

        scanner.close();
    }
}
