import java.util.ArrayDeque;
import java.util.Deque;

class BrowserHistory {
    // Utilizamos Deque como si fueran Stacks para mejor rendimiento
    private Deque<String> backStack;
    private Deque<String> forwardStack;
    private String currentPage;

    public BrowserHistory() {
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        currentPage = "about:blank"; // Página inicial por defecto
    }

    // O(1) - Visitar una nueva página
    public void visit(String url) {
        System.out.println("Visitando nueva página: " + url);
        if (!currentPage.equals("about:blank")) {
            backStack.push(currentPage); // Guardamos la página actual en el historial hacia atrás
        }
        currentPage = url;
        forwardStack.clear(); // Al visitar nueva página, se borra el historial hacia adelante
    }

    // Ir hacia atrás
    public void goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No hay historial hacia atrás.");
            return;
        }
        forwardStack.push(currentPage); // Guardamos la actual en forward antes de retroceder
        currentPage = backStack.pop();  // Sacamos la última visitada
        System.out.println("<- Navegando hacia atrás a: " + currentPage);
    }

    // Ir hacia adelante
    public void goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No hay historial hacia adelante.");
            return;
        }
        backStack.push(currentPage);     // Guardamos la actual en back antes de avanzar
        currentPage = forwardStack.pop(); // Recuperamos la página de forward
        System.out.println("-> Navegando hacia adelante a: " + currentPage);
    }

    public void printCurrentPage() {
        System.out.println("Página actual: [" + currentPage + "]");
    }
}