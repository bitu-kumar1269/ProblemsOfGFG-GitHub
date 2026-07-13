/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    int getlength(Node head){
        Node temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size/2;
    }
    int getMiddle(Node head) {
        // code here
        Node slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //second method
        Node temp = head;
        int len = getlength(head);
        for(int i=1; i<len; i++){
            temp = temp.next;
        }
        return temp.
        return slow.data;
    }
}