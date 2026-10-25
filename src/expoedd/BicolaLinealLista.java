package expoedd;
public class BicolaLinealLista {
    private class Nodo {
        int dato;
        Nodo sig;
        Nodo ant;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo frente;
    private Nodo fin;

    public BicolaLinealLista() { frente = null; fin = null; }
    public boolean estaVacia() { return frente == null; }

    public void insertarFrente(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            nuevo.sig = frente;
            frente.ant = nuevo;
            frente = nuevo;
        }
        System.out.println("Inserta Frente: " + dato);
    }

    public void insertarAtras(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.sig = nuevo;
            nuevo.ant = fin;
            fin = nuevo;
        }
        System.out.println("Inserta Atrás: " + dato);
    }

    public int eliminarFrente() {
        if (estaVacia()) { System.out.println("UNDERFLOW"); return -1; }
        int dato = frente.dato;
        System.out.println("Elimina Frente: " + dato);
        if (frente == fin) {
            frente = fin = null;
        } else {
            frente = frente.sig;
            frente.ant = null;
        }
        return dato;
    }

    public int eliminarAtras() {
        if (estaVacia()) { System.out.println("UNDERFLOW"); return -1; }
        int dato = fin.dato;
        System.out.println("Elimina Atrás: " + dato);
        if (frente == fin) {
            frente = fin = null;
        } else {
            fin = fin.ant;
            fin.sig = null;
        }
        return dato;
    }

    public void mostrar() {
        if (estaVacia()) { System.out.println("Bicola vacía"); return; }
        System.out.print("Frente -> ");
        Nodo actual = frente;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.sig;
        }
        System.out.println(" <- Fin");
    }

    public void mostrarReversa() {
        if (estaVacia()) return;
        System.out.print("Fin -> ");
        Nodo actual = fin;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.ant;
        }
        System.out.println(" <- Frente (doble enlace)");
    }

    public static void main(String[] args) {
        BicolaLinealLista b = new BicolaLinealLista();
        b.insertarAtras(10);
        b.insertarAtras(20);
        b.insertarFrente(5);
        b.insertarFrente(1);
        b.mostrar(); // 1 <-> 5 <-> 10 <-> 20

        b.eliminarAtras(); // 20
        b.eliminarFrente(); // 1
        b.mostrar(); // 5 <-> 10

        b.mostrarReversa(); // Demuestra que es doblemente enlazada
    }
}