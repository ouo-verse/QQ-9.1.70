package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    static final NotificationLite<Object> NL = NotificationLite.instance();
    final Scheduler scheduler;
    final int size;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CountedSerializedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        boolean emitting;
        List<Object> queue;
        final Scheduler.Worker worker;
        final Object guard = new Object();
        volatile State<T> state = State.empty();

        public ExactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker) {
            this.child = new SerializedSubscriber(subscriber);
            this.worker = worker;
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        void complete() {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
        
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean drain(List<Object> list) {
            if (list == null) {
                return true;
            }
            Iterator<Object> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next == OperatorWindowWithTime.NEXT_SUBJECT) {
                    if (!replaceSubject()) {
                        return false;
                    }
                } else {
                    NotificationLite<Object> notificationLite = OperatorWindowWithTime.NL;
                    if (notificationLite.isError(next)) {
                        error(notificationLite.getError(next));
                        break;
                    }
                    if (notificationLite.isCompleted(next)) {
                        complete();
                        break;
                    }
                    if (!emitValue(next)) {
                        return false;
                    }
                }
            }
        }

        boolean emitValue(T t16) {
            State<T> next;
            State<T> state = this.state;
            if (state.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                state = this.state;
            }
            state.consumer.onNext(t16);
            if (state.count == OperatorWindowWithTime.this.size - 1) {
                state.consumer.onCompleted();
                next = state.clear();
            } else {
                next = state.next();
            }
            this.state = next;
            return true;
        }

        void error(Throwable th5) {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onError(th5);
            }
            this.child.onError(th5);
            unsubscribe();
        }

        void nextWindow() {
            boolean z16;
            List<Object> list;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithTime.NEXT_SUBJECT);
                    return;
                }
                boolean z17 = true;
                this.emitting = true;
                try {
                    if (!replaceSubject()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.queue;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.queue = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    z17 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        z16 = z17;
                                        th = th6;
                                        if (!z16) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } while (drain(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    z16 = false;
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithTime.NL.completed());
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                this.emitting = true;
                try {
                    drain(list);
                    complete();
                } catch (Throwable th5) {
                    error(th5);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(OperatorWindowWithTime.NL.error(th5));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            List<Object> list;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t16);
                    return;
                }
                boolean z16 = true;
                this.emitting = true;
                try {
                    if (!emitValue(t16)) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.queue;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.queue = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    z16 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (!z16) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } while (drain(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    z16 = false;
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        boolean replaceSubject() {
            Observer<T> observer = this.state.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            UnicastSubject create = UnicastSubject.create();
            this.state = this.state.create(create, create);
            this.child.onNext(create);
            return true;
        }

        void scheduleExact() {
            Scheduler.Worker worker = this.worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.2
                @Override // rx.functions.Action0
                public void call() {
                    ExactSubscriber.this.nextWindow();
                }
            };
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            worker.schedulePeriodically(action0, 0L, operatorWindowWithTime.timespan, operatorWindowWithTime.unit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<CountedSerializedSubject<T>> chunks;
        boolean done;
        final Object guard;
        final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker) {
            super(subscriber);
            this.child = subscriber;
            this.worker = worker;
            this.guard = new Object();
            this.chunks = new LinkedList();
        }

        CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new CountedSerializedSubject<>(create, create);
        }

        @Override // rx.Observer
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.done = true;
                ArrayList arrayList = new ArrayList(this.chunks);
                this.chunks.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((CountedSerializedSubject) it.next()).consumer.onCompleted();
                }
                this.child.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.done = true;
                ArrayList arrayList = new ArrayList(this.chunks);
                this.chunks.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((CountedSerializedSubject) it.next()).consumer.onError(th5);
                }
                this.child.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                ArrayList<CountedSerializedSubject> arrayList = new ArrayList(this.chunks);
                Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                while (it.hasNext()) {
                    CountedSerializedSubject<T> next = it.next();
                    int i3 = next.count + 1;
                    next.count = i3;
                    if (i3 == OperatorWindowWithTime.this.size) {
                        it.remove();
                    }
                }
                for (CountedSerializedSubject countedSerializedSubject : arrayList) {
                    countedSerializedSubject.consumer.onNext(t16);
                    if (countedSerializedSubject.count == OperatorWindowWithTime.this.size) {
                        countedSerializedSubject.consumer.onCompleted();
                    }
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        void scheduleChunk() {
            Scheduler.Worker worker = this.worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            };
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            long j3 = operatorWindowWithTime.timeshift;
            worker.schedulePeriodically(action0, j3, j3, operatorWindowWithTime.unit);
        }

        void startNewChunk() {
            final CountedSerializedSubject<T> createCountedSerializedSubject = createCountedSerializedSubject();
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.chunks.add(createCountedSerializedSubject);
                try {
                    this.child.onNext(createCountedSerializedSubject.producer);
                    Scheduler.Worker worker = this.worker;
                    Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.2
                        @Override // rx.functions.Action0
                        public void call() {
                            InexactSubscriber.this.terminateChunk(createCountedSerializedSubject);
                        }
                    };
                    OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
                    worker.schedule(action0, operatorWindowWithTime.timespan, operatorWindowWithTime.unit);
                } catch (Throwable th5) {
                    onError(th5);
                }
            }
        }

        void terminateChunk(CountedSerializedSubject<T> countedSerializedSubject) {
            boolean z16;
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() == countedSerializedSubject) {
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
                    countedSerializedSubject.consumer.onCompleted();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class State<T> {
        static final State<Object> EMPTY = new State<>(null, null, 0);
        final Observer<T> consumer;
        final int count;
        final Observable<T> producer;

        public State(Observer<T> observer, Observable<T> observable, int i3) {
            this.consumer = observer;
            this.producer = observable;
            this.count = i3;
        }

        public static <T> State<T> empty() {
            return (State<T>) EMPTY;
        }

        public State<T> clear() {
            return empty();
        }

        public State<T> create(Observer<T> observer, Observable<T> observable) {
            return new State<>(observer, observable, 0);
        }

        public State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }
    }

    public OperatorWindowWithTime(long j3, long j16, TimeUnit timeUnit, int i3, Scheduler scheduler) {
        this.timespan = j3;
        this.timeshift = j16;
        this.unit = timeUnit;
        this.size = i3;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(subscriber, createWorker);
            exactSubscriber.add(createWorker);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(subscriber, createWorker);
        inexactSubscriber.add(createWorker);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }
}
