package lesson14;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

    @Test
    public void uniqueMorseRepresentationsTest() {
        MorseCode morseCode = new MorseCode();

        Assert.assertEquals(2,morseCode.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
    }
}
