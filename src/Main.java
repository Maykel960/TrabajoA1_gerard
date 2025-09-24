import java.io.File;
import java.util.*;

public class Main{


    void listarContenido(File file){

        String[] listado = file.list();
        if (file.isDirectory()){
            for (int i = 0; i < file.length() ; i++) {
                System.out.println(listado[i]);
            }
        }
        System.out.println(file);
    }

    public static void main(String[] args) {

    }
}