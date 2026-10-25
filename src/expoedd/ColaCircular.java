package expoedd;
public class ColaCircular {
    private int[] datos;
    private int frente;
    private int fin;
    private int tam;
    private int capacidad;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.frente = -1;
        this.fin = -1;
        this.tam = 0;
    }

    public boolean isEmpty() {
        return tam == 0;
    }

    public boolean isFull() {
        return tam == capacidad;
    }

    // ENCOLAR - offer
    public void offer(int valor) {
        if (isFull()) {
            System.out.println("Cola llena, no se puede insertar " + valor);
            return;
        }
        if (isEmpty()) {
            frente = 0;
        }
        // AQUÍ ESTÁ LA MAGIA CIRCULAR
        fin = (fin + 1) % capacidad; 
        datos[fin] = valor;
        tam++;
    }

    // DESENCOLAR - poll
    public int poll() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        int valor = datos[frente];
        if (frente == fin) { // era el último elemento
            frente = -1;
            fin = -1;
        } else {
            // MAGIA CIRCULAR OTRA VEZ
            frente = (frente + 1) % capacidad;
        }
        tam--;
        return valor;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return datos[frente];
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return;
        }
        System.out.print("Cola: ");
        for (int i = 0; i < tam; i++) {
            int idx = (frente + i) % capacidad;
            System.out.print(datos[idx] + " ");
        }
        System.out.println(" (frente=" + frente + ", fin=" + fin + ")");
    }

    // MAIN DE PRUEBA
    public static void main(String[] args) {
        ColaCircular cola = new ColaCircular(5);

        cola.offer(10);
        cola.offer(20);
        cola.offer(30);
        cola.offer(40);
        cola.offer(50);
        cola.mostrar(); // 10 20 30 40 50

        System.out.println("Sacamos: " + cola.poll()); // 10
        System.out.println("Sacamos: " + cola.poll()); // 20
        cola.mostrar(); // 30 40 50 - tiene 2 huecos al inicio

        // Aquí una cola simple diría "llena" - la circular no
        cola.offer(60);
        cola.offer(70);
        cola.mostrar(); // 30 40 50 60 70 - reutilizó los huecos!

        // Prueba de vuelta completa
        System.out.println("Frente actual: " + cola.peek()); // 30
    }
}