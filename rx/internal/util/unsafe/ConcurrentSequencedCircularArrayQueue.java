package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE;
    private static final int ELEMENT_SHIFT;
    protected final long[] sequenceBuffer;

    static {
        if (8 == UnsafeAccess.UNSAFE.arrayIndexScale(long[].class)) {
            ELEMENT_SHIFT = ConcurrentCircularArrayQueue.SPARSE_SHIFT + 3;
            ARRAY_BASE = r0.arrayBaseOffset(long[].class) + (32 << (r3 - r2));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i3) {
        super(i3);
        int i16 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[(i16 << ConcurrentCircularArrayQueue.SPARSE_SHIFT) + 64];
        for (long j3 = 0; j3 < i16; j3++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j3), j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long calcSequenceOffset(long j3) {
        return ARRAY_BASE + ((j3 & this.mask) << ELEMENT_SHIFT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvSequence(long[] jArr, long j3) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soSequence(long[] jArr, long j3, long j16) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j3, j16);
    }
}
