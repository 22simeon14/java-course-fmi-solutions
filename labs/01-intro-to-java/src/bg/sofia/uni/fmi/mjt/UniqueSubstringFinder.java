package bg.sofia.uni.fmi.mjt;

import java.util.Scanner;

public class UniqueSubstringFinder {

    public static String longestUniqueSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        int currLen = 0;
        int startingIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            temp += s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char curr = s.charAt(j);
                if (temp.indexOf(curr) == -1) {
                    temp += curr;
                    currLen++;
                } else {
                    if (maxLen < currLen) {
                        maxLen = currLen;
                        startingIdx = i;
                    }
                    currLen = 0;
                    break;
                }
            }
        }

        if (maxLen == Integer.MIN_VALUE)
            maxLen = s.length() - 1;
        return s.substring(startingIdx, startingIdx + maxLen + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s;
            s = sc.nextLine();
            if (s.equals("break") || s.equals("Break") || s.equals("exit")) {
                sc.close();
                break;
            }
            // System.out.println("\n");
            System.out.println(longestUniqueSubstring(s));
        }

    }

}
