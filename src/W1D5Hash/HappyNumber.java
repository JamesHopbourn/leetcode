package W1D5Hash;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/happy-number/
 * https://leetcode.cn/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(cal(10));
        System.out.println(cal(19));
        System.out.println(cal(23));

        int num = 19;
        boolean happy = isHappy(num);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        // 要么等于 1，要么进入了循环
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = cal(n);
        }
        // 最后统一判断
        return n == 1;
    }

    public static int cal(int n){
        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            sum += digit*digit;
            n /= 10;
        }
        return sum;
    }
}
