package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.functions.Functions;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorZip<R> implements Observable.Operator<R, Observable<?>[]> {
    final FuncN<? extends R> zipFunction;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Zip<R> extends AtomicLong {
        static final int THRESHOLD = (int) (RxRingBuffer.SIZE * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        final Observer<? super R> child;
        private final CompositeSubscription childSubscription;
        int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class InnerSubscriber extends Subscriber {
            final RxRingBuffer items = RxRingBuffer.getSpmcInstance();

            InnerSubscriber() {
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.items.onCompleted();
                Zip.this.tick();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                Zip.this.child.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(Object obj) {
                try {
                    this.items.onNext(obj);
                } catch (MissingBackpressureException e16) {
                    onError(e16);
                }
                Zip.this.tick();
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(RxRingBuffer.SIZE);
            }

            public void requestMore(long j3) {
                request(j3);
            }
        }

        public Zip(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.childSubscription = compositeSubscription;
            this.child = subscriber;
            this.zipFunction = funcN;
            subscriber.add(compositeSubscription);
        }

        public void start(Observable[] observableArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[observableArr.length];
            for (int i3 = 0; i3 < observableArr.length; i3++) {
                InnerSubscriber innerSubscriber = new InnerSubscriber();
                objArr[i3] = innerSubscriber;
                this.childSubscription.add(innerSubscriber);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i16 = 0; i16 < observableArr.length; i16++) {
                observableArr[i16].unsafeSubscribe((InnerSubscriber) objArr[i16]);
            }
        }

        void tick() {
            Object[] objArr = this.subscribers;
            if (objArr != null && getAndIncrement() == 0) {
                int length = objArr.length;
                Observer<? super R> observer = this.child;
                AtomicLong atomicLong = this.requested;
                while (true) {
                    Object[] objArr2 = new Object[length];
                    boolean z16 = true;
                    for (int i3 = 0; i3 < length; i3++) {
                        RxRingBuffer rxRingBuffer = ((InnerSubscriber) objArr[i3]).items;
                        Object peek = rxRingBuffer.peek();
                        if (peek == null) {
                            z16 = false;
                        } else {
                            if (rxRingBuffer.isCompleted(peek)) {
                                observer.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                            objArr2[i3] = rxRingBuffer.getValue(peek);
                        }
                    }
                    if (atomicLong.get() > 0 && z16) {
                        try {
                            observer.onNext(this.zipFunction.call(objArr2));
                            atomicLong.decrementAndGet();
                            this.emitted++;
                            for (Object obj : objArr) {
                                RxRingBuffer rxRingBuffer2 = ((InnerSubscriber) obj).items;
                                rxRingBuffer2.poll();
                                if (rxRingBuffer2.isCompleted(rxRingBuffer2.peek())) {
                                    observer.onCompleted();
                                    this.childSubscription.unsubscribe();
                                    return;
                                }
                            }
                            if (this.emitted > THRESHOLD) {
                                for (Object obj2 : objArr) {
                                    ((InnerSubscriber) obj2).requestMore(this.emitted);
                                }
                                this.emitted = 0;
                            }
                        } catch (Throwable th5) {
                            Exceptions.throwOrReport(th5, observer, objArr2);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ZipProducer<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        final Zip<R> zipper;

        public ZipProducer(Zip<R> zip) {
            this.zipper = zip;
        }

        @Override // rx.Producer
        public void request(long j3) {
            BackpressureUtils.getAndAddRequest(this, j3);
            this.zipper.tick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class ZipSubscriber extends Subscriber<Observable[]> {
        final Subscriber<? super R> child;
        final ZipProducer<R> producer;
        boolean started;
        final Zip<R> zipper;

        public ZipSubscriber(Subscriber<? super R> subscriber, Zip<R> zip, ZipProducer<R> zipProducer) {
            this.child = subscriber;
            this.zipper = zip;
            this.producer = zipProducer;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.started) {
                this.child.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.child.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(Observable[] observableArr) {
            if (observableArr != null && observableArr.length != 0) {
                this.started = true;
                this.zipper.start(observableArr, this.producer);
            } else {
                this.child.onCompleted();
            }
        }
    }

    public OperatorZip(FuncN<? extends R> funcN) {
        this.zipFunction = funcN;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Observable[]> call(Subscriber<? super R> subscriber) {
        Zip zip = new Zip(subscriber, this.zipFunction);
        ZipProducer zipProducer = new ZipProducer(zip);
        ZipSubscriber zipSubscriber = new ZipSubscriber(subscriber, zip, zipProducer);
        subscriber.add(zipSubscriber);
        subscriber.setProducer(zipProducer);
        return zipSubscriber;
    }

    public OperatorZip(Func2 func2) {
        this.zipFunction = Functions.fromFunc(func2);
    }

    public OperatorZip(Func3 func3) {
        this.zipFunction = Functions.fromFunc(func3);
    }

    public OperatorZip(Func4 func4) {
        this.zipFunction = Functions.fromFunc(func4);
    }

    public OperatorZip(Func5 func5) {
        this.zipFunction = Functions.fromFunc(func5);
    }

    public OperatorZip(Func6 func6) {
        this.zipFunction = Functions.fromFunc(func6);
    }

    public OperatorZip(Func7 func7) {
        this.zipFunction = Functions.fromFunc(func7);
    }

    public OperatorZip(Func8 func8) {
        this.zipFunction = Functions.fromFunc(func8);
    }

    public OperatorZip(Func9 func9) {
        this.zipFunction = Functions.fromFunc(func9);
    }
}
