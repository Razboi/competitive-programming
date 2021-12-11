// Implement an algorithm to find the kth to last element of a singly linked list


class ReturnKthToLast {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(returnKthToLast(list, 3).data);
        System.out.println(returnKthToLastWithoutCount(list, 3).data);
    }

    // time complexity: O(n), space complexity: O(1)
    private static MyNode returnKthToLast(MyLinkedList list, Integer k) {
        int nodeIndex = list.length - k - 1;
        int currentIndex = 0;
        MyNode currentNode = list.head;
        while (currentNode.next != null && currentIndex != nodeIndex) {
            currentNode = currentNode.next;
            currentIndex += 1;
        }
        return currentNode;
    }

    // time complexity: O(n), space complexity: O(1)
    private static MyNode returnKthToLastWithoutCount(MyLinkedList list, Integer k) {
        MyNode currentNode = list.head;
        MyNode runner = list.head;
        for (int i = 0; i < k; i++) {
            runner = runner.next;
        }
        while (runner.next != null) {
            currentNode = currentNode.next;
            runner = runner.next;
        }
        return currentNode;
    }
}
