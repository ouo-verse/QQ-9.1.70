package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public abstract class SpmcArrayQueueConsumerField<E> extends SpmcArrayQueueL2Pad<E> {
    protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    public SpmcArrayQueueConsumerField(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean casHead(long j3, long j16) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }
}
