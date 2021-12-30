from linked_list import LinkedList

"""
Given a linked list which might contain a loop, implement an
algorithm that returns the node at the begining of the loop (if exists)
"""

# time complexity: O(n), space complexity: O(1)
def get_loop_head(list):
    if list.head == None:
        return None

    fast_node = list.head
    slow_node = list.head
    while True:
        fast_node = fast_node.next.next
        slow_node = slow_node.next
        if fast_node == None or fast_node.next == None:
            return None
        if fast_node is slow_node:
           break 

    slow_node = list.head
    while fast_node is not slow_node:
        fast_node = fast_node.next
        slow_node = slow_node.next

    return fast_node


list = LinkedList(1)
loop_end = list.head
list.add(2)
list.add(3)
list.add(4)
list.add(5)
list.add(6)
list.add(7)
list.add(8)
loop_end.next = list.head
list.add(9)
list.add(10)
list.add(11)

print(get_loop_head(list).data)
