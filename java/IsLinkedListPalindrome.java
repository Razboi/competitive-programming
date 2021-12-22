class IsLinkedListPalindrome {
    public static void main(String args[]) {
        MyLinkedList<Character> list = new MyLinkedList<Character>('t');
        list.add('e');
        list.add('n');
        list.add('e');
        list.add('t');
        System.out.println(isLinkedListPalindrome(list));
    }

    private static MyLinkedList reverseLinkedList(MyLinkedList<Character> list) {
        MyLinkedList<Character> reversedLinkedList = new MyLinkedList<Character>(list.head.data);
        MyNode<Character> currentNode = list.head.next;
        while (currentNode != null) {
            reversedLinkedList.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return reversedLinkedList;
    }

    // time complexity: O(n), space complexity: O(n)
    private static boolean isLinkedListPalindrome(MyLinkedList<Character> list) {
        if (list.head == null) {
            return false;
        }
        MyLinkedList<Character> reversedLinkedList = reverseLinkedList(list);
        MyNode<Character> currentNode = list.head;
        MyNode<Character> currentNodeReversed = reversedLinkedList.head;
        for (int i = 0; i < list.length / 2; i++) {
            if (currentNode.data != currentNodeReversed.data) {
                return false;
            }
            currentNode = currentNode.next;
            currentNodeReversed = currentNodeReversed.next;
        }
        return true;
    }
}
