package lesson23;

import Lesson23.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class PatternTest {

    @Test
    public void wordPatternTest() {
        Pattern pattern = new Pattern();

        Assert.assertTrue(pattern.wordPattern("abba","dog cat cat dog"));
        Assert.assertFalse(pattern.wordPattern("abba","dog cat cat fish"));
        Assert.assertFalse(pattern.wordPattern("aaaa","dog cat cat dog"));

    }
}
