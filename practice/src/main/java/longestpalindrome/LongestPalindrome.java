package longestpalindrome;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/3/15
 */
public class LongestPalindrome {


    private static String s = "aa";

    public static void main(String[] args) {
        LongestPalindrome d = new LongestPalindrome();
        System.out.println("result:" + d.longestPalindrome(s));
        System.out.println("result:" + d.longestPalindrome2(s));
    }

    public String longestPalindrome(String s) {
        String ret = "";
        for (int start = 0; start <= s.length(); start++) {
            for (int end = s.length(); end > start; end--) {
                String tmpStr = s.substring(start, end);
                boolean isPal = true;
                for (int cal = 0; cal < tmpStr.length() / 2; cal++) {
                    if (tmpStr.charAt(cal) != tmpStr.charAt(tmpStr.length() - cal - 1)) {
                        isPal = false;
                    }
                }
                if (isPal && tmpStr.length() >= ret.length()) {
                    ret = tmpStr;
                }
            }
        }
        return ret;
    }

    public String longestPalindrome2(String s) {
        if (s.length() < 1) {
            return s;
        }

        String ret = "";
        int l = 0;
        int r = 0;
        for (int i = 0; i <= s.length(); i++) {
            int len1 = findLongest(s, i, i);
            int len2 = findLongest(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > r - l) {
                l = i - (len - 1) / 2;
                r = i + len  /2;
            }
        }
        return s.substring(l, r);
    }

    private int findLongest(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
