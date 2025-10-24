package es.edu.biblioteca.service;
import es.edu.biblioteca.dao.AutorDao;
import es.edu.biblioteca.model.Autor;

import java.util.List;
import java.util.Scanner;

public class AutorService {
    AutorDao A1=new AutorDao();
    public void listarAutores() {
        List<Autor> autores=A1.findAll();
        for(Autor autor:autores){
            System.out.println(autor.toString());
        }
    }

    public void insertarAutor() {
        System.out.println("Introduce el nombre");
        String nombre=new Scanner(System.in).nextLine();
        System.out.println("Introduce la nacionalidad");
        String nacio=new Scanner(System.in).nextLine();
        Autor autor=new Autor(nombre,nacio);
        A1.insert(autor);
    }

    public void actualizarAutor() {
        System.out.println("Introduce el nuevo nombre");
        String nombre=new Scanner(System.in).nextLine();
        System.out.println("Introduce la nueva nacionalidad");
        String nacio=new Scanner(System.in).nextLine();
        System.out.println("Introduce si id de autor");
        int id=new Scanner(System.in).nextInt();
        Autor autor=new Autor(nombre,nacio);
        A1.update(autor,id);
   }

    public void eliminarAutor() {
        System.out.println("Introduce si id de autor");
        int id=new Scanner(System.in).nextInt();
        A1.delete(id);
   }
}
