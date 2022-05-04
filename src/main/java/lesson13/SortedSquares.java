package lesson13;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] array= new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] * nums[i];
        }

        sortArray(array);

        return array;
    }

    private void sortArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private void swap(int[] array, int i, int min) {
        int tmp = array[i];
        array[i] = array[min];
        array[min] = tmp;
    }

}
