package rx.internal.util;

import ADV_REPORT.mobile_adv_report_req;
import java.util.Arrays;
import rx.functions.Action1;
import rx.internal.util.unsafe.Pow2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    static int mix(int i3) {
        int i16 = i3 * INT_PHI;
        return i16 ^ (i16 >>> 16);
    }

    public boolean add(T t16) {
        T t17;
        T[] tArr = this.keys;
        int i3 = this.mask;
        int mix = mix(t16.hashCode()) & i3;
        T t18 = tArr[mix];
        if (t18 != null) {
            if (t18.equals(t16)) {
                return false;
            }
            do {
                mix = (mix + 1) & i3;
                t17 = tArr[mix];
                if (t17 == null) {
                }
            } while (!t17.equals(t16));
            return false;
        }
        tArr[mix] = t16;
        int i16 = this.size + 1;
        this.size = i16;
        if (i16 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public void clear(Action1<? super T> action1) {
        if (this.size == 0) {
            return;
        }
        T[] tArr = this.keys;
        for (mobile_adv_report_req mobile_adv_report_reqVar : tArr) {
            if (mobile_adv_report_reqVar != null) {
                action1.call(mobile_adv_report_reqVar);
            }
        }
        Arrays.fill(tArr, (Object) null);
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    void rehash() {
        T t16;
        T[] tArr = this.keys;
        int length = tArr.length;
        int i3 = length << 1;
        int i16 = i3 - 1;
        T[] tArr2 = (T[]) new Object[i3];
        int i17 = this.size;
        while (true) {
            int i18 = i17 - 1;
            if (i17 == 0) {
                this.mask = i16;
                this.maxSize = (int) (i3 * this.loadFactor);
                this.keys = tArr2;
                return;
            }
            do {
                length--;
                t16 = tArr[length];
            } while (t16 == null);
            int mix = mix(t16.hashCode()) & i16;
            if (tArr2[mix] == null) {
                tArr2[mix] = tArr[length];
                i17 = i18;
            }
            do {
                mix = (mix + 1) & i16;
            } while (tArr2[mix] != null);
            tArr2[mix] = tArr[length];
            i17 = i18;
        }
    }

    public boolean remove(T t16) {
        T t17;
        T[] tArr = this.keys;
        int i3 = this.mask;
        int mix = mix(t16.hashCode()) & i3;
        T t18 = tArr[mix];
        if (t18 == null) {
            return false;
        }
        if (t18.equals(t16)) {
            return removeEntry(mix, tArr, i3);
        }
        do {
            mix = (mix + 1) & i3;
            t17 = tArr[mix];
            if (t17 == null) {
                return false;
            }
        } while (!t17.equals(t16));
        return removeEntry(mix, tArr, i3);
    }

    boolean removeEntry(int i3, T[] tArr, int i16) {
        int i17;
        T t16;
        this.size--;
        while (true) {
            int i18 = i3 + 1;
            while (true) {
                i17 = i18 & i16;
                t16 = tArr[i17];
                if (t16 == null) {
                    tArr[i3] = null;
                    return true;
                }
                int mix = mix(t16.hashCode()) & i16;
                if (i3 <= i17) {
                    if (i3 < mix && mix <= i17) {
                        i18 = i17 + 1;
                    }
                } else {
                    if (i3 >= mix && mix > i17) {
                        break;
                    }
                    i18 = i17 + 1;
                }
            }
            tArr[i3] = t16;
            i3 = i17;
        }
    }

    public void terminate() {
        this.size = 0;
        this.keys = (T[]) new Object[0];
    }

    public T[] values() {
        return this.keys;
    }

    public OpenHashSet(int i3) {
        this(i3, 0.75f);
    }

    public OpenHashSet(int i3, float f16) {
        this.loadFactor = f16;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i3);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f16 * roundToPowerOfTwo);
        this.keys = (T[]) new Object[roundToPowerOfTwo];
    }
}
