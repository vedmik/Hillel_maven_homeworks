package lesson20;

import org.junit.Assert;
import org.junit.Test;

public class RomanToIntegerTest {

    @Test
    public void romanToInt() {
        RomanToInteger romanToInteger = new RomanToInteger();
        Assert.assertEquals(1447,romanToInteger.romanToInt("MCDXLVII"));
    }
}
