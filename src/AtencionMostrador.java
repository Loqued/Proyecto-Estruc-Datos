import java.util.Random;

public class AtencionMostrador<E, F> {
    private ListaEnlazada<F> pasajeros;
    private ListaProcesos<E, F> mostradores;
    private Random rd = new Random();

    public AtencionMostrador(ListaEnlazada<F> pasajeros, ListaProcesos<E, F> mostradores) {
        this.pasajeros = pasajeros;
        this.mostradores = mostradores;
    }

    public void ejecutar() {
        NodoProceso<E, F> nodoMostrador = mostradores.getprimero();
        while (!pasajeros.estavacio()) {
            int size = pasajeros.getSize();
            int np;
            if (size == 1) {
                np = 1;
            } else {
                np = rd.nextInt(size/2) + 1;
            }
            for (int i = 0; i < np; i++) {
                System.out.println("iteración" + i + " " + nodoMostrador.getData());
                NodoLista<F> nodoPasajero = pasajeros.eliminarPrim();
                nodoMostrador.getLista().anadir(nodoPasajero.getData());
                nodoMostrador = nodoMostrador.getNext();
                if (nodoMostrador == null) {
                    nodoMostrador = mostradores.getprimero();
                }
            }
            System.out.println("*** PASAJEROS QUE ACABAN DE LLEGAR AL MOSTRADOR ***");
            mostradores.imprimir();
        }

        int nm = rd.nextInt(mostradores.getSize()) + 1;
        NodoProceso<E, F> mostradorEscogido = mostradores.getNodoxIdx(nm - 1);
        NodoLista<F> pasajeroAtendido = mostradorEscogido.getLista().eliminarPrim();
        if (pasajeroAtendido != null) {
            System.out.println(pasajeroAtendido.getData() + " fue atendido en mostrador " + mostradorEscogido.getData());
        } else {
            System.out.println(mostradorEscogido.getData() + " no tiene pasajeros que atender");
        }
    }
}