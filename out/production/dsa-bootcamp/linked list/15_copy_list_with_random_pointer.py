# 138. Copy List with Random Pointer
# Medium
# A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
# Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its
# corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in
# the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
# For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
# Return the head of the copied linked list.
# The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
# val: an integer representing Node.val
# random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
# Your code will only be given the head of the original linked list.


# Example 1:
# Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
# Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]


# Definition for a Node.
class Node:
    def __init__(self, x: int, next: "Node" = None, random: "Node" = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList2(self, head):
        # I. Hashmap Solution | TC: 2 pass O(n) and SC: O(n)
        if head is None:
            return None
        mapping = {}
        cur = head
        while cur:
            mapping[cur] = Node(cur.val, None, None)
            cur = cur.next
        cur = head
        while cur:
            if cur.next:
                mapping[cur].next = mapping[cur.next]
            if cur.random:
                mapping[cur].random = mapping[cur.random]
            cur = cur.next
        return mapping[head]

    def copyRandomList(self, head):
        # II. Deepcopy Bridge Solution | Constant Space

        cur = head
        if not head:
            return

        # creating deepcopy bridged between nodes
        while cur:
            nxt = cur.next
            cur.next = Node(cur.val)
            cur.next.next = nxt
            cur = nxt
        cur = head

        # copying random for deepcopy
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next

        second = cur = head.next
        # destroying bridge links
        while cur.next:
            head.next = cur.next
            head = head.next
            cur.next = head.next
            cur = cur.next
        head.next = None
        return second
