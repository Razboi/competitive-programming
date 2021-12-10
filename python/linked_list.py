from node import Node

class LinkedList:
    def __init__(self, data):
        node = Node(data)
        self.head = node
        self.count = 0

    def add(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node

    def print_data(self):
        current_node = self.head
        while current_node != None:
            print(current_node.data)
            current_node = current_node.next

