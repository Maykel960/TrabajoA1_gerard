import java.io.File;
import java.io.IOException;

public class Main{
    static boolean crearDirectorio(String nombre) throws IOException {
        File file = new File(nombre);
        if (file.createNewFile()){
            return true;
        } else {
            return false;
        }
    }
}