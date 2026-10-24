package expoedd;
public class ColaEstatica {
    // 1. ATRIBUTOS - Memoria Estática
    private int MAX = 5; // Tamaño máximo definido, como dice tu texto
    private int[] cola;
    private int front; // Apunta al frente / salida
    private int rear;  // TOPE / REAR - Apunta al final / entrada
    // Tu texto lo llama TOPE, normalmente se llama REAR

    // 2. CONSTRUCTOR
    public ColaEstatica() {
        cola = new int[MAX]; // Reservamos memoria fija
        front = -1;
        rear = -1;
    }

    // 3. VERIFICAR SI ESTÁ VACÍA
    public boolean estaVacia() {
        return front == -1;
    }

    // 4. VERIFICAR SI ESTÁ LLENA - Versión circular eficiente
    public boolean estaLlena() {
        return (rear + 1) % MAX == front;
    }

    // 5. ENQUEUE - Insertar al final
    public void enqueue(int dato) {
        if (estaLlena()) {
            System.out.println("OVERFLOW: Cola llena, no se puede insertar " + dato);
            return;
        }
        if (estaVacia()) {
            front = 0; // Primer elemento
        }
        rear = (rear + 1) % MAX; // Avance circular: si está en 4, vuelve a 0
        cola[rear] = dato;
        System.out.println("Enqueue: " + dato + " insertado en posición " + rear);
    }

    // 6. DEQUEUE - Eliminar del frente
    public int dequeue() {
        if (estaVacia()) {
            System.out.println("UNDERFLOW: Cola vacía");
            return -1;
        }
        int dato = cola[front];
        System.out.println("Dequeue: " + dato + " eliminado de posición " + front);
        
        if (front == rear) {
            // Solo quedaba un elemento, la cola queda vacía
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX; // Avance circular del front
        }
        return dato;
    }

    // 7. MOSTRAR COLA
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacía []");
            return;
        }
        System.out.print("Cola [FRONT -> ");
        int i = front;
        while (true) {
            System.out.print(cola[i] + " ");
            if (i == rear) break;
            i = (i + 1) % MAX;
        }
        System.out.println("<- REAR/TOPE]");
    } }

