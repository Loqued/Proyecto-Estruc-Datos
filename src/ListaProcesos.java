public class ListaProcesos<E> {
    private NodoProceso<E> primero;
    private NodoProceso<E> ultimo;

    public ListaProcesos() {
        primero = ultimo = null;
    }

    public NodoProceso<E> getprimero() {
        return primero;
    }

    public NodoProceso<E> getultimo() {
        return ultimo;
    }

    public boolean nohayfila() {
        return primero == null;
    }

    public void ingresarnuevoproceso(E proceso, ListaEnlazada<E> lista) {
        NodoProceso<E> nd = new NodoProceso<>(proceso, lista);
        if (nohayfila()) {
            primero = ultimo = nd;
        } else {
            ultimo.setNext(nd);
            ultimo = nd;
        }
    }

    public void imprimir() {
        NodoProceso<E> p = primero;
        while (p != null) {
            System.out.println(p.getData());
            p.getLista().imprimir();
            p = p.getNext();
        }
    }
}