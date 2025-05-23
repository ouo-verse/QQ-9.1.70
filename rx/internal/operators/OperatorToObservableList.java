package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorToObservableList<T> implements Observable.Operator<List<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorToObservableList<Object> INSTANCE = new OperatorToObservableList<>();

        Holder() {
        }
    }

    OperatorToObservableList() {
    }

    public static <T> OperatorToObservableList<T> instance() {
        return (OperatorToObservableList<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorToObservableList.1
            boolean completed;
            List<T> list = new LinkedList();

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        ArrayList arrayList = new ArrayList(this.list);
                        this.list = null;
                        singleDelayedProducer.setValue(arrayList);
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, this);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                if (!this.completed) {
                    this.list.add(t16);
                }
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(singleDelayedProducer);
        return subscriber2;
    }
}
