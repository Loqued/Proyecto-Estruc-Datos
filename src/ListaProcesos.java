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
        NodoProceso<E,F> p;
        for(p=primero; p!=null; p = p.getNext()){
            if(!p.getLista().estavacio()) {return false;};
        }
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
    }

    public void imprimir() {
        NodoProceso<E,F> p = primero;
        while (p != null) {
            System.out.println(p.getData());
            p.getLista().imprimir();
            p = p.getNext();
        }
    }

    public NodoProceso<E,F> getNodoxIdx(int pos){
        NodoProceso<E,F> p=primero;
        for(int i=0; i < pos; i++){
            p = p.getNext();
            if(p==null) return null;
        }
        return p;
    }
}