# 61. Rotate List
# Medium
# Given the head of a linked list, rotate the list to the right by k places.

# Example 1:

# Input: head = [1,2,3,4,5], k = 2
# Output: [4,5,1,2,3]


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(head, k):
        last, prev = head, head
        if head is None or head.next is None:
            return head
        for i in range(k):
            prev = None
            while last.next:
                prev = last
                last = last.next
            prev.next = None
            last.next = head
            head = last
        return head
    
    h = ListNode(-1)
    hh = h
    for i in range(1,4):
        h.next = ListNode(i)
        h = h.next
    # print(h.val)
    v = rotateRight(hh.next, 2000000000)
    while v:
        print(v.val)
        v = v.next