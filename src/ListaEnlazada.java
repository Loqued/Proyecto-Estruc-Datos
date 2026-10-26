public class ListaEnlazada<E> {
    private NodoLista<E> first;
    private NodoLista<E> last;

    public ListaEnlazada() {
        first = last = null;
    }

    public NodoLista<E> getfirst() { return first; }
    public NodoLista<E> getLast() { return last; }

    public void imprimir() {
        NodoLista<E> q = first;
        while (q != null) {
            System.out.println(q.getData());
            q = q.getNext();
        }
    }
    public int getSize(){
        NodoLista<E> q = first;
        int total = 0;
        while(q != null){
            total = total + 1;
            q = q.getNext();
        }
        return total;
    }
    public boolean estavacio() {
        return first == null;
    }

    public void anadir(E cont) {
        NodoLista<E> nuevo = new NodoLista<>(cont);
        if (estavacio()) {
            first = last = nuevo;
        } else {
            last.setNext(nuevo);
            nuevo.setPrev(last);
            last = nuevo;
        }
    }

    public void anadirinicio(E cont) {
        NodoLista<E> nuevo = new NodoLista<>(cont);
        if (estavacio()) {
            last = nuevo;
        } else {
            first.setPrev(nuevo);
        }
        nuevo.setNext(first);
        first = nuevo;
    }

    public NodoLista<E> buscarAnt(NodoLista<E> q) {
        return q.getPrev();
    }

    public NodoLista<E> eliminarxPos(NodoLista<E> q) {
        NodoLista<E> r = q.getPrev();
        NodoLista<E> s = q.getNext();
        if (q == first) {
            first = s;
        } else {
            r.setNext(s);
        }
        if (q == last) {
            last = r;
        } else {
            s.setPrev(r);
        }
        q.setNext(null);
        q.setPrev(null);
        return q;
    }

    public E revisarPrimero() {
        if (estavacio()) { return null; }
        return first.getData();
    }

    public NodoLista<E> eliminarPrim() {
        if (estavacio()) { return null; }
        NodoLista<E> q = first;
        first = q.getNext();
        q.setNext(null);
        if (q == last) {
            last = null;
        } else {
            first.setPrev(null);
        }
        return q;
    }
}