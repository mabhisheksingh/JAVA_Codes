package leetcode.easy;

/*Given two strings s and goal, return true if you can swap two letters in
s so the result is equal to goal, otherwise, return false.
Swapping letters is defined as taking two indices i and
j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".*/
public class BuddyStrings {
    public static void main(String[] args) {
        String s = "aa";
        String goal = "aa";
        System.out.println("\nbuddyString : " + buddyStrings(s, goal));
    }

    private static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        else {
            int a[] = new int[26];
            boolean flaga = false;
            int missMatchCount = 0;
            int x = -1, y = -1;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 97;
                a[index]++;
                if (a[index] > 1) {
                    flaga = true;
                }
                if (s.charAt(i) != goal.charAt(i)) {
                    missMatchCount++;
                    if (missMatchCount <= 2) {
                        if (x == -1) {
                            x = i;
                        } else {
                            y = i;
                        }
                    }
                }
            }
            System.out.println("miss " + missMatchCount + " " + s + " " + x + " " + y + " " + goal);
            if (missMatchCount==2 && s.charAt(x) == goal.charAt(y) && s.charAt(y) == goal.charAt(x) ) {
                return true;
            }
            if ((missMatchCount == 0 && flaga)) return true;
        }
        return false;
    }
}
