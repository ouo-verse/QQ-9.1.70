package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SingleOnSubscribeMap<T, R> implements Single.OnSubscribe<R> {
    final Single<T> source;
    final Func1<? super T, ? extends R> transformer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MapSubscriber<T, R> extends SingleSubscriber<T> {
        final SingleSubscriber<? super R> actual;
        boolean done;
        final Func1<? super T, ? extends R> mapper;

        public MapSubscriber(SingleSubscriber<? super R> singleSubscriber, Func1<? super T, ? extends R> func1) {
            this.actual = singleSubscriber;
            this.mapper = func1;
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
            } else {
                this.done = true;
                this.actual.onError(th5);
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t16) {
            try {
                this.actual.onSuccess(this.mapper.call(t16));
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th5, t16));
            }
        }
    }

    public SingleOnSubscribeMap(Single<T> single, Func1<? super T, ? extends R> func1) {
        this.source = single;
        this.transformer = func1;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super R> singleSubscriber) {
        MapSubscriber mapSubscriber = new MapSubscriber(singleSubscriber, this.transformer);
        singleSubscriber.add(mapSubscriber);
        this.source.subscribe(mapSubscriber);
    }
}
