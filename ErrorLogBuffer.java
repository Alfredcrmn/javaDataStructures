import java.util.ArrayList;
import java.util.List;

public class ErrorLogBuffer {
    private static final int MAX_CAPACITY = 10000;
    private List<String> errorLog;
    private int currentIndex;
    private boolean isFull;

    public ErrorLogBuffer() {
        // Pre-asignamos la capacidad para evitar el costo de redimensionamiento
        errorLog = new ArrayList<>(MAX_CAPACITY);
        currentIndex = 0;
        isFull = false;
    }

    // O(1) Inserción constante
    public void addError(String errorMessage) {
        if (!isFull && errorLog.size() < MAX_CAPACITY) {
            // Si no está lleno, simplemente agregamos al final
            errorLog.add(errorMessage);
        } else {
            // Si ya llegamos a MAX_CAPACITY, sobrescribimos el elemento más antiguo
            isFull = true;
            errorLog.set(currentIndex, errorMessage);
        }
        
        // Actualizamos el índice de forma circular
        currentIndex = (currentIndex + 1) % MAX_CAPACITY;
    }

    // O(n) Lectura secuencial rápida gracias a la localidad de memoria del ArrayList
    public List<String> getSequentialLog() {
        List<String> orderedLog = new ArrayList<>(errorLog.size());
        
        if (!isFull) {
            return new ArrayList<>(errorLog);
        }
        
        // Si el buffer ha dado la vuelta, leemos primero desde el índice actual hasta el final
        for (int i = currentIndex; i < MAX_CAPACITY; i++) {
            orderedLog.add(errorLog.get(i));
        }
        // Y luego desde el principio hasta el índice actual
        for (int i = 0; i < currentIndex; i++) {
            orderedLog.add(errorLog.get(i));
        }
        
        return orderedLog;
    }
}