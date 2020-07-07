package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void change(String weather) {
        weather = "winter";
    }

    public static void changeD(String[] days) {
        days[1] = "W";
    }

    public static void main(String[] args) {

        String weather = "summer";
        change(weather);
        System.out.println("Weather " + weather);

        String[] rainyDays = new String[] {"M", "T"};
        changeD(rainyDays);
        System.out.println("Days " + rainyDays[0] +" " + rainyDays[1]);



        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '0'}
        };

        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '0', '0', '0'}
        };

        HNumberOfIslands hNumberOfIslands = new HNumberOfIslands();
        System.out.println("Number of Islands for grid1 " + hNumberOfIslands.numbIslands(grid));
        System.out.println("Number of Islands for grid2 " +hNumberOfIslands.numbIslands(grid1));
        int arr[] = new int[]{2, 1, 1};
        System.out.println("Duplicate Entry "+ duplicateEntry(arr));

        System.out.println("Longest sub String for Banana:  ");
        findAllSubStrings("banana");
        System.out.println("Longest sub String for tomato:  ");
        findAllSubStrings("tomato");
        System.out.println("Longest sub String for aaaaaa: ");
        findAllSubStrings("aaaaaa");
        System.out.println("Longest sub String for Ask not what your country can do for you, ask what you can do for your country.:  ");
        findAllSubStrings("Ask not what your country can do for you, ask what you can do for your country.");

        System.out.println("Fib of " + fib(10));

        List<Integer> list = new ArrayList<>();
        list.add(0, 2);
        list.add(0, 5);
        System.out.println(list);

        ENaryTreePostOrder eNaryTreePostOrder = new ENaryTreePostOrder();
        List<ENaryTreePostOrder.Node> firstChildren = new ArrayList<>();
        List<ENaryTreePostOrder.Node> secondChildren = new ArrayList<>();
        secondChildren.add(new ENaryTreePostOrder.Node(5, Collections.emptyList()));
        secondChildren.add(new ENaryTreePostOrder.Node(6, Collections.emptyList()));
        firstChildren.add(new ENaryTreePostOrder.Node(3, secondChildren));
        firstChildren.add(new ENaryTreePostOrder.Node(2, secondChildren));
        firstChildren.add(new ENaryTreePostOrder.Node(4, secondChildren));

        ENaryTreePostOrder.Node root = new ENaryTreePostOrder.Node(1, firstChildren);
        //System.out.println(eNaryTreePostOrder.postOrder(root));
        System.out.println(compareKeyPress("abc<", "ab"));
        System.out.println(compareKeyPress("ab<c<", "a"));

        Integer element = 2;
        if(element % 2 == 0) {

        }

        Shape b = new Ballb();
        System.out.println(b.getName());

        List<String> list1 = new ArrayList<>();
        list1.add("foo");

        List<String> list2 = list1;
        List<String> list3 = new ArrayList<>(list2);
        list1.clear();
        list2.add("bar");
        list3.add("baz");

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        try {
            list3.add("nothing");
            return;
        } finally {
            System.out.println("finally");
        }
    }

    static <T> void add(List<String> list) {
        list.add("foo");
    }



    static boolean compareKeyPress(String input1, String input2) {
        int index = input1.length() - 1;
        int secondIndex = input2.length() -1;
        while(index >= 0 && secondIndex >= 0) {
            if(index == secondIndex) {
                if(input1.charAt(index) == input2.charAt(secondIndex)) {
                    if(input1.charAt(index) == '<') {
                        index--;
                    }
                    index--;
                    secondIndex--;
                }
                else {
                    try {
                        return false;
                    } finally {
                        System.out.println("Finally");
                    }
                }
            } else if (index > secondIndex) {
                if(input1.charAt(index) == '<') {
                    index--;
                }
                index--;
            } else return false;
        }
        if(secondIndex > index) {
            return false;
        }
        return true;
    }


    static int fib(int n) {
        if(n==1 || n==2) return 1;
        int a=1,b=1;
        int sum = 0;
        for(int index = 3; index <= n; index++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int duplicateEntry(int[] arr) {
        Arrays.sort(arr);
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] != (index+1)) {
                return arr[index];

            }
        }
        return -1;
    }

    public static void findAllSubStrings(String str) {
        Map<String, Integer> subStringOccurance = new HashMap<>();

        for(int index = 0; index < str.length()-1; index++) {
            for(int secondIndex = index +1 ; secondIndex <= str.length(); secondIndex++) {
                String subString = str.substring(index, secondIndex);
                int count = 1;
                if(subStringOccurance.containsKey(subString)) {
                    count = subStringOccurance.get(subString);
                    count++;
                }
                subStringOccurance.put(subString, count);
            }
        }

        Optional<Map.Entry<String, Integer>> subStringList =
                subStringOccurance.entrySet().stream().filter(element -> element.getValue() > 1)
                        .max(Comparator.comparingInt(o -> o.getKey().length()));
                        //collect(Collectors.toList());
                        //.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));


        System.out.println(subStringList.get().getKey());
        /*String longestSubString = "";
        subStringList.forEach(subString -> {
            if(subString.getKey().length() > longestSubString.length()) {
                longestSubString = subString.getKey();
            }

        });*/
    }

    public static int search(int L, int n, String S) {
        HashSet<String> seen = new HashSet();
        String tmp;
        for(int start = 0; start < n - L + 1; ++start) {
            tmp = S.substring(start, start + L);
            if (seen.contains(tmp)) return start;
            seen.add(tmp);
        }
        return -1;
    }

    public static int longestRepeatingSubstring(String S) {
        int n = S.length();
        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left <= right) {
            L = left + (right - left) / 2;
            if (search(L, n, S) != -1) left = L + 1;
            else right = L - 1;
        }

        return left - 1;
    }

    public void topFeature() {

        int numFeatures = 6;
        int topFeatures = 2;
        List<String> possibleFeatures = new ArrayList<>();
        possibleFeatures.add("storage");
        possibleFeatures.add( "battery");
        possibleFeatures.add("hover");
        possibleFeatures.add("waterproof");
        int numFeatureRequests = 7;
        List<String> featureRequests = new ArrayList<>();
        featureRequests.add("Req battery");
        featureRequests.add("need hover");
        featureRequests.add("extended Battery!");
        featureRequests.add("Waterproof waterproof!");
        featureRequests.add("Waterproof");
        featureRequests.add("Need waterproof!");

        Map<String, Integer> featureCount = new HashMap<>();

        for(String featureRequest : featureRequests) {
             //Considering multiple occurances as single mention.
            Set<String> words = new HashSet<>(Arrays.asList(featureRequest.toLowerCase().split("\\W+")));
            for (String word : words) {
                if (possibleFeatures.contains(word.toLowerCase())) {
                    int count = 1;
                    if (featureCount.containsKey(word.toLowerCase())) {
                        count = featureCount.get(word.toLowerCase());
                        count += 1;
                    }
                    featureCount.put(word.toLowerCase(), count);
                }
            }
        }

        if(topFeatures > possibleFeatures.size()) {
            //if topfeatures > possibleFeatures returning the features in featureRequest
            //return new ArrayList<>(featureCount.keySet());
        } else {
            //Sorting the map based on the count in reverseOrder using Java 8 Streams
            List<Map.Entry<String, Integer>> popularFeaturesList = featureCount
                    .entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
            ArrayList<String> features = new ArrayList<>();
            for(int index =0; index < topFeatures; index++) {
                //return only the keys of from the list upto topFeatures
                features.add(popularFeaturesList.get(index).getKey());
            }
           // return features;
        }


        System.out.println(featureCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList()));
    }
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
    	if(logFileSize == 0)
            return logLines;
    List<String> letterList = new ArrayList<>();
    List<String> digitList = new ArrayList<>();
    //Wanted two temp lists to separate lines with letters to be sorted.
		for(String line : logLines) {
        if(line.split(" ")[1].charAt(0) < 'a') {
            digitList.add(line);
        } else {
            letterList.add(line);
        }
    }

    //Solution was to use Comparator to do custom sorting on the each word of the line
    // also when the two strings are equal do the comparison on the identifier
		Collections.sort(letterList, (log1, log2) -> {
        String[] str1 = log1.split(" ");
        String[] str2 = log2.split(" ");
        int length1 = str1.length;
        int length2 = str2.length;
        for(int index = 1; index < Math.min(length1, length2); index++) {
            if(!str1[index].equals(str2[index])) {
                return str1[index].compareTo(str2[index]);
            }
        }
        return str1[0].compareTo(str2[0]);
    });

    List<String> sortedLogLines = new ArrayList<>();
		for(int index = 0; index < logFileSize; index++) {
        if(index < letterList.size()) {
            sortedLogLines.add(index, letterList.get(index));
        } else {
            sortedLogLines.add(index, digitList.get(index - letterList.size()));
        }
    }
		return sortedLogLines;
}


}
