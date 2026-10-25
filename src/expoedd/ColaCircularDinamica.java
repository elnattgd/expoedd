package expoedd;
public class ColaCircularDinamica {

    // NODO INTERNO
    private class Nodo {
        int dato;
        Nodo sig;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo frente; // sale por aquí
    private Nodo fin;    // entra por aquí

    public ColaCircularDinamica() {
        frente = null;
        fin = null;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    // ENCOLAR
    public void offer(int valor) {
        Nodo nuevo = new Nodo(valor);

        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
            fin.sig = frente; // primer nodo se apunta a sí mismo -> círculo de 1
        } else {
            fin.sig = nuevo;  // el último apunta al nuevo
            fin = nuevo;      // el nuevo es el nuevo final
            fin.sig = frente; // CIERRE DEL CÍRCULO - siempre apunta al frente
        }
    }

    // DESENCOLAR
    public int poll() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }

        int valor = frente.dato;

        if (frente == fin) { // solo había 1 elemento
            frente = null;
            fin = null;
        } else {
            frente = frente.sig; // el frente avanza
            fin.sig = frente;    // el fin sigue apuntando al NUEVO frente -> mantiene el círculo
        }
        return valor;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return frente.dato;
    }

    // Para mostrarla sin romperla
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return;
        }
        System.out.print("Cola circular: ");
        Nodo actual = frente;
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.sig;
        } while (actual != frente);
        System.out.println("(vuelve a " + frente.dato + ")");
    }

    public static void main(String[] args) {
        ColaCircularDinamica cola = new ColaCircularDinamica();

        cola.offer(10);
        cola.offer(20);
        cola.offer(30);
        cola.mostrar(); // 10 -> 20 -> 30 -> (vuelve a 10)

        System.out.println("Sacamos: " + cola.poll()); // 10
        cola.mostrar(); // 20 -> 30 -> (vuelve a 20)

        cola.offer(40);
        cola.offer(50);
        cola.mostrar(); // 20 -> 30 -> 40 -> 50 -> (vuelve a 20)

        // Simulando turnos infinitos (round-robin)
        System.out.println("\nSimulando 7 turnos:");
        Nodo turno = cola.frente;
        for (int i = 0; i < 7; i++) {
            System.out.print(turno.dato + " ");
            turno = turno.sig;
        }
        // Salida: 20 30 40 50 20 30 40 -> nunca se acaba
    }
}
