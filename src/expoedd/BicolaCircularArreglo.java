package expoedd;
public class BicolaCircularArreglo {
    private int MAX = 5;
    private int[] deque;
    private int F; // Frente
    private int A; // Atrás / Rear

    public BicolaCircularArreglo() {
        deque = new int[MAX];
        F = -1;
        A = -1;
    }

    public boolean estaVacia() { return F == -1; }
    public boolean estaLlena() { return (A + 1) % MAX == F; }

    // Inserta por el frente F
    public void insertarFrente(int dato) {
        if (estaLlena()) {
            System.out.println("OVERFLOW: Bicola llena al insertar " + dato + " por Frente");
            return;
        }
        if (estaVacia()) {
            F = 0; A = 0;
        } else {
            F = (F - 1 + MAX) % MAX; // Clave para ir hacia atrás circular
        }
        deque[F] = dato;
        System.out.println("Inserta Frente F: " + dato + " en pos " + F);
    }

    // Inserta por atrás A
    public void insertarAtras(int dato) {
        if (estaLlena()) {
            System.out.println("OVERFLOW: Bicola llena al insertar " + dato + " por Atrás");
            return;
        }
        if (estaVacia()) {
            F = 0; A = 0;
        } else {
            A = (A + 1) % MAX; // Avance circular
        }
        deque[A] = dato;
        System.out.println("Inserta Atrás A: " + dato + " en pos " + A);
    }

    public int eliminarFrente() {
        if (estaVacia()) { System.out.println("UNDERFLOW"); return -1; }
        int dato = deque[F];
        System.out.println("Elimina Frente F: " + dato + " de pos " + F);
        if (F == A) { F = -1; A = -1; }
        else { F = (F + 1) % MAX; }
        return dato;
    }

    public int eliminarAtras() {
        if (estaVacia()) { System.out.println("UNDERFLOW"); return -1; }
        int dato = deque[A];
        System.out.println("Elimina Atrás A: " + dato + " de pos " + A);
        if (F == A) { F = -1; A = -1; }
        else { A = (A - 1 + MAX) % MAX; }
        return dato;
    }

    public void mostrar() {
        if (estaVacia()) { System.out.println("Bicola vacía []"); return; }
        System.out.print("Bicola [");
        int i = F;
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == A) break;
            i = (i + 1) % MAX;
        }
        System.out.println("] F=" + F + " A=" + A);
    }

    public static void main(String[] args) {
        BicolaCircularArreglo b = new BicolaCircularArreglo();
        b.insertarAtras(10); // A
        b.insertarAtras(20); // A
        b.insertarFrente(5); // F
        b.insertarFrente(1); // F
        b.mostrar(); // [1 5 10 20]

        b.eliminarFrente(); // Saca 1
        b.eliminarAtras();  // Saca 20
        b.mostrar(); // [5 10]

        b.insertarFrente(100);
        b.insertarAtras(200);
        b.insertarAtras(300); // Se llena reutilizando huecos
        b.mostrar(); // Demuestra lo circular [100 5 10 200 300]
    }
}