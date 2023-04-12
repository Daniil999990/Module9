public class MyStack<A> {
    private A[] head;
    private int size;
    public MyStack(int capacity) {
        head = (A[]) new Object[capacity];
        size = -1;
    }

    public void push(A value) {
        if (size == head.length - 1) {
            throw new IllegalStateException("Stack overflow");
        }
        size++;
        head[size] = value;
    }

    public A pop() {
        if (isEmpty()) {
            throw new NullPointerException("Stack underflow");
        }
        A poppedElement = head[size];
        head[size] = null;
        size--;
        return poppedElement;
    }

    public A peek() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }
        return head[size];
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public int size() {
        return size + 1;
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }
}
