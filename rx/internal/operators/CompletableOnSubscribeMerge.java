package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeMerge implements Completable.CompletableOnSubscribe {
    final boolean delayErrors;
    final int maxConcurrency;
    final Observable<Completable> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CompletableMergeSubscriber extends Subscriber<Completable> {
        final Completable.CompletableSubscriber actual;
        final boolean delayErrors;
        volatile boolean done;
        final int maxConcurrency;
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(1);
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<Queue<Throwable>> errors = new AtomicReference<>();

        public CompletableMergeSubscriber(Completable.CompletableSubscriber completableSubscriber, int i3, boolean z16) {
            this.actual = completableSubscriber;
            this.maxConcurrency = i3;
            this.delayErrors = z16;
            if (i3 == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request(i3);
            }
        }

        Queue<Throwable> getOrCreateErrors() {
            Queue<Throwable> queue = this.errors.get();
            if (queue != null) {
                return queue;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            if (c.a(this.errors, null, concurrentLinkedQueue)) {
                return concurrentLinkedQueue;
            }
            return this.errors.get();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            terminate();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
                return;
            }
            getOrCreateErrors().offer(th5);
            this.done = true;
            terminate();
        }

        void terminate() {
            Queue<Throwable> queue;
            if (this.wip.decrementAndGet() == 0) {
                Queue<Throwable> queue2 = this.errors.get();
                if (queue2 != null && !queue2.isEmpty()) {
                    Throwable collectErrors = CompletableOnSubscribeMerge.collectErrors(queue2);
                    if (this.once.compareAndSet(false, true)) {
                        this.actual.onError(collectErrors);
                        return;
                    } else {
                        RxJavaHooks.onError(collectErrors);
                        return;
                    }
                }
                this.actual.onCompleted();
                return;
            }
            if (!this.delayErrors && (queue = this.errors.get()) != null && !queue.isEmpty()) {
                Throwable collectErrors2 = CompletableOnSubscribeMerge.collectErrors(queue);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(collectErrors2);
                } else {
                    RxJavaHooks.onError(collectErrors2);
                }
            }
        }

        @Override // rx.Observer
        public void onNext(Completable completable) {
            if (this.done) {
                return;
            }
            this.wip.getAndIncrement();
            completable.unsafeSubscribe(new Completable.CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeMerge.CompletableMergeSubscriber.1

                /* renamed from: d, reason: collision with root package name */
                Subscription f432658d;
                boolean innerDone;

                @Override // rx.Completable.CompletableSubscriber
                public void onCompleted() {
                    if (this.innerDone) {
                        return;
                    }
                    this.innerDone = true;
                    CompletableMergeSubscriber.this.set.remove(this.f432658d);
                    CompletableMergeSubscriber.this.terminate();
                    if (!CompletableMergeSubscriber.this.done) {
                        CompletableMergeSubscriber.this.request(1L);
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onError(Throwable th5) {
                    if (this.innerDone) {
                        RxJavaHooks.onError(th5);
                        return;
                    }
                    this.innerDone = true;
                    CompletableMergeSubscriber.this.set.remove(this.f432658d);
                    CompletableMergeSubscriber.this.getOrCreateErrors().offer(th5);
                    CompletableMergeSubscriber.this.terminate();
                    CompletableMergeSubscriber completableMergeSubscriber = CompletableMergeSubscriber.this;
                    if (completableMergeSubscriber.delayErrors && !completableMergeSubscriber.done) {
                        CompletableMergeSubscriber.this.request(1L);
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onSubscribe(Subscription subscription) {
                    this.f432658d = subscription;
                    CompletableMergeSubscriber.this.set.add(subscription);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletableOnSubscribeMerge(Observable<? extends Completable> observable, int i3, boolean z16) {
        this.source = observable;
        this.maxConcurrency = i3;
        this.delayErrors = z16;
    }

    public static Throwable collectErrors(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Throwable) arrayList.get(0);
        }
        return new CompositeException(arrayList);
    }

    @Override // rx.functions.Action1
    public void call(Completable.CompletableSubscriber completableSubscriber) {
        CompletableMergeSubscriber completableMergeSubscriber = new CompletableMergeSubscriber(completableSubscriber, this.maxConcurrency, this.delayErrors);
        completableSubscriber.onSubscribe(completableMergeSubscriber);
        this.source.subscribe((Subscriber<? super Completable>) completableMergeSubscriber);
    }
}
