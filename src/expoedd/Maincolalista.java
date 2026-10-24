package expoedd;
public class Maincolalista{
    // 8. MAIN DE PRUEBA
    public static void main(String[] args) {
        ColaDinamica q = new ColaDinamica();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.mostrar();
        // FRONT -> [10|•] -> [20|•] -> [30|•] -> NULL

        q.dequeue();
        q.mostrar();
        // FRONT -> [20|•] -> [30|•] -> NULL - FRONT avanzó, 10 se eliminó

        q.enqueue(40);
        q.enqueue(50);
        q.mostrar();
        // FRONT -> [20|•] -> [30|•] -> [40|•] -> [50|•] -> NULL
        // REAR siempre al final, sin límite de tamaño

        // A diferencia de la estática, aquí nunca hay OVERFLOW
        // Puede crecer hasta que se acabe la memoria RAM
    }
}