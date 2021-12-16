from linked_list import LinkedList
from node import Node

"""
You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1st digit is at the head.
Write a function that adds the two numbers and returns the sum as a linked list.

FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
"""

def sum_lists_using_heads(node_longest_list, node_shortest_list, value_carried):
    while node_longest_list:
        value_1 = node_longest_list.data
        value_2 = node_shortest_list.data if node_shortest_list else 0
        result = value_1 + value_2 + value_carried
        value_carried = 0

        if result > 9:
            value_carried = int(str(result)[0])
            result = int(str(result)[1])

        node_longest_list.data = result
        node_longest_list = node_longest_list.next
        node_shortest_list = node_shortest_list.next if node_shortest_list else None


# time complexity: O(n), space complexity: O(1)
def sum_lists(list_1, list_2):
    node_longest_list = list_1.head if list_1.count > list_2.count else list_2.head
    node_shortest_list = list_2.head if list_2.count < list_1.count else list_1.head
    value_carried = 0

    sum_lists_using_heads(node_longest_list, node_shortest_list, value_carried)

    if value_carried:
        new_node = Node(value_carried)
        node_longest_list.next = new_node

    return list_1 if list_1.count > list_2.count else list_2


def sum_lists_forward_using_heads(longest_list, node_longest_list, node_shortest_list, value_carried):
    prev_node_longest_list = None
    while node_longest_list:
        value_1 = node_longest_list.data
        value_2 = node_shortest_list.data if node_shortest_list else 0
        result = value_1 + value_2

        if result > 9:
            value_carried = int(str(result)[0])
            result = int(str(result)[1])
            if prev_node_longest_list:
                prev_node_longest_list.data += value_carried
            else:
                longest_list.add(value_carried)

        node_longest_list.data = result
        prev_node_longest_list = node_longest_list
        node_longest_list = node_longest_list.next
        node_shortest_list = node_shortest_list.next if node_shortest_list else None


# time complexity: O(n), space complexity: O(1)
def sum_lists_forward(list_1, list_2):
    longest_list = list_1 if list_1.count > list_2.count else list_2
    shortest_list = list_2 if list_2.count < list_1.count else list_1
    value_carried = 0
    num_paddings = abs(list_1.count - list_2.count)

    for i in range(num_paddings):
        shortest_list.add(0)

    sum_lists_forward_using_heads(longest_list, longest_list.head, shortest_list.head, value_carried)
    return longest_list


list = LinkedList(6)
list.add(1)
list.add(7)

list_2 = LinkedList(2)
list_2.add(9)
list_2.add(5)

result_list = sum_lists(list, list_2)
result_list.print_data()


list_forward = LinkedList(7)
list_forward.add(1)
list_forward.add(6)

list_forward_2 = LinkedList(5)
list_forward_2.add(9)
list_forward_2.add(2)

result_list = sum_lists_forward(list_forward, list_forward_2)
result_list.print_data()
