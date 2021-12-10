class MyLinkedList<T> {
	MyNode<T> head;
	private int length = 0;

	public static void main(String args[]) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(22);
		list.add(17);
		list.add(3);
		System.out.println(list.head.data);
		System.out.println(list.head.next.data);
		System.out.println(list.head.next.next.data);
	}

	public void add(T data) {
		MyNode<T> node = new MyNode<T>(data);
		node.next = head;
		this.head = node;
		this.length += 1;
	}

	public void printData() {
		MyNode<T> currentNode = this.head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
}
