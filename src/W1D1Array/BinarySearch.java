package W1D1Array;


public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(search(ints, 4));
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
