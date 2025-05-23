package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public class SpscUnboundedArrayQueue<E> extends SpscUnboundedArrayQueueConsumerField<E> implements QueueProgressIndicators {
    private static final long C_INDEX_OFFSET;
    private static final long P_INDEX_OFFSET;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();

    static {
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = unsafe.arrayBaseOffset(Object[].class);
        try {
            P_INDEX_OFFSET = unsafe.objectFieldOffset(SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex"));
            try {
                C_INDEX_OFFSET = unsafe.objectFieldOffset(SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e16) {
                InternalError internalError = new InternalError();
                internalError.initCause(e16);
                throw internalError;
            }
        } catch (NoSuchFieldException e17) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e17);
            throw internalError2;
        }
    }

    public SpscUnboundedArrayQueue(int i3) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i3);
        long j3 = roundToPowerOfTwo - 1;
        E[] eArr = (E[]) new Object[roundToPowerOfTwo + 1];
        this.producerBuffer = eArr;
        this.producerMask = j3;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = eArr;
        this.consumerMask = j3;
        this.producerLookAhead = j3 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i3) {
        this.producerLookAheadStep = Math.min(i3 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static long calcDirectOffset(long j3) {
        return REF_ARRAY_BASE + (j3 << REF_ELEMENT_SHIFT);
    }

    private static long calcWrappedOffset(long j3, long j16) {
        return calcDirectOffset(j3 & j16);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    private static <E> Object lvElement(E[] eArr, long j3) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j3);
    }

    private E[] lvNext(E[] eArr) {
        return (E[]) ((Object[]) lvElement(eArr, calcDirectOffset(eArr.length - 1)));
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private E newBufferPeek(E[] eArr, long j3, long j16) {
        this.consumerBuffer = eArr;
        return (E) lvElement(eArr, calcWrappedOffset(j3, j16));
    }

    private E newBufferPoll(E[] eArr, long j3, long j16) {
        this.consumerBuffer = eArr;
        long calcWrappedOffset = calcWrappedOffset(j3, j16);
        E e16 = (E) lvElement(eArr, calcWrappedOffset);
        if (e16 == null) {
            return null;
        }
        soElement(eArr, calcWrappedOffset, null);
        soConsumerIndex(j3 + 1);
        return e16;
    }

    private void resize(E[] eArr, long j3, long j16, E e16, long j17) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.producerBuffer = eArr2;
        this.producerLookAhead = (j17 + j3) - 1;
        soElement(eArr2, j16, e16);
        soNext(eArr, eArr2);
        soElement(eArr, j16, HAS_NEXT);
        soProducerIndex(j3 + 1);
    }

    private void soConsumerIndex(long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j3);
    }

    private static void soElement(Object[] objArr, long j3, Object obj) {
        UnsafeAccess.UNSAFE.putOrderedObject(objArr, j3, obj);
    }

    private void soNext(E[] eArr, E[] eArr2) {
        soElement(eArr, calcDirectOffset(eArr.length - 1), eArr2);
    }

    private void soProducerIndex(long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j3);
    }

    private boolean writeToQueue(E[] eArr, E e16, long j3, long j16) {
        soElement(eArr, j16, e16);
        soProducerIndex(j3 + 1);
        return true;
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // rx.internal.util.unsafe.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e16) {
        if (e16 != null) {
            E[] eArr = this.producerBuffer;
            long j3 = this.producerIndex;
            long j16 = this.producerMask;
            long calcWrappedOffset = calcWrappedOffset(j3, j16);
            if (j3 < this.producerLookAhead) {
                return writeToQueue(eArr, e16, j3, calcWrappedOffset);
            }
            long j17 = this.producerLookAheadStep + j3;
            if (lvElement(eArr, calcWrappedOffset(j17, j16)) == null) {
                this.producerLookAhead = j17 - 1;
                return writeToQueue(eArr, e16, j3, calcWrappedOffset);
            }
            if (lvElement(eArr, calcWrappedOffset(1 + j3, j16)) != null) {
                return writeToQueue(eArr, e16, j3, calcWrappedOffset);
            }
            resize(eArr, j3, calcWrappedOffset, e16, j16);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.consumerBuffer;
        long j3 = this.consumerIndex;
        long j16 = this.consumerMask;
        E e16 = (E) lvElement(eArr, calcWrappedOffset(j3, j16));
        if (e16 == HAS_NEXT) {
            return newBufferPeek(lvNext(eArr), j3, j16);
        }
        return e16;
    }

    @Override // java.util.Queue
    public final E poll() {
        boolean z16;
        E[] eArr = this.consumerBuffer;
        long j3 = this.consumerIndex;
        long j16 = this.consumerMask;
        long calcWrappedOffset = calcWrappedOffset(j3, j16);
        E e16 = (E) lvElement(eArr, calcWrappedOffset);
        if (e16 == HAS_NEXT) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (e16 != null && !z16) {
            soElement(eArr, calcWrappedOffset, null);
            soConsumerIndex(j3 + 1);
            return e16;
        }
        if (!z16) {
            return null;
        }
        return newBufferPoll(lvNext(eArr), j3, j16);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
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
