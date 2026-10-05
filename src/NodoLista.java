class NodoLista<E> {
    private E data;
    private NodoLista<E> next;

    public NodoLista(E cont) {
        this.data = cont;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodoLista<E> getNext() {
        return next;
    }

    public void setNext(NodoLista<E> n) {
        this.next = n;
    }
}

