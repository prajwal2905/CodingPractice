package com.company;
/*
* We distribute some number of candies, to a row of n = num_people people in the following way:

We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.

Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.

This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).

Return an array (of length num_people and sum candies) that represents the final distribution of candies.



Example 1:

Input: candies = 7, num_people = 4
Output: [1,2,3,1]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0,0].
On the third turn, ans[2] += 3, and the array is [1,2,3,0].
On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
Example 2:

Input: candies = 10, num_people = 3
Output: [5,2,3]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0].
On the third turn, ans[2] += 3, and the array is [1,2,3].
On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
*
*
* candies = 60, num_people = 4
* Output: [15,18,15,12]
*
*
* */
public class ECountCandies {

    public static int[] distributeCandies(int candies, int num_people) {
        int[] candiesPerson = new int[num_people];
        int passCount = 0;
        int i = 0;
        while(candies > 0) {
            if(passCount == 0) {
                if(candies > (i+1)){
                    candiesPerson[i] = i + 1;
                    candies = candies - (i + 1);
                } else {
                    candiesPerson[i] += candies;
                    candies -= candies;
                }
            } else {
                if(candies > (num_people + (i + 1))){
                    candiesPerson[i] = candiesPerson[i] + (num_people + (i + 1));
                    candies = candies - (num_people + (i+1));
                } else {
                    candiesPerson[i] += candies;
                    candies -= candies;
                }
            }
            i++;
            if(i == num_people) {
                i=0;
                passCount++;
            }
        }
        return candiesPerson;
    }


    static void candies(int n, int k)
    {

        // Count number of complete turns
        int count = 0;

        // Get the last term
        int ind = 1;

        // Stores the number of candies
        int []arr=new int[k];

        for(int i=0;i<k;i++)
            arr[i]=0;

        while (n>0) {

            // Last term of last and
            // current series
            int f1 = (ind - 1) * k;
            int f2 = ind * k;

            // Sum of current and last series
            int sum1 = (f1 * (f1 + 1)) / 2;
            int sum2 = (f2 * (f2 + 1)) / 2;

            // Sum of current series only
            int res = sum2 - sum1;

            // If sum of current is less than N
            if (res <= n) {
                count++;
                n -= res;
                ind++;
            }
            else // Individually distribute
            {
                int i = 0;

                // First term
                int term = ((ind - 1) * k) + 1;

                // Distribute candies till there
                while (n > 0) {

                    // Candies available
                    if (term <= n) {
                        arr[i++] = term;
                        n -= term;
                        term++;
                    }
                    else // Not available
                    {
                        arr[i++] = n;
                        n = 0;
                    }
                }
            }
        }

        // Count the total candies
        for (int i = 0; i < k; i++)
            arr[i] += (count * (i + 1))
                    + (k * (count * (count - 1)) / 2);

        // Print the total candies
        for (int i = 0; i < k; i++)
            System.out.print( arr[i] + " ");
    }
}
