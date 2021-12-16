import java.lang.Math;

class SumLists {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>(6);
        list.add(1);
        list.add(7);

        MyLinkedList<Integer> list2 = new MyLinkedList<Integer>(2);
        list2.add(9);
        list2.add(5);

        MyLinkedList<Integer> resultList = sumLists(list, list2);
        resultList.printData();

        MyLinkedList<Integer> listForward = new MyLinkedList<Integer>(7);
        listForward.add(1);
        listForward.add(6);

        MyLinkedList<Integer> listForward2 = new MyLinkedList<Integer>(5);
        listForward2.add(9);
        listForward2.add(2);

        MyLinkedList<Integer> resultListForward = sumListsForward(listForward, listForward2);
        resultListForward.printData();
    }

    private static void sumListsUsingHeads(
            MyNode<Integer> nodeLongestList,
            MyNode<Integer> nodeShortestList,
            int valueCarried)
    {
        while (nodeLongestList != null) {
            int value1 = nodeLongestList.data;
            int value2 = nodeShortestList != null ? nodeShortestList.data : 0;
            int result = value1 + value2 + valueCarried;
            valueCarried = 0;

            if (result > 9) {
                valueCarried = Integer.parseInt(Integer.toString(result).substring(0, 1));
                result = Integer.parseInt(Integer.toString(result).substring(1, 2));
            }
            nodeLongestList.data = result;
            nodeLongestList = nodeLongestList.next;
            nodeShortestList = nodeShortestList != null ? nodeShortestList.next : null;
        }
    }

    private static MyLinkedList sumLists(MyLinkedList list1, MyLinkedList list2) {
        MyNode<Integer> nodeLongestList = list1.length > list2.length ? list1.head : list2.head;
        MyNode<Integer> nodeShortestList = list2.length < list1.length ? list2.head : list1.head;
        int valueCarried = 0;

        sumListsUsingHeads(nodeLongestList, nodeShortestList, valueCarried);

        if (valueCarried > 0) {
            MyNode<Integer> newNode = new MyNode(valueCarried);
            nodeLongestList.next = newNode;
        }
        return list1.length > list2.length ? list1 : list2;
    }

    private static void sumListsForwardUsingHeads(
            MyLinkedList longestList,
            MyNode<Integer> nodeLongestList,
            MyNode<Integer> nodeShortestList,
            int valueCarried)
    {
        MyNode<Integer> prevNodeLongestList = null;
        while (nodeLongestList != null) {
            int value1 = nodeLongestList.data;
            int value2 = nodeShortestList != null ? nodeShortestList.data : 0;
            int result = value1 + value2;

            if (result > 9) {
                valueCarried = Integer.parseInt(Integer.toString(result).substring(0, 1));
                result = Integer.parseInt(Integer.toString(result).substring(1, 2));
                if (prevNodeLongestList != null) {
                    prevNodeLongestList.data += valueCarried;
                } else {
                    longestList.add(valueCarried);
                }
            }
            nodeLongestList.data = result;
            prevNodeLongestList = nodeLongestList;
            nodeLongestList = nodeLongestList.next;
            nodeShortestList = nodeShortestList != null ? nodeShortestList.next : null;
        }
    }

    private static MyLinkedList sumListsForward(MyLinkedList list1, MyLinkedList list2) {
        MyLinkedList longestList = list1.length > list2.length ? list1 : list2;
        MyLinkedList shortestList = list2.length < list1.length ? list2 : list1;
        int valueCarried = 0;
        int numPaddings = Math.abs(list1.length - list2.length);

        for (int i = 0; i < numPaddings; i++) {
            shortestList.add(0);
        }

        sumListsForwardUsingHeads(longestList, longestList.head, shortestList.head, valueCarried);
        return longestList;
    }
}

