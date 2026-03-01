import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;

class TextAnalyzer {
    // HashMap para inserciones y actualizaciones en O(1)
    private Map<String, Integer> wordCounts;

    public TextAnalyzer() {
        wordCounts = new HashMap<>();
    }

    // Método para simular la lectura del documento
    public void processDocument(String[] document) {
        for (String word : document) {
            word = word.toLowerCase(); // Normalizamos la palabra
            // Si la palabra ya existe, sumamos 1. Si no, la inicializamos en 1.
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
    }

    // Imprimir en orden alfabético usando TreeMap (O(k log k))
    public void printAlphabetically() {
        // Al pasar el HashMap al TreeMap, este ordena automáticamente las claves alfabéticamente
        Map<String, Integer> sortedAlphabetically = new TreeMap<>(wordCounts);
        
        System.out.println("--- Palabras en Orden Alfabético ---");
        for (Map.Entry<String, Integer> entry : sortedAlphabetically.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Imprimir por frecuencia de mayor a menor usando PriorityQueue
    public void printByFrequency() {
        // PriorityQueue ordenará las entradas basándose en el valor (la frecuencia) de mayor a menor
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );
        
        // Agregamos todas las entradas a la cola de prioridad
        queue.addAll(wordCounts.entrySet());

        System.out.println("--- Palabras Ordenadas por Frecuencia (Mayor a Menor) ---");
        // Extraemos e imprimimos hasta que la cola esté vacía
        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}