// 141. Linked List Cycle
// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: true

/**
 * LinkedListCycle
 */
public class LinkedListCycle {

  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode hasCycle(ListNode head) {
         ListNode slow=head, fast=head;

         while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)){
                break;
            }
        }

        if( fast != null || fast.next != null){
            return new ListNode(0);
        }

        fast = head;

        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        
    }
}