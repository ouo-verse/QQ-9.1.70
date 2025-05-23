package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> actual;
    private boolean emitting;

    /* renamed from: nl, reason: collision with root package name */
    private final NotificationLite<T> f432875nl = NotificationLite.instance();
    private FastList queue;
    private volatile boolean terminated;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class FastList {
        Object[] array;
        int size;

        FastList() {
        }

        public void add(Object obj) {
            int i3 = this.size;
            Object[] objArr = this.array;
            if (objArr == null) {
                objArr = new Object[16];
                this.array = objArr;
            } else if (i3 == objArr.length) {
                Object[] objArr2 = new Object[(i3 >> 2) + i3];
                System.arraycopy(objArr, 0, objArr2, 0, i3);
                this.array = objArr2;
                objArr = objArr2;
            }
            objArr[i3] = obj;
            this.size = i3 + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.actual = observer;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            if (this.emitting) {
                FastList fastList = this.queue;
                if (fastList == null) {
                    fastList = new FastList();
                    this.queue = fastList;
                }
                fastList.add(this.f432875nl.completed());
                return;
            }
            this.emitting = true;
            this.actual.onCompleted();
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        Exceptions.throwIfFatal(th5);
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            if (this.emitting) {
                FastList fastList = this.queue;
                if (fastList == null) {
                    fastList = new FastList();
                    this.queue = fastList;
                }
                fastList.add(this.f432875nl.error(th5));
                return;
            }
            this.emitting = true;
            this.actual.onError(th5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x002f, code lost:
    
        continue;
     */
    @Override // rx.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t16) {
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            if (this.emitting) {
                FastList fastList = this.queue;
                if (fastList == null) {
                    fastList = new FastList();
                    this.queue = fastList;
                }
                fastList.add(this.f432875nl.next(t16));
                return;
            }
            this.emitting = true;
            try {
                this.actual.onNext(t16);
                while (true) {
                    synchronized (this) {
                        FastList fastList2 = this.queue;
                        if (fastList2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.queue = null;
                        for (Object obj : fastList2.array) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (this.f432875nl.accept(this.actual, obj)) {
                                    this.terminated = true;
                                    return;
                                }
                            } catch (Throwable th5) {
                                this.terminated = true;
                                Exceptions.throwIfFatal(th5);
                                this.actual.onError(OnErrorThrowable.addValueAsLastCause(th5, t16));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th6) {
                this.terminated = true;
                Exceptions.throwOrReport(th6, this.actual, t16);
            }
        }
    }
}
