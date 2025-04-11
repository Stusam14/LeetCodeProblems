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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        
        for(ListNode node: lists){
            ListNode newNode = node; 
            while(newNode != null){
                pq.add(newNode.val);
                newNode = newNode.next;
            }
        }

        if(pq.isEmpty()){
            return null;
        }
        ListNode res = new ListNode(pq.poll()); 
        ListNode temp = res;
        while(!pq.isEmpty()){

            temp.next = new ListNode(pq.poll());
            temp = temp.next;
            
        }

        return res;
        

    }
}