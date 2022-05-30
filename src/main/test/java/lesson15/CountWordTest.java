package lesson15;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CountWordTest {

    String dir = "src/main/resources/test.txt";
    String dir2 = "src/main/resources/result_test.txt";

    @Before
    public void createFile(){
        new File(dir);
    }

    @Test
    public void countUniqueWordsAndSaveFileTest() {
        CountWord countWord = new CountWord();

        countWord.countUniqueWordsAndSaveFile(dir);

        Assert.assertTrue(new File(dir2).exists());
    }

    @After
    public void deleteFiles(){
        new File(dir).delete();
        new File(dir2).delete();
    }
}
