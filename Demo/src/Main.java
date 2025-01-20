import java.util.EnumMap;


public class Main {
    public static void main(String[] args) {

        Season winter = Season.WINTER;
        Season value = Season.valueOf("WINTER");
        String nature = value.nature;
        System.out.println(nature);
        System.out.println("**************************");
        for(Season s:Season.values()){
            System.out.println(s.nature);
        }

        EnumMap<Season,String> enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.SUMMER,"Summer Season");
        enumMap.put(Season.RAINY,"Rainy Season");
        enumMap.put(Season.WINTER,"Winter Season");
        System.out.println("**************************");
        enumMap.entrySet().stream().forEach(e-> System.out.println(e.getKey().nature + " | "+e.getValue()));

                String input = "abca";
        int result = lengthOfLongestSubstring(input);
        System.out.println(longestSubstringWithoutRepeating(input));
        System.out.println("The length of the longest substring without repeating characters is: " + result);
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rearrangeArray(numbers);
        System.out.println("longest palindrome : "+longestPalindrome("forgeeksskeegfor"));
        System.out.println(removeAdjacentDuplicates("abbaca"));
        permutations("abc");
        System.out.println(reverseVowels("manovikas"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;

        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }

    public static String longestSubstringWithoutRepeating(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int start = 0;

        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }
      return s.substring(start, start + maxLength);
    }

    public static void rearrangeArray(int[] arr) {
        int[] temp = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] %2 == 0) {
                temp[count] = arr[i];
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] %2 != 0) {
                temp[count] = arr[i];
                count++;
            }
        }
        System.out.println(Arrays.toString(temp));
    }

    public static String reverseVowels(String str) {
        char[] chars = str.toCharArray();
        List<Character> vowels = new ArrayList<>();
        for (char c : chars) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        int vowelIndex = vowels.size() - 1;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowels.get(vowelIndex--);
            }
        }
        return new String(chars);
    }
    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String switchCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isLowerCase(ch)) {
                chars[i] = Character.toUpperCase(ch);
            }
            else if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            }
        }
        return new String(chars);
    }
    public static String alternateAndSwitchCase(char[] c1, char[] c2) {
        String result = "";
        int len1 = c1.length;
        int len2 = c2.length;

        int maxLength = Math.max(len1, len2);
        for (int i = 0; i < maxLength; i++) {
            if (i < len1) {
                result += Character.toLowerCase(c1[i]) + ", ";
            }
            if (i < len2) {
                result += Character.toUpperCase(c2[i]) + ", ";
            }
        }
       if (result.length() > 0) {
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    public static void moveRepeatingToEnd(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> nonRepeatingList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
                nonRepeatingList.add(arr[i]);
            }
        }
        int index = 0;
        for (int num : nonRepeatingList) {
            arr[index++] = num;
        }
        for (int num : nonRepeatingList) {
            int count = freqMap.get(num);
            if (count > 1) {
                for (int i = 1; i < count; i++) {
                    arr[index++] = num;
                }
            }
        }
    }

    public static List<String> findAllSubstrings(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }
        return result;
    }

    public static String longestPalindrome(String s){
        String longestPalindrome = "";
        int maxLength = 0;
        for(int i = 0; i<s.length();i++){
            for (int j = i+1; j < s.length(); j++) {
                String substring = s.substring(i, j);
                if(isPalindrome(substring)){
                    if (substring.length() > longestPalindrome.length()) {
                        longestPalindrome = substring;
                        maxLength = substring.length();
                    }
                }
            }
        }
        System.out.println(maxLength);
        return longestPalindrome;
    }
    private static boolean isPalindrome(String s){
        int left = 0,right = s.length()-1;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public static String removeAdjacentDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (result.length() > 0 && result.charAt(result.length() - 1) == c) {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int findLargestUnique(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        int largest = -1;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                if (largest == -1 || key > largest) {
                    largest = key;
                }
            }
        }
        return largest;
    }

    public static char firstNonRepeat(String s) {
        HashMap<Character, Integer> char_count = new HashMap<>();
        for(int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if(char_count.containsKey(c)) {
                char_count.put(c, char_count.get(c) + 1);
            } else {
                char_count.put(c, 1);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(char_count.get(c)== 1)
                return c;
        }
        return '_';
    }

    static void convertNumToChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                System.out.print(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                int count = Character.getNumericValue(s.charAt(i));
                if (i > 0 && count > 0) {
                    for (int j = 1; j < count; j++) {
                        System.out.print(s.charAt(i - 1));
                    }
                }
            }
        }
    }

    public static void permutations(String str) {
        List<String> ans = new ArrayList<>(); //ArrayList
        ans.add(String.valueOf(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                String temp = ans.remove(j);
                for (int k = 0; k <= temp.length(); k++) {
                    ans.add(temp.substring(0, k) + str.charAt(i) + temp.substring(k));
                }
            }
        }

        System.out.println(ans);
    }
}
