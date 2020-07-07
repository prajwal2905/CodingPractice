package com.company;

import java.util.*;
import java.util.stream.Collectors;

/*Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

        Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



        Example 1:

        Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        Output: [2,2,2,1,4,3,3,9,6,7,19]


        Constraints:

        arr1.length, arr2.length <= 1000
        0 <= arr1[i], arr2[i] <= 1000
        Each arr2[i] is distinct.
        Each arr2[i] is in arr1.*/
public class ERelativeSort {

    public void relativeSort() {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        List<Integer> arr1List = new ArrayList<>(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        int[] newArr = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr2.length; i++) {
            map.put(arr2[i],i);
        }
        int nextIndex = 0;

        System.out.println(arr1List);
        for(int i=0; i<arr2.length; i++) {
            int count=0;
            while(arr1List.contains(arr2[i])) {
                nextIndex = map.get(arr2[i])+count;
                newArr[nextIndex] = arr2[i];
                arr1List.remove(new Integer(arr2[i]));
                count++;
            }
            if(i!=(arr2.length-1)) {
                map.put(arr2[i + 1], nextIndex + 1);
            }
        }
        Collections.sort(arr1List);
        for(int a : arr1List) {
            newArr[++nextIndex] = a;
        }

        for(int i=0;i<newArr.length;i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
