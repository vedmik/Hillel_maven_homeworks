package lesson14;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {

    @Test
    public void isHappyTest() {
        HappyNumber happyNumber = new HappyNumber();

        Assert.assertTrue(happyNumber.isHappy(19));
    }
}
