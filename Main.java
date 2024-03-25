package problema7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String path = "/Users/iurypedrosa/Desktop/Mesa/Sistemas de Informação./CURSOS/Back End/Java-Nelio-Udemy/Arquivos-curso/log.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path)); // Lendo o caminho do arquivo como argumento de linha de comando
            Map<String, Integer> votes = new HashMap<>();

            // Lendo o arquivo linha por linha
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String candidate = parts[0].trim();
                int count = Integer.parseInt(parts[1].trim());
                votes.put(candidate, votes.getOrDefault(candidate, 0) + count);
            }

            // Exibindo os resultados
            for (Map.Entry<String, Integer> entry : votes.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Por favor, especifique o caminho do arquivo como argumento.");
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número: " + e.getMessage());
        }
    }
}
