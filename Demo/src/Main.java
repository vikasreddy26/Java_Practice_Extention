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

       final int x = 10;
        System.out.println("x = " +x);
        String[] str = {"flower", "flaight", "flow"};
        System.out.println(longestCommonPrefix(str));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingChar("abcdea"));
        System.out.println(reverseVowels("vikas"));
        System.out.println(lowerToUpperViseVersa("Mano Vikas"));
        System.out.println(findAllSubstrings("abcde"));
        System.out.println(longestPalindrome("forgeeksskeegfor"));
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<Integer, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(e -> e.length()));
        System.out.println(groupAnagram(strs));
        System.out.println(removeAdjacentDuplicates("abbaca"));
        System.out.println(firstNonRepeat("anovikas"));
        System.out.println(compressStringToItsCount("aaabbccccdd"));
        convertNumToChar("a3b2c");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,12};
        moveOddNumbersToLast(numbers);
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,10,9,8,7};
        System.out.println(LargestUniqueNumber(arr));
        int array[] = {1,2,3,3,2,1,3};
        System.out.println(checkArrayPalindrome(array));
        findMissingNum(numbers,12);
        Integer integer = Integer.valueOf("10");
        System.out.println(integer + 20);
        System.out.println(integer.floatValue());
        groupBylength(strs);
        int[] i ={-4, 1, 0, 0, 2, 21, 4};
        moveZerosToEnd(i);
        nthLaragestElement(i,3);
        String[] str1 = {"mano", "vikas", "reddy", "yerra", "raj", "sp"};
        sort(str1);
        sumOfNumsInString("ab12op101h#$#dkur34ch897u#$@#y");
    }

     public static int lengthOfLongestSubstringWithoutRepeatingChar(String s){
        int maxLength = 0;
        String maxSubstring = "";
        for(int i =0;i<s.length();i++){
            int currentLength = 0;
            String currentSubstring = "";
            Set<Character> set = new HashSet<>();
            for(int j = i; j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                currentSubstring += s.charAt(j);
                currentLength++;
                if(currentLength>maxLength){
                    maxLength=currentLength;
                    maxSubstring = currentSubstring;
                }
            }
        }
        System.out.println(maxSubstring);
        return maxLength;
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
        char[] chars =s.toCharArray();
        String result = "";
        for (char c :chars){
            if(!result.isEmpty() && result.charAt(result.length()-1)==c){//If result is empty there is no adjacent chars and if last character added same as adjacent then we need to remove last char
                result=result.substring(0,result.length()-1);// Remove the last character
            }
            else {
                result+=c;
            }
        }
        return result;
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

    public static String compressStringToItsCount(String s){
        if(s.isEmpty() || s == null){
            return "";
        }
        String result ="";
        int count = 1;
        for(int i =1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                result+=s.charAt(i-1) + String.valueOf(count);
            }
        }
        result+=s.charAt(s.length()-1) + String.valueOf(count);
        return result;
    }

    static boolean checkArrayPalindrome(int[] arr){
        int start =0,end = arr.length-1;
        while (start<end){
            if(arr[start]!=arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
     }

     public static void findMissingNum(int[] arr,int n){
        int missing = n*(n+1)/2;
        int sum = 0;
        for(int i :arr){
            sum = sum+i;
        }
         System.out.println(missing-sum);
     }

     static void groupBylength(String[] str){
        Map<Integer,List<String>>map = new HashMap<>();
        for (String s:str){
            if(!map.containsKey(s.length())){
                map.put(s.length(),new ArrayList<>());
            }
            map.get(s.length()).add(s);
        }
         System.out.println(map);
     }
     static void moveZerosToEnd(int arr[]){
        int count = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count]=temp;
                count++;
            }
        }
         System.out.println(Arrays.toString(arr));
     }

    public static void sumOfNumsInString(String s){
        int sum = 0;
        String nums []= s.split("\\D+");
        for (String num : nums) {
            if (!num.isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }
        System.out.println("Sum of numbers in the string: " + sum);
    }

    public static void patternPrinting(){
        int n = 4; // Number of rows/columns
        for (int i = 0; i < n; i++) {  // Loop for rows
            for (int j = 0; j < n; j++) {  // Loop for columns
                if (i == j) {
                    System.out.print("* ");  // Replace diagonal elements with '*'
                } else {
                    System.out.print((j + 1) + " ");  // Print numbers otherwise
                }
            }
            System.out.println();  // New line for each row
        }
    }
    static void seperateAlphaAndNumbers(){
        String input = "A1B2C3";
        String letters = input.replaceAll("[^A-Za-z]", "");
        String numbers = input.replaceAll("[^0-9]", "");
        System.out.println(letters + " " + numbers); // Output: ABC 123
    }

    public static String transformString(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        String result = "";

        for (char c : str.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                int count = charCountMap.get(c) + 1;
                charCountMap.put(c, count);
                result += count; // Append count if it's a duplicate
            } else {
                charCountMap.put(c, 1);
                result += c; // Append character if it's the first occurrence
            }
        }
        return result;
    }

    public static void averageOfArray(){
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;
        int count = numbers.length;
        if (count > 0) { // Ensure no division by zero
            for (int num : numbers) {
                sum += num;
            }
            double average = (double) sum / count;
            System.out.println("Average: " + average);
        } else {
            System.out.println("Array is empty, average is 0.");
        }
    }

    public static void sortByFrequency(){
        int[] arr = {4, 5, 6, 5, 4, 3, 6, 6, 6, 2, 4, 2}; // Input array
        // Step 1: Count frequency of elements
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        // Step 2: Store elements in a list for sorting
        List<Integer> elements = new ArrayList<>();
        for (int num : arr) {
            elements.add(num);
        }
        // Step 3: Sort based on frequency (descending), and by value (ascending) for tie-breaking
        Collections.sort(elements, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqA = frequencyMap.get(a);
                int freqB = frequencyMap.get(b);

                if (freqA != freqB) {
                    return freqB - freqA; // Sort by frequency (descending)
                }
                return a - b; // If frequency is same, sort by value (ascending)
            }
        });
        // Step 4: Convert List to array
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < elements.size(); i++) {
            sortedArr[i] = elements.get(i);
        }
        // Step 5: Print the result
        System.out.println("Sorted by Frequency: " + Arrays.toString(sortedArr));
    }

    static void removeSpaceAndSort(){
        String str = "My Name is Vikas";
        // Step 1: Remove spaces
        str = str.replace(" ", ""); // Removes all spaces
        // Step 2: Convert string to character array and sort
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        // Step 3: Convert sorted char array back to string
        String sortedString = new String(charArray);
        // Output
        System.out.println("Sorted String without spaces: " + sortedString);
    }

    public static int findSecondLargestDigit(String s) {
        TreeSet<Integer> digits = new TreeSet<>();
//str1025rts
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(ch - '0'); // Convert char to int
            }
        }
        if (digits.size() < 2) {
            return -1; // If there's no second largest digit
        }
        digits.pollLast(); // Remove the largest
        return digits.last(); // Get the second largest
    }

    public static int[] incrementNumber(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // If all digits are 9, create a new array
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
        // System.out.println(Arrays.toString(incrementNumber(new int[]{1, 2, 9}))); // [1, 3, 0]
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
