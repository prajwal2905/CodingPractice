package com.company;


/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode listMerge(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        while (true) {
            if(l1 == null) {
                temp.next = l2;
                break;
            }
            if(l2 == null) {
                temp.next = l1;
                break;
            }
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return l3.next;
    }
}
