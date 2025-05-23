package rx.internal.operators;

import java.util.Arrays;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SingleOnSubscribeUsing<T, Resource> implements Single.OnSubscribe<T> {
    final Action1<? super Resource> disposeAction;
    final boolean disposeEagerly;
    final Func0<Resource> resourceFactory;
    final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;

    public SingleOnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1, boolean z16) {
        this.resourceFactory = func0;
        this.singleFactory = func1;
        this.disposeAction = action1;
        this.disposeEagerly = z16;
    }

    void handleSubscriptionTimeError(SingleSubscriber<? super T> singleSubscriber, Resource resource, Throwable th5) {
        Exceptions.throwIfFatal(th5);
        if (this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th6) {
                Exceptions.throwIfFatal(th6);
                th5 = new CompositeException(Arrays.asList(th5, th6));
            }
        }
        singleSubscriber.onError(th5);
        if (!this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th7) {
                Exceptions.throwIfFatal(th7);
                RxJavaHooks.onError(th7);
            }
        }
    }

    @Override // rx.functions.Action1
    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        try {
            final Resource call = this.resourceFactory.call();
            try {
                Single<? extends T> call2 = this.singleFactory.call(call);
                if (call2 == null) {
                    handleSubscriptionTimeError(singleSubscriber, call, new NullPointerException("The single"));
                    return;
                }
                SingleSubscriber<T> singleSubscriber2 = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOnSubscribeUsing.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // rx.SingleSubscriber
                    public void onError(Throwable th5) {
                        SingleOnSubscribeUsing.this.handleSubscriptionTimeError(singleSubscriber, call, th5);
                    }

                    @Override // rx.SingleSubscriber
                    public void onSuccess(T t16) {
                        SingleOnSubscribeUsing singleOnSubscribeUsing = SingleOnSubscribeUsing.this;
                        if (singleOnSubscribeUsing.disposeEagerly) {
                            try {
                                singleOnSubscribeUsing.disposeAction.call((Object) call);
                            } catch (Throwable th5) {
                                Exceptions.throwIfFatal(th5);
                                singleSubscriber.onError(th5);
                                return;
                            }
                        }
                        singleSubscriber.onSuccess(t16);
                        SingleOnSubscribeUsing singleOnSubscribeUsing2 = SingleOnSubscribeUsing.this;
                        if (!singleOnSubscribeUsing2.disposeEagerly) {
                            try {
                                singleOnSubscribeUsing2.disposeAction.call((Object) call);
                            } catch (Throwable th6) {
                                Exceptions.throwIfFatal(th6);
                                RxJavaHooks.onError(th6);
                            }
                        }
                    }
                };
                singleSubscriber.add(singleSubscriber2);
                call2.subscribe((SingleSubscriber<? super Object>) singleSubscriber2);
            } catch (Throwable th5) {
                handleSubscriptionTimeError(singleSubscriber, call, th5);
            }
        } catch (Throwable th6) {
            Exceptions.throwIfFatal(th6);
            singleSubscriber.onError(th6);
        }
    }
}
