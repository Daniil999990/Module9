class MyArrayList<A, T> {
    private Object[] array;
    private int size;
    public MyArrayList() {
        this.array = new Object[10];
        this.size = 0;
    }
    public void add(A value) {
        if (this.size == this.array.length) {
            Object[] newArray = new Object[this.array.length * 2];
            for (int i = 0; i < this.array.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[this.size] = value;
        this.size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.size--;
    }
    public void clear() {
        this.array = new Object[10];
        this.size = 0;
    }
    public int size() {
        return this.size;
    }
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.array[index];
    }
}