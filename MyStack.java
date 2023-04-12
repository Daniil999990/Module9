public class MyStack<B> {
    private Node top;
    private int size;

    private class Node<A> {
        Object data;
        Node next;

        public Node(A data) {
            this.data = data;
        }
    }

    public void push(B value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object pop() {
        if (top == null) {
            return null;
        }
        Object value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public Object peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            top = top.next;
            size--;
            return;
        }
        Node prev = top;
        Node current = top.next;
        for (int i = 1; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        size--;
    }
}
