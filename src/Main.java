import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void leerDirectorio(File f){

        File[] leer = f.listFiles();
        for (int i = 0; i < leer.length ; i++) {
            System.out.println(leer[i]);
        }
    }

    public static void comprobarDirectorio(String ruta){
        File f = new File(ruta);
        if(f.exists()){
            System.out.println("El archivo/directorio existe\nSu ruta es: " + f.getAbsolutePath());

        }else{
            System.out.println("El archivo/directorio no existe");
        }
    }

    static boolean EsborrarTot(File ruta) throws FileNotFoundException {
        if(!ruta.exists()){
            throw new FileNotFoundException();
        }
        boolean resultat = false;
        if(ruta.isFile()){
            resultat = ruta.delete();
        }else{
            for(File f : ruta.listFiles(File::isFile)){
                f.delete();
            }
            resultat = ruta.delete();
        }
        return resultat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1.Crear un archivo o directorio.\n" +
                    "2.Leer el contenido de un archivo de texto.\n" +
                    "3. Escribir contenido en un archivo de texto existente.\n" +
                    "4. Eliminar un archivo o directorio.\n" +
                    "5. Comprobar si un archivo o directorio existe en la ruta proporcionada.\n" +
                    "6. Listar el contenido de un directorio");

            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("creación de archivo o directorio");
                    break;
                case 2:
                    System.out.println("Escribir contenido en un archivo de texto");
                    break;
                case 3:
                    System.out.println("Escribir contenido en un archivo de texto existente");
                    break;
                case 4:
                    System.out.println(" Introduce ruta del atchivo/directorio a eliminar:");
                    try {
                        if(EsborrarTot(new File(scanner.nextLine()))){
                            System.out.println("El archivo/directorio se ha eliminado");
                        }else{
                            System.out.println("El archivo/directorio no se ha podido eliminar");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("El archivo no existe");;
                    }
                    break;
                case 5:
                    System.out.println(" Introduce la ruta del archivo/directorio a comprobar");
                    comprobarDirectorio(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Listar el contenido de un directorio");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo");
                    return;

            }
        }
    }
}