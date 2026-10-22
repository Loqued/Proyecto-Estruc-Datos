public class Pasajero {
    private int id;
    private String nombre;
    private int cantmaleta;

    public Pasajero(int id, String nombre, int cantmaleta){
        this.id=id;
        this.nombre=nombre;
        this.cantmaleta=cantmaleta;
    };

    public int getId() {return id;}

    public String toString(){
        return "(id: " + id + " / nombre: " + nombre + " / maletas: " +cantmaleta+")";
    };
}
