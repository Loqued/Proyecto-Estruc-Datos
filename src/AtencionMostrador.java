import java.util.Random;

public class AtencionMostrador {
    private ListaEnlazada<Pasajero> pasajeros;
    private ListaProcesos<String, Pasajero> mostradores;
    private ListaEnlazada<Maleta> LMaletas;
    private ListaProcesos<String, Maleta> LM;
    private Random rd = new Random();


    public AtencionMostrador(ListaEnlazada<Pasajero> pasajeros, ListaProcesos<String, Pasajero> mostradores, ListaEnlazada<Maleta> LMaletas, ListaProcesos<String, Maleta> LM) {
        this.pasajeros = pasajeros;
        this.mostradores = mostradores;
        this.LMaletas = LMaletas;
        this.LM = LM;
    }

    private NodoProceso<String, Pasajero> mostradorMasCorto() {
        NodoProceso<String, Pasajero> mejor = mostradores.getprimero();
        int min = mejor.getLista().getSize();
        NodoProceso<String, Pasajero> p = mejor.getNext();
        while (p != mostradores.getprimero()) {
            int s = p.getLista().getSize();
            if (s < min) {
                min = s;
                mejor = p;
            }
            p = p.getNext();
        }
        return mejor;
    }

    public void ejecutar() {
        while (!pasajeros.estavacio()) {
            int size = pasajeros.getSize();
            int np = (size == 1) ? 1 : rd.nextInt(size / 2) + 1;

            for (int i = 0; i < np; i++) {
                NodoProceso<String, Pasajero> destino = mostradorMasCorto();
                NodoLista<Pasajero> nodoPasajero = pasajeros.eliminarPrim();
                destino.getLista().anadir(nodoPasajero.getData());
                System.out.println("iteración " + i + ": " + nodoPasajero.getData()
                        + " va a " + destino.getData());
            }
            System.out.println("*** PASAJEROS QUE ACABAN DE LLEGAR AL MOSTRADOR ***");
            mostradores.imprimir();
        }

        int nm = rd.nextInt(mostradores.getSize()) + 1;
        System.out.println("Numero mostrador " + nm);
        NodoProceso<String, Pasajero> mostradorEscogido = mostradores.getNodoxIdx(nm - 1);
        NodoLista<Pasajero> pasajeroAtendido = mostradorEscogido.getLista().eliminarPrim();

        if (pasajeroAtendido != null) {
            Pasajero pa = pasajeroAtendido.getData();
            System.out.println(pa + " fue atendido en " + mostradorEscogido.getData());

            NodoLista<Maleta> q = LMaletas.getfirst();
            while (q != null) {
                NodoLista<Maleta> sig = q.getNext();
                if (q.getData().getidPasajero() == pa.getId()) {
                    System.out.println("Maleta " + q.getData() + " retirada de LMaletas");
                    LMaletas.eliminarxPos(q);
                }
                q = sig;
            }
            System.out.println("*** MALETAS POR VUELO (LM) ***");
            LM.imprimir();
        } else {
            System.out.println(mostradorEscogido.getData() + " no tiene pasajeros que atender");
        }
    }
}