package lesson13;

public class MaximumProduct {

    public int maxProduct(int[] nums) {
        int result = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                sum = (nums[i] - 1) * (nums[j] - 1);
                if(sum > result){
                    result = sum;
                }
            }
        }

        return result;
    }
}
