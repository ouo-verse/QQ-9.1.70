package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i3) {
        super(i3);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, SpscArrayQueueConsumerField.C_INDEX_OFFSET);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, SpscArrayQueueProducerFields.P_INDEX_OFFSET);
    }

    private void soConsumerIndex(long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, SpscArrayQueueConsumerField.C_INDEX_OFFSET, j3);
    }

    private void soProducerIndex(long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, SpscArrayQueueProducerFields.P_INDEX_OFFSET, j3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.unsafe.MessagePassingQueue
    public boolean isEmpty() {
        if (lvProducerIndex() == lvConsumerIndex()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public boolean offer(E e16) {
        if (e16 != null) {
            E[] eArr = this.buffer;
            long j3 = this.producerIndex;
            long calcElementOffset = calcElementOffset(j3);
            if (lvElement(eArr, calcElementOffset) != null) {
                return false;
            }
            soElement(eArr, calcElementOffset, e16);
            soProducerIndex(j3 + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long j3 = this.consumerIndex;
        long calcElementOffset = calcElementOffset(j3);
        E[] eArr = this.buffer;
        E lvElement = lvElement(eArr, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(eArr, calcElementOffset, null);
        soConsumerIndex(j3 + 1);
        return lvElement;
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
