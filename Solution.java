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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        int carryOver = 0;
        while (l1 != null && l2 != null) {
            l1.val = l1.val + l2.val + carryOver;
            l2.val = l1.val;
            if (l1.val >= 10) {
                l1.val = l1.val - 10;
                l2.val = l2.val - 10;
                carryOver = 1;
            }
            else {
                carryOver = 0;
            }
            if (l2.next == null && l1.next == null) {
                if (carryOver == 1) {
                    l1.next = new ListNode();
                    l1 = l1.next;
                    l1.val = carryOver;
                    return l1Head;
                }
                else {
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            while (l1 != null) {
                l1.val = l1.val + carryOver;
                if (l1.val >= 10) {
                    l1.val = l1.val - 10;
                    carryOver = 1;
                }
                else {
                    carryOver = 0;
                }
                if (l1.next == null) {
                    if (carryOver == 1) {
                        l1.next = new ListNode();
                        l1 = l1.next;
                        l1.val = carryOver;
                        return l1Head;
                    }
                    else {
                        l1 = l1.next;
                    }
                }
                else {
                    l1 = l1.next;
                }
            }
            return l1Head;
        }
        if (l2 != null) {
            while (l2 != null) {
                l2.val = l2.val + carryOver;
                if (l2.val >= 10) {
                    l2.val = l2.val - 10;
                    carryOver = 1;
                }
                else {
                    carryOver = 0;
                }
                if (l2.next == null) {
                    if (carryOver == 1) {
                        l2.next = new ListNode();
                        l2 = l2.next;
                        l2.val = carryOver;
                        return l2Head;
                    }
                    else {
                        l2 = l2.next;
                    }
                }
                else {
                    l2 = l2.next;
                }
            }
            return l2Head;
        }
        return l1Head;
    }
}
