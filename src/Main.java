import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        ArrayList<Pasajero> pasajeros = new ArrayList<>(5);
        ArrayList<Maleta> maletas = new ArrayList<>(5);
        Gestor gestor = new Gestor(pasajeros, maletas);

        pasajeros.add(new Pasajero(1, "Andres Ferrán", "20C"));
        pasajeros.add(new Pasajero(2, "Carlos Uribe", "4B"));
        pasajeros.add(new Pasajero(3, "Ana Ruiz", "15D"));
        pasajeros.add(new Pasajero(4, "Luis Fernandez", "15A"));
        pasajeros.add(new Pasajero(5, "Bob Bob", "67E"));

        maletas.add(new Maleta(1, 15.2, "Azul Oscuro"));
        maletas.add(new Maleta(2, 20.1, "Gris"));
        maletas.add(new Maleta(3, 12.6, "Rojo Oscuro"));
        maletas.add(new Maleta(4, 17.3, "Verde Oscuro"));
        maletas.add(new Maleta(5, 17.3, "Negro"));

        //Buscar maleta del pasajero con id 4
        gestor.buscarMaletas(4);
    };
}