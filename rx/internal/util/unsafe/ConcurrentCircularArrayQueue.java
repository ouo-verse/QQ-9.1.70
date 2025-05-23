package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    protected static final int BUFFER_PAD = 32;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    protected static final int SPARSE_SHIFT;
    protected final E[] buffer;
    protected final long mask;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        SPARSE_SHIFT = intValue;
        int arrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = intValue + 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = r1.arrayBaseOffset(Object[].class) + (32 << (REF_ELEMENT_SHIFT - intValue));
    }

    public ConcurrentCircularArrayQueue(int i3) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i3);
        this.mask = roundToPowerOfTwo - 1;
        this.buffer = (E[]) new Object[(roundToPowerOfTwo << SPARSE_SHIFT) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long calcElementOffset(long j3) {
        return calcElementOffset(j3, this.mask);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lpElement(long j3) {
        return lpElement(this.buffer, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lvElement(long j3) {
        return lvElement(this.buffer, j3);
    }

    protected final void soElement(long j3, E e16) {
        soElement(this.buffer, j3, e16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void spElement(long j3, E e16) {
        spElement(this.buffer, j3, e16);
    }

    protected final long calcElementOffset(long j3, long j16) {
        return REF_ARRAY_BASE + ((j3 & j16) << REF_ELEMENT_SHIFT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lpElement(E[] eArr, long j3) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lvElement(E[] eArr, long j3) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soElement(E[] eArr, long j3, E e16) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j3, e16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void spElement(E[] eArr, long j3, E e16) {
        UnsafeAccess.UNSAFE.putObject(eArr, j3, e16);
    }
}
