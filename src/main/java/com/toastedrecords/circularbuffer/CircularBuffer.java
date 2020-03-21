package com.toastedrecords.circularbuffer;

public class CircularBuffer<T> {
    private T[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int bufferSize) {
        this.buffer = (T[]) new Object[bufferSize];
    }

    public boolean offer(T value) {
        if (buffer[writeCursor] != null) {
            return false;
        }
        buffer[writeCursor] = value;
        writeCursor = nextCursor(writeCursor);
        return true;
    }

    public T poll() {
        T retVal = buffer[readCursor];
        if (retVal != null) {
            buffer[readCursor] = null;
            readCursor = nextCursor(readCursor);
        }
        return retVal;
    }

    private int nextCursor(int currentCursor) {
        return (currentCursor + 1) % buffer.length;
    }
}
