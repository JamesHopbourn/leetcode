package W1D6Hash;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/4sum-ii/
 * https://leetcode.cn/problems/4sum-ii/solution/454-si-shu-xiang-jia-ii-by-shen-du-rm-s44b/
 * https://ls8sck0zrg.feishu.cn/wiki/EcSrwnoURimDEokXSsjcrFd1nf4
 */
public class FourSumII {
    public static void main(String[] args) {
        int result = fourSumCount(new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2});
        System.out.println(result);
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                count += map.getOrDefault(-n3-n4, 0);
            }
        }
        return count;
    }
}
