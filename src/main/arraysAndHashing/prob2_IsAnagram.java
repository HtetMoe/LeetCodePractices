package main.arraysAndHashing;

public class prob2_IsAnagram {
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";
        //System.out.println('c' - 'a'); // 2
        System.out.println(STR."result => \{isAnagram(s, t)}");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26]; // 26 alphabet in English
        for (int i = 0; i < s.length(); i++) { //exact same character frequencies.
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        //System.out.println(Arrays.toString(charCount));

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }
}
