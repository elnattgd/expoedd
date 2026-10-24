package expoedd;
public class Maincolaexpo{
  // 8. MAIN DE PRUEBA
    public static void main(String[] args) {
        ColaEstatica q = new ColaEstatica();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.mostrar(); // [10 20 30 40]

        q.dequeue();
        q.dequeue();
        q.mostrar(); // [30 40] - Posiciones 0 y 1 quedan vacías

        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70); // Este 70 se inserta en la posición 0, reutilizando!
        q.mostrar(); // Demuestra la cola circular [30 40 50 60 70]

        // q.enqueue(80); -> Daría Overflow porque ya está llena
    }}
