package D2;

import java.util.HashMap;

public class FourSumII {
    public static void main(String[] args) {
        int count = fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2});
        System.out.println(count);
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum  = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                count += map.getOrDefault(-i-j, 0);
            }
        }
        return count;
    }
}
