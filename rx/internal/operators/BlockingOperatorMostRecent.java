package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BlockingOperatorMostRecent {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class MostRecentObserver<T> extends Subscriber<T> {

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432652nl;
        volatile Object value;

        MostRecentObserver(T t16) {
            NotificationLite<T> instance = NotificationLite.instance();
            this.f432652nl = instance;
            this.value = instance.next(t16);
        }

        public Iterator<T> getIterable() {
            return new Iterator<T>() { // from class: rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver.1
                private Object buf;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    this.buf = MostRecentObserver.this.value;
                    return !MostRecentObserver.this.f432652nl.isCompleted(r0);
                }

                @Override // java.util.Iterator
                public T next() {
                    try {
                        if (this.buf == null) {
                            this.buf = MostRecentObserver.this.value;
                        }
                        if (!MostRecentObserver.this.f432652nl.isCompleted(this.buf)) {
                            if (!MostRecentObserver.this.f432652nl.isError(this.buf)) {
                                return MostRecentObserver.this.f432652nl.getValue(this.buf);
                            }
                            throw Exceptions.propagate(MostRecentObserver.this.f432652nl.getError(this.buf));
                        }
                        throw new NoSuchElementException();
                    } finally {
                        this.buf = null;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Read only iterator");
                }
            };
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.value = this.f432652nl.completed();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.value = this.f432652nl.error(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.value = this.f432652nl.next(t16);
        }
    }

    BlockingOperatorMostRecent() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> mostRecent(final Observable<? extends T> observable, final T t16) {
        return new Iterable<T>() { // from class: rx.internal.operators.BlockingOperatorMostRecent.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                MostRecentObserver mostRecentObserver = new MostRecentObserver(t16);
                observable.subscribe((Subscriber) mostRecentObserver);
                return mostRecentObserver.getIterable();
            }
        };
    }
}
