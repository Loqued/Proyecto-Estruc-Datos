class NodoProceso<E, F> {
    private E data;
    private NodoProceso<E,F> next;
    private ListaEnlazada<F> lista;

    public NodoProceso(E cont, ListaEnlazada<F> lista) {
        this.data = cont;
        this.next = null;
        this.lista = lista;
    }

    public E getData() {
        return data;
    }

    public NodoProceso<E, F> getNext() {
        return next;
    }

    public ListaEnlazada<F> getLista() {
        return lista;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(NodoProceso<E, F> next) {
        this.next = next;
    }

    public void setLista(ListaEnlazada<F> lista) {
        this.lista = lista;
    }
}
