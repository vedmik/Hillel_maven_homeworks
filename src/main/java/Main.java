
import lesson12.IdenticalPairs;
import lesson12.JewelsAndStones;
import lesson13.MaximumProduct;
import lesson13.SortedSquares;
import java.util.Arrays;
import lesson14.HappyNumber;
import lesson14.MorseCode;
import lesson18.LibApp;
import lesson15.CountWord;

public class Main {
        public static void main( String[] args ) {
//                MaximumProduct maximumProduct = new MaximumProduct();
//
//                System.out.println(maximumProduct.maxProduct(new int[]{3,4,5,2}));
//                System.out.println(maximumProduct.maxProduct(new int[]{1,5,4,5}));
//                System.out.println(maximumProduct.maxProduct(new int[]{3,7}));
//
//                SortedSquares sortedSquares = new SortedSquares();
//
//                System.out.println(Arrays.toString(sortedSquares.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
//                System.out.println(Arrays.toString(sortedSquares.sortedSquares(new int[]{-7,-3,2,3,11})));
//
//                MorseCode morseCode = new MorseCode();
//
//                System.out.println(morseCode.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
//                System.out.println(morseCode.uniqueMorseRepresentations(new String[]{"a"}));
//
//                HappyNumber happyNumber = new HappyNumber();
//
//                System.out.println(happyNumber.isHappy(19));
//                System.out.println(happyNumber.isHappy(2));
//
//                JewelsAndStones jewelsAndStones = new JewelsAndStones();
//
//                System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
//                System.out.println(jewelsAndStones.numJewelsInStones("z", "ZZ"));
//
//                IdenticalPairs identicalPairs = new IdenticalPairs();
//
//                System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
//                System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,1,1,1}));
//                System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,2,3}));


                LibApp libApp = new LibApp();
                libApp.start();

                CountWord countWord = new CountWord();
                countWord.countUniqueWordsAndSaveFile("src/main/resources/tolstoy_voyna-i-mir__xoraa_436421.txt");
        }
}
