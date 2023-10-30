package D1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 左闭右闭
        while (left <= right) { // 左闭右闭
            int mid = left + right;
            if (nums[mid] > target) {
                mid = right--;
            } else if (nums[mid] < target){
                mid = left++;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
