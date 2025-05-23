package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class MpmcArrayQueueProducerField<E> extends MpmcArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    public MpmcArrayQueueProducerField(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean casProducerIndex(long j3, long j16) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvProducerIndex() {
        return this.producerIndex;
    }
}
