package D2;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
                               
    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (byte aByte : s.getBytes()) {
            alphabet[aByte - 'a']++;
        }
        for (byte aByte : t.getBytes()) {
            alphabet[aByte - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
