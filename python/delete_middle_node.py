from linked_list import LinkedList

# time complexity: O(1), space complexity: O(1)
def delete_middle_node(node):
    if node == None or node.next == None:
        return False
    next_node = node.next
    node.data = next_node.data
    node.next = next_node.next
    return True


list = LinkedList(1)
list.add(2)
list.add(3)
list.add(4)
list.add(5)
list.add(6)
list.add(7)
list.add(8)
list.add(9)

node = list.head.next.next.next
delete_middle_node(node)
list.print_data()
