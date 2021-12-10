import java.util.Hashtable;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
class RemoveDups {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(22);
        list.add(1);
        list.add(17);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(2);
        removeDuplicatesConstantMemory(list);
        list.printData();
    }

    // time complexity: O(n), space complexity: O(n)
    private static void removeDuplicates(MyLinkedList<Integer> list) {
        if (list.head.next == null) {
            return;
        }
        Hashtable<Integer, Boolean> valueToExistenceTable = new Hashtable<Integer, Boolean>();
        MyNode<Integer> prevNode = null;
        MyNode<Integer> currentNode = list.head;
        while (currentNode != null) {
            if (valueToExistenceTable.containsKey(currentNode.data)) {
                prevNode.next = currentNode.next;
            } else {
                valueToExistenceTable.put(currentNode.data, true);
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    // time complexity: O(n²), space complexity: O(1)
    private static void removeDuplicatesConstantMemory(MyLinkedList<Integer> list) {
        if (list.head.next == null) {
            return;
        }
        MyNode<Integer> currentNode = list.head;
        MyNode<Integer> searchNode;
        MyNode<Integer> prevSearchNode;

        while (currentNode.next != null) {
            searchNode = currentNode.next;
            prevSearchNode = currentNode;
            while (searchNode != null) {

                if (searchNode.data == currentNode.data) {
                    prevSearchNode.next = searchNode.next;
                } else {
                    prevSearchNode = searchNode;
                }
                searchNode = searchNode.next;
            }
            currentNode = currentNode.next;
        }
    }
}

