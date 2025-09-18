import java.io.File;

public class Main{

    void leerDirectorio(File f){

        File[] leer = f.listFiles();
        for (int i = 0; i < leer.length ; i++) {
            System.out.println(leer[i]);
        }
    }
    public static void main(String[] args) {

    }
}