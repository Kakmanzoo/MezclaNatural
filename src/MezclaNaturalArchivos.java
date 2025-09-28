import java.io.*;
import java.util.*;

public class MezclaNaturalArchivos {

    // Método principal de Mezcla Natural
    public static void mezclaNatural(String archivoEntrada, String archivoSalida) throws IOException {
        String aux1 = "aux1.txt";
        String aux2 = "aux2.txt";

        String actual = archivoEntrada;
        String destino = archivoSalida;

        while (true) {
            repartirRuns(actual, aux1, aux2);
            int runs = fusionarRuns(aux1, aux2, destino);

            if (runs <= 1) break; // ya está ordenado

            // intercambiar roles
            String temp = actual;
            actual = destino;
            destino = temp;
        }
    }

    // Repartir runs entre dos archivos auxiliares
    private static void repartirRuns(String entrada, String aux1, String aux2) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(entrada));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(aux1));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(aux2))
        ) {
            boolean turno = false; // false = aux1, true = aux2
            String linea = br.readLine();
            if (linea == null) return;

            int prev = Integer.parseInt(linea);
            List<Integer> run = new ArrayList<>();
            run.add(prev);

            while ((linea = br.readLine()) != null) {
                int val = Integer.parseInt(linea);
                if (val >= prev) {
                    run.add(val);
                } else {
                    // guardar la run completa
                    BufferedWriter destino = turno ? bw2 : bw1;
                    for (int x : run) {
                        destino.write(x + "\n");
                    }
                    turno = !turno;
                    run.clear();
                    run.add(val);
                }
                prev = val;
            }

            // última run
            BufferedWriter destino = turno ? bw2 : bw1;
            for (int x : run) {
                destino.write(x + "\n");
            }
        }
    }

    // Fusionar runs de aux1 y aux2 en salida
    private static int fusionarRuns(String aux1, String aux2, String salida) throws IOException {
        try (
            BufferedReader br1 = new BufferedReader(new FileReader(aux1));
            BufferedReader br2 = new BufferedReader(new FileReader(aux2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(salida))
        ) {
            int numRuns = 0;

            while (true) {
                List<Integer> run1 = leerRun(br1);
                List<Integer> run2 = leerRun(br2);

                if (run1.isEmpty() && run2.isEmpty()) break;

                if (run2.isEmpty()) {
                    for (int x : run1) { bw.write(x + "\n"); }
                } else if (run1.isEmpty()) {
                    for (int x : run2) { bw.write(x + "\n"); }
                } else {
                    // merge clásico
                    int i = 0, j = 0;
                    while (i < run1.size() && j < run2.size()) {
                        if (run1.get(i) <= run2.get(j)) {
                            bw.write(run1.get(i++) + "\n");
                        } else {
                            bw.write(run2.get(j++) + "\n");
                        }
                    }
                    while (i < run1.size()) bw.write(run1.get(i++) + "\n");
                    while (j < run2.size()) bw.write(run2.get(j++) + "\n");
                }
                numRuns++;
            }
            return numRuns;
        }
    }

    // Leer una run (secuencia ordenada) desde un archivo
    private static List<Integer> leerRun(BufferedReader br) throws IOException {
        List<Integer> run = new ArrayList<>();
        br.mark(1000);
        String linea = br.readLine();
        if (linea == null) return run;

        int prev = Integer.parseInt(linea);
        run.add(prev);

        while (true) {
            br.mark(1000);
            String siguiente = br.readLine();
            if (siguiente == null) break;
            int val = Integer.parseInt(siguiente);

            if (val >= prev) {
                run.add(val);
                prev = val;
            } else {
                br.reset(); // retroceder
                break;
            }
        }
        return run;
    }

    // Método de prueba
    public static void main(String[] args) throws IOException {
        // Archivo original con números desordenados
        String entrada = "datos.txt";
        String salida = "ordenado.txt";

        // Ejecutar Mezcla Natural
        mezclaNatural(entrada, salida);

        System.out.println("Archivo ordenado generado en: " + salida);
    }
}
