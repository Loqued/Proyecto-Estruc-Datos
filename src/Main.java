import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Pasajero> LPasajeros = new ListaEnlazada<>();
        LPasajeros.anadir(new Pasajero(1, "Alex", 2));
        LPasajeros.anadir(new Pasajero(2, "Emilia", 1));
        LPasajeros.anadir(new Pasajero(3, "Carlos", 3));
        LPasajeros.anadir(new Pasajero(4, "Eddy", 1));
        LPasajeros.anadir(new Pasajero(5, "Santiago", 1));

        ListaEnlazada<Pasajero> LMostrador1 = new ListaEnlazada<>();
        ListaEnlazada<Pasajero> LMostrador2 = new ListaEnlazada<>();
        ListaEnlazada<Pasajero> LMostrador3 = new ListaEnlazada<>();

        // ESTO LO PUSE ASÍ COMO MEDIDA AUXILIAR SI EL CODIGO NO COMPILABA.
        //ListaEnlazada<Integer> l2 = new ListaEnlazada<>();
        //        // l2.anadir(10);
        //        //l2.anadir(20);
        //        // l2.anadir(30);

        ListaProcesos<String, Pasajero> lp = new ListaProcesos<>();
        for (int i = 1; i <= 3; i++) {
            lp.ingresarnuevoproceso("Mostrador " + i, new ListaEnlazada<>());
        }

        new AtencionMostrador<>(LPasajeros, lp).ejecutar();
    }
}