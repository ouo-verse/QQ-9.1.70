package rx.schedulers;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TimeInterval<T> {
    private final long intervalInMilliseconds;
    private final T value;

    public TimeInterval(long j3, T t16) {
        this.value = t16;
        this.intervalInMilliseconds = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeInterval timeInterval = (TimeInterval) obj;
        if (this.intervalInMilliseconds != timeInterval.intervalInMilliseconds) {
            return false;
        }
        T t16 = this.value;
        if (t16 == null) {
            if (timeInterval.value != null) {
                return false;
            }
        } else if (!t16.equals(timeInterval.value)) {
            return false;
        }
        return true;
    }

    public long getIntervalInMilliseconds() {
        return this.intervalInMilliseconds;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        long j3 = this.intervalInMilliseconds;
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
        return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + this.value + "]";
    }
}
