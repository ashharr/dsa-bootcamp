# 876. Middle of the Linked List
# Given the head of a singly linked list, return the middle node of the linked list.
# If there are two middle nodes, return the second middle node.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        # I. Brute Approach | TC: O(n) SC: O(n) 
        # arr = []
        # temp = head
        # while temp != None:
        #     arr.append(temp.val)
        #     temp=temp.next

        # for i in range( len(arr) // 2):
        #     # res += ListNode(arr[i])
        #     head = head.next  
            
        # return head

        # II. Brute-Better Approach | TC: O(n) SC: O(1) 
        # count = 0
        # temp = head
        # while temp != None:
        #     count += 1
        #     temp=temp.next

        # for i in range( count // 2):
        #     # res += ListNode(arr[i])
        #     head = head.next  
            
        # return head

        # III. Optimal Approach | TC: O(n) SC: O(1) 
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        return slow