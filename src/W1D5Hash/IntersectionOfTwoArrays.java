package W1D5Hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * https://www.bilibili.com/video/BV1ba411S7wu/
 * https://leetcode.cn/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/651251
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> num1Set = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int i : nums2) {
            if (num1Set.contains(i)){
                intersectionSet.add(i);
            }
        }
        int[] result = new int[]{intersectionSet.size()};
        int index = 0;
        for (Integer item : intersectionSet) {
            result[index++] = item;
        }
        return result;
    }
}
