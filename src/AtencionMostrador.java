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

            if (rd.nextBoolean()) {
                int nc = rd.nextInt(mostradores.getSize()) + 1;
                cerrarMostrador(mostradores.getNodoxIdx(nc - 1).getData());
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
    public boolean cerrarMostrador(String nombre) {
        if (mostradores.getSize() <= 1) {
            System.out.println("No se puede cerrar: debe quedar al menos un mostrador");
            return false;
        }
        NodoProceso<String, Pasajero> cerrar = mostradores.buscarxDato(nombre);
        if (cerrar == null) {
            System.out.println("No existe el mostrador " + nombre);
            return false;
        }

        ListaEnlazada<Pasajero> fila = cerrar.getLista();
        if (fila.estavacio()) {
            mostradores.eliminarProceso(cerrar);
            System.out.println(nombre + " estaba vacío y fue cerrado");
            return true;
        }

        System.out.println("Se cierra " + nombre + " y se redistribuyen sus pasajeros");
        while (!fila.estavacio()) {
            NodoLista<Pasajero> n = fila.eliminarPrim();
            NodoProceso<String, Pasajero> destino = mostradores.getFilaMasCortaSin(cerrar);
            destino.getLista().anadir(n.getData());
            System.out.println(n.getData() + " pasa a " + destino.getData());
        }
        mostradores.eliminarProceso(cerrar);
        return true;
    }
}