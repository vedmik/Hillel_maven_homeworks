package lesson18;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson18.model.Book;
import lesson18.model.Library;
import lesson18.service.LibSerializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class LibSerializerTest {
    Library lib = new Library();
    Library libTest = new Library();
    Book book = new Book();
    LibSerializer libSerializer;
    String dir = "src/resources/libraryTest.json";
    File file = new File(dir);

    @Before
    public void prepareForTest(){
        libSerializer = new LibSerializer(new ObjectMapper(), dir);
        book.setTitle("title");
        book.setAuthor("author");
        lib.getBooks().add(book);
    }

    @Test
    public void writeToFileTest() {
        libSerializer.writeToFile(lib);
        Assert.assertTrue(file.exists());
        Assert.assertEquals(file.length(), 47L );
    }

    @Test
    public void readFromFileTest(){
        libTest = libSerializer.readFromFile();
        Assert.assertEquals(lib, libTest);
        file.delete();
        Assert.assertFalse(file.exists());
    }
}
