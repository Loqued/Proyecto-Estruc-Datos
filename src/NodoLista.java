class NodoLista<E> {
    private E data;
    private NodoLista<E> next;
    private NodoLista<E> prev;

    public NodoLista(E cont) {
        this.data = cont;
        this.next = null;
        this.prev = null;
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

    public NodoLista<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoLista<E> p) {
        this.prev = p;
    }
}

