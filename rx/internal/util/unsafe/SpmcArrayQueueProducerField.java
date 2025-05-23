package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    public SpmcArrayQueueProducerField(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soTail(long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j3);
    }
}
