package W1D5Hash;

/**
 * https://leetcode.cn/problems/valid-anagram/
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean result = function(s, t);
        System.out.println(result);

        String s1 = "cat", s2 = "dog";
        boolean s1Result = function(s1, s2);
        System.out.println(s1Result);
    }

    public static boolean function(String s, String t){
        // 基础判断
        if (s.length() != t.length()) {
            return false;
        }
        // 创建哈希表
        int[] table = new int[26];
        // 添加字母频率
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            table[index]++;
        }
        // 删除字母频率
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            table[index]--;
            // 提前判断，不要外面再写一个 for 处理
            if (table[index] < 0){
                return false;
            }
        }
        return true;
    }
}
