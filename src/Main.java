import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Pasajero> LPasajeros = new ListaEnlazada<>();
        LPasajeros.anadir(new Pasajero(1, "Alex", 2));
        LPasajeros.anadir(new Pasajero(2, "Emilia", 1));
        LPasajeros.anadir(new Pasajero(3, "Carlos", 3));
        LPasajeros.anadir(new Pasajero(4, "Eddy", 1));
        LPasajeros.anadir(new Pasajero(5, "Santiago", 1));

        ListaEnlazada<Maleta> LMaletas = new ListaEnlazada<>();
        LMaletas.anadir(new Maleta(1, 20.5, "Negro", 1, "AV101"));
        LMaletas.anadir(new Maleta(2, 15.0, "Rojo", 1, "AV101"));
        LMaletas.anadir(new Maleta(3, 18.2, "Azul", 2, "LA202"));
        LMaletas.anadir(new Maleta(4, 22.0, "Verde", 3, "AA303"));
        LMaletas.anadir(new Maleta(5, 12.7, "Gris", 3, "AA303"));
        LMaletas.anadir(new Maleta(6, 25.3, "Negro", 3, "LA202"));
        LMaletas.anadir(new Maleta(7, 19.9, "Azul", 4, "AV101"));
        LMaletas.anadir(new Maleta(8, 16.4, "Rojo", 5, "AA303"));

        ListaProcesos<String, Pasajero > lp = new ListaProcesos<>();
        for (int i = 1; i <= 3; i++) {
            lp.ingresarnuevoproceso("Mostrador " + i, new ListaEnlazada<>());
        }
        ListaProcesos<String, Maleta> LM = new ListaProcesos<>();

        new AtencionMostrador(LPasajeros, lp, LMaletas, LM).ejecutar();
    }
}