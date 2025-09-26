
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

public class Main {

    static boolean crearArchivo(String nombre) throws IOException {
        File file = new File(nombre);
        if (nombre.contains(".")) {
            file.createNewFile();
            return true;
        } else {
            file.mkdir();
            return false;

        }
    }

    public static void leerContenido(File file) {
        try (Scanner lector = new Scanner(file)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static void listarContenido(String file) {
        File archivo = new File(file);
        String[] listado = archivo.list();
        if (archivo.isDirectory() && listado != null) {
            for (int i = 0; i < listado.length; i++) {

    static void listarContenido(File file){

        String[] listado = file.list();
        if (file.isDirectory()){
            for (int i = 0; i < listado.length ; i++) {

                System.out.println(listado[i]);
            }
        }
        System.out.println(file);
    }

    public static void comprobarDirectorio(String ruta) {
        File f = new File(ruta);
        if (f.exists()) {
            System.out.println("El archivo/directorio existe\nSu ruta es: " + f.getAbsolutePath());

        } else {
            System.out.println("El archivo/directorio no existe");
        }
    }

    public static void escribirFile(String texto) throws IOException {
        String comando = texto;
        String[] trozos = comando.split(" ");
        try {
            FileWriter myWriter = new FileWriter(trozos[0]);
            myWriter.write(trozos[1]);
            myWriter.close();
            System.out.println("Escrito con éxito");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    static boolean EsborrarTot(File ruta) throws FileNotFoundException {
        if (!ruta.exists()) {
            throw new FileNotFoundException();
        }
        boolean resultat = false;
        if (ruta.isFile()) {
            resultat = ruta.delete();
        } else {
            for (File f : ruta.listFiles(File::isFile)) {
                f.delete();
            }
            resultat = ruta.delete();
        }
        return resultat;
    }

    public static void main(String[] args) throws IOException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1.Crear un archivo o directorio.\n" +
                    "2.Leer el contenido de un archivo de texto.\n" +
                    "3. Escribir contenido en un archivo de texto existente.\n" +
                    "4. Eliminar un archivo o directorio.\n" +
                    "5. Comprobar si un archivo o directorio existe en la ruta proporcionada.\n" +
                    "6. Listar el contenido de un directorio\n" +
                    "7. Salir del programa\n");
            try {
                int op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {
                    case 1:
                        System.out.println("creación de archivo o directorio");
                        crearDirectorio(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Leer Contenido de un archivo");
                        leerContenido(new File(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Escribir contenido en un archivo ");
                        escribirFile(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println(" Introduce ruta del atchivo/directorio a eliminar:");
                        try {
                            if (EsborrarTot(new File(scanner.nextLine()))) {
                                System.out.println("El archivo/directorio se ha eliminado");
                            } else {
                                System.out.println("El archivo/directorio no se ha podido eliminar");
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("El archivo no existe");
                        }
                        break;
                    case 5:
                        System.out.println(" Introduce la ruta del archivo/directorio a comprobar");
                        comprobarDirectorio(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Listar el contenido de un directorio");
                        listarContenido(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("Adíos");
                        break;
                    default:
                        System.out.println("Opción no válida, intenta de nuevo");
                        return;
                }
            } catch (InputMismatchException e){
                System.out.println("Pon un comando válido joder");
                return;
  
    