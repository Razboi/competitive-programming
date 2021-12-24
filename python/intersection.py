from linked_list import LinkedList

"""
Given two (singly) linked lists, determine if the two lists intersect.
Return the intersecting node. The intersection is defined by reference.
"""

def get_last_node(list):
    current_node = list_1.head
    while current_node.next != None:
        current_node = current_node.next
    return current_node

def is_last_node_equal(list_1, list_2):
    last_node_1 = get_last_node(list_1)
    last_node_2 = get_last_node(list_2)
    return last_node_1 is last_node_2

# time complexity: O(A + B) being A and B the length of the lists, space complexity: O(1)
def get_intersected_node(list_1, list_2):
    if not is_last_node_equal(list_1, list_2):
        return None

    current_node_longest = list_1.head if list_1.count > list_2.count else list_2.head
    current_node_shortest = list_2.head if list_2.count < list_1.count else list_1.head
    count_difference = abs(list_1.count - list_2.count)

    for i in range(0, count_difference):
        current_node_longest = current_node_longest.next

    while current_node_longest != None and current_node_shortest != None:
        if current_node_longest is current_node_shortest:
            return current_node_longest
        current_node_longest = current_node_longest.next
        current_node_shortest = current_node_shortest.next


list_1 = LinkedList(1)
list_1.add(2)
list_1.add(5)
intersected_node = list_1.head
list_1.add(6)
list_1.add(7)
list_1.add(8)

list_2 = LinkedList(3)
list_2.add(4)
list_2.add_node(intersected_node)

print(get_intersected_node(list_1, list_2).data)
