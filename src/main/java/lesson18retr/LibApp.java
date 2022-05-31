package lesson18retr;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson18retr.model.Book;
import lesson18retr.model.Library;
import lesson18retr.service.LibSerializer;

import java.util.Iterator;
import java.util.Scanner;

public class LibApp {

    Library lib = new Library();
    Scanner in = new Scanner(System.in);
    String dir = "src/main/resources/library.json";
    String str;
    LibSerializer libSerializer = new LibSerializer(new ObjectMapper(), dir);

    public void start() {
        lib = libSerializer.readFromFile();

        do{
            System.out.println("Show the contents of the library / show");
            System.out.println("Add a book to the library / add");
            System.out.println("Delete a book from the library / del");
            System.out.println("Exit the app / exit");
            System.out.println("Choose one of the actions:");
            str = in.nextLine();
            System.out.println("You entered: " + str + "\n");
            switch (str){
                case "add" : this.add();
                    break;
                case "show" : this.show();
                    break;
                case "del" : this.del();
                    break;
            }

        } while (!str.equals("exit"));
    }

    private void add(){
        Book book = new Book();

        System.out.println("Add new book");
        System.out.println("Enter a book Title:");
        book.setTitle(in.nextLine());

        System.out.println("Enter a book Author:");
        book.setAuthor(in.nextLine());

        System.out.println("You add a new Book");
        System.out.println("Title: " + book.getTitle() + " - Author: " + book.getAuthor() + "\n\n\n");

        lib.getBooks().add(book);
        libSerializer.writeToFile(lib);
        this.start();
    }

    private void del() {
        Book book = new Book();

        System.out.println("Delete book");
        System.out.println("Enter a book Title or Author:");
        str = in.nextLine();

        Iterator<Book> i = lib.getBooks().iterator();
        while (i.hasNext()) {
            book = i.next();
            if(book.getTitle().equals(str) || book.getAuthor().equals(str)){
                System.out.println("Book: " + book.getTitle() + " - " + book.getAuthor() + " was deleted\n\n\n");
            }
        }
        lib.getBooks().remove(book);

        libSerializer.writeToFile(lib);

        this.start();
    }

    private void show() {

        Iterator<Book> i = lib.getBooks().iterator();
        while (i.hasNext()) {
            Book book = i.next();
            System.out.println("Book: " + book.getTitle() + " - " + book.getAuthor());
        }

        System.out.println("\n\n\n");

        this.start();
    }
}

