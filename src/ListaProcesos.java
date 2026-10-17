public class ListaProcesos<E,F> {
    private NodoProceso<E,F> primero;
    private NodoProceso<E,F> ultimo;

    public ListaProcesos() {
        primero = ultimo = null;
    }

    public NodoProceso<E,F> getprimero() {
        return primero;
    }

    public NodoProceso<E,F> getultimo() {
        return ultimo;
    }

    public boolean nohayfila() {
        return primero == null;
    }

    public boolean estavacialista(){
        if (nohayfila()) return true;
        NodoProceso<E,F> p = primero;
        do {
            if(!p.getLista().estavacio()) {return false;}
            p = p.getNext();
        } while (p != primero);
        return true;
    }

    public void ingresarnuevoproceso(E proceso, ListaEnlazada<F> lista) {
        NodoProceso<E,F> nd = new NodoProceso<>(proceso, lista);
        if (nohayfila()) {
            primero = ultimo = nd;
        } else {
            ultimo.setNext(nd);
            ultimo = nd;
        }
        ultimo.setNext(primero);
    }

    public void imprimir() {
        if (nohayfila()) return;
        NodoProceso<E,F> p = primero;
        do {
            System.out.println(p.getData());
            p.getLista().imprimir();
            p = p.getNext();
        } while (p != primero);
    }

    public int getSize(){
        if (nohayfila()) return 0;
        int total = 0;
        NodoProceso<E,F> p = primero;
        do {
            total = total + 1;
            p = p.getNext();
        } while (p != primero);
        return total;
    }

    public NodoProceso<E,F> getNodoxIdx(int pos){
        if (pos < 0 || pos >= getSize()) return null;
        NodoProceso<E,F> p = primero;
        for(int i=0; i < pos; i++){
            p = p.getNext();
        }
        return p;
    }
}