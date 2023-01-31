# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    # def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
    #     h1, h2 = head, head
    #     count = 1
    #     if head.next is None:
    #         return head.next
    #     while head.next:
    #         count += 1
    #         head = head.next
    #     i, pos = 0, count - n
    #     prev = head
    #     if pos == 0:
    #         return h1.next
    #     while i != pos-1:
    #         h1 = h1.next
    #         i += 1
    #     h1.next = h1.next.next
    #     return h2

    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        slow, fast = head, head
        if head.next is None:
            return head.next

        for i in range(n):
            fast = fast.next

        if not fast:
            return head.next

        while fast.next:
            slow = slow.next
            fast = fast.next

        slow.next = slow.next.next

        return head
