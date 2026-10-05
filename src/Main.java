public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> l1 = new ListaEnlazada<>();
        l1.anadir(1);
        l1.anadir(2);

        ListaEnlazada<Integer> l2 = new ListaEnlazada<>();
        l2.anadir(10);
        l2.anadir(20);
        l2.anadir(30);

        ListaProcesos<Integer> lp = new ListaProcesos<>();
        lp.ingresarnuevoproceso(100, l1);
        lp.ingresarnuevoproceso(200, l2);

        lp.imprimir();
    }
}