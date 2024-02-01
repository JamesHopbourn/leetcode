package D1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] > target){
                right = mid--;
            } else if (nums[mid] < target){
                left = mid++;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
