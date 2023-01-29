# 25. Reverse Nodes in k-Group
# Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
# k is a positive integer and is less than or equal to the length of the linked list. 
# If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
# You may not alter the values in the list's nodes, only nodes themselves may be changed.


# Example 1:

# Input: head = [1,2,3,4,5], k = 2
# Output: [2,1,4,3,5]



# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(head, k):
        if head is None or k==1:
            return head
        
        dummy=ListNode(0)
        dummy.next=head
        pre,cur,nex=dummy,dummy,dummy
        
        count=0
        while cur.next:
            count+=1
            cur=cur.next
            
        while count>=k:
            cur=pre.next            # cur will be at start of sub k-group
            nex=cur.next            # nex will move
            for i in range(1,k):
                cur.next=nex.next   # storing next element in cur.next to use later
                nex.next=pre.next   # link reversal part which runs k-1 times
                pre.next=nex        # moving pre head forward
                nex=cur.next        # movin nex forward by using cur.next stored before
            count-=k
            pre=cur
        # return dummy.next'

# TC: O(n) | SC: O(1) 
