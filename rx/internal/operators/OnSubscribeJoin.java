package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {
    final Observable<TLeft> left;
    final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
    final Func2<TLeft, TRight, R> resultSelector;
    final Observable<TRight> right;
    final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class ResultSink {
        boolean leftDone;
        int leftId;
        boolean rightDone;
        int rightId;
        final Subscriber<? super R> subscriber;
        final Object guard = new Object();
        final CompositeSubscription group = new CompositeSubscription();
        final Map<Integer, TLeft> leftMap = new HashMap();
        final Map<Integer, TRight> rightMap = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class LeftSubscriber extends Subscriber<TLeft> {

            /* compiled from: P */
            /* loaded from: classes29.dex */
            final class LeftDurationSubscriber extends Subscriber<TLeftDuration> {

                /* renamed from: id, reason: collision with root package name */
                final int f432668id;
                boolean once = true;

                public LeftDurationSubscriber(int i3) {
                    this.f432668id = i3;
                }

                @Override // rx.Observer
                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        LeftSubscriber.this.expire(this.f432668id, this);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th5) {
                    LeftSubscriber.this.onError(th5);
                }

                @Override // rx.Observer
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            LeftSubscriber() {
            }

            protected void expire(int i3, Subscription subscription) {
                boolean z16;
                synchronized (ResultSink.this.guard) {
                    if (ResultSink.this.leftMap.remove(Integer.valueOf(i3)) != null && ResultSink.this.leftMap.isEmpty() && ResultSink.this.leftDone) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                if (z16) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                } else {
                    ResultSink.this.group.remove(subscription);
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                boolean z16;
                synchronized (ResultSink.this.guard) {
                    ResultSink resultSink = ResultSink.this;
                    z16 = true;
                    resultSink.leftDone = true;
                    if (!resultSink.rightDone && !resultSink.leftMap.isEmpty()) {
                        z16 = false;
                    }
                }
                if (z16) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                } else {
                    ResultSink.this.group.remove(this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                ResultSink.this.subscriber.onError(th5);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(TLeft tleft) {
                int i3;
                ResultSink resultSink;
                int i16;
                synchronized (ResultSink.this.guard) {
                    ResultSink resultSink2 = ResultSink.this;
                    i3 = resultSink2.leftId;
                    resultSink2.leftId = i3 + 1;
                    resultSink2.leftMap.put(Integer.valueOf(i3), tleft);
                    resultSink = ResultSink.this;
                    i16 = resultSink.rightId;
                }
                try {
                    Observable<TLeftDuration> call = OnSubscribeJoin.this.leftDurationSelector.call(tleft);
                    LeftDurationSubscriber leftDurationSubscriber = new LeftDurationSubscriber(i3);
                    ResultSink.this.group.add(leftDurationSubscriber);
                    call.unsafeSubscribe(leftDurationSubscriber);
                    ArrayList arrayList = new ArrayList();
                    synchronized (ResultSink.this.guard) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i16) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(tleft, it.next()));
                    }
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public final class RightSubscriber extends Subscriber<TRight> {

            /* compiled from: P */
            /* loaded from: classes29.dex */
            final class RightDurationSubscriber extends Subscriber<TRightDuration> {

                /* renamed from: id, reason: collision with root package name */
                final int f432669id;
                boolean once = true;

                public RightDurationSubscriber(int i3) {
                    this.f432669id = i3;
                }

                @Override // rx.Observer
                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        RightSubscriber.this.expire(this.f432669id, this);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th5) {
                    RightSubscriber.this.onError(th5);
                }

                @Override // rx.Observer
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            RightSubscriber() {
            }

            void expire(int i3, Subscription subscription) {
                boolean z16;
                synchronized (ResultSink.this.guard) {
                    if (ResultSink.this.rightMap.remove(Integer.valueOf(i3)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                if (z16) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                } else {
                    ResultSink.this.group.remove(subscription);
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                boolean z16;
                synchronized (ResultSink.this.guard) {
                    ResultSink resultSink = ResultSink.this;
                    z16 = true;
                    resultSink.rightDone = true;
                    if (!resultSink.leftDone && !resultSink.rightMap.isEmpty()) {
                        z16 = false;
                    }
                }
                if (z16) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                } else {
                    ResultSink.this.group.remove(this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                ResultSink.this.subscriber.onError(th5);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(TRight tright) {
                int i3;
                int i16;
                synchronized (ResultSink.this.guard) {
                    ResultSink resultSink = ResultSink.this;
                    i3 = resultSink.rightId;
                    resultSink.rightId = i3 + 1;
                    resultSink.rightMap.put(Integer.valueOf(i3), tright);
                    i16 = ResultSink.this.leftId;
                }
                ResultSink.this.group.add(new SerialSubscription());
                try {
                    Observable<TRightDuration> call = OnSubscribeJoin.this.rightDurationSelector.call(tright);
                    RightDurationSubscriber rightDurationSubscriber = new RightDurationSubscriber(i3);
                    ResultSink.this.group.add(rightDurationSubscriber);
                    call.unsafeSubscribe(rightDurationSubscriber);
                    ArrayList arrayList = new ArrayList();
                    synchronized (ResultSink.this.guard) {
                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap.entrySet()) {
                            if (entry.getKey().intValue() < i16) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(it.next(), tright));
                    }
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this);
                }
            }
        }

        public ResultSink(Subscriber<? super R> subscriber) {
            this.subscriber = subscriber;
        }

        public void run() {
            this.subscriber.add(this.group);
            LeftSubscriber leftSubscriber = new LeftSubscriber();
            RightSubscriber rightSubscriber = new RightSubscriber();
            this.group.add(leftSubscriber);
            this.group.add(rightSubscriber);
            OnSubscribeJoin.this.left.unsafeSubscribe(leftSubscriber);
            OnSubscribeJoin.this.right.unsafeSubscribe(rightSubscriber);
        }
    }

    public OnSubscribeJoin(Observable<TLeft> observable, Observable<TRight> observable2, Func1<TLeft, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<TLeft, TRight, R> func2) {
        this.left = observable;
        this.right = observable2;
        this.leftDurationSelector = func1;
        this.rightDurationSelector = func12;
        this.resultSelector = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        new ResultSink(new SerializedSubscriber(subscriber)).run();
    }
}
