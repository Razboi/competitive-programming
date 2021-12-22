from linked_list import LinkedList

def reverse_linked_list(list):
    current_node = list.head.next
    reversed_list = LinkedList(list.head.data)

    while current_node != None:
        reversed_list.add(current_node.data)
        current_node = current_node.next

    return reversed_list


# time complexity: O(n), space complexity: O(n)
def is_linked_list_palindrome(list):
    if list.head == None:
        return False

    reversed_list = reverse_linked_list(list)
    current_node = list.head
    current_node_reversed = reversed_list.head

    for i in range(0, list.count // 2):
        if current_node.data != current_node_reversed.data:
            return False
        current_node = current_node.next
        current_node_reversed = current_node_reversed.next

    return True

list = LinkedList('t')
list.add('e')
list.add('n')
list.add('e')
list.add('t')
print(is_linked_list_palindrome(list))
