package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class MpmcArrayQueueConsumerField<E> extends MpmcArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    public MpmcArrayQueueConsumerField(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean casConsumerIndex(long j3, long j16) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }
}
