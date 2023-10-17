import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExercicisMultiproces1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Introdueix un nombre: ");
            try {
                String input = reader.readLine();

                if (input.equals("exit")) {
                    System.out.println("Adeu!");
                    break;
                }

                try {
                    int num = Integer.parseInt(input);

                    // Llama a "java" para ejecutar el programa "ExercicisMultiproces1_ParellSenar" como un subproceso
                    ProcessBuilder pb = new ProcessBuilder("java", "C:\\GS2\\Prog\\Exercicis1\\src\\ExercicisMultiproces1_ParellSenar.java");
                    pb.redirectErrorStream(true);
                    Process process = pb.start();

                    // Escribe el número en el proceso hijo
                    PrintWriter pw = new PrintWriter(process.getOutputStream());
                    pw.println(num);
                    pw.flush();
                    pw.close();

                    // Lee y muestra la salida del proceso hijo
                    BufferedReader processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = processOutput.readLine()) != null) {
                        System.out.println(line);
                    }

                    process.waitFor();
                } catch (NumberFormatException e) {
                    System.out.println("Si us plau, introdueix un número enter positiu.");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
