package lesson13;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductTest {

    @Test
    public void maxProductTest() {
        MaximumProduct maximumProduct = new MaximumProduct();

        Assert.assertEquals(12, maximumProduct.maxProduct(new int[]{3,4,5,2}));
    }
}
