package W1D2Array;


import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] ints = {-5, -3, 1, 2, 3, 4};
        function(ints);
    }

    public static void function(int[] nums){
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[i]){
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
