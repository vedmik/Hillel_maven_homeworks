package lesson12;

import lesson12.JewelsAndStones;
import org.junit.Assert;
import org.junit.Test;

public class JewelsAndStonesTest {
    @Test
    public void numJewelsInStonesTest() {
        JewelsAndStones jas = new JewelsAndStones();
        Assert.assertEquals(6, jas.numJewelsInStones("abS ","absolut abstract"));
    }
}