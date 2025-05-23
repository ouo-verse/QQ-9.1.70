package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {

    /* renamed from: p30, reason: collision with root package name */
    long f432740p30;

    /* renamed from: p31, reason: collision with root package name */
    long f432741p31;

    /* renamed from: p32, reason: collision with root package name */
    long f432742p32;

    /* renamed from: p33, reason: collision with root package name */
    long f432743p33;

    /* renamed from: p34, reason: collision with root package name */
    long f432744p34;

    /* renamed from: p35, reason: collision with root package name */
    long f432745p35;
    long p36;
    long p37;

    /* renamed from: p40, reason: collision with root package name */
    long f432746p40;

    /* renamed from: p41, reason: collision with root package name */
    long f432747p41;

    /* renamed from: p42, reason: collision with root package name */
    long f432748p42;

    /* renamed from: p43, reason: collision with root package name */
    long f432749p43;

    /* renamed from: p44, reason: collision with root package name */
    long f432750p44;

    /* renamed from: p45, reason: collision with root package name */
    long f432751p45;
    long p46;

    public MpmcArrayQueue(int i3) {
        super(Math.max(2, i3));
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
            long j3 = this.mask + 1;
            long[] jArr = this.sequenceBuffer;
            long j16 = Long.MAX_VALUE;
            while (true) {
                long lvProducerIndex = lvProducerIndex();
                long calcSequenceOffset = calcSequenceOffset(lvProducerIndex);
                long lvSequence = lvSequence(jArr, calcSequenceOffset) - lvProducerIndex;
                if (lvSequence == 0) {
                    long j17 = lvProducerIndex + 1;
                    if (casProducerIndex(lvProducerIndex, j17)) {
                        spElement(calcElementOffset(lvProducerIndex), e16);
                        soSequence(jArr, calcSequenceOffset, j17);
                        return true;
                    }
                } else if (lvSequence < 0) {
                    long j18 = lvProducerIndex - j3;
                    if (j18 <= j16) {
                        j16 = lvConsumerIndex();
                        if (j18 <= j16) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E peek() {
        long lvConsumerIndex;
        E lpElement;
        do {
            lvConsumerIndex = lvConsumerIndex();
            lpElement = lpElement(calcElementOffset(lvConsumerIndex));
            if (lpElement != null) {
                break;
            }
        } while (lvConsumerIndex != lvProducerIndex());
        return lpElement;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.MessagePassingQueue
    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long j3 = -1;
        while (true) {
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvConsumerIndex);
            long j16 = lvConsumerIndex + 1;
            long lvSequence = lvSequence(jArr, calcSequenceOffset) - j16;
            if (lvSequence == 0) {
                if (casConsumerIndex(lvConsumerIndex, j16)) {
                    long calcElementOffset = calcElementOffset(lvConsumerIndex);
                    E lpElement = lpElement(calcElementOffset);
                    spElement(calcElementOffset, null);
                    soSequence(jArr, calcSequenceOffset, lvConsumerIndex + this.mask + 1);
                    return lpElement;
                }
            } else if (lvSequence < 0 && lvConsumerIndex >= j3) {
                j3 = lvProducerIndex();
                if (lvConsumerIndex == j3) {
                    return null;
                }
            }
        }
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
