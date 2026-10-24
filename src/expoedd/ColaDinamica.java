package expoedd;
// 1. CLASE NODO - Cada elemento de la cola
class Nodo {
    int dato;
    Nodo siguiente; // Puntero al siguiente nodo

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null; // Como dice tu texto: apunta a puntero nulo
    }
}

public class ColaDinamica {
    // 2. ATRIBUTOS - Memoria Dinámica
    private Nodo front; // Puntero al primer elemento - NUNCA perderlo
    private Nodo rear;  // Puntero al último elemento - Donde se insertan nuevos

    // 3. CONSTRUCTOR
    public ColaDinamica() {
        front = null;
        rear = null;
    }

    // 4. VERIFICAR SI ESTÁ VACÍA
    public boolean estaVacia() {
        return front == null;
    }

    // 5. ENQUEUE - Insertar al final (por REAR)
    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);
        System.out.println("Enqueue: Creando nodo con dato " + dato);

        if (estaVacia()) {
            // Primer nodo - FRONT y REAR apuntan al mismo
            front = nuevo;
            rear = nuevo;
        } else {
            // Lista ya tiene elementos
            rear.siguiente = nuevo; // El último actual apunta al nuevo
            rear = nuevo;           // REAR ahora es el nuevo
        }
    }

    // 6. DEQUEUE - Eliminar del frente (por FRONT)
    public int dequeue() {
        if (estaVacia()) {
            System.out.println("UNDERFLOW: Cola vacía");
            return -1;
        }

        int datoEliminado = front.dato;
        System.out.println("Dequeue: Eliminando nodo del frente con dato " + datoEliminado);

        Nodo temp = front;
        front = front.siguiente; // FRONT avanza al siguiente nodo

        if (front == null) {
            // Se eliminó el último nodo, la cola queda vacía
            rear = null;
        }
        
        // En Java el Garbage Collector libera 'temp' automáticamente
        return datoEliminado;
    }

    // 7. MOSTRAR COLA
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacía: FRONT -> NULL <- REAR");
            return;
        }

        System.out.print("Cola Dinámica: FRONT -> ");
        Nodo actual = front;
        while (actual != null) {
            System.out.print("[" + actual.dato + "|•] -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL <- REAR");
        System.out.println("   FRONT apunta a: " + front.dato + " | REAR apunta a: " + rear.dato);
    }
}