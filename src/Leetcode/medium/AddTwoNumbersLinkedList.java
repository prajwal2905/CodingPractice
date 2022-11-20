
/**
*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
*
*You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
*
*Input: l1 = [2,4,3], l2 = [5,6,4]
*Output: [7,0,8]
*Explanation: 342 + 465 = 807.
*Example 2:

*Input: l1 = [0], l2 = [0]
*Output: [0]
*Example 3:

*Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
*Output: [8,9,9,9,0,0,0,1]
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
*carryOver = 0
* while(head1.next()!= null || head)
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carryOver = 0;
        while(l1 != null || l2 != null) {
            //[9,9,9,9,9,9,9]
            //[9,9,9,9]
            //[8,9,9,9,0,0,0,]
            int sum = 0;
            if(l1 == null) {
                sum = l2.val + carryOver; 
                l2 = l2.next;
            }
            else if(l2 == null) {
                sum = l1.val + carryOver;
                l1 = l1.next;
            }
            else {
                sum = l1.val + l2.val + carryOver; //19
                l1 = l1.next;
                l2 = l2.next;
            }
            carryOver = sum / 10; //1
            curr.next = new ListNode(sum % 10); //9
            curr = curr.next; 
        }
        if(carryOver > 0) {
            curr.next = new ListNode(carryOver);
            curr = curr.next;
        }
       
        return dummy.next;
    }
}
