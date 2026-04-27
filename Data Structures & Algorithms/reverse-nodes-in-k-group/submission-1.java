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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null) return head;
        int count =1;
        ListNode temp=head;
        ListNode start = head;
        ListNode prevEnd =null;

        while(temp!=null){
            if(count==k){
                ListNode kthNode = temp;
                ListNode nextK = kthNode.next;
                kthNode.next=null;
                reverseLL(start);
                if(prevEnd==null){
                    head=kthNode;
                }
                else prevEnd.next = kthNode;
                start.next = nextK;

                prevEnd = start;
                start = start.next;
                count=1;
                temp = start;
            }
            else{
                temp = temp.next;
                count++;
            }
        }
        return head;
    }

    ListNode reverseLL(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode currNode = head;
        ListNode nextNode = currNode.next;
        ListNode newHead = reverseLL(nextNode);
        nextNode.next =currNode;
        currNode.next=null;
        return newHead;
    }
}
