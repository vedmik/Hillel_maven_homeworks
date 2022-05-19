package lesson16;

import java.io.*;
import java.util.*;

public class LibApp {

    List<Book> lib = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    String str;
    String dir = "src/main/resources/library.ser";


    public void start() {
        if(new File(dir).exists()){
            lib = this.readFromFile();
        } else {
            try {
                new File(dir).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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

        lib.add(book);
        writeToFile(lib);
        this.start();
    }

    private void del() {

        System.out.println("Delete book\n");
        System.out.println("Enter a book Title or Author:");
        str = in.nextLine();
        Iterator<Book> i = lib.iterator();
        while (i.hasNext()) {
            Book book = i.next();
            if(book.getTitle().equals(str) || book.getAuthor().equals(str)){

                System.out.println("Book: " + book.getTitle() + " - " + book.getAuthor() + " was deleted");
                lib.remove(book);
            }
        }
        writeToFile(lib);
        this.start();
    }

    private void show() {

        Iterator<Book> i = lib.iterator();
        while (i.hasNext()) {
            Book book = i.next();
            System.out.println("Book: " + book.getTitle() + " - " + book.getAuthor());
        }

        this.start();
    }

    private void writeToFile(List<Book> lib) {

        try(FileOutputStream outputStream = new FileOutputStream(dir)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(lib);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    private List<Book> readFromFile(){
        List<Book> lib = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream(dir)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            lib = (ArrayList) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lib;
    }
}
