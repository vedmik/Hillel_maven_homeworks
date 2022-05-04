import lesson13.MaximumProduct;
import lesson13.SortedSquares;

import java.util.Arrays;

public class Main {
        public static void main( String[] args ) {
                MaximumProduct maximumProduct = new MaximumProduct();

                System.out.println(maximumProduct.maxProduct(new int[]{3,4,5,2}));
                System.out.println(maximumProduct.maxProduct(new int[]{1,5,4,5}));
                System.out.println(maximumProduct.maxProduct(new int[]{3,7}));

                SortedSquares sortedSquares = new SortedSquares();

                System.out.println(Arrays.toString(sortedSquares.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
                System.out.println(Arrays.toString(sortedSquares.sortedSquares(new int[]{-7,-3,2,3,11})));

        }

}
