import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Counter!");
        System.out.println("Select any one from below mentioned option:");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file path");

        int option = scanner.nextInt();
        scanner.nextLine();

        String inputText = "";

        switch (option) {
            case 1:
                System.out.println("Enter your text:");
                inputText = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                try {
                    inputText = readFile(filePath);
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Invalid option");
                return;
        }

        
        String[] words = inputText.split("[\\s\\p{Punct}]+");

        
        int wordCount = 0;

        
        Set<String> uniqueWords = new HashSet<>();

        
        Map<String, Integer> wordFrequency = new HashMap<>();

        
        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "a", "an", "the", "in", "on", "at", "to", "of", "for", "and"
        ));

        
        for (String word : words) {
            
            word = word.toLowerCase().trim();
            
            
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordCount++;
                uniqueWords.add(word);

            
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        
        System.out.println("Total word count: " + wordCount);

        
        System.out.println("Number of unique words: " + uniqueWords.size());

        
        System.out.println("Word frequency statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
