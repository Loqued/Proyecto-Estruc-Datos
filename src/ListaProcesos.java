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

    public NodoProceso<E,F> getFilaMasCorta(){
        if (nohayfila()) return null;
        NodoProceso<E,F> menor = primero;
        NodoProceso<E,F> p = primero.getNext();
        while (p != primero) {
            if (p.getLista().getSize() < menor.getLista().getSize()) {
                menor = p;
            }
            p = p.getNext();
        }
        return menor;
    }

    public NodoProceso<E,F> buscarxDato(E dato){
        if (nohayfila()) return null;
        NodoProceso<E,F> p = primero;
        do {
            if (p.getData().equals(dato)) {
                return p;
            }
            p = p.getNext();
        } while (p != primero);
        return null;
    }

    public NodoProceso<E,F> eliminarProceso(NodoProceso<E,F> nodo) {
        if (nohayfila() || nodo == null) return null;
        
        NodoProceso<E,F> ant = ultimo;
        NodoProceso<E,F> p = primero;
        do {
            if (p == nodo) break;
            ant = p;
            p = p.getNext();
        } while (p != primero);
        if (p != nodo) return null;

        if (primero == ultimo) {
            primero = ultimo = null;
        } else {
            ant.setNext(nodo.getNext());
            if (nodo == primero) primero = nodo.getNext();
            if (nodo == ultimo) ultimo = ant;
        }
        nodo.setNext(null);
        return nodo;
    }
}