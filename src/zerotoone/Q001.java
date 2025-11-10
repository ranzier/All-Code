package zerotoone;

public class Q001 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "xyznn";
        System.out.println(mergeAlternately(word1, word2));
    }

    // abc xyznn
    // axbycznn
    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder newWord = new StringBuilder(len1 + len2);

        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            newWord.append(word1.charAt(i));
            newWord.append(word2.charAt(i));
        }

        if (len1 < len2) {
            newWord.append(word2.substring(len));
        } else if (len1 > len2) {
            newWord.append(word1.substring(len));
        }

        return newWord.toString();
    }

}
