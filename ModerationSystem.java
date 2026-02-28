import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModerationSystem {
    private Set<String> bannedWords;

    // El constructor recibe la lista de palabras y las carga en el HashSet al inicio
    public ModerationSystem(List<String> initialWords) {
        bannedWords = new HashSet<>(initialWords);
    }

    // Método con complejidad O(1) para buscar la palabra al instante
    public boolean isBanned(String word) {
        // La función .contains() en un HashSet es extremadamente rápida
        return bannedWords.contains(word.toLowerCase());
    }
}