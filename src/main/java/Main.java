import lesson14.HappyNumber;
import lesson14.MorseCode;

public class Main {
        public static void main( String[] args ) {

                MorseCode morseCode = new MorseCode();

                System.out.println(morseCode.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
                System.out.println(morseCode.uniqueMorseRepresentations(new String[]{"a"}));

                HappyNumber happyNumber = new HappyNumber();

                System.out.println(happyNumber.isHappy(19));
                System.out.println(happyNumber.isHappy(2));

                JewelsAndStones jewelsAndStones = new JewelsAndStones();

                System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
                System.out.println(jewelsAndStones.numJewelsInStones("z", "ZZ"));

                IdenticalPairs identicalPairs = new IdenticalPairs();

                System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
                System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,1,1,1}));
                System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,2,3}));

        }
}
