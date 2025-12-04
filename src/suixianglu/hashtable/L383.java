package suixianglu.hashtable;

import java.util.HashMap;
import java.util.Map;

public class L383 {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        int flag = map.size();
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) - 1);
                if (map.get(magazine.charAt(i)) == 0) {
                    flag--;
                }
            }
        }
        return flag == 0;
    }

}
