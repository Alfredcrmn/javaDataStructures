import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        logger.addError("Error 6: CPU al 100%"); // ¡Este sobrescribirá el Error 1!
        logger.addError("Error 7: Falla de red"); // ¡Este sobrescribirá el Error 2!
        
        System.out.println("Log después de dar la vuelta (nota cómo el 1 y 2 desaparecen y el orden se mantiene):");
        imprimirLog(logger.getSequentialLog());
    }
    
    // Método auxiliar para imprimir bonito
    private static void imprimirLog(List<String> log) {
        for (int i = 0; i < log.size(); i++) {
            System.out.println((i + 1) + ". " + log.get(i));
        }
    }
}