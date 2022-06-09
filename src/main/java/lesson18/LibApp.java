package lesson18;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson18.config.DbConfig;
import lesson18.dao.BookDAO;
import lesson18.dao.BookDAOImpl;
import lesson18.model.Book;
import lesson18.model.Library;
import lesson18.service.LibSerializer;

import java.sql.SQLException;
import java.util.*;

public class LibApp {

    Library lib = new Library();
    Scanner in = new Scanner(System.in);
    Book book;
    String str;
    BookDAOImpl bookDAO = new BookDAOImpl();

    public void start() {

        lib = bookDAO.getLib();

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
                case "exit" : bookDAO.closeConnection();
            }

        } while (!str.equals("exit"));
    }

    private void add(){
        book = new Book();

        System.out.println("Add new book");
        System.out.println("Enter a book Title:");
        book.setTitle(in.nextLine());

        System.out.println("Enter a book Author:");
        book.setAuthor(in.nextLine());

        System.out.println("You add a new Book");
        System.out.println("Title: " + book.getTitle() + " - Author: " + book.getAuthor() + "\n\n\n");

        lib.getBooks().add(book);
        bookDAO.addBook(book);
        this.start();
    }

    private void del() {
        book = new Book();

        System.out.println("Delete book");
        System.out.println("Enter a book Title or Author:");
        str = in.nextLine();

        Iterator<Book> i = lib.getBooks().iterator();
        while (i.hasNext()) {
            Book checkBook = i.next();
            if(checkBook.getTitle().equals(str) || checkBook.getAuthor().equals(str)){
                System.out.println("Book: " + checkBook.getTitle() + " - " + checkBook.getAuthor() + " was deleted\n\n\n");
                book = checkBook;
            }
        }
        lib.getBooks().remove(book);

        bookDAO.delBook(book);

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

