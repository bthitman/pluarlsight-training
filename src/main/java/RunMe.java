import com.toastedrecords.circularbuffer.CircularBuffer;

public class RunMe {
    public static void main(String[] args) {
        CircularBuffer<String> buffer = new CircularBuffer<>(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");
    }
}
