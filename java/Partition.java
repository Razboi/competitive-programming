// Write code to partition a linked list around a value X, such that all nodes less than X
// come before all nodes greater than or equal to X

class Partition {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>(1);
        list.add(7);
        list.add(4);
        list.add(9);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(6);
        partition(list, 5);
        list.printData();
    }

    // time complexity: O(n), space complexity: O(1)
    private static MyLinkedList partition(MyLinkedList list, Integer value) {
        MyNode<Integer> currentNode = list.head.next;
        MyNode<Integer> prevNode = list.head;
        while (currentNode != null) {
            if (currentNode.data < value) {
                list.add(currentNode.data);
                prevNode.next = currentNode.next;
            } else {
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return list;
    }
}
