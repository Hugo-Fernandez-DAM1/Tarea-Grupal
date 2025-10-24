package es.edu.biblioteca.service;
import es.edu.biblioteca.dao.LibroDao;
import es.edu.biblioteca.model.Libro;
import java.util.List;
import java.util.Scanner;

public class LibroService {
    private final Scanner sc = new Scanner(System.in);
    LibroDao dao=new LibroDao();
    public void listarLibrosConAutor() {
        List<Libro> libros = dao.findAllWithAutor();
       for(Libro libro:libros){
           System.out.println(libro.toString());
       }
   }

    public void insertarLibro() {
        System.out.println("Introduce el titulo");
        String titulo=new Scanner(System.in).nextLine();
        System.out.println("Introduce la id de su Autor");
        int id=new Scanner(System.in).nextInt();
        System.out.println("Introduce su año de publicacion");
        int año=new Scanner(System.in).nextInt();
        Libro L1=new Libro(titulo,id,año);
        dao.insert(L1);
    }
}
