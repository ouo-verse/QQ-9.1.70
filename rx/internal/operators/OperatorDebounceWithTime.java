package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorDebounceWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: rx.internal.operators.OperatorDebounceWithTime$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class AnonymousClass1 extends Subscriber<T> {
        final Subscriber<?> self;
        final DebounceState<T> state;
        final /* synthetic */ SerializedSubscriber val$s;
        final /* synthetic */ SerialSubscription val$ssub;
        final /* synthetic */ Scheduler.Worker val$worker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Subscriber subscriber, SerialSubscription serialSubscription, Scheduler.Worker worker, SerializedSubscriber serializedSubscriber) {
            super(subscriber);
            this.val$ssub = serialSubscription;
            this.val$worker = worker;
            this.val$s = serializedSubscriber;
            this.state = new DebounceState<>();
            this.self = this;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.emitAndComplete(this.val$s, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.val$s.onError(th5);
            unsubscribe();
            this.state.clear();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            final int next = this.state.next(t16);
            SerialSubscription serialSubscription = this.val$ssub;
            Scheduler.Worker worker = this.val$worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorDebounceWithTime.1.1
                @Override // rx.functions.Action0
                public void call() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.state.emit(next, anonymousClass1.val$s, anonymousClass1.self);
                }
            };
            OperatorDebounceWithTime operatorDebounceWithTime = OperatorDebounceWithTime.this;
            serialSubscription.set(worker.schedule(action0, operatorDebounceWithTime.timeout, operatorDebounceWithTime.unit));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DebounceState<T> {
        boolean emitting;
        boolean hasValue;
        int index;
        boolean terminate;
        T value;

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }

        public void emit(int i3, Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (!this.emitting && this.hasValue && i3 == this.index) {
                    T t16 = this.value;
                    this.value = null;
                    this.hasValue = false;
                    this.emitting = true;
                    try {
                        subscriber.onNext(t16);
                        synchronized (this) {
                            if (!this.terminate) {
                                this.emitting = false;
                            } else {
                                subscriber.onCompleted();
                            }
                        }
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, subscriber2, t16);
                    }
                }
            }
        }

        public void emitAndComplete(Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (this.emitting) {
                    this.terminate = true;
                    return;
                }
                T t16 = this.value;
                boolean z16 = this.hasValue;
                this.value = null;
                this.hasValue = false;
                this.emitting = true;
                if (z16) {
                    try {
                        subscriber.onNext(t16);
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, subscriber2, t16);
                        return;
                    }
                }
                subscriber.onCompleted();
            }
        }

        public synchronized int next(T t16) {
            int i3;
            this.value = t16;
            this.hasValue = true;
            i3 = this.index + 1;
            this.index = i3;
            return i3;
        }
    }

    public OperatorDebounceWithTime(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeout = j3;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(createWorker);
        serializedSubscriber.add(serialSubscription);
        return new AnonymousClass1(subscriber, serialSubscription, createWorker, serializedSubscriber);
    }
}
