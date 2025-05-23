package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final AtomicLong consumerIndex;
    final int mask;
    final AtomicLong producerIndex;

    public SpscExactAtomicArrayQueue(int i3) {
        super(Pow2.roundToPowerOfTwo(i3));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i3;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.producerIndex == this.consumerIndex) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t16) {
        t16.getClass();
        long j3 = this.producerIndex.get();
        int i3 = this.mask;
        if (get(((int) (this.capacitySkip + j3)) & i3) != null) {
            return false;
        }
        this.producerIndex.lazySet(j3 + 1);
        lazySet(i3 & ((int) j3), t16);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        return get(((int) this.consumerIndex.get()) & this.mask);
    }

    @Override // java.util.Queue
    public T poll() {
        long j3 = this.consumerIndex.get();
        int i3 = ((int) j3) & this.mask;
        T t16 = get(i3);
        if (t16 == null) {
            return null;
        }
        this.consumerIndex.lazySet(j3 + 1);
        lazySet(i3, null);
        return t16;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long j3 = this.consumerIndex.get();
        while (true) {
            long j16 = this.producerIndex.get();
            long j17 = this.consumerIndex.get();
            if (j3 == j17) {
                return (int) (j16 - j17);
            }
            j3 = j17;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
