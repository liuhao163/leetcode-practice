import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuhaoeric code 3
 * Create time: 2018/10/28
 * Description:
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("alqebriavxoo"
        ));

        System.out.println(lengthOfLongestSubstringBySliceWindow("alqebriavxoo"
        ));

        System.out.println(lengthOfLongestSubstringBySliceWindowParse2("alqebriavxoo"
        ));
    }

    /**
     * 优化的滑动窗口，特点Map是字符-index，假设s[i,j]每次发现重复字符j'，直接滑动窗口变为[j'+1,j]
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringBySliceWindowParse2(String s) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                flag = Math.max(map.get(s.charAt(i)), flag);//j+1
            }

            res = Math.max(res, i - flag + 1);//返回的是长度
            map.put(s.charAt(i), i+1);
        }

        return res;
    }

    /**
     * 滑动窗口,set包括了不重复的字符串[start,end],如果不重复，end++,放到set中，如果重复start++，同时set删除一个字符。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringBySliceWindow(String s) {
        int start = 0;
        int end = 0;
        int res = 0;

        int length = s.length();
        Set<Character> set = new HashSet<>();
        while (start < length && end < length) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return res;
    }

    //暴力法
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int start = 0;
        int currentMax = 0;
        int max = 0;
        while (start < s.toCharArray().length) {
            for (int i = start; i < s.toCharArray().length; i++) {
                char c = s.toCharArray()[i];
                if (!set.contains(c)) {
                    set.add(c);
                    max++;
                } else {
                    if (max > currentMax) {
                        currentMax = max;
                    }
                    set.clear();
                    max = 0;
                    break;
                }
            }
            start++;
        }

        return currentMax;
    }
}
