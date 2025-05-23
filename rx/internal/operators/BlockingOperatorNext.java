package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BlockingOperatorNext {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final Observable<? extends T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        NextIterator(Observable<? extends T> observable, NextObserver<T> nextObserver) {
            this.items = observable;
            this.observer = nextObserver;
        }

        private boolean moveToNext() {
            try {
                if (!this.started) {
                    this.started = true;
                    this.observer.setWaiting(1);
                    this.items.materialize().subscribe((Subscriber<? super Notification<? extends T>>) this.observer);
                }
                Notification<? extends T> takeNext = this.observer.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnCompleted()) {
                    return false;
                }
                if (takeNext.isOnError()) {
                    Throwable throwable = takeNext.getThrowable();
                    this.error = throwable;
                    throw Exceptions.propagate(throwable);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e16) {
                this.observer.unsubscribe();
                Thread.currentThread().interrupt();
                this.error = e16;
                throw Exceptions.propagate(e16);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th5 = this.error;
            if (th5 == null) {
                if (!this.hasNext) {
                    return false;
                }
                if (!this.isNextConsumed) {
                    return true;
                }
                return moveToNext();
            }
            throw Exceptions.propagate(th5);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th5 = this.error;
            if (th5 == null) {
                if (hasNext()) {
                    this.isNextConsumed = true;
                    return this.next;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw Exceptions.propagate(th5);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class NextObserver<T> extends Subscriber<Notification<? extends T>> {
        private final BlockingQueue<Notification<? extends T>> buf = new ArrayBlockingQueue(1);
        final AtomicInteger waiting = new AtomicInteger();

        NextObserver() {
        }

        void setWaiting(int i3) {
            this.waiting.set(i3);
        }

        public Notification<? extends T> takeNext() throws InterruptedException {
            setWaiting(1);
            return this.buf.take();
        }

        @Override // rx.Observer
        public void onNext(Notification<? extends T> notification) {
            if (this.waiting.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<? extends T> poll = this.buf.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
        }
    }

    BlockingOperatorNext() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> next(final Observable<? extends T> observable) {
        return new Iterable<T>() { // from class: rx.internal.operators.BlockingOperatorNext.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new NextIterator(Observable.this, new NextObserver());
            }
        };
    }
}
