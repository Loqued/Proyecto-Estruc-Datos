class NodoProceso<E> {
    private E data;
    private NodoProceso<E> next;
    private ListaEnlazada<E> lista;

    public NodoProceso(E cont, ListaEnlazada<E> lista) {
        this.data = cont;
        this.next = null;
        this.lista = lista;
    }

    public E getData() {
        return data;
    }

    public NodoProceso<E> getNext() {
        return next;
    }

    public ListaEnlazada<E> getLista() {
        return lista;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(NodoProceso<E> next) {
        this.next = next;
    }
}