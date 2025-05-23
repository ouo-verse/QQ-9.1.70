package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.subjects.Subject;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorWindowWithSize<T> implements Observable.Operator<Observable<T>, T> {
    final int size;
    final int skip;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WindowExact<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super Observable<T>> actual;
        final Subscription cancel;
        int index;
        final int size;
        Subject<T, T> window;
        final AtomicInteger wip = new AtomicInteger(1);

        public WindowExact(Subscriber<? super Observable<T>> subscriber, int i3) {
            this.actual = subscriber;
            this.size = i3;
            Subscription create = Subscriptions.create(this);
            this.cancel = create;
            add(create);
            request(0L);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        Producer createProducer() {
            return new Producer() { // from class: rx.internal.operators.OperatorWindowWithSize.WindowExact.1
                @Override // rx.Producer
                public void request(long j3) {
                    if (j3 >= 0) {
                        if (j3 != 0) {
                            WindowExact.this.request(BackpressureUtils.multiplyCap(WindowExact.this.size, j3));
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("n >= 0 required but it was " + j3);
                }
            };
        }

        @Override // rx.Observer
        public void onCompleted() {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onCompleted();
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onError(th5);
            }
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            int i3 = this.index;
            UnicastSubject unicastSubject = this.window;
            if (i3 == 0) {
                this.wip.getAndIncrement();
                unicastSubject = UnicastSubject.create(this.size, this);
                this.window = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            int i16 = i3 + 1;
            unicastSubject.onNext(t16);
            if (i16 == this.size) {
                this.index = 0;
                this.window = null;
                unicastSubject.onCompleted();
                return;
            }
            this.index = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WindowOverlap<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super Observable<T>> actual;
        final Subscription cancel;
        volatile boolean done;
        Throwable error;
        int index;
        int produced;
        final Queue<Subject<T, T>> queue;
        final int size;
        final int skip;
        final AtomicInteger wip = new AtomicInteger(1);
        final ArrayDeque<Subject<T, T>> windows = new ArrayDeque<>();
        final AtomicInteger drainWip = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class WindowOverlapProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            WindowOverlapProducer() {
            }

            @Override // rx.Producer
            public void request(long j3) {
                if (j3 >= 0) {
                    if (j3 != 0) {
                        WindowOverlap windowOverlap = WindowOverlap.this;
                        if (!get() && compareAndSet(false, true)) {
                            windowOverlap.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(windowOverlap.skip, j3 - 1), windowOverlap.size));
                        } else {
                            WindowOverlap.this.request(BackpressureUtils.multiplyCap(windowOverlap.skip, j3));
                        }
                        BackpressureUtils.getAndAddRequest(windowOverlap.requested, j3);
                        windowOverlap.drain();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }

        public WindowOverlap(Subscriber<? super Observable<T>> subscriber, int i3, int i16) {
            this.actual = subscriber;
            this.size = i3;
            this.skip = i16;
            Subscription create = Subscriptions.create(this);
            this.cancel = create;
            add(create);
            request(0L);
            this.queue = new SpscLinkedArrayQueue((i3 + (i16 - 1)) / i16);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<? super Subject<T, T>> subscriber, Queue<Subject<T, T>> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z16) {
                Throwable th5 = this.error;
                if (th5 != null) {
                    queue.clear();
                    subscriber.onError(th5);
                    return true;
                }
                if (z17) {
                    subscriber.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }

        Producer createProducer() {
            return new WindowOverlapProducer();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            boolean z16;
            AtomicInteger atomicInteger = this.drainWip;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Observable<T>> subscriber = this.actual;
            Queue<Subject<T, T>> queue = this.queue;
            int i3 = 1;
            do {
                long j3 = this.requested.get();
                long j16 = 0;
                while (j16 != j3) {
                    boolean z17 = this.done;
                    Subject<T, T> poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z17, z16, subscriber, queue)) {
                        return;
                    }
                    if (z16) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j16++;
                }
                if (j16 == j3 && checkTerminated(this.done, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                if (j16 != 0 && j3 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j16);
                }
                i3 = atomicInteger.addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // rx.Observer
        public void onCompleted() {
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th5);
            }
            this.windows.clear();
            this.error = th5;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            int i3 = this.index;
            ArrayDeque<Subject<T, T>> arrayDeque = this.windows;
            if (i3 == 0 && !this.actual.isUnsubscribed()) {
                this.wip.getAndIncrement();
                UnicastSubject create = UnicastSubject.create(16, this);
                arrayDeque.offer(create);
                this.queue.offer(create);
                drain();
            }
            Iterator<Subject<T, T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t16);
            }
            int i16 = this.produced + 1;
            if (i16 == this.size) {
                this.produced = i16 - this.skip;
                Subject<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.produced = i16;
            }
            int i17 = i3 + 1;
            if (i17 == this.skip) {
                this.index = 0;
            } else {
                this.index = i17;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WindowSkip<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super Observable<T>> actual;
        final Subscription cancel;
        int index;
        final int size;
        final int skip;
        Subject<T, T> window;
        final AtomicInteger wip = new AtomicInteger(1);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class WindowSkipProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            WindowSkipProducer() {
            }

            @Override // rx.Producer
            public void request(long j3) {
                if (j3 >= 0) {
                    if (j3 != 0) {
                        WindowSkip windowSkip = WindowSkip.this;
                        if (get() || !compareAndSet(false, true)) {
                            windowSkip.request(BackpressureUtils.multiplyCap(j3, windowSkip.skip));
                            return;
                        } else {
                            windowSkip.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(j3, windowSkip.size), BackpressureUtils.multiplyCap(windowSkip.skip - windowSkip.size, j3 - 1)));
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }

        public WindowSkip(Subscriber<? super Observable<T>> subscriber, int i3, int i16) {
            this.actual = subscriber;
            this.size = i3;
            this.skip = i16;
            Subscription create = Subscriptions.create(this);
            this.cancel = create;
            add(create);
            request(0L);
        }

        @Override // rx.functions.Action0
        public void call() {
            if (this.wip.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        Producer createProducer() {
            return new WindowSkipProducer();
        }

        @Override // rx.Observer
        public void onCompleted() {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onCompleted();
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            Subject<T, T> subject = this.window;
            if (subject != null) {
                this.window = null;
                subject.onError(th5);
            }
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            int i3 = this.index;
            UnicastSubject unicastSubject = this.window;
            if (i3 == 0) {
                this.wip.getAndIncrement();
                unicastSubject = UnicastSubject.create(this.size, this);
                this.window = unicastSubject;
                this.actual.onNext(unicastSubject);
            }
            int i16 = i3 + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t16);
            }
            if (i16 == this.size) {
                this.index = i16;
                this.window = null;
                unicastSubject.onCompleted();
            } else if (i16 == this.skip) {
                this.index = 0;
            } else {
                this.index = i16;
            }
        }
    }

    public OperatorWindowWithSize(int i3, int i16) {
        this.size = i3;
        this.skip = i16;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        int i3 = this.skip;
        int i16 = this.size;
        if (i3 == i16) {
            WindowExact windowExact = new WindowExact(subscriber, i16);
            subscriber.add(windowExact.cancel);
            subscriber.setProducer(windowExact.createProducer());
            return windowExact;
        }
        if (i3 > i16) {
            WindowSkip windowSkip = new WindowSkip(subscriber, i16, i3);
            subscriber.add(windowSkip.cancel);
            subscriber.setProducer(windowSkip.createProducer());
            return windowSkip;
        }
        WindowOverlap windowOverlap = new WindowOverlap(subscriber, i16, i3);
        subscriber.add(windowOverlap.cancel);
        subscriber.setProducer(windowOverlap.createProducer());
        return windowOverlap;
    }
}
