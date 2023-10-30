package D1;

/**
 * <a href="https://www.bilibili.com/video/BV12A4y1Z7LP/">数组中移除元素并不容易！ | LeetCode：27. 移除元素_哔哩哔哩_bilibili</a>
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
