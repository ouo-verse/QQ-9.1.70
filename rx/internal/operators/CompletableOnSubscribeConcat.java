package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeConcat implements Completable.CompletableOnSubscribe {
    final int prefetch;
    final Observable<Completable> sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CompletableConcatSubscriber extends Subscriber<Completable> {
        final Completable.CompletableSubscriber actual;
        volatile boolean done;
        final ConcatInnerSubscriber inner;
        final AtomicBoolean once;
        final int prefetch;
        final SpscArrayQueue<Completable> queue;

        /* renamed from: sr, reason: collision with root package name */
        final SerialSubscription f432655sr;
        final AtomicInteger wip;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class ConcatInnerSubscriber implements Completable.CompletableSubscriber {
            ConcatInnerSubscriber() {
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                CompletableConcatSubscriber.this.innerComplete();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                CompletableConcatSubscriber.this.innerError(th5);
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                CompletableConcatSubscriber.this.f432655sr.set(subscription);
            }
        }

        public CompletableConcatSubscriber(Completable.CompletableSubscriber completableSubscriber, int i3) {
            this.actual = completableSubscriber;
            this.prefetch = i3;
            this.queue = new SpscArrayQueue<>(i3);
            SerialSubscription serialSubscription = new SerialSubscription();
            this.f432655sr = serialSubscription;
            this.inner = new ConcatInnerSubscriber();
            this.wip = new AtomicInteger();
            this.once = new AtomicBoolean();
            add(serialSubscription);
            request(i3);
        }

        void innerComplete() {
            if (this.wip.decrementAndGet() != 0) {
                next();
            }
            if (!this.done) {
                request(1L);
            }
        }

        void innerError(Throwable th5) {
            unsubscribe();
            onError(th5);
        }

        void next() {
            boolean z16 = this.done;
            Completable poll = this.queue.poll();
            if (poll == null) {
                if (z16) {
                    if (this.once.compareAndSet(false, true)) {
                        this.actual.onCompleted();
                        return;
                    }
                    return;
                }
                RxJavaHooks.onError(new IllegalStateException("Queue is empty?!"));
                return;
            }
            poll.unsafeSubscribe(this.inner);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                next();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th5);
            } else {
                RxJavaHooks.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(Completable completable) {
            if (!this.queue.offer(completable)) {
                onError(new MissingBackpressureException());
            } else if (this.wip.getAndIncrement() == 0) {
                next();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeConcat(Observable<? extends Completable> observable, int i3) {
        this.sources = observable;
        this.prefetch = i3;
    }

    @Override // rx.functions.Action1
    public void call(Completable.CompletableSubscriber completableSubscriber) {
        CompletableConcatSubscriber completableConcatSubscriber = new CompletableConcatSubscriber(completableSubscriber, this.prefetch);
        completableSubscriber.onSubscribe(completableConcatSubscriber);
        this.sources.subscribe((Subscriber<? super Completable>) completableConcatSubscriber);
    }
}
