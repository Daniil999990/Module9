class MyQueue<T> {
    private T[] data;
    private int head;
    private int tail;
    private int size;

    public MyQueue() {
        this.data = (T[]) new Object[10];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void add(T value) {
        if (size == data.length) {
            T[] newData = (T[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(head + i) % data.length];
            }
            data = newData;
            head = 0;
            tail = size;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void clear() {
        data = (T[]) new Object[10];
        head = 0;
        tail = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T value = data[head];
        head = (head + 1) % data.length;
        size--;
        return value;
    }
}
