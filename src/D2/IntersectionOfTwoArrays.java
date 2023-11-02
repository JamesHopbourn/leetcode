package D2;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i : intersection) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        for (int i : nums1) {hash1[i]++;}
        for (int i : nums2) {hash2[i]++;}
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] > 0 && hash2[i] > 0){integers.add(i);}
        }
        int index= 0 ;
        int[] result = new int[integers.size()];
        for (int integer : integers) {
            result[index++] = integer;
        }
        return result;
    }
}
