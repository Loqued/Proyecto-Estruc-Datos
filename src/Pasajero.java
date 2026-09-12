public class Pasajero {
    private int id;
    private String nombre;
    private String asiento;

    public Pasajero(int id, String nombre, String asiento){
        this.id=id;
        this.nombre=nombre;
        this.asiento=asiento;
    };
    public String toString(){
        return "(" + id + "/" + nombre + "/" + asiento + ")";
    };
}
