package rx.schedulers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Timestamped<T> {
    private final long timestampMillis;
    private final T value;

    public Timestamped(long j3, T t16) {
        this.value = t16;
        this.timestampMillis = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Timestamped)) {
            return false;
        }
        Timestamped timestamped = (Timestamped) obj;
        if (this.timestampMillis != timestamped.timestampMillis) {
            return false;
        }
        T t16 = this.value;
        T t17 = timestamped.value;
        if (t16 == t17) {
            return true;
        }
        if (t16 != null && t16.equals(t17)) {
            return true;
        }
        return false;
    }

    public long getTimestampMillis() {
        return this.timestampMillis;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        long j3 = this.timestampMillis;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) + 31) * 31;
        T t16 = this.value;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        return i3 + hashCode;
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.timestampMillis), this.value.toString());
    }
}
