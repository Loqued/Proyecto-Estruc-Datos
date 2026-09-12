import java.util.ArrayList;

public class Gestor {

    private ArrayList<Pasajero> pasajeros;
    private ArrayList<Maleta> maletas;

    public Gestor (ArrayList<Pasajero> pasajeros, ArrayList<Maleta> maletas){
        this.pasajeros = pasajeros;
        this.maletas = maletas;
    }

    //El enunciado del proyecto mencionaba crear un metodo con tres parametros, pero yo decidí encapsular la lógica
    // en la clase Gestor siguiendo los principios POO y cumpliendo con el cometido del enunciado

    public void buscarMaletas(int id){
        if (id > 0 && id <= pasajeros.size() && id <= maletas.size()) {
            int index = id - 1;
            Pasajero pasajeroBuscado = pasajeros.get(index);
            Maleta maletaBuscada = maletas.get(index);
            System.out.println("Datos de búsqueda:");
            System.out.println(pasajeroBuscado.toString());
            System.out.println(maletaBuscada.toString());
            System.out.println();
        } else {
            System.out.println("Número inválido");
        }
    }
}

