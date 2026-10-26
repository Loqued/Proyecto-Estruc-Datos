public class Pasajero {
    private int id;
    private String nombre;
    private int cantmaleta;
    private String vuelo;

    public Pasajero(int id, String nombre, int cantmaleta, String vuelo){
        this.id=id;
        this.nombre=nombre;
        this.cantmaleta=cantmaleta;
        this.vuelo=vuelo;
    };

    public int getId(){
        return id;
    };

    public String toString(){
        return "(id: " + id + " / nombre: " + nombre + " / maletas: " +cantmaleta+" / vuelo: " + vuelo+")";
    };
}
