package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorMaterialize<T> implements Observable.Operator<Notification<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();

        Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ParentSubscriber<T> extends Subscriber<T> {
        private boolean busy;
        private final Subscriber<? super Notification<T>> child;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();
        private volatile Notification<T> terminalNotification;

        ParentSubscriber(Subscriber<? super Notification<T>> subscriber) {
            this.child = subscriber;
        }

        private void decrementRequested() {
            long j3;
            AtomicLong atomicLong = this.requested;
            do {
                j3 = atomicLong.get();
                if (j3 == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j3, j3 - 1));
        }

        private void drain() {
            synchronized (this) {
                if (this.busy) {
                    this.missed = true;
                    return;
                }
                AtomicLong atomicLong = this.requested;
                while (!this.child.isUnsubscribed()) {
                    Notification<T> notification = this.terminalNotification;
                    if (notification != null && atomicLong.get() > 0) {
                        this.terminalNotification = null;
                        this.child.onNext(notification);
                        if (!this.child.isUnsubscribed()) {
                            this.child.onCompleted();
                            return;
                        }
                        return;
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            this.busy = false;
                            return;
                        }
                    }
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.terminalNotification = Notification.createOnCompleted();
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.terminalNotification = Notification.createOnError(th5);
            RxJavaHooks.onError(th5);
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.child.onNext(Notification.createOnNext(t16));
            decrementRequested();
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0L);
        }

        void requestMore(long j3) {
            BackpressureUtils.getAndAddRequest(this.requested, j3);
            request(j3);
            drain();
        }
    }

    OperatorMaterialize() {
    }

    public static <T> OperatorMaterialize<T> instance() {
        return (OperatorMaterialize<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorMaterialize.1
            @Override // rx.Producer
            public void request(long j3) {
                if (j3 > 0) {
                    parentSubscriber.requestMore(j3);
                }
            }
        });
        return parentSubscriber;
    }
}
