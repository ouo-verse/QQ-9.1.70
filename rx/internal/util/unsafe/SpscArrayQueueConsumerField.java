package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class SpscArrayQueueConsumerField<E> extends SpscArrayQueueL2Pad<E> {
    protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueConsumerField.class, "consumerIndex");
    protected long consumerIndex;

    public SpscArrayQueueConsumerField(int i3) {
        super(i3);
    }
}
