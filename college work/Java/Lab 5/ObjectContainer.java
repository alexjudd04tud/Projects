public class ObjectContainer<T> {
    private T object;
    private static int readCount = 0;

    public ObjectContainer(T object) {
        this.object = object;
    }

    public T get() {
        readCount++;
        return object;
    }

    public static int getReadCount() {
        return readCount;
    }

    @Override
    public int hashCode() {
        return object != null ? object.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ObjectContainer<?> that = (ObjectContainer<?>) obj;
        return object != null ? object.equals(that.object) : that.object == null;
    }
}