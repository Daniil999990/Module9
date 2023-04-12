class MyQueue<A> {
    private Node front;
    private Node rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(A value) {
        Node newNode = new Node(value);
        if (size == 0) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return front.value;
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object value = front.value;
        front = front.next;
        size--;
        if (size == 0) {
            rear = null;
        }
        return value;
    }

    private static class Node<E> {
        Object value;
        Node next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }
}
