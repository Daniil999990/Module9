public class MyLinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value, null, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.prev = tail;
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> nodeToRemove = head;
        for (int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.next;
        }
        E value = nodeToRemove.value;
        Node<E> prevNode = nodeToRemove.prev;
        Node<E> nextNode = nodeToRemove.next;
        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        nodeToRemove.value = null;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        size--;
        return value;
    }

    public void clear() {
        Node<E> node = head;
        while (node != null) {
            Node<E> nextNode = node.next;
            node.value = null;
            node.next = null;
            node.prev = null;
            node = nextNode;
        }
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }
}
