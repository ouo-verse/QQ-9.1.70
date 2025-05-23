package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SpscAtomicArrayQueue<E> extends AtomicReferenceArrayQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public SpscAtomicArrayQueue(int i3) {
        super(i3);
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i3 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private void soConsumerIndex(long j3) {
        this.consumerIndex.lazySet(j3);
    }

    private void soProducerIndex(long j3) {
        this.producerIndex.lazySet(j3);
    }

    @Override // rx.internal.util.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (lvProducerIndex() == lvConsumerIndex()) {
            return true;
        }
        return false;
    }

    @Override // rx.internal.util.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e16) {
        if (e16 != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
            int i3 = this.mask;
            long j3 = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j3, i3);
            if (j3 >= this.producerLookAhead) {
                long j16 = this.lookAheadStep + j3;
                if (lvElement(atomicReferenceArray, calcElementOffset(j16, i3)) == null) {
                    this.producerLookAhead = j16;
                } else if (lvElement(atomicReferenceArray, calcElementOffset) != null) {
                    return false;
                }
            }
            soElement(atomicReferenceArray, calcElementOffset, e16);
            soProducerIndex(j3 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j3 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j3);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E lvElement = lvElement(atomicReferenceArray, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(j3 + 1);
        return lvElement;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
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
}
