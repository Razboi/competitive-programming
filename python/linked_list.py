from node import Node

class LinkedList:
    def __init__(self, data):
        node = Node(data)
        self.head = node
        self.count = 1

    def add(self, data):
        node = Node(data)
        self.add_node(node)

    def add_node(self, node):
        node.next = self.head
        self.head = node
        self.count += 1

    def print_data(self):
        current_node = self.head
        while current_node != None:
            print(current_node.data)
            current_node = current_node.next

