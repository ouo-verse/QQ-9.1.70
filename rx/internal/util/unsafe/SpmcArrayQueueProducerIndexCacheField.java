package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
/* loaded from: classes29.dex */
abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    public SpmcArrayQueueProducerIndexCacheField(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void svProducerIndexCache(long j3) {
        this.producerIndexCache = j3;
    }
}
