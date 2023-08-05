package W1D1Array;


public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(search(ints, 4));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        // 使用左闭右开可以不用 -1
        int right = nums.length;
        // [1,1) 闭区间的 1 能不能等于开区间的 1？
        // 不能，既然不能就可以使用 <=，那么就使用 <
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                // 右区间因为没有闭合，所以直接赋值
                right = mid;
            } else if (nums[mid] < target) {
                // 左区间因为有闭合，所以需要 +1 向前一位
                left = mid + 1;
            } else {
                // 返回的是下标位置
                return mid;
            }
        }
        return -1;
    }
}
