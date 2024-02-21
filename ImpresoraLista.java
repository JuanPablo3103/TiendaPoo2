import java.util.ArrayList;

public class ImpresoraLista {
    public ImpresoraLista() {
    }

    public static void mostrarLista(ArrayList<Producto> miLista){
        for (Producto producto: miLista){
            producto.mostrarProducto();
        }
    }
}