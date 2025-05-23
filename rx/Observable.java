package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.AsyncEmitter;
import rx.BackpressureOverflow;
import rx.annotations.Beta;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
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
import rx.internal.operators.CachedObservable;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeAmb;
import rx.internal.operators.OnSubscribeCollect;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeConcatMap;
import rx.internal.operators.OnSubscribeDefer;
import rx.internal.operators.OnSubscribeDelaySubscription;
import rx.internal.operators.OnSubscribeDelaySubscriptionOther;
import rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector;
import rx.internal.operators.OnSubscribeDetach;
import rx.internal.operators.OnSubscribeFilter;
import rx.internal.operators.OnSubscribeFlattenIterable;
import rx.internal.operators.OnSubscribeFromArray;
import rx.internal.operators.OnSubscribeFromAsync;
import rx.internal.operators.OnSubscribeFromCallable;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OnSubscribeGroupJoin;
import rx.internal.operators.OnSubscribeJoin;
import rx.internal.operators.OnSubscribeLift;
import rx.internal.operators.OnSubscribeMap;
import rx.internal.operators.OnSubscribeRange;
import rx.internal.operators.OnSubscribeRedo;
import rx.internal.operators.OnSubscribeReduce;
import rx.internal.operators.OnSubscribeReduceSeed;
import rx.internal.operators.OnSubscribeSingle;
import rx.internal.operators.OnSubscribeTakeLastOne;
import rx.internal.operators.OnSubscribeThrow;
import rx.internal.operators.OnSubscribeTimerOnce;
import rx.internal.operators.OnSubscribeTimerPeriodically;
import rx.internal.operators.OnSubscribeToObservableFuture;
import rx.internal.operators.OnSubscribeUsing;
import rx.internal.operators.OperatorAll;
import rx.internal.operators.OperatorAny;
import rx.internal.operators.OperatorAsObservable;
import rx.internal.operators.OperatorBufferWithSingleObservable;
import rx.internal.operators.OperatorBufferWithSize;
import rx.internal.operators.OperatorBufferWithStartEndObservable;
import rx.internal.operators.OperatorBufferWithTime;
import rx.internal.operators.OperatorCast;
import rx.internal.operators.OperatorDebounceWithSelector;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.internal.operators.OperatorDelay;
import rx.internal.operators.OperatorDelayWithSelector;
import rx.internal.operators.OperatorDematerialize;
import rx.internal.operators.OperatorDistinct;
import rx.internal.operators.OperatorDistinctUntilChanged;
import rx.internal.operators.OperatorDoAfterTerminate;
import rx.internal.operators.OperatorDoOnEach;
import rx.internal.operators.OperatorDoOnRequest;
import rx.internal.operators.OperatorDoOnSubscribe;
import rx.internal.operators.OperatorDoOnUnsubscribe;
import rx.internal.operators.OperatorEagerConcatMap;
import rx.internal.operators.OperatorElementAt;
import rx.internal.operators.OperatorGroupBy;
import rx.internal.operators.OperatorIgnoreElements;
import rx.internal.operators.OperatorMapNotification;
import rx.internal.operators.OperatorMapPair;
import rx.internal.operators.OperatorMaterialize;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnBackpressureBuffer;
import rx.internal.operators.OperatorOnBackpressureDrop;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import rx.internal.operators.OperatorPublish;
import rx.internal.operators.OperatorReplay;
import rx.internal.operators.OperatorRetryWithPredicate;
import rx.internal.operators.OperatorSampleWithObservable;
import rx.internal.operators.OperatorSampleWithTime;
import rx.internal.operators.OperatorScan;
import rx.internal.operators.OperatorSequenceEqual;
import rx.internal.operators.OperatorSerialize;
import rx.internal.operators.OperatorSingle;
import rx.internal.operators.OperatorSkip;
import rx.internal.operators.OperatorSkipLast;
import rx.internal.operators.OperatorSkipLastTimed;
import rx.internal.operators.OperatorSkipTimed;
import rx.internal.operators.OperatorSkipUntil;
import rx.internal.operators.OperatorSkipWhile;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorSwitch;
import rx.internal.operators.OperatorSwitchIfEmpty;
import rx.internal.operators.OperatorTake;
import rx.internal.operators.OperatorTakeLast;
import rx.internal.operators.OperatorTakeLastTimed;
import rx.internal.operators.OperatorTakeTimed;
import rx.internal.operators.OperatorTakeUntil;
import rx.internal.operators.OperatorTakeUntilPredicate;
import rx.internal.operators.OperatorTakeWhile;
import rx.internal.operators.OperatorThrottleFirst;
import rx.internal.operators.OperatorTimeInterval;
import rx.internal.operators.OperatorTimeout;
import rx.internal.operators.OperatorTimeoutWithSelector;
import rx.internal.operators.OperatorTimestamp;
import rx.internal.operators.OperatorToMap;
import rx.internal.operators.OperatorToMultimap;
import rx.internal.operators.OperatorToObservableList;
import rx.internal.operators.OperatorToObservableSortedList;
import rx.internal.operators.OperatorUnsubscribeOn;
import rx.internal.operators.OperatorWindowWithObservable;
import rx.internal.operators.OperatorWindowWithObservableFactory;
import rx.internal.operators.OperatorWindowWithSize;
import rx.internal.operators.OperatorWindowWithStartEndObservable;
import rx.internal.operators.OperatorWindowWithTime;
import rx.internal.operators.OperatorWithLatestFrom;
import rx.internal.operators.OperatorWithLatestFromMany;
import rx.internal.operators.OperatorZip;
import rx.internal.operators.OperatorZipIterable;
import rx.internal.util.ActionNotificationObserver;
import rx.internal.util.ActionSubscriber;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ObserverSubscriber;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.observables.AsyncOnSubscribe;
import rx.observables.BlockingObservable;
import rx.observables.ConnectableObservable;
import rx.observables.GroupedObservable;
import rx.observables.SyncOnSubscribe;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.schedulers.TimeInterval;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Observable<T> {
    final OnSubscribe<T> onSubscribe;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface OnSubscribe<T> extends Action1<Subscriber<? super T>> {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class OnSubscribeExtend<T> implements OnSubscribe<T> {
        final Observable<T> parent;

        OnSubscribeExtend(Observable<T> observable) {
            this.parent = observable;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            subscriber.add(Observable.subscribe(subscriber, this.parent));
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Transformer<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> amb(Iterable<? extends Observable<? extends T>> iterable) {
        return create(OnSubscribeAmb.amb(iterable));
    }

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return combineLatest(Arrays.asList(observable, observable2), Functions.fromFunc(func2));
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        return create(new OnSubscribeCombineLatest(null, iterable, funcN, RxRingBuffer.SIZE, true));
    }

    public static <T> Observable<T> concat(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.concatMap(UtilityFunctions.identity());
    }

    @Experimental
    public static <T> Observable<T> concatDelayError(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.concatMapDelayError(UtilityFunctions.identity());
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return concatEager(Arrays.asList(observable, observable2));
    }

    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<>(RxJavaHooks.onCreate(onSubscribe));
    }

    public static <T> Observable<T> defer(Func0<Observable<T>> func0) {
        return create(new OnSubscribeDefer(func0));
    }

    public static <T> Observable<T> empty() {
        return EmptyObservableHolder.instance();
    }

    public static <T> Observable<T> error(Throwable th5) {
        return create(new OnSubscribeThrow(th5));
    }

    public static <T> Observable<T> from(Future<? extends T> future) {
        return create(OnSubscribeToObservableFuture.toObservableFuture(future));
    }

    @Experimental
    public static <T> Observable<T> fromAsync(Action1<AsyncEmitter<T>> action1, AsyncEmitter.BackpressureMode backpressureMode) {
        return create(new OnSubscribeFromAsync(action1, backpressureMode));
    }

    @Beta
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        return create(new OnSubscribeFromCallable(callable));
    }

    public static Observable<Long> interval(long j3, TimeUnit timeUnit) {
        return interval(j3, j3, timeUnit, Schedulers.computation());
    }

    public static <T> Observable<T> just(T t16) {
        return ScalarSynchronousObservable.create(t16);
    }

    private <R> Observable<R> mapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        return lift(new OperatorMapNotification(func1, func12, func0));
    }

    public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> iterable) {
        return merge(from(iterable));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.lift(OperatorMerge.instance(true));
    }

    public static <T> Observable<T> never() {
        return NeverObservableHolder.instance();
    }

    public static Observable<Integer> range(int i3, int i16) {
        if (i16 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (i16 == 0) {
            return empty();
        }
        if (i3 > (Integer.MAX_VALUE - i16) + 1) {
            throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
        }
        if (i16 == 1) {
            return just(Integer.valueOf(i3));
        }
        return create(new OnSubscribeRange(i3, (i16 - 1) + i3));
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return sequenceEqual(observable, observable2, InternalObservableUtils.OBJECT_EQUALS);
    }

    public static <T> Observable<T> switchOnNext(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.lift(OperatorSwitch.instance(false));
    }

    @Experimental
    public static <T> Observable<T> switchOnNextDelayError(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.lift(OperatorSwitch.instance(true));
    }

    @Deprecated
    public static Observable<Long> timer(long j3, long j16, TimeUnit timeUnit) {
        return interval(j3, j16, timeUnit, Schedulers.computation());
    }

    public static <T, Resource> Observable<T> using(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1) {
        return using(func0, func1, action1, false);
    }

    public static <R> Observable<R> zip(Iterable<? extends Observable<?>> iterable, FuncN<? extends R> funcN) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Observable<?>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return just(arrayList.toArray(new Observable[arrayList.size()])).lift(new OperatorZip(funcN));
    }

    public final Observable<Boolean> all(Func1<? super T, Boolean> func1) {
        return lift(new OperatorAll(func1));
    }

    public final Observable<T> ambWith(Observable<? extends T> observable) {
        return amb(this, observable);
    }

    public final Observable<T> asObservable() {
        return (Observable<T>) lift(OperatorAsObservable.instance());
    }

    public final <TClosing> Observable<List<T>> buffer(Func0<? extends Observable<? extends TClosing>> func0) {
        return (Observable<List<T>>) lift(new OperatorBufferWithSingleObservable(func0, 16));
    }

    public final Observable<T> cache() {
        return CachedObservable.from(this);
    }

    public final Observable<T> cacheWithInitialCapacity(int i3) {
        return CachedObservable.from(this, i3);
    }

    public final <R> Observable<R> cast(Class<R> cls) {
        return lift(new OperatorCast(cls));
    }

    public final <R> Observable<R> collect(Func0<R> func0, Action2<R, ? super T> action2) {
        return create(new OnSubscribeCollect(this, func0, action2));
    }

    public <R> Observable<R> compose(Transformer<? super T, ? extends R> transformer) {
        return (Observable) transformer.call(this);
    }

    public final <R> Observable<R> concatMap(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return create(new OnSubscribeConcatMap(this, func1, 2, 0));
    }

    @Experimental
    public final <R> Observable<R> concatMapDelayError(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return create(new OnSubscribeConcatMap(this, func1, 2, 2));
    }

    @Experimental
    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return concatMapEager(func1, RxRingBuffer.SIZE);
    }

    public final <R> Observable<R> concatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> func1) {
        return OnSubscribeFlattenIterable.createFrom(this, func1, RxRingBuffer.SIZE);
    }

    public final Observable<T> concatWith(Observable<? extends T> observable) {
        return concat(this, observable);
    }

    public final Observable<Boolean> contains(Object obj) {
        return exists(InternalObservableUtils.equalsWith(obj));
    }

    public final Observable<Integer> count() {
        return reduce(0, InternalObservableUtils.COUNTER);
    }

    public final Observable<Long> countLong() {
        return reduce(0L, InternalObservableUtils.LONG_COUNTER);
    }

    public final <U> Observable<T> debounce(Func1<? super T, ? extends Observable<U>> func1) {
        return (Observable<T>) lift(new OperatorDebounceWithSelector(func1));
    }

    public final Observable<T> defaultIfEmpty(T t16) {
        return switchIfEmpty(just(t16));
    }

    public final <U, V> Observable<T> delay(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1) {
        return (Observable<T>) delaySubscription(func0).lift(new OperatorDelayWithSelector(this, func1));
    }

    public final Observable<T> delaySubscription(long j3, TimeUnit timeUnit) {
        return delaySubscription(j3, timeUnit, Schedulers.computation());
    }

    public final <T2> Observable<T2> dematerialize() {
        return (Observable<T2>) lift(OperatorDematerialize.instance());
    }

    public final Observable<T> distinct() {
        return (Observable<T>) lift(OperatorDistinct.instance());
    }

    public final Observable<T> distinctUntilChanged() {
        return (Observable<T>) lift(OperatorDistinctUntilChanged.instance());
    }

    public final Observable<T> doAfterTerminate(Action0 action0) {
        return (Observable<T>) lift(new OperatorDoAfterTerminate(action0));
    }

    public final Observable<T> doOnCompleted(Action0 action0) {
        return (Observable<T>) lift(new OperatorDoOnEach(new ActionSubscriber(Actions.empty(), Actions.empty(), action0)));
    }

    public final Observable<T> doOnEach(Action1<Notification<? super T>> action1) {
        return (Observable<T>) lift(new OperatorDoOnEach(new ActionNotificationObserver(action1)));
    }

    public final Observable<T> doOnError(Action1<Throwable> action1) {
        return (Observable<T>) lift(new OperatorDoOnEach(new ActionSubscriber(Actions.empty(), action1, Actions.empty())));
    }

    public final Observable<T> doOnNext(Action1<? super T> action1) {
        return (Observable<T>) lift(new OperatorDoOnEach(new ActionSubscriber(action1, Actions.empty(), Actions.empty())));
    }

    @Beta
    public final Observable<T> doOnRequest(Action1<Long> action1) {
        return (Observable<T>) lift(new OperatorDoOnRequest(action1));
    }

    public final Observable<T> doOnSubscribe(Action0 action0) {
        return (Observable<T>) lift(new OperatorDoOnSubscribe(action0));
    }

    public final Observable<T> doOnTerminate(Action0 action0) {
        return (Observable<T>) lift(new OperatorDoOnEach(new ActionSubscriber(Actions.empty(), Actions.toAction1(action0), action0)));
    }

    public final Observable<T> doOnUnsubscribe(Action0 action0) {
        return (Observable<T>) lift(new OperatorDoOnUnsubscribe(action0));
    }

    public final Observable<T> elementAt(int i3) {
        return (Observable<T>) lift(new OperatorElementAt(i3));
    }

    public final Observable<T> elementAtOrDefault(int i3, T t16) {
        return (Observable<T>) lift(new OperatorElementAt(i3, t16));
    }

    public final Observable<Boolean> exists(Func1<? super T, Boolean> func1) {
        return lift(new OperatorAny(func1, false));
    }

    @Experimental
    public <R> R extend(Func1<? super OnSubscribe<T>, ? extends R> func1) {
        return func1.call(new OnSubscribeExtend(this));
    }

    public final Observable<T> filter(Func1<? super T, Boolean> func1) {
        return create(new OnSubscribeFilter(this, func1));
    }

    @Deprecated
    public final Observable<T> finallyDo(Action0 action0) {
        return (Observable<T>) lift(new OperatorDoAfterTerminate(action0));
    }

    public final Observable<T> first() {
        return take(1).single();
    }

    public final Observable<T> firstOrDefault(T t16) {
        return take(1).singleOrDefault(t16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return merge(map(func1));
    }

    public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> func1) {
        return flatMapIterable(func1, RxRingBuffer.SIZE);
    }

    public final void forEach(Action1<? super T> action1) {
        subscribe(action1);
    }

    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12) {
        return lift(new OperatorGroupBy(func1, func12));
    }

    public final <T2, D1, D2, R> Observable<R> groupJoin(Observable<T2> observable, Func1<? super T, ? extends Observable<D1>> func1, Func1<? super T2, ? extends Observable<D2>> func12, Func2<? super T, ? super Observable<T2>, ? extends R> func2) {
        return create(new OnSubscribeGroupJoin(this, observable, func1, func12, func2));
    }

    public final Observable<T> ignoreElements() {
        return (Observable<T>) lift(OperatorIgnoreElements.instance());
    }

    public final Observable<Boolean> isEmpty() {
        return lift(InternalObservableUtils.IS_EMPTY);
    }

    public final <TRight, TLeftDuration, TRightDuration, R> Observable<R> join(Observable<TRight> observable, Func1<T, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<T, TRight, R> func2) {
        return create(new OnSubscribeJoin(this, observable, func1, func12, func2));
    }

    public final Observable<T> last() {
        return takeLast(1).single();
    }

    public final Observable<T> lastOrDefault(T t16) {
        return takeLast(1).singleOrDefault(t16);
    }

    public final <R> Observable<R> lift(Operator<? extends R, ? super T> operator) {
        return create(new OnSubscribeLift(this.onSubscribe, operator));
    }

    public final Observable<T> limit(int i3) {
        return take(i3);
    }

    public final <R> Observable<R> map(Func1<? super T, ? extends R> func1) {
        return create(new OnSubscribeMap(this, func1));
    }

    public final Observable<Notification<T>> materialize() {
        return (Observable<Notification<T>>) lift(OperatorMaterialize.instance());
    }

    public final Observable<T> mergeWith(Observable<? extends T> observable) {
        return merge(this, observable);
    }

    public final Observable<Observable<T>> nest() {
        return just(this);
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, RxRingBuffer.SIZE);
    }

    public final <R> Observable<R> ofType(Class<R> cls) {
        return filter(InternalObservableUtils.isInstanceOf(cls)).cast(cls);
    }

    public final Observable<T> onBackpressureBuffer() {
        return (Observable<T>) lift(OperatorOnBackpressureBuffer.instance());
    }

    public final Observable<T> onBackpressureDrop(Action1<? super T> action1) {
        return (Observable<T>) lift(new OperatorOnBackpressureDrop(action1));
    }

    public final Observable<T> onBackpressureLatest() {
        return (Observable<T>) lift(OperatorOnBackpressureLatest.instance());
    }

    public final Observable<T> onErrorResumeNext(Func1<Throwable, ? extends Observable<? extends T>> func1) {
        return (Observable<T>) lift(new OperatorOnErrorResumeNextViaFunction(func1));
    }

    public final Observable<T> onErrorReturn(Func1<Throwable, ? extends T> func1) {
        return (Observable<T>) lift(OperatorOnErrorResumeNextViaFunction.withSingle(func1));
    }

    public final Observable<T> onExceptionResumeNext(Observable<? extends T> observable) {
        return (Observable<T>) lift(OperatorOnErrorResumeNextViaFunction.withException(observable));
    }

    @Experimental
    public final Observable<T> onTerminateDetach() {
        return create(new OnSubscribeDetach(this));
    }

    public final ConnectableObservable<T> publish() {
        return OperatorPublish.create(this);
    }

    @Experimental
    public final Observable<T> rebatchRequests(int i3) {
        if (i3 > 0) {
            return (Observable<T>) lift(OperatorObserveOn.rebatch(i3));
        }
        throw new IllegalArgumentException("n > 0 required but it was " + i3);
    }

    public final Observable<T> reduce(Func2<T, T, T> func2) {
        return create(new OnSubscribeReduce(this, func2));
    }

    public final Observable<T> repeat() {
        return OnSubscribeRedo.repeat(this);
    }

    public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, InternalObservableUtils.createRepeatDematerializer(func1), scheduler);
    }

    public final ConnectableObservable<T> replay() {
        return OperatorReplay.create(this);
    }

    public final Observable<T> retry() {
        return OnSubscribeRedo.retry(this);
    }

    public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return OnSubscribeRedo.retry(this, InternalObservableUtils.createRetryDematerializer(func1));
    }

    public final Observable<T> sample(long j3, TimeUnit timeUnit) {
        return sample(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> scan(Func2<T, T, T> func2) {
        return (Observable<T>) lift(new OperatorScan(func2));
    }

    public final Observable<T> serialize() {
        return (Observable<T>) lift(OperatorSerialize.instance());
    }

    public final Observable<T> share() {
        return publish().refCount();
    }

    public final Observable<T> single() {
        return (Observable<T>) lift(OperatorSingle.instance());
    }

    public final Observable<T> singleOrDefault(T t16) {
        return (Observable<T>) lift(new OperatorSingle(t16));
    }

    public final Observable<T> skip(int i3) {
        return (Observable<T>) lift(new OperatorSkip(i3));
    }

    public final Observable<T> skipLast(int i3) {
        return (Observable<T>) lift(new OperatorSkipLast(i3));
    }

    public final <U> Observable<T> skipUntil(Observable<U> observable) {
        return (Observable<T>) lift(new OperatorSkipUntil(observable));
    }

    public final Observable<T> skipWhile(Func1<? super T, Boolean> func1) {
        return (Observable<T>) lift(new OperatorSkipWhile(OperatorSkipWhile.toPredicate2(func1)));
    }

    public final Observable<T> startWith(Observable<T> observable) {
        return concat(observable, this);
    }

    public final Subscription subscribe() {
        return subscribe((Subscriber) new ActionSubscriber(Actions.empty(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.empty()));
    }

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarScheduleOn(scheduler);
        }
        return create(new OperatorSubscribeOn(this, scheduler));
    }

    public final Observable<T> switchIfEmpty(Observable<? extends T> observable) {
        return (Observable<T>) lift(new OperatorSwitchIfEmpty(observable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> switchMap(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return switchOnNext(map(func1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Experimental
    public final <R> Observable<R> switchMapDelayError(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return switchOnNextDelayError(map(func1));
    }

    public final Observable<T> take(int i3) {
        return (Observable<T>) lift(new OperatorTake(i3));
    }

    public final Observable<T> takeFirst(Func1<? super T, Boolean> func1) {
        return filter(func1).take(1);
    }

    public final Observable<T> takeLast(int i3) {
        if (i3 == 0) {
            return ignoreElements();
        }
        if (i3 == 1) {
            return create(new OnSubscribeTakeLastOne(this));
        }
        return (Observable<T>) lift(new OperatorTakeLast(i3));
    }

    public final Observable<List<T>> takeLastBuffer(int i3) {
        return takeLast(i3).toList();
    }

    public final <E> Observable<T> takeUntil(Observable<? extends E> observable) {
        return (Observable<T>) lift(new OperatorTakeUntil(observable));
    }

    public final Observable<T> takeWhile(Func1<? super T, Boolean> func1) {
        return (Observable<T>) lift(new OperatorTakeWhile(func1));
    }

    public final Observable<T> throttleFirst(long j3, TimeUnit timeUnit) {
        return throttleFirst(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> throttleLast(long j3, TimeUnit timeUnit) {
        return sample(j3, timeUnit);
    }

    public final Observable<T> throttleWithTimeout(long j3, TimeUnit timeUnit) {
        return debounce(j3, timeUnit);
    }

    public final Observable<TimeInterval<T>> timeInterval() {
        return timeInterval(Schedulers.computation());
    }

    public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1) {
        return timeout(func0, func1, (Observable) null);
    }

    public final Observable<Timestamped<T>> timestamp() {
        return timestamp(Schedulers.computation());
    }

    public final BlockingObservable<T> toBlocking() {
        return BlockingObservable.from(this);
    }

    @Experimental
    public Completable toCompletable() {
        return Completable.fromObservable(this);
    }

    public final Observable<List<T>> toList() {
        return (Observable<List<T>>) lift(OperatorToObservableList.instance());
    }

    public final <K> Observable<Map<K, T>> toMap(Func1<? super T, ? extends K> func1) {
        return (Observable<Map<K, T>>) lift(new OperatorToMap(func1, UtilityFunctions.identity()));
    }

    public final <K> Observable<Map<K, Collection<T>>> toMultimap(Func1<? super T, ? extends K> func1) {
        return (Observable<Map<K, Collection<T>>>) lift(new OperatorToMultimap(func1, UtilityFunctions.identity()));
    }

    @Beta
    public Single<T> toSingle() {
        return new Single<>(OnSubscribeSingle.create(this));
    }

    public final Observable<List<T>> toSortedList() {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(10));
    }

    public final Subscription unsafeSubscribe(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            RxJavaHooks.onObservableStart(this, this.onSubscribe).call(subscriber);
            return RxJavaHooks.onObservableReturn(subscriber);
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            try {
                subscriber.onError(RxJavaHooks.onObservableError(th5));
                return Subscriptions.unsubscribed();
            } catch (Throwable th6) {
                Exceptions.throwIfFatal(th6);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th5.getMessage() + "] and then again while trying to pass to onError.", th6);
                RxJavaHooks.onObservableError(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorUnsubscribeOn(scheduler));
    }

    public final <TClosing> Observable<Observable<T>> window(Func0<? extends Observable<? extends TClosing>> func0) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithObservableFactory(func0));
    }

    @Experimental
    public final <U, R> Observable<R> withLatestFrom(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        return lift(new OperatorWithLatestFrom(observable, func2));
    }

    public final <T2, R> Observable<R> zipWith(Iterable<? extends T2> iterable, Func2<? super T, ? super T2, ? extends R> func2) {
        return lift(new OperatorZipIterable(iterable, func2));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return create(OnSubscribeAmb.amb(observable, observable2));
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return combineLatest(Arrays.asList(observable, observable2, observable3), Functions.fromFunc(func3));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return concat(just(observable, observable2));
    }

    @Experimental
    public static <T> Observable<T> concatDelayError(Iterable<? extends Observable<? extends T>> iterable) {
        return concatDelayError(from(iterable));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return concatEager(Arrays.asList(observable, observable2, observable3));
    }

    @Beta
    public static <S, T> Observable<T> create(SyncOnSubscribe<S, T> syncOnSubscribe) {
        return create((OnSubscribe) syncOnSubscribe);
    }

    public static <T> Observable<T> from(Future<? extends T> future, long j3, TimeUnit timeUnit) {
        return create(OnSubscribeToObservableFuture.toObservableFuture(future, j3, timeUnit));
    }

    public static Observable<Long> interval(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j3, j3, timeUnit, scheduler);
    }

    public static <T> Observable<T> just(T t16, T t17) {
        return from(new Object[]{t16, t17});
    }

    public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> iterable, int i3) {
        return merge(from(iterable), i3);
    }

    @Experimental
    public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> observable, int i3) {
        return (Observable<T>) observable.lift(OperatorMerge.instance(true, i3));
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> observable, Observable<? extends T> observable2, Func2<? super T, ? super T, Boolean> func2) {
        return OperatorSequenceEqual.sequenceEqual(observable, observable2, func2);
    }

    @Deprecated
    public static Observable<Long> timer(long j3, long j16, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j3, j16, timeUnit, scheduler);
    }

    @Experimental
    public static <T, Resource> Observable<T> using(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z16) {
        return create(new OnSubscribeUsing(func0, func1, action1, z16));
    }

    public final Observable<List<T>> buffer(int i3) {
        return buffer(i3, i3);
    }

    @Deprecated
    public final Observable<T> cache(int i3) {
        return cacheWithInitialCapacity(i3);
    }

    @Experimental
    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> func1, int i3) {
        if (i3 >= 1) {
            return lift(new OperatorEagerConcatMap(func1, i3, Integer.MAX_VALUE));
        }
        throw new IllegalArgumentException("capacityHint > 0 required but it was " + i3);
    }

    public final Observable<T> debounce(long j3, TimeUnit timeUnit) {
        return debounce(j3, timeUnit, Schedulers.computation());
    }

    public final <U> Observable<T> delay(Func1<? super T, ? extends Observable<U>> func1) {
        return (Observable<T>) lift(new OperatorDelayWithSelector(this, func1));
    }

    public final Observable<T> delaySubscription(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return create(new OnSubscribeDelaySubscription(this, j3, timeUnit, scheduler));
    }

    public final <U> Observable<T> distinct(Func1<? super T, ? extends U> func1) {
        return (Observable<T>) lift(new OperatorDistinct(func1));
    }

    public final <U> Observable<T> distinctUntilChanged(Func1<? super T, ? extends U> func1) {
        return (Observable<T>) lift(new OperatorDistinctUntilChanged(func1));
    }

    public final Observable<T> first(Func1<? super T, Boolean> func1) {
        return takeFirst(func1).single();
    }

    public final Observable<T> firstOrDefault(T t16, Func1<? super T, Boolean> func1) {
        return takeFirst(func1).singleOrDefault(t16);
    }

    @Beta
    public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> func1, int i3) {
        return OnSubscribeFlattenIterable.createFrom(this, func1, i3);
    }

    public final void forEach(Action1<? super T> action1, Action1<Throwable> action12) {
        subscribe(action1, action12);
    }

    @Experimental
    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        if (func13 != null) {
            return lift(new OperatorGroupBy(func1, func12, func13));
        }
        throw new NullPointerException("evictingMapFactory cannot be null");
    }

    public final Observable<T> last(Func1<? super T, Boolean> func1) {
        return filter(func1).takeLast(1).single();
    }

    public final Observable<T> lastOrDefault(T t16, Func1<? super T, Boolean> func1) {
        return filter(func1).takeLast(1).singleOrDefault(t16);
    }

    public final Observable<T> observeOn(Scheduler scheduler, int i3) {
        return observeOn(scheduler, false, i3);
    }

    public final Observable<T> onBackpressureBuffer(long j3) {
        return (Observable<T>) lift(new OperatorOnBackpressureBuffer(j3));
    }

    public final Observable<T> onBackpressureDrop() {
        return (Observable<T>) lift(OperatorOnBackpressureDrop.instance());
    }

    public final Observable<T> onErrorResumeNext(Observable<? extends T> observable) {
        return (Observable<T>) lift(OperatorOnErrorResumeNextViaFunction.withOther(observable));
    }

    public final <R> Observable<R> publish(Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return OperatorPublish.create(this, func1);
    }

    public final <R> Observable<R> reduce(R r16, Func2<R, ? super T, R> func2) {
        return create(new OnSubscribeReduceSeed(this, r16, func2));
    }

    public final Observable<T> repeat(Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, scheduler);
    }

    public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        return OnSubscribeRedo.repeat(this, InternalObservableUtils.createRepeatDematerializer(func1));
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this), func1);
    }

    public final Observable<T> retry(long j3) {
        return OnSubscribeRedo.retry(this, j3);
    }

    public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return OnSubscribeRedo.retry(this, InternalObservableUtils.createRetryDematerializer(func1), scheduler);
    }

    public final Observable<T> sample(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorSampleWithTime(j3, timeUnit, scheduler));
    }

    public final <R> Observable<R> scan(R r16, Func2<R, ? super T, R> func2) {
        return lift(new OperatorScan(r16, func2));
    }

    public final Observable<T> single(Func1<? super T, Boolean> func1) {
        return filter(func1).single();
    }

    public final Observable<T> singleOrDefault(T t16, Func1<? super T, Boolean> func1) {
        return filter(func1).singleOrDefault(t16);
    }

    public final Observable<T> skip(long j3, TimeUnit timeUnit) {
        return skip(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> skipLast(long j3, TimeUnit timeUnit) {
        return skipLast(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> startWith(Iterable<T> iterable) {
        return concat(from(iterable), this);
    }

    public final Observable<T> take(long j3, TimeUnit timeUnit) {
        return take(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<List<T>> takeLastBuffer(int i3, long j3, TimeUnit timeUnit) {
        return takeLast(i3, j3, timeUnit).toList();
    }

    public final Observable<T> takeUntil(Func1<? super T, Boolean> func1) {
        return (Observable<T>) lift(new OperatorTakeUntilPredicate(func1));
    }

    public final Observable<T> throttleFirst(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorThrottleFirst(j3, timeUnit, scheduler));
    }

    public final Observable<T> throttleLast(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j3, timeUnit, scheduler);
    }

    public final Observable<T> throttleWithTimeout(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j3, timeUnit, scheduler);
    }

    public final Observable<TimeInterval<T>> timeInterval(Scheduler scheduler) {
        return (Observable<TimeInterval<T>>) lift(new OperatorTimeInterval(scheduler));
    }

    public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        if (func1 != null) {
            return (Observable<T>) lift(new OperatorTimeoutWithSelector(func0, func1, observable));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    public final Observable<Timestamped<T>> timestamp(Scheduler scheduler) {
        return (Observable<Timestamped<T>>) lift(new OperatorTimestamp(scheduler));
    }

    public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return (Observable<Map<K, V>>) lift(new OperatorToMap(func1, func12));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return (Observable<Map<K, Collection<V>>>) lift(new OperatorToMultimap(func1, func12));
    }

    public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> func2) {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(func2, 10));
    }

    public final Observable<Observable<T>> window(int i3) {
        return window(i3, i3);
    }

    @Experimental
    public final <T1, T2, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Func3<? super T, ? super T1, ? super T2, R> func3) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2}, null, Functions.fromFunc(func3)));
    }

    public final <T2, R> Observable<R> zipWith(Observable<? extends T2> observable, Func2<? super T, ? super T2, ? extends R> func2) {
        return zip(this, observable, func2);
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3));
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4), Functions.fromFunc(func4));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return concat(just(observable, observable2, observable3));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4));
    }

    @Experimental
    public static <S, T> Observable<T> create(AsyncOnSubscribe<S, T> asyncOnSubscribe) {
        return create((OnSubscribe) asyncOnSubscribe);
    }

    public static <T> Observable<T> from(Future<? extends T> future, Scheduler scheduler) {
        return create(OnSubscribeToObservableFuture.toObservableFuture(future)).subscribeOn(scheduler);
    }

    public static Observable<Long> interval(long j3, long j16, TimeUnit timeUnit) {
        return interval(j3, j16, timeUnit, Schedulers.computation());
    }

    public static <T> Observable<T> just(T t16, T t17, T t18) {
        return from(new Object[]{t16, t17, t18});
    }

    public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).scalarFlatMap(UtilityFunctions.identity());
        }
        return (Observable<T>) observable.lift(OperatorMerge.instance(false));
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> iterable) {
        return mergeDelayError(from(iterable));
    }

    public static Observable<Long> timer(long j3, TimeUnit timeUnit) {
        return timer(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<List<T>> buffer(int i3, int i16) {
        return (Observable<List<T>>) lift(new OperatorBufferWithSize(i3, i16));
    }

    public final Observable<T> debounce(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorDebounceWithTime(j3, timeUnit, scheduler));
    }

    public final Observable<T> delay(long j3, TimeUnit timeUnit) {
        return delay(j3, timeUnit, Schedulers.computation());
    }

    public final <U> Observable<T> delaySubscription(Func0<? extends Observable<U>> func0) {
        return create(new OnSubscribeDelaySubscriptionWithSelector(this, func0));
    }

    @Experimental
    public final Observable<T> distinctUntilChanged(Func2<? super T, ? super T, Boolean> func2) {
        return (Observable<T>) lift(new OperatorDistinctUntilChanged(func2));
    }

    public final Observable<T> doOnEach(Observer<? super T> observer) {
        return (Observable<T>) lift(new OperatorDoOnEach(observer));
    }

    public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        return flatMap(OperatorMapPair.convertSelector(func1), func2);
    }

    public final void forEach(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        subscribe(action1, action12, action0);
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z16) {
        return observeOn(scheduler, z16, RxRingBuffer.SIZE);
    }

    public final Observable<T> onBackpressureBuffer(long j3, Action0 action0) {
        return (Observable<T>) lift(new OperatorOnBackpressureBuffer(j3, action0));
    }

    public final Observable<T> repeat(long j3) {
        return OnSubscribeRedo.repeat(this, j3);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i3) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, i3), func1);
    }

    public final Observable<T> retry(Func2<Integer, Throwable, Boolean> func2) {
        return (Observable<T>) nest().lift(new OperatorRetryWithPredicate(func2));
    }

    public final <U> Observable<T> sample(Observable<U> observable) {
        return (Observable<T>) lift(new OperatorSampleWithObservable(observable));
    }

    public final Observable<T> skip(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorSkipTimed(j3, timeUnit, scheduler));
    }

    public final Observable<T> skipLast(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorSkipLastTimed(j3, timeUnit, scheduler));
    }

    public final Observable<T> startWith(T t16) {
        return concat(just(t16), this);
    }

    public final Observable<T> take(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTakeTimed(j3, timeUnit, scheduler));
    }

    public final Observable<List<T>> takeLastBuffer(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(i3, j3, timeUnit, scheduler).toList();
    }

    public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        return (Observable<Map<K, V>>) lift(new OperatorToMap(func1, func12, func0));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        return (Observable<Map<K, Collection<V>>>) lift(new OperatorToMultimap(func1, func12, func0));
    }

    @Experimental
    public final Observable<List<T>> toSortedList(int i3) {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(i3));
    }

    public final Observable<Observable<T>> window(int i3, int i16) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + i3);
        }
        if (i16 > 0) {
            return (Observable<Observable<T>>) lift(new OperatorWindowWithSize(i3, i16));
        }
        throw new IllegalArgumentException("skip > 0 required but it was " + i16);
    }

    @Experimental
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Func4<? super T, ? super T1, ? super T2, ? super T3, R> func4) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3}, null, Functions.fromFunc(func4)));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3, observable4));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5), Functions.fromFunc(func5));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return concat(just(observable, observable2, observable3, observable4));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5));
    }

    public static Observable<Long> interval(long j3, long j16, TimeUnit timeUnit, Scheduler scheduler) {
        return create(new OnSubscribeTimerPeriodically(j3, j16, timeUnit, scheduler));
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19) {
        return from(new Object[]{t16, t17, t18, t19});
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> iterable, int i3) {
        return mergeDelayError(from(iterable), i3);
    }

    public static Observable<Long> timer(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return create(new OnSubscribeTimerOnce(j3, timeUnit, scheduler));
    }

    public final Observable<List<T>> buffer(long j3, long j16, TimeUnit timeUnit) {
        return buffer(j3, j16, timeUnit, Schedulers.computation());
    }

    @Experimental
    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> func1, int i3, int i16) {
        if (i3 < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i3);
        }
        if (i16 >= 1) {
            return lift(new OperatorEagerConcatMap(func1, i3, i16));
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i3);
    }

    public final Observable<T> delay(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorDelay(j3, timeUnit, scheduler));
    }

    @Experimental
    public final <U> Observable<T> delaySubscription(Observable<U> observable) {
        observable.getClass();
        return create(new OnSubscribeDelaySubscriptionOther(this, observable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i3) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return merge(map(func1), i3);
    }

    @Beta
    public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2, int i3) {
        return flatMap(OperatorMapPair.convertSelector(func1), func2, i3);
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Func1<? super T, ? extends K> func1) {
        return (Observable<GroupedObservable<K, T>>) lift(new OperatorGroupBy(func1));
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z16, int i3) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarScheduleOn(scheduler);
        }
        return (Observable<T>) lift(new OperatorObserveOn(scheduler, z16, i3));
    }

    @Experimental
    public final Observable<T> onBackpressureBuffer(long j3, Action0 action0, BackpressureOverflow.Strategy strategy) {
        return (Observable<T>) lift(new OperatorOnBackpressureBuffer(j3, action0, strategy));
    }

    public final Observable<T> repeat(long j3, Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, j3, scheduler);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i3, long j3, TimeUnit timeUnit) {
        return replay(func1, i3, j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> startWith(T t16, T t17) {
        return concat(just(t16, t17), this);
    }

    public final Observable<T> takeLast(int i3, long j3, TimeUnit timeUnit) {
        return takeLast(i3, j3, timeUnit, Schedulers.computation());
    }

    public final Observable<List<T>> takeLastBuffer(long j3, TimeUnit timeUnit) {
        return takeLast(j3, timeUnit).toList();
    }

    public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> func1) {
        return timeout((Func0) null, func1, (Observable) null);
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        return (Observable<Map<K, Collection<V>>>) lift(new OperatorToMultimap(func1, func12, func0, func13));
    }

    @Experimental
    public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> func2, int i3) {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(func2, i3));
    }

    @Experimental
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Func5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> func5) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4}, null, Functions.fromFunc(func5)));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), Functions.fromFunc(func6));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return concat(just(observable, observable2, observable3, observable4, observable5));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T> Observable<T> from(Iterable<? extends T> iterable) {
        return create(new OnSubscribeFromIterable(iterable));
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19, T t26) {
        return from(new Object[]{t16, t17, t18, t19, t26});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return mergeDelayError(just(observable, observable2));
    }

    @Experimental
    public static <R> Observable<R> zip(Observable<?>[] observableArr, FuncN<? extends R> funcN) {
        return just(observableArr).lift(new OperatorZip(funcN));
    }

    public final Observable<List<T>> buffer(long j3, long j16, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) lift(new OperatorBufferWithTime(j3, j16, timeUnit, Integer.MAX_VALUE, scheduler));
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        if (i3 >= 0) {
            return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, i3, j3, timeUnit, scheduler), func1);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final Observable<T> startWith(T t16, T t17, T t18) {
        return concat(just(t16, t17, t18), this);
    }

    public final Subscription subscribe(Action1<? super T> action1) {
        if (action1 != null) {
            return subscribe((Subscriber) new ActionSubscriber(action1, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.empty()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final Observable<T> takeLast(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTakeLastTimed(i3, j3, timeUnit, scheduler));
    }

    public final Observable<List<T>> takeLastBuffer(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j3, timeUnit, scheduler).toList();
    }

    public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        return timeout((Func0) null, func1, observable);
    }

    @Experimental
    public final <T1, T2, T3, T4, T5, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T1> observable3, Observable<T2> observable4, Observable<T1> observable5, Func6<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> func6) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5}, null, Functions.fromFunc(func6)));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), Functions.fromFunc(func7));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T> Observable<T> from(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return just(tArr[0]);
        }
        return create(new OnSubscribeFromArray(tArr));
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19, T t26, T t27) {
        return from(new Object[]{t16, t17, t18, t19, t26, t27});
    }

    public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> observable, int i3) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).scalarFlatMap(UtilityFunctions.identity());
        }
        return (Observable<T>) observable.lift(OperatorMerge.instance(false, i3));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return mergeDelayError(just(observable, observable2, observable3));
    }

    public static Observable<Integer> range(int i3, int i16, Scheduler scheduler) {
        return range(i3, i16).subscribeOn(scheduler);
    }

    public static <R> Observable<R> zip(Observable<? extends Observable<?>> observable, FuncN<? extends R> funcN) {
        return observable.toList().map(InternalObservableUtils.TO_ARRAY).lift(new OperatorZip(funcN));
    }

    public final Observable<List<T>> buffer(long j3, TimeUnit timeUnit) {
        return buffer(j3, timeUnit, Integer.MAX_VALUE, Schedulers.computation());
    }

    public final Observable<T> startWith(T t16, T t17, T t18, T t19) {
        return concat(just(t16, t17, t18, t19), this);
    }

    public final Observable<T> takeLast(long j3, TimeUnit timeUnit) {
        return takeLast(j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> timeout(long j3, TimeUnit timeUnit) {
        return timeout(j3, timeUnit, null, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long j3, long j16, TimeUnit timeUnit) {
        return window(j3, j16, timeUnit, Integer.MAX_VALUE, Schedulers.computation());
    }

    @Experimental
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T1> observable3, Observable<T2> observable4, Observable<T1> observable5, Observable<T2> observable6, Func7<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> func7) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6}, null, Functions.fromFunc(func7)));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), Functions.fromFunc(func8));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19, T t26, T t27, T t28) {
        return from(new Object[]{t16, t17, t18, t19, t26, t27, t28});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return mergeDelayError(just(observable, observable2, observable3, observable4));
    }

    public static <T1, T2, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return just(new Observable[]{observable, observable2}).lift(new OperatorZip(func2));
    }

    public final Observable<List<T>> buffer(long j3, TimeUnit timeUnit, int i3) {
        return (Observable<List<T>>) lift(new OperatorBufferWithTime(j3, j3, timeUnit, i3, Schedulers.computation()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1, Func1<? super Throwable, ? extends Observable<? extends R>> func12, Func0<? extends Observable<? extends R>> func0) {
        return merge(mapNotification(func1, func12, func0));
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i3, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, i3), InternalObservableUtils.createReplaySelectorAndObserveOn(func1, scheduler));
    }

    public final Observable<T> startWith(T t16, T t17, T t18, T t19, T t26) {
        return concat(just(t16, t17, t18, t19, t26), this);
    }

    public final Observable<T> takeLast(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTakeLastTimed(j3, timeUnit, scheduler));
    }

    public final Observable<T> timeout(long j3, TimeUnit timeUnit, Observable<? extends T> observable) {
        return timeout(j3, timeUnit, observable, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long j3, long j16, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j3, j16, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    @Experimental
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T1> observable3, Observable<T2> observable4, Observable<T1> observable5, Observable<T2> observable6, Observable<T1> observable7, Func8<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> func8) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7}, null, Functions.fromFunc(func8)));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), Functions.fromFunc(func9));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19, T t26, T t27, T t28, T t29) {
        return from(new Object[]{t16, t17, t18, t19, t26, t27, t28, t29});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5));
    }

    public static <T1, T2, T3, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return just(new Observable[]{observable, observable2, observable3}).lift(new OperatorZip(func3));
    }

    public final Observable<List<T>> buffer(long j3, TimeUnit timeUnit, int i3, Scheduler scheduler) {
        return (Observable<List<T>>) lift(new OperatorBufferWithTime(j3, j3, timeUnit, i3, scheduler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1, Func1<? super Throwable, ? extends Observable<? extends R>> func12, Func0<? extends Observable<? extends R>> func0, int i3) {
        return merge(mapNotification(func1, func12, func0), i3);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, long j3, TimeUnit timeUnit) {
        return replay(func1, j3, timeUnit, Schedulers.computation());
    }

    public final Observable<T> startWith(T t16, T t17, T t18, T t19, T t26, T t27) {
        return concat(just(t16, t17, t18, t19, t26, t27), this);
    }

    public final Observable<T> timeout(long j3, TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTimeout(j3, timeUnit, observable, scheduler));
    }

    public final Observable<Observable<T>> window(long j3, long j16, TimeUnit timeUnit, int i3, Scheduler scheduler) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithTime(j3, j16, timeUnit, i3, scheduler));
    }

    @Experimental
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T1> observable3, Observable<T2> observable4, Observable<T1> observable5, Observable<T2> observable6, Observable<T1> observable7, Observable<T2> observable8, Func9<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> func9) {
        return create(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8}, null, Functions.fromFunc(func9)));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return create(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return create(new OnSubscribeCombineLatest(list, funcN));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> iterable) {
        return from(iterable).concatMapEager(UtilityFunctions.identity());
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19, T t26, T t27, T t28, T t29, T t36) {
        return from(new Object[]{t16, t17, t18, t19, t26, t27, t28, t29, t36});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return merge(new Observable[]{observable, observable2});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T1, T2, T3, T4, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return just(new Observable[]{observable, observable2, observable3, observable4}).lift(new OperatorZip(func4));
    }

    public final Observable<List<T>> buffer(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j3, j3, timeUnit, scheduler);
    }

    public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        return merge(lift(new OperatorMapPair(func1, func2)));
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, j3, timeUnit, scheduler), func1);
    }

    public final Observable<T> startWith(T t16, T t17, T t18, T t19, T t26, T t27, T t28) {
        return concat(just(t16, t17, t18, t19, t26, t27, t28), this);
    }

    public final Subscription subscribe(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action12 != null) {
            return subscribe((Subscriber) new ActionSubscriber(action1, action12, Actions.empty()));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final Observable<T> timeout(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(j3, timeUnit, null, scheduler);
    }

    public final Observable<Observable<T>> window(long j3, TimeUnit timeUnit) {
        return window(j3, j3, timeUnit, Schedulers.computation());
    }

    @Experimental
    public final <R> Observable<R> withLatestFrom(Observable<?>[] observableArr, FuncN<R> funcN) {
        return create(new OperatorWithLatestFromMany(this, observableArr, null, funcN));
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        return create(new OnSubscribeCombineLatest(iterable, funcN));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> iterable, int i3) {
        return from(iterable).concatMapEager(UtilityFunctions.identity(), i3);
    }

    public static <T> Observable<T> just(T t16, T t17, T t18, T t19, T t26, T t27, T t28, T t29, T t36, T t37) {
        return from(new Object[]{t16, t17, t18, t19, t26, t27, t28, t29, t36, t37});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return merge(new Observable[]{observable, observable2, observable3});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5}).lift(new OperatorZip(func5));
    }

    public final <TOpening, TClosing> Observable<List<T>> buffer(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        return (Observable<List<T>>) lift(new OperatorBufferWithStartEndObservable(observable, func1));
    }

    @Beta
    public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2, int i3) {
        return merge(lift(new OperatorMapPair(func1, func2)), i3);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(func1, scheduler));
    }

    public final Observable<T> startWith(T t16, T t17, T t18, T t19, T t26, T t27, T t28, T t29) {
        return concat(just(t16, t17, t18, t19, t26, t27, t28, t29), this);
    }

    public final Observable<Observable<T>> window(long j3, TimeUnit timeUnit, int i3) {
        return window(j3, timeUnit, i3, Schedulers.computation());
    }

    @Experimental
    public final <R> Observable<R> withLatestFrom(Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        return create(new OperatorWithLatestFromMany(this, null, iterable, funcN));
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<T>) observable.concatMapEager(UtilityFunctions.identity());
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return merge(new Observable[]{observable, observable2, observable3, observable4});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6}).lift(new OperatorZip(func6));
    }

    public final <B> Observable<List<T>> buffer(Observable<B> observable) {
        return buffer(observable, 16);
    }

    public final ConnectableObservable<T> replay(int i3) {
        return OperatorReplay.create(this, i3);
    }

    public final Observable<T> startWith(T t16, T t17, T t18, T t19, T t26, T t27, T t28, T t29, T t36) {
        return concat(just(t16, t17, t18, t19, t26, t27, t28, t29, t36), this);
    }

    public final Observable<Observable<T>> window(long j3, TimeUnit timeUnit, int i3, Scheduler scheduler) {
        return window(j3, j3, timeUnit, i3, scheduler);
    }

    @Experimental
    public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> observable, int i3) {
        return (Observable<T>) observable.concatMapEager(UtilityFunctions.identity(), i3);
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5});
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7}).lift(new OperatorZip(func7));
    }

    public final <B> Observable<List<T>> buffer(Observable<B> observable, int i3) {
        return (Observable<List<T>>) lift(new OperatorBufferWithSingleObservable(observable, i3));
    }

    public final ConnectableObservable<T> replay(int i3, long j3, TimeUnit timeUnit) {
        return replay(i3, j3, timeUnit, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j3, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8}).lift(new OperatorZip(func8));
    }

    public final ConnectableObservable<T> replay(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        if (i3 >= 0) {
            return OperatorReplay.create(this, j3, timeUnit, scheduler, i3);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final Subscription subscribe(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action12 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (action0 != null) {
            return subscribe((Subscriber) new ActionSubscriber(action1, action12, action0));
        }
        throw new IllegalArgumentException("onComplete can not be null");
    }

    public final <TOpening, TClosing> Observable<Observable<T>> window(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithStartEndObservable(observable, func1));
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9}).lift(new OperatorZip(func9));
    }

    public final <U> Observable<Observable<T>> window(Observable<U> observable) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithObservable(observable));
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8});
    }

    public final ConnectableObservable<T> replay(int i3, Scheduler scheduler) {
        return OperatorReplay.observeOn(replay(i3), scheduler);
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9});
    }

    public final ConnectableObservable<T> replay(long j3, TimeUnit timeUnit) {
        return replay(j3, timeUnit, Schedulers.computation());
    }

    public static <T> Observable<T> merge(Observable<? extends T>[] observableArr) {
        return merge(from(observableArr));
    }

    public final ConnectableObservable<T> replay(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return OperatorReplay.create(this, j3, timeUnit, scheduler);
    }

    public final Subscription subscribe(Observer<? super T> observer) {
        if (observer instanceof Subscriber) {
            return subscribe((Subscriber) observer);
        }
        if (observer != null) {
            return subscribe((Subscriber) new ObserverSubscriber(observer));
        }
        throw new NullPointerException("observer is null");
    }

    public static <T> Observable<T> merge(Observable<? extends T>[] observableArr, int i3) {
        return merge(from(observableArr), i3);
    }

    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        return OperatorReplay.observeOn(replay(), scheduler);
    }

    public final Subscription subscribe(Subscriber<? super T> subscriber) {
        return subscribe(subscriber, this);
    }

    static <T> Subscription subscribe(Subscriber<? super T> subscriber, Observable<T> observable) {
        if (subscriber != null) {
            if (observable.onSubscribe != null) {
                subscriber.onStart();
                if (!(subscriber instanceof SafeSubscriber)) {
                    subscriber = new SafeSubscriber(subscriber);
                }
                try {
                    RxJavaHooks.onObservableStart(observable, observable.onSubscribe).call(subscriber);
                    return RxJavaHooks.onObservableReturn(subscriber);
                } catch (Throwable th5) {
                    Exceptions.throwIfFatal(th5);
                    if (subscriber.isUnsubscribed()) {
                        RxJavaHooks.onError(RxJavaHooks.onObservableError(th5));
                    } else {
                        try {
                            subscriber.onError(RxJavaHooks.onObservableError(th5));
                        } catch (Throwable th6) {
                            Exceptions.throwIfFatal(th6);
                            OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th5.getMessage() + "] and then again while trying to pass to onError.", th6);
                            RxJavaHooks.onObservableError(onErrorFailedException);
                            throw onErrorFailedException;
                        }
                    }
                    return Subscriptions.unsubscribed();
                }
            }
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        throw new IllegalArgumentException("subscriber can not be null");
    }
}
