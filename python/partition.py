from linked_list import LinkedList

# Write code to partition a linked list around a value X, such that all nodes less than X
# come before all nodes greater than or equal to X

# time complexity: O(n), space complexity: O(1)
def partition(list, value):
    current_node = list.head.next
    prev_node = list.head
    while current_node != None:
        if current_node.data < value:
            list.add(current_node.data)
            prev_node.next = current_node.next
        else:
            prev_node = current_node
        current_node = current_node.next
    return list



list = LinkedList(1)
list.add(9)
list.add(3)
list.add(2)
list.add(4)
list.add(6)
list.add(8)
list.add(5)
list.add(7)

partition(list, 5)
list.print_data()
