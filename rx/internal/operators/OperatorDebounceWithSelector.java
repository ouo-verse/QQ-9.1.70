package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorDebounceWithSelector<T, U> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<U>> selector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: rx.internal.operators.OperatorDebounceWithSelector$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class AnonymousClass1 extends Subscriber<T> {
        final Subscriber<?> self;
        final OperatorDebounceWithTime.DebounceState<T> state;
        final /* synthetic */ SerializedSubscriber val$s;
        final /* synthetic */ SerialSubscription val$ssub;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Subscriber subscriber, SerializedSubscriber serializedSubscriber, SerialSubscription serialSubscription) {
            super(subscriber);
            this.val$s = serializedSubscriber;
            this.val$ssub = serialSubscription;
            this.state = new OperatorDebounceWithTime.DebounceState<>();
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
            try {
                Observable<U> call = OperatorDebounceWithSelector.this.selector.call(t16);
                final int next = this.state.next(t16);
                Subscriber<U> subscriber = new Subscriber<U>() { // from class: rx.internal.operators.OperatorDebounceWithSelector.1.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.state.emit(next, anonymousClass1.val$s, anonymousClass1.self);
                        unsubscribe();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        AnonymousClass1.this.self.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(U u16) {
                        onCompleted();
                    }
                };
                this.val$ssub.set(subscriber);
                call.unsafeSubscribe(subscriber);
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, this);
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> func1) {
        this.selector = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        return new AnonymousClass1(subscriber, serializedSubscriber, serialSubscription);
    }
}
