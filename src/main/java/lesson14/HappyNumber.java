package lesson14;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public boolean isHappy(int n) {
        while(checkNumberOfSigns(n) > 1){
            n = squaringAndSumming(n);
        }
        if(n == 1){
            return true;
        }
        return false;
    }

    private int squaringAndSumming(int n){
        int result = 0;
        int singleNum = 0;

        while(n > 0) {
            singleNum = n%10;
            result +=  singleNum * singleNum;
            n = n / 10;
        }

        return result;
    }

    private int checkNumberOfSigns(int n){
        int result = 0;

        while(n > 0) {
            n = n / 10;
            result++;
        }

        return result;
    }
}
