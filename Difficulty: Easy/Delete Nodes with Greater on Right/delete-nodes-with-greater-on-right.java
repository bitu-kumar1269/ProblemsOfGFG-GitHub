/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node reverseList(Node head){
        Node prev = null;
        Node curr = head;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return prev;
    }
    Node compute(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        head = reverseList(head);
        
        Node curr = head;
        int max = curr.data;
        
        while(curr != null && curr.next != null){
            if(curr.next.data < max){
                curr.next = curr.next.next;
            }else{
                max = curr.next.data;
                curr = curr.next;
            }
            
        }
        head = reverseList(head);
        return head;
        
    }
}