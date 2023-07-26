package W1D1Array;


import java.util.Arrays;

/**
 * https://www.bilibili.com/video/BV12A4y1Z7LP/
 * https://programmercarl.com/0027.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.html
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 3, 5, 6};
        removeElement(ints, 3);
    }

    public static int removeElement(int[] nums, int val){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        int[] ints = Arrays.stream(nums).limit(slow).toArray();
        System.out.println(Arrays.toString(ints));
        return slow;
    }
}
