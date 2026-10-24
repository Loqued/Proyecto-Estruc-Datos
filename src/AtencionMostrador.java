import java.util.Random;

public class AtencionMostrador {
    private ListaEnlazada<Pasajero> pasajeros;
    private ListaProcesos<String, Pasajero> mostradores;
    private ListaEnlazada<Maleta> maletas;
    private ListaProcesos<String, Maleta> vuelos;
    private Random rd = new Random();

    public AtencionMostrador(ListaEnlazada<Pasajero> pasajeros, ListaProcesos<String, Pasajero> mostradores,
                             ListaEnlazada<Maleta> maletas, ListaProcesos<String, Maleta> vuelos) {
        this.pasajeros = pasajeros;
        this.mostradores = mostradores;
        this.maletas = maletas;
        this.vuelos = vuelos;
    }

    public void ejecutar() {
        while (!pasajeros.estavacio() || !mostradores.estavacialista()) {
            if (!pasajeros.estavacio()) {
                int size = pasajeros.getSize();
                int np;
                if (size == 1) {
                    np = 1;
                } else {
                    np = rd.nextInt(size/2) + 1;
                }
                for (int i = 0; i < np; i++) {
                    NodoProceso<String, Pasajero> nodoMostrador = mostradores.getFilaMasCorta();
                    NodoLista<Pasajero> nodoPasajero = pasajeros.eliminarPrim();
                    nodoMostrador.getLista().anadir(nodoPasajero.getData());
                    System.out.println(nodoPasajero.getData() + " va a la fila de " + nodoMostrador.getData());
                }
                System.out.println("*** PASAJEROS QUE ACABAN DE LLEGAR AL MOSTRADOR ***");
                mostradores.imprimir();
            }

            int nm = rd.nextInt(mostradores.getSize()) + 1;
            NodoProceso<String, Pasajero> mostradorEscogido = mostradores.getNodoxIdx(nm - 1);
            NodoLista<Pasajero> pasajeroAtendido = mostradorEscogido.getLista().eliminarPrim();
            if (pasajeroAtendido != null) {
                System.out.println(pasajeroAtendido.getData() + " fue atendido en mostrador " + mostradorEscogido.getData());
                moverMaletas(pasajeroAtendido.getData());
            } else {
                System.out.println(mostradorEscogido.getData() + " no tiene pasajeros que atender");
            }
        }
    }

    public void moverMaletas(Pasajero pasajero) {
        NodoLista<Maleta> q = maletas.getfirst();
        while (q != null) {
            NodoLista<Maleta> sig = q.getNext();
            Maleta m = q.getData();
            if (m.getIdPasajero() == pasajero.getId()) {
                maletas.eliminarxPos(q);
                NodoProceso<String, Maleta> nodoVuelo = vuelos.buscarxDato(m.getVuelo());
                if (nodoVuelo == null) {
                    vuelos.ingresarnuevoproceso(m.getVuelo(), new ListaEnlazada<>());
                    nodoVuelo = vuelos.getultimo();
                    System.out.println("Se crea el vuelo " + m.getVuelo());
                }
                nodoVuelo.getLista().anadir(m);
                System.out.println("Maleta " + m + " colocada en " + nodoVuelo.getData());
            }
            q = sig;
        }
    }
}