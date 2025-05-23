package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.Operator<List<T>, T> {
    final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    final int initialCapacity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        void emit() {
            synchronized (this) {
                if (this.done) {
                    return;
                }
                List<T> list = this.chunk;
                this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
                try {
                    this.child.onNext(list);
                } catch (Throwable th5) {
                    unsubscribe();
                    synchronized (this) {
                        if (this.done) {
                            return;
                        }
                        this.done = true;
                        Exceptions.throwOrReport(th5, this.child);
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
            synchronized (this) {
                if (this.done) {
                    return;
                }
                this.chunk.add(t16);
            }
        }
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> func0, int i3) {
        this.bufferClosingSelector = func0;
        this.initialCapacity = i3;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        try {
            Observable<? extends TClosing> call = this.bufferClosingSelector.call();
            final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
            Subscriber<TClosing> subscriber2 = new Subscriber<TClosing>() { // from class: rx.internal.operators.OperatorBufferWithSingleObservable.2
                @Override // rx.Observer
                public void onCompleted() {
                    bufferingSubscriber.onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable th5) {
                    bufferingSubscriber.onError(th5);
                }

                @Override // rx.Observer
                public void onNext(TClosing tclosing) {
                    bufferingSubscriber.emit();
                }
            };
            subscriber.add(subscriber2);
            subscriber.add(bufferingSubscriber);
            call.unsafeSubscribe(subscriber2);
            return bufferingSubscriber;
        } catch (Throwable th5) {
            Exceptions.throwOrReport(th5, subscriber);
            return Subscribers.empty();
        }
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> observable, int i3) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() { // from class: rx.internal.operators.OperatorBufferWithSingleObservable.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<? extends TClosing> call() {
                return observable;
            }
        };
        this.initialCapacity = i3;
    }
}
