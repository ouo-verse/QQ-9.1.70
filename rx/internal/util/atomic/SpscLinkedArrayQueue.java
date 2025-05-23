package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SpscLinkedArrayQueue<T> implements Queue<T> {
    AtomicReferenceArray<Object> consumerBuffer;
    final AtomicLong consumerIndex;
    int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int producerLookAheadStep;
    int producerMask;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();

    public SpscLinkedArrayQueue(int i3) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i3);
        int i16 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i16;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i16;
        this.producerLookAhead = i16 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    private void adjustLookAheadStep(int i3) {
        this.producerLookAheadStep = Math.min(i3 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static int calcWrappedOffset(long j3, int i3) {
        return calcDirectOffset(((int) j3) & i3);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i3) {
        return atomicReferenceArray.get(i3);
    }

    private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1));
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j3, int i3) {
        this.consumerBuffer = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j3, i3));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j3, int i3) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j3, i3);
        T t16 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t16 == null) {
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(j3 + 1);
        return t16;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j3, int i3, T t16, long j16) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j16 + j3) - 1;
        soElement(atomicReferenceArray2, i3, t16);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i3, HAS_NEXT);
        soProducerIndex(j3 + 1);
    }

    private void soConsumerIndex(long j3) {
        this.consumerIndex.lazySet(j3);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i3, Object obj) {
        atomicReferenceArray.lazySet(i3, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j3) {
        this.producerIndex.lazySet(j3);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t16, long j3, int i3) {
        soElement(atomicReferenceArray, i3, t16);
        soProducerIndex(j3 + 1);
        return true;
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
        if (lvProducerIndex() == lvConsumerIndex()) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i3 = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i3);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, t16, lpProducerIndex, calcWrappedOffset);
        }
        long j3 = this.producerLookAheadStep + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j3, i3)) == null) {
            this.producerLookAhead = j3 - 1;
            return writeToQueue(atomicReferenceArray, t16, lpProducerIndex, calcWrappedOffset);
        }
        if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i3)) == null) {
            return writeToQueue(atomicReferenceArray, t16, lpProducerIndex, calcWrappedOffset);
        }
        resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t16, i3);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i3 = this.consumerMask;
        T t16 = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i3));
        if (t16 == HAS_NEXT) {
            return newBufferPeek(lvNext(atomicReferenceArray), lpConsumerIndex, i3);
        }
        return t16;
    }

    @Override // java.util.Queue
    public T poll() {
        boolean z16;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i3 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i3);
        T t16 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t16 == HAS_NEXT) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (t16 != null && !z16) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(lpConsumerIndex + 1);
            return t16;
        }
        if (!z16) {
            return null;
        }
        return newBufferPoll(lvNext(atomicReferenceArray), lpConsumerIndex, i3);
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
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
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

    public boolean offer(T t16, T t17) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i3 = this.producerMask;
        long j3 = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j3, i3)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i3);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t17);
            soElement(atomicReferenceArray, calcWrappedOffset, t16);
            soProducerIndex(j3);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i3);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t17);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t16);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j3);
        return true;
    }

    private static int calcDirectOffset(int i3) {
        return i3;
    }
}
