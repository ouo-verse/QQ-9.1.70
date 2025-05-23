package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> buffer;
    protected final int mask;

    public AtomicReferenceArrayQueue(int i3) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i3);
        this.mask = roundToPowerOfTwo - 1;
        this.buffer = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcElementOffset(long j3, int i3) {
        return ((int) j3) & i3;
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

    protected final E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i3) {
        return atomicReferenceArray.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i3) {
        return atomicReferenceArray.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soElement(AtomicReferenceArray<E> atomicReferenceArray, int i3, E e16) {
        atomicReferenceArray.lazySet(i3, e16);
    }

    protected final void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i3, E e16) {
        atomicReferenceArray.lazySet(i3, e16);
    }

    protected final void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i3, E e16) {
        atomicReferenceArray.set(i3, e16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcElementOffset(long j3) {
        return ((int) j3) & this.mask;
    }

    protected final E lpElement(int i3) {
        return this.buffer.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lvElement(int i3) {
        return lvElement(this.buffer, i3);
    }

    protected final void soElement(int i3, E e16) {
        this.buffer.lazySet(i3, e16);
    }

    protected final void spElement(int i3, E e16) {
        this.buffer.lazySet(i3, e16);
    }
}
