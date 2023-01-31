# 2. Add Two Numbers
# You are given two non-empty linked lists representing two non-negative integers. The digits
# are stored in reverse order, and each of their nodes contains a single digit.
# Add the two numbers and return the sum as a linked list.
# You may assume the two numbers do not contain any leading zero, except the number 0 itself.


# Example 1:

# Input: l1 = [2,4,3], l2 = [5,6,4]
# Output: [7,0,8]
# Explanation: 342 + 465 = 807

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(l1, l2):

        # I. Naive Solution: convert to integer then add and create LL
        # def reverseList(head):
        #     curr, prev = head, None
        #     while curr is not None:
        #         next = curr.next
        #         curr.next = prev
        #         prev = curr
        #         curr = next
        #     return prev
        # h1, h2 = l1, l2
        # num1, num2 = 0,0
        # n = 1
        # while h1 is not None:
        #     if n == 1:
        #         num1 += h1.val
        #     else:
        #         num1 += n * h1.val
        #     h1, n = h1.next, n*10
        # n = 1
        # while h2 is not None:
        #     if n == 1:
        #         num2 += h2.val
        #     else:
        #         num2 += n * h2.val
        #     h2, n = h2.next, n*10
        # resNum = num1 + num2
        # resNum = [int(i) for i in str(resNum)]
        # resList = ListNode(-1)
        # resHead = resList
        # for i in range(len(resNum)):
        #     resList.next = ListNode(resNum[i])
        #     resList = resList.next
        # pre = resHead
        # resHead = resHead.next
        # pre.next = None
        # ress = reverseList(resHead)
        # return ress

        # I. Optimal Solution: Add directly to new LL with sum and carry
        summ, carry = 0, 0
        dummy = ListNode(-1)
        temp = dummy
        while l1 or l2 or carry:
            summ = 0
            if l1:
                summ += l1.val
                l1 = l1.next
            if l2:
                summ += l2.val
                l2 = l2.next
            summ += carry
            carry = summ // 10
            temp.next = ListNode(summ % 10)
            temp = temp.next
        return dummy.next
