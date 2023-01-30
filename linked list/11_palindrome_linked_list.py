# 234. Palindrome Linked List
# Easy

# Given the head of a singly linked list, return true if it is a
# palindrome
#  or false otherwise.

# Example 1:
# Input: head = [1,2,2,1]
# Output: true

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(head) -> bool:
        # I. Naive Approach | Stack method O(n) Space and time
        # l, counter = head, head
        # count = 0
        # stack = []
        # while counter:
        #     counter = counter.next
        #     count += 1
        # i = 0
        # while i != count//2:
        #     stack.append(l.val)
        #     l = l.next
        #     i += 1
        # if count % 2 == 1:
        #     l = l.next
        # while l:
        #     if l.val != stack.pop():
        #         return False
        #     l = l.next
        # return True

        # II. Hare and Tortoise Approach | Constant Space | Optimal Solution
        fast, slow, prev = head, head, head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
        prev, prev.next, slow = slow, None, slow.next
        while slow:
            slow.next, prev, slow = prev, slow, slow.next
        fast, slow = head, prev
        while slow:
            if fast.val != slow.val:
                return False
            fast, slow = fast.next, slow.next
        return True
