import java.util.List;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        // ==========================================
        // ESCENARIO 1: Buffer Circular de Errores
        // ==========================================
        System.out.println("=== ESCENARIO 1: Buffer de Errores ===");
        ErrorLogBuffer logger = new ErrorLogBuffer();
        
        System.out.println("--- Agregando los primeros 3 errores ---");
        logger.addError("Error 1: Timeout de conexión");
        logger.addError("Error 2: NullPointerException");
        logger.addError("Error 3: Base de datos inalcanzable");
        
        System.out.println("Log actual: ");
        imprimirLog(logger.getSequentialLog());
        
        System.out.println("\n--- Llenando el buffer y dando la vuelta ---");
        logger.addError("Error 4: Disco lleno");
        logger.addError("Error 5: Memoria insuficiente");
        logger.addError("Error 6: CPU al 100%"); // ¡Este sobrescribirá el Error 1
        logger.addError("Error 7: Falla de red"); // ¡Este sobrescribirá el Error 2
        
        System.out.println("Log después de dar la vuelta:");
        imprimirLog(logger.getSequentialLog());


        // ==========================================
        // ESCENARIO 2: Sistema de Moderación
        // ==========================================
        System.out.println("\n=== ESCENARIO 2: Sistema de Moderación ===");
        
        // 1. Simulamos la carga de las palabras al inicio
        List<String> listaCargaInicial = Arrays.asList("spam", "estafa", "phishing", "fraude");
        ModerationSystem moderador = new ModerationSystem(listaCargaInicial);
        
        // 2. Simulamos las revisiones por segundo
        String palabraPrueba1 = "hola";
        String palabraPrueba2 = "Estafa"; // Comprobamos ignorando mayúsculas/minúsculas
        
        System.out.println("Revisando la palabra '" + palabraPrueba1 + "'...");
        System.out.println("¿Está prohibida? " + moderador.isBanned(palabraPrueba1));
        
        System.out.println("Revisando la palabra '" + palabraPrueba2 + "'...");
        System.out.println("¿Está prohibida? " + moderador.isBanned(palabraPrueba2));
    }
    
    // ASuxiliar para imprimir
    private static void imprimirLog(List<String> log) {
        for (int i = 0; i < log.size(); i++) {
            System.out.println((i + 1) + ". " + log.get(i));
        }
    }
}