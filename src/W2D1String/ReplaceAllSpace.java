package W2D1String;

public class ReplaceAllSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
        System.out.println(replaceSpaceMethodTwo("We are happy."));
        System.out.println(function("We are happy."));
    }

    public static String function(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 3];

        int size = 0;
        for (char aChar : chars) {
            if (aChar != ' ') {
                result[size++] = aChar;
            } else {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            }
        }
        return new String(result, 0, size);
    }

    public static String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                builder.append(c);
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }

    public static String replaceSpaceMethodTwo(String s) {
        int size = 0;
        char[] result = new char[s.length() * 3];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            } else {
                result[size++] = aChar;
            }
        }
        return new String(result, 0, size);
    }
}
