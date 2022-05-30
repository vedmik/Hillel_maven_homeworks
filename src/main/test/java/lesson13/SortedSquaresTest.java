package lesson13;

import org.junit.Assert;
import org.junit.Test;

public class SortedSquaresTest {

    @Test
    public void sortedSquaresTest() {
        SortedSquares sortedSquares = new SortedSquares();

        Assert.assertArrayEquals(new int[]{0,1,9,16,100},sortedSquares.sortedSquares(new int[]{-4,-1,0,3,10}));
    }
}
