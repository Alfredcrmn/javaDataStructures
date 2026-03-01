import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        // ==========================================
        // ESCENARIO 1: Buffer Circular de Errores
        // ==========================================

        
        System.out.println("=== ESCENARIO 1: Buffer de Errores ===");
        ErrorLogBuffer logger = new ErrorLogBuffer();
        logger.addError("Error 1: Timeout de conexión");
        logger.addError("Error 2: NullPointerException");
        logger.addError("Error 3: Base de datos inalcanzable");

        System.out.println("Log actual: ");
        imprimirLog(logger.getSequentialLog());
        
        System.out.println("\n--- Llenando el buffer y dando la vuelta ---");

        logger.addError("Error 4: Disco lleno");
        logger.addError("Error 5: Memoria insuficiente");
        logger.addError("Error 6: CPU al 100%"); // Sobrescribe el error 1
        logger.addError("Error 7: Falla de red"); // Sobreescribe el error 2
        
        System.out.println("Log después de dar la vuelta al buffer:");
        imprimirLog(logger.getSequentialLog());


        // ==========================================
        // ESCENARIO 2: Sistema de Moderación
        // ==========================================
        System.out.println("\n=== ESCENARIO 2: Sistema de Moderación ===");
        List<String> listaCargaInicial = Arrays.asList("spam", "estafa", "phishing");
        ModerationSystem moderador = new ModerationSystem(listaCargaInicial);
        
        System.out.println("¿La palabra 'estafa' está prohibida? " + moderador.isBanned("estafa"));
        System.out.println("¿La palabra 'hola' está prohibida? " + moderador.isBanned("hola"));


        // ==========================================
        // ESCENARIO 3: Historial del Navegador
        // ==========================================
        System.out.println("\n=== ESCENARIO 3: Historial de Navegación ===");
        BrowserHistory history = new BrowserHistory();
        
        history.visit("google.com");
        history.visit("stackoverflow.com");
        history.visit("github.com");
        history.printCurrentPage(); 
        
        System.out.println("\n-- Probando botones Back y Forward --");
        history.goBack();    
        history.goBack();    
        history.goForward(); 
        history.printCurrentPage(); 


        // ==========================================
        // ESCENARIO 4: Analizador de Texto
        // ==========================================
        System.out.println("\n=== ESCENARIO 4: Analizador de Texto ===");
        TextAnalyzer analyzer = new TextAnalyzer();
        
        // Simulamos un mini documento con palabras repetidas
        String[] documentoSimulado = {
            "java", "codigo", "java", "estructura", "datos", 
            "codigo", "codigo", "optimización", "java", "java"
        };
        
        // Procesamos el documento
        analyzer.processDocument(documentoSimulado);
        
        // Se muestran los resultados con las estructuras auxiliares
        analyzer.printAlphabetically(); // Usa TreeMap
        System.out.println();
        analyzer.printByFrequency();    // Usa PriorityQueue
    }
    
    // Método auxiliar para imprimir el escenario 1
    private static void imprimirLog(List<String> log) {
        for (int i = 0; i < log.size(); i++) {
            System.out.println((i + 1) + ". " + log.get(i));
        }
    }
}