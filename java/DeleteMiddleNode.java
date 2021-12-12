// Implement an algorith to delete a node in the middle of a singly linked list
// given only access to that node

class DeleteMiddleNode {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        MyNode node = list.head.next.next.next;
        deleteMiddleNode(node);
        list.printData();
    }

    // time complexity: O(1), space complexity: O(1)
    private static boolean deleteMiddleNode(MyNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }
}

