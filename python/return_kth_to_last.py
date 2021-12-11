from linked_list import LinkedList

# Implement an algorithm to find the kth to last element of a singly linked list

# time complexity: O(n), space complexity: O(1)
def return_kth_to_last(list, k):
    node_index = list.count - k - 1
    current_node = list.head
    current_index = 0
    while current_node.next and current_index != node_index:
        current_node = current_node.next
        current_index += 1
    return current_node


# time complexity: O(n), space complexity: O(1)
def return_kth_to_last_without_count(list, k):
    current_node = list.head
    runner = list.head
    for i in range(k):
        runner = runner.next
    while runner.next != None:
        current_node = current_node.next
        runner = runner.next
    return current_node



list = LinkedList(1)
list.add(2)
list.add(3)
list.add(4)
list.add(5)
list.add(6)
list.add(7)

print(return_kth_to_last(list, 3).data)
print(return_kth_to_last_without_count(list, 3).data)
