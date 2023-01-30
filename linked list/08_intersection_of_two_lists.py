# 160. Intersection of Two Linked Lists - Easy
# Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
# For example, the following two linked lists begin to intersect at node c1:
# The test cases are generated such that there are no cycles anywhere in the entire linked structure.
# Note that the linked lists must retain their original structure after the function returns.

# Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
# Output: Intersected at '8'



# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # I. Floyd Warshall Method
    def getIntersectionNode(headA, headB):
        # floyd warshall method
        # creating loop by concatenating the lists
        last = headA
        while last.next: last = last.next
        last.next = headB

        slow, fast = headA, headA

        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast:
                fast = headA
                while slow != fast:
                    slow, fast = slow.next, fast.next
                last.next = None
                return slow
        # No Intersections
        last.next = None
        return None


        
        

# II. Two pointer method
    def getIntersectionNode(self, headA, headB):
            if headA is None or headB is None:
                return None

            pa = headA # 2 pointers
            pb = headB

            while pa is not pb:
                # if either pointer hits the end, switch head and continue the second traversal, 
                # if not hit the end, just move on to next
                pa = headB if pa is None else pa.next
                pb = headA if pb is None else pb.next

            return pa # only 2 ways to get out of the loop, they meet or the both hit the end=None

    # the idea is if you switch head, the possible difference between length would be countered. 
    # On the second traversal, they either hit or miss. 
    # if they meet, pa or pb would be the node we are looking for, 
    # if they didn't meet, they will hit the end at the same iteration, pa == pb == None, return either one of them is the same,None

