package W1D6Hash;

/**
 * https://leetcode.cn/problems/ransom-note/
 */

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab", "ab"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        int[] characters = new int[26];
        for (char magazineChar : magazine.toCharArray()) {
            characters[magazineChar - 'a']++;
        }
        for (char ransomNoteChar : ransomNote.toCharArray()) {
            characters[ransomNoteChar - 'a']--;
            if (characters[ransomNoteChar - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
