class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        
    def setNext( self, next):
        self.next = next

    def setData(self, data):
        self.data = data
    
    def getData(self):
        return self.data
    
    def getNext(self):
        return self.next
    
    def hasNext(self):
        return self.next != None
    
    def pushNode(self, head, data):
        new_node = Node(data)
        new_node.next = head
        head = new_node
        return head

    def printNode(self, head):
        while (head != None):
            print('%d->' % head.data, end="")
            head = head.next
        print("NULL")

head = None 
ll = LinkedList()
for i in range(10,0, -1):
    head = ll.pushNode(head, i)

ll.printNode(head)
