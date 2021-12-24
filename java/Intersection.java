import java.lang.Math;

class Intersection {
    public static void main(String args[]) {
        MyLinkedList<Integer> list1 = new MyLinkedList(1);
        list1.add(2);
        list1.add(5);
        MyNode intersectedNode = list1.head;
        list1.add(6);
        list1.add(7);
        list1.add(8);

        MyLinkedList<Integer> list2 = new MyLinkedList(3);
        list2.add(4);
        list2.add(intersectedNode);

        System.out.println(getIntersectedNode(list1, list2).data);
    }

    private static MyNode getLastNode(MyLinkedList list) {
        MyNode currentNode = list.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private static boolean checkLastNodeIsEqual(MyLinkedList list1, MyLinkedList list2) {
        MyNode list1LastNode = getLastNode(list1);
        MyNode list2LastNode = getLastNode(list2);
        return list1LastNode == list2LastNode;
    }

    // time complexity: O(A + B) being A and B the length of the lists, space complexity: O(1)
    private static MyNode getIntersectedNode(MyLinkedList list1, MyLinkedList list2) {
        if (!checkLastNodeIsEqual(list1, list2)) {
            return null;
        }
        MyNode currentNodeLongest = list1.length > list2.length ? list1.head : list2.head;
        MyNode currentNodeShortest = list2.length < list1.length ? list2.head : list1.head;
        int lengthDifference = Math.abs(list1.length - list2.length);

        for (int i = 0; i < lengthDifference; i++) {
            currentNodeLongest = currentNodeLongest.next;
        }
        while (currentNodeLongest != null && currentNodeShortest != null) {
            if (currentNodeLongest == currentNodeShortest) {
                return currentNodeLongest;
            }
            currentNodeLongest = currentNodeLongest.next;
            currentNodeShortest = currentNodeShortest.next;
        }
        return null;
    }
}

