from linked_list import LinkedList

# time complexity: O(n), space complexity: O(n)
def remove_duplicates(linked_list):
    if linked_list.head.next == None:
        return

    value_to_existence_dic = {}
    current_node = linked_list.head.next
    prev_node = linked_list.head
    while current_node != None:
        if current_node.data in value_to_existence_dic:
            prev_node.next = current_node.next
        else:
            value_to_existence_dic[current_node.data] = True
            prev_node = current_node
        current_node = current_node.next


# time complexity: O(n²), space complexity: O(1)
def remove_duplicates_constant_space(linked_list):
    if linked_list.head.next == None:
        return

    current_node = linked_list.head.next
    while current_node.next != None:
        search_node = current_node.next
        prev_search_node = current_node

        while search_node != None:
            if current_node.data == search_node.data:
                prev_search_node.next = search_node.next
            else:
                prev_search_node = search_node
            search_node = search_node.next

        current_node = current_node.next


list = LinkedList(1)
list.add(77)
list.add(2)
list.add(2)
list.add(2)
list.add(7)
list.add(1)
list.add(4)
remove_duplicates_constant_space(list)
list.print_data()
