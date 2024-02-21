
public abstract class Producto {

    public String nombre;
    private int identificador;

    // Constructor
    public Producto(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }


    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    //
    public void mostrarProducto(){
        System.out.println("Nombre: " + this.nombre + "\tIdentificador: " + getIdentificador());
    }
}