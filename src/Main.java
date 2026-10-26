public class Main {
    public static void main(String[] args) {
        // CREACION DE LAS LISTAS DE PASAJEROS Y MALETAS, AMBAS SE JUNTAN POR EL VUELO AL QUE PERTENECEN
        ListaEnlazada<Pasajero> LPasajeros = new ListaEnlazada<>();
        LPasajeros.anadir(new Pasajero(1, "Alex", 2, "Vuelo 101"));
        LPasajeros.anadir(new Pasajero(2, "Emilia", 2, "Vuelo 101"));
        LPasajeros.anadir(new Pasajero(3, "Carlos", 2, "Vuelo 202"));
        LPasajeros.anadir(new Pasajero(4, "Eddy", 1, "Vuelo 101"));
        LPasajeros.anadir(new Pasajero(5, "Santiago", 1, "Vuelo 303"));

        ListaEnlazada<Maleta> LMaletas = new ListaEnlazada<>();
        LMaletas.anadir(new Maleta(1, 23.0, "negro", 1, "Vuelo 101"));
        LMaletas.anadir(new Maleta(2, 10.5, "azul", 1, "Vuelo 101"));
        LMaletas.anadir(new Maleta(3, 18.0, "rojo", 2, "Vuelo 202"));
        LMaletas.anadir(new Maleta(4, 20.0, "gris", 3, "Vuelo 101"));
        LMaletas.anadir(new Maleta(5, 15.0, "verde", 3, "Vuelo 101"));
        LMaletas.anadir(new Maleta(6, 8.0, "negro", 3, "Vuelo 101"));
        LMaletas.anadir(new Maleta(7, 22.5, "blanco", 4, "Vuelo 303"));
        LMaletas.anadir(new Maleta(8, 12.0, "azul", 5, "Vuelo 202"));
        LMaletas.anadir(new Maleta(8, 12.0, "azul", 1, "Vuelo 302"));


        // TODOS LOS PROCESOS DE LOS MOSTRADORES ABIERTOS
        ListaProcesos<String, Pasajero> lp = new ListaProcesos<>();
        for (int i = 1; i <= 3; i++) {
            lp.ingresarnuevoproceso("Mostrador " + i, new ListaEnlazada<>());
        }

        // CREAR UNA LISTA CON TODAS LAS MALETAS A PROCESAR HACIA SUS RESPECTIVOS VUELOS
        ListaProcesos<String, Maleta> LM = new ListaProcesos<>();

        new AtencionMostrador(LPasajeros, lp, LMaletas, LM).ejecutar();

        System.out.println("MALETAS POR VUELO");
        LM.imprimir();

        AtencionMostrador am = new AtencionMostrador(LPasajeros, lp, LMaletas, LM);

        // INTENTO DE CERRAR MOSTRADORES
        am.cerrarMostrador("Mostrador 1");
        am.cerrarMostrador("Mostrador 2");
        am.cerrarMostrador("Mostrador 3");
        lp.imprimir();


        // ACÁ SE EVIDENCIA DONDE SE REDISTRIBUYEN LOS PASAJEROS A OTROS MOSTRADORES TRAS EL CIERRE DE UNO
        lp.getprimero().getLista().anadir(new Pasajero(6, "Luis", 1, "Vuelo 302"));
        am.cerrarMostrador("Mostrador 3");
        lp.imprimir();

        // INTENTO DE SACAR MALETAS DE UN VUELO QUE NO TIENE
        LM.ingresarnuevoproceso("Vuelo 404", new ListaEnlazada<>());
        NodoProceso<String, Maleta> vacio = LM.buscarxDato("Vuelo 404");
        if (vacio.getLista().eliminarPrim() == null) {
            System.out.println(vacio.getData() + " no tiene maletas que procesar");
        }


    }
}