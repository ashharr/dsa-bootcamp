# Flattening a Linked List
# Medium
# Stand out from the crowd. Prepare with Complete Interview Preparation  
# Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
# (i) a next pointer to the next node,
# (ii) a bottom pointer to a linked list where this node is head.
# Each of the sub-linked-list is in sorted order.
# Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

# Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
# For more clarity have a look at the printList() function in the driver code.

# Example 1:

# Input:
# 5 -> 10 -> 19 -> 28
# |     |     |     | 
# 7     20    22   35
# |           |     | 
# 8          50    40
# |                 | 
# 30               45
# Output:  5-> 7-> 8- > 10 -> 19-> 20->
# 22-> 28-> 30-> 35-> 40-> 45-> 50.
# Explanation:
# The resultant linked lists has every 
# node in a single level.
# (Note: | represents the bottom pointer.)


#User function Template for python3


'''

class Node:
    def __init__(self, d):
        self.data=d
        self.next=None
        self.bottom=None
        
'''
def mergeTwoLists(a, b):
    res = Node(0)
    temp = res
    while a and b:
        if a.data < b.data:
            temp.bottom = a
            temp = temp.bottom
            a = a.bottom
        else:
            temp.bottom = b
            temp = temp.bottom
            b = b.bottom
            
    if a: temp.bottom = a
    else: temp.bottom = b
    
    return res.bottom

def flatten(root):
    #Your code here
    # arr = []
    # tempR = root
    # while root:
    #     arr.append(root.data)
    #     while tempR and tempR.bottom:
    #         tempR = tempR.bottom
    #         arr.append(tempR.data)
    #     root= root.next
    #     tempR = root
    
    # arr.sort()
    # dummy = Node(0)
    # res = dummy
    # for i in range(len(arr)):
    #     # dummy.next = Node(arr[i])
    #     # dummy = dummy.next
    #     print(arr[i], end=" ")
    
    # recur for list on right 
    if root == None or root.next == None:
        return root
        
    # now merge
    root.next = flatten(root.next)
    
    # return the root 
    # it will be in turn merged with its left 
    root = mergeTwoLists(root, root.next)
    
    return root



#{ 
 # Driver Code Starts
#Initial Template for Python 3

class Node:
    def __init__(self, d):
        self.data=d
        self.next=None
        self.bottom=None
        
        

def printList(node):
    while(node is not None):
        print(node.data,end=" ")
        node=node.bottom
        
    print()


if __name__=="__main__":
    t=int(input())
    while(t>0):
        head=None
        N=int(input())
        arr=[]
        
        arr=[int(x) for x in input().strip().split()]
        temp=None
        tempB=None
        pre=None
        preB=None
        
        flag=1
        flag1=1
        listo=[int(x) for x in input().strip().split()]
        it=0
        for i in range(N):
            m=arr[i]
            m-=1
            a1=listo[it]
            it+=1
            temp=Node(a1)
            if flag == 1:
                head=temp
                pre=temp
                flag=0
                flag1=1
            else:
                pre.next=temp
                pre=temp
                flag1=1
                
            for j in range(m):
                a=listo[it]
                it+=1
                tempB=Node(a)
                if flag1 == 1:
                    temp.bottom=tempB
                    preB=tempB
                    flag1=0
                else:
                    preB.bottom=tempB
                    preB=tempB
        root=flatten(head)
        printList(root)
        
        t-=1
            
# } Driver Code Ends