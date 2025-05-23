package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorDematerialize<T> implements Observable.Operator<T, Notification<T>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: rx.internal.operators.OperatorDematerialize$2, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$rx$Notification$Kind;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            $SwitchMap$rx$Notification$Kind = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$rx$Notification$Kind[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize<>();

        Holder() {
        }
    }

    OperatorDematerialize() {
    }

    public static OperatorDematerialize instance() {
        return Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Notification<T>> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<Notification<T>>(subscriber) { // from class: rx.internal.operators.OperatorDematerialize.1
            boolean terminated;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.terminated) {
                    this.terminated = true;
                    subscriber.onCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                if (!this.terminated) {
                    this.terminated = true;
                    subscriber.onError(th5);
                }
            }

            @Override // rx.Observer
            public void onNext(Notification<T> notification) {
                int i3 = AnonymousClass2.$SwitchMap$rx$Notification$Kind[notification.getKind().ordinal()];
                if (i3 == 1) {
                    if (this.terminated) {
                        return;
                    }
                    subscriber.onNext(notification.getValue());
                } else {
                    if (i3 == 2) {
                        onError(notification.getThrowable());
                        return;
                    }
                    if (i3 != 3) {
                        onError(new IllegalArgumentException("Unsupported notification type: " + notification));
                        return;
                    }
                    onCompleted();
                }
            }
        };
    }
}
