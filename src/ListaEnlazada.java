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
            last = nuevo;
        }
    }

    public void anadirinicio(E cont) {
        NodoLista<E> nuevo = new NodoLista<>(cont);
        if (estavacio()) {
            last = nuevo;
        }
        nuevo.setNext(first);
        first = nuevo;
    }

    public NodoLista<E> buscarAnt(NodoLista<E> q) {
        for (NodoLista<E> p = first; p != null; p = p.getNext()) {
            if (p.getNext() == q) {
                return p;
            }
        }
        return null;
    }

    public NodoLista<E> eliminarxPos(NodoLista<E> q) {  // no puse eliminarPrimero en el caso de que se desee eliminar
        if (q == first) {                               // otra posición diferente de la primera, tenga la liberta de
            first = q.getNext();                        // y por eso lo puse como xPos en vez de primero.
            q.setNext(null);
            if (q == last) last = null;
        } else {
            NodoLista<E> r = buscarAnt(q);
            r.setNext(q.getNext());
            q.setNext(null);
            if (q == last) last = r;
        }
        return q;
    }

    public NodoLista<E> eliminarPrim() {
        if (estavacio()) { return null; }
        NodoLista<E> q = first;
        first = q.getNext();
        q.setNext(null);
        if (q == last) {
            last = null;
        }
        return q;
    }
}