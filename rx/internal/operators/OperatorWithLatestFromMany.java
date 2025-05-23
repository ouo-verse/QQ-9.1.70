package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorWithLatestFromMany<T, R> implements Observable.OnSubscribe<R> {
    final FuncN<R> combiner;
    final Observable<T> main;
    final Observable<?>[] others;
    final Iterable<Observable<?>> othersIterable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WithLatestMainSubscriber<T, R> extends Subscriber<T> {
        static final Object EMPTY = new Object();
        final Subscriber<? super R> actual;
        final FuncN<R> combiner;
        final AtomicReferenceArray<Object> current;
        boolean done;
        final AtomicInteger ready;

        public WithLatestMainSubscriber(Subscriber<? super R> subscriber, FuncN<R> funcN, int i3) {
            this.actual = subscriber;
            this.combiner = funcN;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i3 + 1);
            for (int i16 = 0; i16 <= i3; i16++) {
                atomicReferenceArray.lazySet(i16, EMPTY);
            }
            this.current = atomicReferenceArray;
            this.ready = new AtomicInteger(i3);
            request(0L);
        }

        void innerComplete(int i3) {
            if (this.current.get(i3) == EMPTY) {
                onCompleted();
            }
        }

        void innerError(int i3, Throwable th5) {
            onError(th5);
        }

        void innerNext(int i3, Object obj) {
            if (this.current.getAndSet(i3, obj) == EMPTY) {
                this.ready.decrementAndGet();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (this.done) {
                return;
            }
            if (this.ready.get() == 0) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.current;
                int length = atomicReferenceArray.length();
                atomicReferenceArray.lazySet(0, t16);
                Object[] objArr = new Object[atomicReferenceArray.length()];
                for (int i3 = 0; i3 < length; i3++) {
                    objArr[i3] = atomicReferenceArray.get(i3);
                }
                try {
                    this.actual.onNext(this.combiner.call(objArr));
                    return;
                } catch (Throwable th5) {
                    Exceptions.throwIfFatal(th5);
                    onError(th5);
                    return;
                }
            }
            request(1L);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.actual.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WithLatestOtherSubscriber extends Subscriber<Object> {
        final int index;
        final WithLatestMainSubscriber<?, ?> parent;

        public WithLatestOtherSubscriber(WithLatestMainSubscriber<?, ?> withLatestMainSubscriber, int i3) {
            this.parent = withLatestMainSubscriber;
            this.index = i3;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.innerComplete(this.index);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.parent.innerError(this.index, th5);
        }

        @Override // rx.Observer
        public void onNext(Object obj) {
            this.parent.innerNext(this.index, obj);
        }
    }

    public OperatorWithLatestFromMany(Observable<T> observable, Observable<?>[] observableArr, Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        this.main = observable;
        this.others = observableArr;
        this.othersIterable = iterable;
        this.combiner = funcN;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        int i3;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Observable<?>[] observableArr = this.others;
        int i16 = 0;
        if (observableArr != null) {
            i3 = observableArr.length;
        } else {
            observableArr = new Observable[8];
            int i17 = 0;
            for (Observable<?> observable : this.othersIterable) {
                if (i17 == observableArr.length) {
                    observableArr = (Observable[]) Arrays.copyOf(observableArr, (i17 >> 2) + i17);
                }
                observableArr[i17] = observable;
                i17++;
            }
            i3 = i17;
        }
        WithLatestMainSubscriber withLatestMainSubscriber = new WithLatestMainSubscriber(subscriber, this.combiner, i3);
        serializedSubscriber.add(withLatestMainSubscriber);
        while (i16 < i3) {
            if (serializedSubscriber.isUnsubscribed()) {
                return;
            }
            int i18 = i16 + 1;
            WithLatestOtherSubscriber withLatestOtherSubscriber = new WithLatestOtherSubscriber(withLatestMainSubscriber, i18);
            withLatestMainSubscriber.add(withLatestOtherSubscriber);
            observableArr[i16].unsafeSubscribe(withLatestOtherSubscriber);
            i16 = i18;
        }
        this.main.unsafeSubscribe(withLatestMainSubscriber);
    }
}
