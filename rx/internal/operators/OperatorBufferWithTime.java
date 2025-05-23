package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorBufferWithTime<T> implements Observable.Operator<List<T>, T> {
    final int count;
    final Scheduler scheduler;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk = new ArrayList();
        boolean done;
        final Scheduler.Worker inner;

        public ExactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        void emit() {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                List<T> list = this.chunk;
                this.chunk = new ArrayList();
                try {
                    this.child.onNext(list);
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this);
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                this.inner.unsubscribe();
                synchronized (this) {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    List<T> list = this.chunk;
                    this.chunk = null;
                    this.child.onNext(list);
                    this.child.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, this.child);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                this.chunk = null;
                this.child.onError(th5);
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            List<T> list;
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.chunk.add(t16);
                if (this.chunk.size() == OperatorBufferWithTime.this.count) {
                    list = this.chunk;
                    this.chunk = new ArrayList();
                } else {
                    list = null;
                }
                if (list != null) {
                    this.child.onNext(list);
                }
            }
        }

        void scheduleExact() {
            Scheduler.Worker worker = this.inner;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorBufferWithTime.ExactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    ExactSubscriber.this.emit();
                }
            };
            OperatorBufferWithTime operatorBufferWithTime = OperatorBufferWithTime.this;
            long j3 = operatorBufferWithTime.timespan;
            worker.schedulePeriodically(action0, j3, j3, operatorBufferWithTime.unit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        boolean done;
        final Scheduler.Worker inner;

        public InexactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        void emitChunk(List<T> list) {
            boolean z16;
            synchronized (this) {
                if (this.done) {
                    return;
                }
                Iterator<List<T>> it = this.chunks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() == list) {
                            it.remove();
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, this);
                    }
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    LinkedList linkedList = new LinkedList(this.chunks);
                    this.chunks.clear();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.child.onNext((List) it.next());
                    }
                    this.child.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, this.child);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                this.chunks.clear();
                this.child.onError(th5);
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                Iterator<List<T>> it = this.chunks.iterator();
                LinkedList linkedList = null;
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t16);
                    if (next.size() == OperatorBufferWithTime.this.count) {
                        it.remove();
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(next);
                    }
                }
                if (linkedList != null) {
                    Iterator it5 = linkedList.iterator();
                    while (it5.hasNext()) {
                        this.child.onNext((List) it5.next());
                    }
                }
            }
        }

        void scheduleChunk() {
            Scheduler.Worker worker = this.inner;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            };
            OperatorBufferWithTime operatorBufferWithTime = OperatorBufferWithTime.this;
            long j3 = operatorBufferWithTime.timeshift;
            worker.schedulePeriodically(action0, j3, j3, operatorBufferWithTime.unit);
        }

        void startNewChunk() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.chunks.add(arrayList);
                Scheduler.Worker worker = this.inner;
                Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.2
                    @Override // rx.functions.Action0
                    public void call() {
                        InexactSubscriber.this.emitChunk(arrayList);
                    }
                };
                OperatorBufferWithTime operatorBufferWithTime = OperatorBufferWithTime.this;
                worker.schedule(action0, operatorBufferWithTime.timespan, operatorBufferWithTime.unit);
            }
        }
    }

    public OperatorBufferWithTime(long j3, long j16, TimeUnit timeUnit, int i3, Scheduler scheduler) {
        this.timespan = j3;
        this.timeshift = j16;
        this.unit = timeUnit;
        this.count = i3;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(serializedSubscriber, createWorker);
            exactSubscriber.add(createWorker);
            subscriber.add(exactSubscriber);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(serializedSubscriber, createWorker);
        inexactSubscriber.add(createWorker);
        subscriber.add(inexactSubscriber);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }
}
