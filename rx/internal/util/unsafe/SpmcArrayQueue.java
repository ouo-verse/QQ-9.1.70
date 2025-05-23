package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public final class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    public SpmcArrayQueue(int i3) {
        super(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        if (lvConsumerIndex() == lvProducerIndex()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e16) {
        if (e16 != null) {
            E[] eArr = this.buffer;
            long j3 = this.mask;
            long lvProducerIndex = lvProducerIndex();
            long calcElementOffset = calcElementOffset(lvProducerIndex);
            if (lvElement(eArr, calcElementOffset) != null) {
                if (lvProducerIndex - lvConsumerIndex() > j3) {
                    return false;
                }
                do {
                } while (lvElement(eArr, calcElementOffset) != null);
            }
            spElement(eArr, calcElementOffset, e16);
            soTail(lvProducerIndex + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        E lvElement;
        long lvProducerIndexCache = lvProducerIndexCache();
        do {
            long lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex >= lvProducerIndexCache) {
                long lvProducerIndex = lvProducerIndex();
                if (lvConsumerIndex >= lvProducerIndex) {
                    return null;
                }
                svProducerIndexCache(lvProducerIndex);
            }
            lvElement = lvElement(calcElementOffset(lvConsumerIndex));
        } while (lvElement == null);
        return lvElement;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long lvConsumerIndex;
        long lvProducerIndexCache = lvProducerIndexCache();
        do {
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex >= lvProducerIndexCache) {
                long lvProducerIndex = lvProducerIndex();
                if (lvConsumerIndex >= lvProducerIndex) {
                    return null;
                }
                svProducerIndexCache(lvProducerIndex);
            }
        } while (!casHead(lvConsumerIndex, 1 + lvConsumerIndex));
        long calcElementOffset = calcElementOffset(lvConsumerIndex);
        E[] eArr = this.buffer;
        E lpElement = lpElement(eArr, calcElementOffset);
        soElement(eArr, calcElementOffset, null);
        return lpElement;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
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
