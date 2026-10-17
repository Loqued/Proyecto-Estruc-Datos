public class Maleta{
    private int id;
    private double peso;
    private String color;

    public Maleta(int id, double peso, String color){
        this.id= id;
        this.peso=peso;
        this.color=color;
    }

    public String toString() {
        return "(id: " + id + " / peso: " + peso + "kg" + " / color: " + color + ")";
    };
}