package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorBufferWithSize<T> implements Observable.Operator<List<T>, T> {
    final int count;
    final int skip;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BufferExact<T> extends Subscriber<T> {
        final Subscriber<? super List<T>> actual;
        List<T> buffer;
        final int count;

        public BufferExact(Subscriber<? super List<T>> subscriber, int i3) {
            this.actual = subscriber;
            this.count = i3;
            request(0L);
        }

        Producer createProducer() {
            return new Producer() { // from class: rx.internal.operators.OperatorBufferWithSize.BufferExact.1
                @Override // rx.Producer
                public void request(long j3) {
                    if (j3 >= 0) {
                        if (j3 != 0) {
                            BufferExact.this.request(BackpressureUtils.multiplyCap(j3, BufferExact.this.count));
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("n >= required but it was " + j3);
                }
            };
        }

        @Override // rx.Observer
        public void onCompleted() {
            List<T> list = this.buffer;
            if (list != null) {
                this.actual.onNext(list);
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.buffer = null;
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            List list = this.buffer;
            if (list == null) {
                list = new ArrayList(this.count);
                this.buffer = list;
            }
            list.add(t16);
            if (list.size() == this.count) {
                this.buffer = null;
                this.actual.onNext(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BufferOverlap<T> extends Subscriber<T> {
        final Subscriber<? super List<T>> actual;
        final int count;
        long index;
        long produced;
        final ArrayDeque<List<T>> queue = new ArrayDeque<>();
        final AtomicLong requested = new AtomicLong();
        final int skip;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class BufferOverlapProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = -4015894850868853147L;

            BufferOverlapProducer() {
            }

            @Override // rx.Producer
            public void request(long j3) {
                BufferOverlap bufferOverlap = BufferOverlap.this;
                if (BackpressureUtils.postCompleteRequest(bufferOverlap.requested, j3, bufferOverlap.queue, bufferOverlap.actual) && j3 != 0) {
                    if (get() || !compareAndSet(false, true)) {
                        bufferOverlap.request(BackpressureUtils.multiplyCap(bufferOverlap.skip, j3));
                    } else {
                        bufferOverlap.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(bufferOverlap.skip, j3 - 1), bufferOverlap.count));
                    }
                }
            }
        }

        public BufferOverlap(Subscriber<? super List<T>> subscriber, int i3, int i16) {
            this.actual = subscriber;
            this.count = i3;
            this.skip = i16;
            request(0L);
        }

        Producer createProducer() {
            return new BufferOverlapProducer();
        }

        @Override // rx.Observer
        public void onCompleted() {
            long j3 = this.produced;
            if (j3 != 0) {
                if (j3 > this.requested.get()) {
                    this.actual.onError(new MissingBackpressureException("More produced than requested? " + j3));
                    return;
                }
                this.requested.addAndGet(-j3);
            }
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.queue.clear();
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            long j3 = this.index;
            if (j3 == 0) {
                this.queue.offer(new ArrayList(this.count));
            }
            long j16 = j3 + 1;
            if (j16 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j16;
            }
            Iterator<List<T>> it = this.queue.iterator();
            while (it.hasNext()) {
                it.next().add(t16);
            }
            List<T> peek = this.queue.peek();
            if (peek != null && peek.size() == this.count) {
                this.queue.poll();
                this.produced++;
                this.actual.onNext(peek);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BufferSkip<T> extends Subscriber<T> {
        final Subscriber<? super List<T>> actual;
        List<T> buffer;
        final int count;
        long index;
        final int skip;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class BufferSkipProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 3428177408082367154L;

            BufferSkipProducer() {
            }

            @Override // rx.Producer
            public void request(long j3) {
                if (j3 >= 0) {
                    if (j3 != 0) {
                        BufferSkip bufferSkip = BufferSkip.this;
                        if (get() || !compareAndSet(false, true)) {
                            bufferSkip.request(BackpressureUtils.multiplyCap(j3, bufferSkip.skip));
                            return;
                        } else {
                            bufferSkip.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(j3, bufferSkip.count), BackpressureUtils.multiplyCap(bufferSkip.skip - bufferSkip.count, j3 - 1)));
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }

        public BufferSkip(Subscriber<? super List<T>> subscriber, int i3, int i16) {
            this.actual = subscriber;
            this.count = i3;
            this.skip = i16;
            request(0L);
        }

        Producer createProducer() {
            return new BufferSkipProducer();
        }

        @Override // rx.Observer
        public void onCompleted() {
            List<T> list = this.buffer;
            if (list != null) {
                this.buffer = null;
                this.actual.onNext(list);
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.buffer = null;
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            long j3 = this.index;
            List list = this.buffer;
            if (j3 == 0) {
                list = new ArrayList(this.count);
                this.buffer = list;
            }
            long j16 = j3 + 1;
            if (j16 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j16;
            }
            if (list != null) {
                list.add(t16);
                if (list.size() == this.count) {
                    this.buffer = null;
                    this.actual.onNext(list);
                }
            }
        }
    }

    public OperatorBufferWithSize(int i3, int i16) {
        if (i3 > 0) {
            if (i16 > 0) {
                this.count = i3;
                this.skip = i16;
                return;
            }
            throw new IllegalArgumentException("skip must be greater than 0");
        }
        throw new IllegalArgumentException("count must be greater than 0");
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        int i3 = this.skip;
        int i16 = this.count;
        if (i3 == i16) {
            BufferExact bufferExact = new BufferExact(subscriber, i16);
            subscriber.add(bufferExact);
            subscriber.setProducer(bufferExact.createProducer());
            return bufferExact;
        }
        if (i3 > i16) {
            BufferSkip bufferSkip = new BufferSkip(subscriber, i16, i3);
            subscriber.add(bufferSkip);
            subscriber.setProducer(bufferSkip.createProducer());
            return bufferSkip;
        }
        BufferOverlap bufferOverlap = new BufferOverlap(subscriber, i16, i3);
        subscriber.add(bufferOverlap);
        subscriber.setProducer(bufferOverlap.createProducer());
        return bufferOverlap;
    }
}
