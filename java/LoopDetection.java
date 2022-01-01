
/*
Given a linked list which might contain a loop, implement an
algorithm that returns the node at the begining of the loop (if exists)
*/

// time complexity: O(n), space complexity: O(1)
class LoopDetection {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>(1);
        MyNode loopEnd = list.head;
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        loopEnd.next = list.head;
        list.add(9);
        list.add(10);
        list.add(11);
        System.out.println(detectLoop(list).data);
    }

    private static MyNode detectLoop(MyLinkedList list) {
        if (list.head == null) {
            return null;
        }
        MyNode fastNode = list.head;
        MyNode slowNode = list.head;
        while (true) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            if (slowNode == fastNode) {
                break;
            }
        }
        slowNode = list.head;
        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastNode;
    }
}
