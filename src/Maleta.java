public class Maleta{
    private int id;
    private double peso;
    private String color;
    private int idPasajero;
    private String vuelo;

    public Maleta(int id, double peso, String color, int idPasajero, String vuelo){
        this.id= id;
        this.peso=peso;
        this.color=color;
        this.idPasajero=idPasajero;
        this.vuelo=vuelo;
    }

    public int getIdPasajero(){
        return idPasajero;
    }

    public String getVuelo(){
        return vuelo;
    }

    public String toString() {
        return "(id: " + id + " / peso: " + peso + "kg" + " / color: " + color + " / pasajero: " + idPasajero + " / vuelo: " + vuelo + ")";
    };
}