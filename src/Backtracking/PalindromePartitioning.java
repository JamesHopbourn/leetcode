package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String substring = s.substring(startIndex, i + 1);
                path.add(substring);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i=startIndex, j= end;i<j;i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
